package br.edu.catolicato.apigestaoarquivos.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileSystemStorageService implements StorageService {

	@Value("${root.location}")
	private String ROOT_LOCATION;

	@Override
	public Path load(String filename) {
		Path rootLocation = Paths.get(ROOT_LOCATION);
		return rootLocation.resolve(filename);
	}
}
