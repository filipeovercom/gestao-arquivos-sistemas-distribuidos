package br.edu.catolicato.apigestaoarquivos.services;

import br.edu.catolicato.apigestaoarquivos.entities.FileModel;

public interface FileModelService {
	FileModel findByID(String id);
}
