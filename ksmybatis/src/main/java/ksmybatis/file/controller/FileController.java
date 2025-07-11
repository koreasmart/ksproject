package ksmybatis.file.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ksmybatis.file.domain.FileMetaData;
import ksmybatis.file.mapper.FileMapper;
import ksmybatis.file.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class FileController {
	
	@Value("${file.path}")
	private String fileRealPath;
	
	private final FileService fileService;
	private final FileMapper fileMapper;
	
	@GetMapping("/file/deleteFile")
	public String fileDelete(@RequestParam(value="fileIdx") String fileIdx) {

		if(fileIdx != null) {
			FileMetaData fileMetaData = fileMapper.getFileInfoByIdx(fileIdx);
			fileService.deleteFile(fileMetaData);
		}
		
		return "redirect:/admin/file/fileDownload";
	}
	
	@RequestMapping(value="/file/download")
	@ResponseBody
	public ResponseEntity<Object> archiveDownload(@RequestParam(value="fileIdx", required = false) String fileIdx
												   ,HttpServletRequest request
												   ,HttpServletResponse response) throws URISyntaxException{
		
		
		if(fileIdx != null) {
			FileMetaData fileMetaData = fileMapper.getFileInfoByIdx(fileIdx);
			
			File file = new File(fileRealPath + fileMetaData.getFilePath());
		
			Path path = Paths.get(file.getAbsolutePath());
	        Resource resource;
			try {
				resource = new UrlResource(path.toUri());
				String contentType = null;
				contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
				if(contentType == null) {
					contentType = "application/octet-stream";
				}
				return ResponseEntity.ok()
						.contentType(MediaType.parseMediaType(contentType))
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + URLEncoder.encode(fileMetaData.getFileOriginalName(),"UTF-8") + "\";")
						.body(resource);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		URI redirectUri = new URI("/");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(redirectUri);
		
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
	}
	
	@GetMapping("/admin/file/fileDownload")
	public String fileDownloadView(Model model) {
		
		model.addAttribute("fileList", fileMapper.getFileList());
		
		return "admin/file/fileDownloadView";
	}
	
	@PostMapping("/admin/file/fileupload")
	public String fileuploadPro(@RequestPart(name = "files", required = false) MultipartFile[] files) {
			
		fileService.addFiles(files);
		
		return "redirect:/admin/file/fileupload";
	}

	@GetMapping("/admin/file/fileupload")
	public String fileuploadView(Model model) {
		
		model.addAttribute("title", "파일업로드");
		
		
		return "admin/file/fileUpload";
	}
}
