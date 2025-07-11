package ksmybatis.file.service;

import org.springframework.web.multipart.MultipartFile;

import ksmybatis.file.domain.FileMetaData;

public interface FileService {

	void addFile(MultipartFile file);
	void addFiles(MultipartFile[] files);
	void deleteFile(FileMetaData fileMetaData);
}
