package com.gura.step03.file.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step03.file.service.FileService;

@Controller
public class FileController {
		/*
			<input type="text" name="title" placeholder="설명 입력 . . . " /><br />
			<input type="file" name="myFile" />
			
			위에서 name 속성의 값은 title와 myFile이라는 이름으로 매개변수명을 정하면
			전송된 text는 title 변수에 담기고
			전송된 파일에 대한 정보(파일명, 파일 크기, 전송된 파일의 객체)는 myFile 객체에 담긴다. 
		 */
	@Autowired
	private FileService service;
	
	
		//CREATE----------------------------------
	   @RequestMapping("/file/upload")
	   public ModelAndView upload(String title, MultipartFile myFile, //매개변수명 유지 필수인거 알지?
			   //여기선 MultipartFile이 큰 역할을 한다.
	         HttpServletRequest request) {
	   
	      //원본 파일명
	      String orgFileName=myFile.getOriginalFilename();
	      //파일 사이즈
	      long fileSize=myFile.getSize();
	      
	      //upload 폴더에 저장할 파일명을 직접구성한다.
	      // 대충 이런 식으로 나온다. 1234123424343xxx.jpg 파일명이 겹칠 일이 없지.
	      String saveFileName=System.currentTimeMillis()+orgFileName;
	      
	      // webapp/upload 폴더까지의 실제 경로 얻어내기 
	      String realPath=request.getServletContext().getRealPath("/upload");
	      // upload 폴더가 존재하지 않을경우 만들기 위한 File 객체 생성
	      File upload=new File(realPath);
	      if(!upload.exists()) {//만일 존재 하지 않으면
	         upload.mkdir(); //만들어준다.
	      }
	      String savePath=null; //savePath 경로를 위한 변수추가.
	      try {
	         //파일을 저장할 전체 경로를 구성한다.  
	         savePath=realPath+File.separator+saveFileName;
	         //separator? > 운영체제 별 \나 / 등 경로설정특수문자때문에 꼬이는 경우를 방지. 운영체제에 맞는 파일구분자가 리턴.
	         //임시폴더에 업로드된 파일을 원하는 파일을 저장할 경로에 전송한다.
	         myFile.transferTo(new File(savePath)); 
	         //transfetTo < 중요. 임시파일을 요청한 경로에 파일객체로 저장해줌 .
	         
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	      //업로드된 파일의 정보를 원래는 DB에 저장해야 하지만 테스트 중이니 그냥 ModelAndView 객체에 담기,
	      // view page 에서 확인만 해 보기.
	      ModelAndView mView=new ModelAndView();
	      mView.addObject("title", title);
	      mView.addObject("fileSize", fileSize);
	      mView.addObject("orgFileName", orgFileName);
	      mView.addObject("saveFileName", saveFileName);
	      mView.addObject("savePath", savePath);
	      mView.setViewName("file/upload");
	      
	      return mView;
	   }
	   //CREATE----------------------------------
	   
	   //READ------------------------------------
	   @RequestMapping("/file/list")
	   public ModelAndView list() {
		   ModelAndView mView=new ModelAndView();
		   service.getListFile(mView);
		   mView.setViewName("file/list");
		   return mView;
	   }
	   //READ------------------------------------

	}
