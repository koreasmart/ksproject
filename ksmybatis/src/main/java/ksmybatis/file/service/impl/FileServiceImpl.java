package ksmybatis.file.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ksmybatis.file.domain.FileMetaData;
import ksmybatis.file.mapper.FileMapper;
import ksmybatis.file.service.FileService;
import ksmybatis.file.util.FilesUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class FileServiceImpl implements FileService{
	
	private final FilesUtils filesUtils;
	private final FileMapper fileMapper;
	
	@Override
	public void deleteFile(FileMetaData fileMetaData) {
		String path = fileMetaData.getFilePath();
		Boolean isDelete = filesUtils.deleteFileByPath(path);
		if(isDelete) fileMapper.deleteFileByIdx(fileMetaData.getFileIdx());
	}
	
	@Override
	public void addFile(MultipartFile file) {
		FileMetaData fileInfo = filesUtils.uploadFile(file);
		if(fileInfo != null) fileMapper.addfile(fileInfo); 
	}
	
	@Override
	public void addFiles(MultipartFile[] files) {
		List<FileMetaData> fileList = filesUtils.uploadFiles(files);
		if(!fileList.isEmpty()) fileMapper.addfiles(fileList);
	}
}
