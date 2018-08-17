package br.edu.catolicato.apigestaoarquivos.services;

import br.edu.catolicato.apigestaoarquivos.entities.FileModel;
import org.springframework.web.multipart.MultipartFile;

public interface FileModelService {

	FileModel save(MultipartFile file);

	void delete(FileModel fileModel);
}
