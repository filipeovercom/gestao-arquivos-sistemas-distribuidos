package br.edu.catolicato.apigestaoarquivos.entities;

import java.util.List;

public class DataTableFileModelDTO {

	private Integer draw;
	private Integer recordsTotal;
	private Integer recordsFiltered;
	private List<List<String>> data;

	public DataTableFileModelDTO(Integer draw, Integer recordsTotal, Integer recordsFiltered, List<List<String>> data) {
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<List<String>> getData() {
		return data;
	}

	public void setData(List<List<String>> data) {
		this.data = data;
	}
}
