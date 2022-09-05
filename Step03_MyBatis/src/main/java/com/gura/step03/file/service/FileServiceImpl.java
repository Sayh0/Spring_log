package com.gura.step03.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step03.file.dao.FileDao;
import com.gura.step03.file.dto.FileDto;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileDao dao;

	@Override
	public void addFile(FileDto dto) {
		dao.insert(dto);
	}

	@Override
	public void updateFile(FileDto dto) {
		dao.update(dto);
	}

	@Override
	public void deleteFile(int num) {
		dao.delete(num);
	}

	@Override
	public void getFile(int num, ModelAndView mView) {
		FileDto dto=dao.getData(num);
		mView.addObject("dto", dto);
	}

	@Override
	public void getListFile(ModelAndView mView) {
		List<FileDto> list=dao.getList();
		mView.addObject("list", list);
	}

}
