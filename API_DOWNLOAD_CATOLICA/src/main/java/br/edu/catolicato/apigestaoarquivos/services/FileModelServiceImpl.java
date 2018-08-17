package br.edu.catolicato.apigestaoarquivos.services;

import br.edu.catolicato.apigestaoarquivos.entities.FileModel;
import br.edu.catolicato.apigestaoarquivos.repositories.FileModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileModelServiceImpl implements FileModelService {

	private final FileModelRepository repository;

	@Autowired
	public FileModelServiceImpl(FileModelRepository repository) {
		this.repository = repository;
	}

	@Override
	public FileModel findByID(String id) {
		return repository.findOne(id);
	}
}
