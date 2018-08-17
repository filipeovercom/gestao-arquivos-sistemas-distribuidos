package br.edu.catolicato.apigestaoarquivos.services;

import br.edu.catolicato.apigestaoarquivos.entities.DataTableFileModelDTO;
import br.edu.catolicato.apigestaoarquivos.entities.DataTableFileModelDTOFactory;
import br.edu.catolicato.apigestaoarquivos.entities.FileModel;
import br.edu.catolicato.apigestaoarquivos.repositories.FileModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileModelService {

	private final FileModelRepository repository;

	@Autowired
	public FileModelService(FileModelRepository repository) {
		this.repository = repository;
	}

	public DataTableFileModelDTO listAllFiles() {
		List<FileModel> result = repository.findAll();
		return new DataTableFileModelDTOFactory(1, result.size(), result.size(), result).buildData();
	}
}
