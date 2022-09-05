package com.gura.step03.file.dao;

import java.util.List;

import com.gura.step03.file.dto.FileDto;

public interface FileDao {
	public void insert(FileDto dto);
	public void update(FileDto dto);
	public void delete(int num);
	public FileDto getData(int num);
	public List<FileDto> getList();

}
