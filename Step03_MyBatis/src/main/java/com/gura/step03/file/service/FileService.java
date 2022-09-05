package com.gura.step03.file.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.step03.file.dto.FileDto;

public interface FileService {
	public void addFile(FileDto dto);
	public void updateFile(FileDto dto);
	public void deleteFile(int num);
	public void getFile(int num, ModelAndView mView);
	public void getListFile(ModelAndView mView);

}
