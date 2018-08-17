package br.edu.catolicato.apigestaoarquivos.controllers;

import br.edu.catolicato.apigestaoarquivos.entities.DataTableFileModelDTO;
import br.edu.catolicato.apigestaoarquivos.services.FileModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/arquivos")
public class ListagemArquivosCtrl {

	private final FileModelService fileModelService;

	@Autowired
	public ListagemArquivosCtrl(FileModelService service) {
		this.fileModelService = service;
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/datatable")
	public ResponseEntity<DataTableFileModelDTO> buildDataTable() {
		try {
			DataTableFileModelDTO dataTableDTO = fileModelService.listAllFiles();
			return ResponseEntity.ok().body(dataTableDTO);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
