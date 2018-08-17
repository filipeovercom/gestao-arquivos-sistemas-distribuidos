package br.edu.catolicato.apigestaoarquivos.services;

import br.edu.catolicato.apigestaoarquivos.storage.StorageService;
import br.edu.catolicato.apigestaoarquivos.entities.FileModel;
import br.edu.catolicato.apigestaoarquivos.entities.FileModelFactory;
import br.edu.catolicato.apigestaoarquivos.repositories.FileModelRepository;
import br.edu.catolicato.apigestaoarquivos.storage.StorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileModelServiceImpl implements FileModelService {

	private final FileModelRepository repository;
	private final StorageService storageService;

	@Autowired
	public FileModelServiceImpl(FileModelRepository repository, StorageService storageService) {
		this.repository = repository;
		this.storageService = storageService;
	}

	@Override
	public FileModel save(MultipartFile file) throws StorageException {
		if(fileIsValid(file)) {
			FileModelFactory fileModelFactory = new FileModelFactory(file);
			FileModel fileModel = fileModelFactory.factory();
			try {
				repository.save(fileModel);
			} catch (Exception e) {
				throw new StorageException("Erro ao salvar informações do arquivo no banco de dados!", e);
			}
			try {
				storageService.store(file);
			} catch (StorageException e) {
				repository.delete(fileModel);
				throw new StorageException("Erro ao salvar arquivo no disco local!", e);
			}
			return fileModel;
		} else {
			throw new StorageException("Arquivo é inválido! Tipos aceitos: [pdf, png, jpg, jpeg, gif]");
		}
	}

	private boolean fileIsValid(MultipartFile file) {
		String type = file.getContentType();
		if (type.equalsIgnoreCase("image/png")) {
			return true;
		} else if (type.equalsIgnoreCase("image/jpeg")) {
			return true;
		} else if (type.equalsIgnoreCase("image/gif")) {
			return true;
		} else if (type.equalsIgnoreCase("image/jpg")) {
			return true;
		} else if (type.equalsIgnoreCase("application/pdf")) {
			return true;
		}
		return false;
	}

	@Override
	public void delete(FileModel fileModel) {
		repository.delete(fileModel);
	}
}
