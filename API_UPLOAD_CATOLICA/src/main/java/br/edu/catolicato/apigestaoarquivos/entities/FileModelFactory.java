package br.edu.catolicato.apigestaoarquivos.entities;

import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public class FileModelFactory {

	private MultipartFile multipartFile;

	public FileModelFactory(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public FileModel factory() {
		FileModel fileModel = new FileModel();
		if(Objects.nonNull(multipartFile)) {
			fileModel.setNome(multipartFile.getOriginalFilename());
			fileModel.setTamanho(multipartFile.getSize());
			fileModel.setTipo(multipartFile.getContentType());
		}
		return fileModel;
	}
}
