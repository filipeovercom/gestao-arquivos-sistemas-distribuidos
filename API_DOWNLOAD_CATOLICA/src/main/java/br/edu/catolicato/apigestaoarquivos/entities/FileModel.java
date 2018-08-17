package br.edu.catolicato.apigestaoarquivos.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Document
public class FileModel {

	@Id
	private String id;
	private String nome;
	private String tipo;
	private Long tamanho;
	private LocalDateTime dataHoraInclusao = LocalDateTime.now();

	public FileModel() {
	}

	public FileModel(String nome, String tipo, Long tamanho) {
		this.nome = nome;
		this.tipo = tipo;
		this.tamanho = tamanho;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotNull
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getTamanho() {
		return tamanho;
	}

	public void setTamanho(Long tamanho) {
		this.tamanho = tamanho;
	}

	public LocalDateTime getDataHoraInclusao() {
		return dataHoraInclusao;
	}

	public void setDataHoraInclusao(LocalDateTime dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}
}
