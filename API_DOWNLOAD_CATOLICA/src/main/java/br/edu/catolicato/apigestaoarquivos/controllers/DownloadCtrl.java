package br.edu.catolicato.apigestaoarquivos.controllers;

import br.edu.catolicato.apigestaoarquivos.entities.FileModel;
import br.edu.catolicato.apigestaoarquivos.services.FileModelService;
import br.edu.catolicato.apigestaoarquivos.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

@RestController
@RequestMapping(path = "/download")
public class DownloadCtrl {

	private final StorageService storageService;
	private final FileModelService fileModelService;

	@Autowired
	public DownloadCtrl(StorageService storageService, FileModelService service) {
		this.storageService = storageService;
		this.fileModelService = service;
	}

	@GetMapping(path = "/{typeDownload}/{fileID}")
	@ResponseBody
	public ResponseEntity<InputStreamResource> handleFileUpload(@PathVariable("typeDownload") String typeDownload, @PathVariable("fileID") String fileID) throws FileNotFoundException {
		FileModel fileModel = fileModelService.findByID(fileID);
		if (Objects.nonNull(fileModel)) {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("Content-Disposition", typeDownload + "; filename=\"" + fileModel.getNome() + "\"");
			return ResponseEntity.ok()
					.contentLength(fileModel.getTamanho())
					.contentType(MediaType.parseMediaType(fileModel.getTipo()))
					.headers(httpHeaders)
					.body(new InputStreamResource(
							new FileInputStream(
									storageService.load(fileModel.getNome()).toFile())));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
