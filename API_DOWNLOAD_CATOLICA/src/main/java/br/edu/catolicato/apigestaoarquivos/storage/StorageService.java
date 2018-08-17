package br.edu.catolicato.apigestaoarquivos.storage;

import java.nio.file.Path;

public interface StorageService {
	Path load(String filename);
}
