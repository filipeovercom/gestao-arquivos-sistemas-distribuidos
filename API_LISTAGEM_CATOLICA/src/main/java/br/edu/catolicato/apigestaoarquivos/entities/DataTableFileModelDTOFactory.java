package br.edu.catolicato.apigestaoarquivos.entities;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataTableFileModelDTOFactory {

	private final List<FileModel> fileModels;
	private DataTableFileModelDTO dataTableFileModelDTO;

	public DataTableFileModelDTOFactory(Integer draw, Integer recordsTotal, Integer recordsFiltered,
										List<FileModel> fileModels) {
		this.dataTableFileModelDTO = new DataTableFileModelDTO(draw, recordsTotal, recordsFiltered, new ArrayList<>());
		this.fileModels = fileModels;
	}

	public DataTableFileModelDTO buildData() {
		List<List<String>> rows = new ArrayList<>();
		if (Objects.nonNull(fileModels)) {
			fileModels.forEach(fileModel -> {
				List<String> columns = new ArrayList<>();
				columns.add(fileModel.getId());
				columns.add(fileModel.getNome());
				columns.add(fileModel.getTipo());
				columns.add(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(fileModel.getDataHoraInclusao()));
				columns.add(convertLongToFileFormat(fileModel.getTamanho()));
				columns.add("");
				rows.add(columns);
			});
		}
		this.dataTableFileModelDTO.setData(rows);
		return dataTableFileModelDTO;
	}

	private String convertLongToFileFormat(Long size) {
		if (size <= 0) return "0";
		final String[] units = new String[]{"B", "kB", "MB", "GB", "TB"};
		int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
		return new DecimalFormat("#,##0.#")
				.format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
	}
}
