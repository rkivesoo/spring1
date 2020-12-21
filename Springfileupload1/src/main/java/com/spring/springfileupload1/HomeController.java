package com.spring.springfileupload1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/fileUploadForm.bo")
	public String fileUploadForm() {
		return "fileUploadForm";
	}
	
	 //커맨드 객체(VO,DTO)를 통합 업로드 파일 접근 
	//커맨드 클래스에 파라미터와 동일한 이름의 MultipartFile타입 프로퍼티를 추가해주기만 하면 
	//업로드 파일 정보를 커맨드 객체를 통해 전달 받을수 있게 된다. 
	@RequestMapping("/fileUpload1.bo")
	public ModelAndView fileUpload1(HttpServletRequest
			request, 
			RequestModel model) throws Exception {
		
	
		String name=request.getParameter("name");
		
		String uploadPath="C:\\Project\\upload\\"; //직업 업로드될 위치 지정 :백슬레시를 하나만 쓰면 제어문자가 되어 버려서 두개 쓴다.
	
		//뷰 지정 
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("download");
		
		ArrayList<String> orgfile_list=new ArrayList<String>();//오리지날 파일 명
		ArrayList<String> storedfile_list=new ArrayList<String>();//실제 저장할 파일(서버에 저장될때 파일 명 )이 저장될 리스트
		ArrayList<Long> filesize_list=new ArrayList<Long>();
		
		for(MultipartFile mf:model.getFile()) {
			String originFileName=mf.getOriginalFilename();//원본 파일 명 ????
		
			//String originFileName=mf.getOriginalFilename();//원본 파일 명
			//String sriginFileName=mf.getOriginalFilename();//원본 파일 명
			long fileSize=mf.getSize();//파일 사이즈 
			
		
			//String originFileName;
			System.out.println("originFileName:"+originFileName);//어떻게 불러 왔는지 확인 하는 작어 ㅂ
			System.out.println("fileSize:"+fileSize);//어떻게 불러 왔는지 확인 
			String storedFileName=System.currentTimeMillis()+originFileName;
		//시간이 밀리세컨드면 동일한 값이 나올 수가 없다 여기에 오리지날 파일 네임 붙이면 저장할 파일이름이 하나 새로 몬달어 진다. 
			
			System.out.println("storedFileName="+storedFileName);
			String safeFile=uploadPath+storedFileName;//저장할 위치+파일명
			try {
				if(mf.getSize()!=0) {//0이 아님 
					mf.transferTo(new File(safeFile));//transferTo업로드에 사용되는 메소드(실제)_//safeFile파일 스트링 정보를 가지고 파일 객체를 만들었어 new File(safeFile))
				}//업로드 끝.
			}catch(IOException e) {
				System.out.println("업로드 에러!!!");
		}
			orgfile_list.add(originFileName);
			storedfile_list.add(storedFileName);
			filesize_list.add(fileSize);//리스트에 추가 
		}
		//뷰에 출력한 데이터 모델에 저장. 
		mav.addObject("name", name);
		mav.addObject("orgfile_list", orgfile_list);
		mav.addObject("storedfile_list", storedfile_list);
		mav.addObject("filesize_list", filesize_list);
		mav.addObject("uploadPath", uploadPath);

		return mav;
		
}
	//MultipartHttpServletRequest를 이용한 업로드 파일 접근
	@RequestMapping("/fileUpload2.bo")
	public ModelAndView fileUpload2(MultipartHttpServletRequest
			request) throws Exception{
		 String name=request.getParameter("name");
		 List<MultipartFile> fileList =request.getFiles("file");//=request.getFiles("file");아까 업로드?정보? 이게읽어와 .getFiles("file")첨부된 파일을 리스트로 반환
		 String uploadPath="C:\\Project\\upload\\";//직업 업로드될 위치 지정
		 
		 //뷰지정 

			//뷰 지정 			
			ModelAndView mav=new ModelAndView();
			mav.setViewName("download");
			
			ArrayList<String> orgfile_list=new ArrayList<String>();
			ArrayList<String> storedfile_list=new ArrayList<String>();
			ArrayList<Long> filesize_list=new ArrayList<Long>();
			
			for(MultipartFile mf: fileList) {
				String originFileName=mf.getOriginalFilename();//원본 파일 명
				long fileSize=mf.getSize();//파일 사이즈 
				
			
				//String originFileName;
				System.out.println("originFileName:"+originFileName);
				System.out.println("fileSize:"+fileSize);
				String storedFileName=System.currentTimeMillis()+originFileName;
				
				System.out.println("storedFileName="+storedFileName);
				
				String safeFile=uploadPath+storedFileName;
				
				try {
					if(mf.getSize()!=0) {
						mf.transferTo(new File(safeFile));
					}
				}catch(IOException e) {
					System.out.println("업로드 에러!!!");
			}
				orgfile_list.add(originFileName);
				storedfile_list.add(storedFileName);
				filesize_list.add(fileSize);
			} 
			//뷰에 출력한 데이터 모델에 저장. 
			mav.addObject("name", name);
			mav.addObject("orgfile_list", orgfile_list);
			mav.addObject("storedfile_list", storedfile_list);
			mav.addObject("filesize_list", filesize_list);
			mav.addObject("uploafPath", uploadPath);
			
			return mav;
	}
	
		//파일 다운로드 방식 
	@RequestMapping("/fileDownload.bo")
	public void fileDownload(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("utf-8");
		
		String of =request.getParameter("of");//서버에 업로드된 병경된 실제 파일명 
		String of2=request.getParameter("of2");//오리지날 파일명

		
	/*//웹사이트 루트디렉토리의 실제 디스크상의 경로 알아내기. 
	 String uploadPath=request.getSession().getServletContext().getRea
	 String fullPath=uploadPath+"/"+of;
	 
	 */
		
	String uploadPath="C:\\Project\\upload\\";//직업 경로 지정
	 String fullPath=uploadPath + of ;
	 File downloadFile=new File(fullPath); //파일객체를 만들었다.
	 
	 //파일 다운로드를 위해 컨텐츠 타입을 application/download 설정 
	 response.setContentType("application/download; charset=UTF-8");
	 //파일 사이즈 지정 //길이
	 response.setContentLength((int)downloadFile.length());
	 //다운로드 창을 띄우기 위한 헤더 조장 
	 response.setHeader("Content-Disposition", "attachment;filename="
			 			+new String(of2.getBytes(),"ISO8859_1"));
	 response.setHeader("Content-Transfer-Encoding","binary");
	 
	 /*
	  * Content-disposition속성 
	  * 1)"Content_disposition:attachment"브라우저 인식 차일 확장자를 포함하여 모든 확장자
	  *    파일들에 대해, 다운로드시 무조건:"파일 다운로드"대화상자가 뜨도록 하는 헤더 속성이다.
	  *    2) "Content-disposition:inline"브라우저 인신 파일확장자를 가진 파일들에 대해서는 
	  *    웹브라우저 상에서 바로 파일을 열고, 그외의 파일들에 대해서는 "파일 다운로드"대화상자가 
	  *    뜨도록 하는 헤더 속성이다.
	  *    
	  * */
	 
	 FileInputStream fin= new FileInputStream(downloadFile);
	 ServletOutputStream sout=response.getOutputStream();
	 
	 byte[] buf = new byte[1024];
	 int size=-1;
	 
	 while((size=fin.read(buf, 0, buf.length))!=-1) {
		 sout.write(buf,0,size);//sout.출력객체로 write하면 출려 ㄱ하는 것. //jsp와 다운로드 패턴은 비슷 
	 }
	 fin.close();
	 sout.close();
	}
		
	}

	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
*/
