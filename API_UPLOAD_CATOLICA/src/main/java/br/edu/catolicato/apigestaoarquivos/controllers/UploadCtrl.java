package br.edu.catolicato.apigestaoarquivos.controllers;

import br.edu.catolicato.apigestaoarquivos.services.FileModelService;
import br.edu.catolicato.apigestaoarquivos.storage.StorageException;
import br.edu.catolicato.apigestaoarquivos.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/upload")
public class UploadCtrl {

	private final FileModelService fileModelService;

	@Autowired
	public UploadCtrl(FileModelService service) {
		this.fileModelService = service;
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping
	public ResponseEntity<Response<String>> handleFileUpload(@RequestBody MultipartFile file) {
		List<String> errorMessages = new ArrayList<>();
		try {
			fileModelService.save(file);
		} catch (StorageException e){
			errorMessages.add(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(errorMessages));
		}
		return ResponseEntity.ok().body(new Response<>("Arquivo " + file.getOriginalFilename() + " salvo com sucesso!"));
	}
}
