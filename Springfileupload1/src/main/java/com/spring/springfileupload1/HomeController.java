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
	
	 //Ŀ�ǵ� ��ü(VO,DTO)�� ���� ���ε� ���� ���� 
	//Ŀ�ǵ� Ŭ������ �Ķ���Ϳ� ������ �̸��� MultipartFileŸ�� ������Ƽ�� �߰����ֱ⸸ �ϸ� 
	//���ε� ���� ������ Ŀ�ǵ� ��ü�� ���� ���� ������ �ְ� �ȴ�. 
	@RequestMapping("/fileUpload1.bo")
	public ModelAndView fileUpload1(HttpServletRequest
			request, 
			RequestModel model) throws Exception {
		
	
		String name=request.getParameter("name");
		
		String uploadPath="C:\\Project\\upload\\"; //���� ���ε�� ��ġ ���� :�齽���ø� �ϳ��� ���� ����ڰ� �Ǿ� ������ �ΰ� ����.
	
		//�� ���� 
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("download");
		
		ArrayList<String> orgfile_list=new ArrayList<String>();//�������� ���� ��
		ArrayList<String> storedfile_list=new ArrayList<String>();//���� ������ ����(������ ����ɶ� ���� �� )�� ����� ����Ʈ
		ArrayList<Long> filesize_list=new ArrayList<Long>();
		
		for(MultipartFile mf:model.getFile()) {
			String originFileName=mf.getOriginalFilename();//���� ���� �� ????
		
			//String originFileName=mf.getOriginalFilename();//���� ���� ��
			//String sriginFileName=mf.getOriginalFilename();//���� ���� ��
			long fileSize=mf.getSize();//���� ������ 
			
		
			//String originFileName;
			System.out.println("originFileName:"+originFileName);//��� �ҷ� �Դ��� Ȯ�� �ϴ� �۾� ��
			System.out.println("fileSize:"+fileSize);//��� �ҷ� �Դ��� Ȯ�� 
			String storedFileName=System.currentTimeMillis()+originFileName;
		//�ð��� �и�������� ������ ���� ���� ���� ���� ���⿡ �������� ���� ���� ���̸� ������ �����̸��� �ϳ� ���� ��޾� ����. 
			
			System.out.println("storedFileName="+storedFileName);
			String safeFile=uploadPath+storedFileName;//������ ��ġ+���ϸ�
			try {
				if(mf.getSize()!=0) {//0�� �ƴ� 
					mf.transferTo(new File(safeFile));//transferTo���ε忡 ���Ǵ� �޼ҵ�(����)_//safeFile���� ��Ʈ�� ������ ������ ���� ��ü�� ������� new File(safeFile))
				}//���ε� ��.
			}catch(IOException e) {
				System.out.println("���ε� ����!!!");
		}
			orgfile_list.add(originFileName);
			storedfile_list.add(storedFileName);
			filesize_list.add(fileSize);//����Ʈ�� �߰� 
		}
		//�信 ����� ������ �𵨿� ����. 
		mav.addObject("name", name);
		mav.addObject("orgfile_list", orgfile_list);
		mav.addObject("storedfile_list", storedfile_list);
		mav.addObject("filesize_list", filesize_list);
		mav.addObject("uploadPath", uploadPath);

		return mav;
		
}
	//MultipartHttpServletRequest�� �̿��� ���ε� ���� ����
	@RequestMapping("/fileUpload2.bo")
	public ModelAndView fileUpload2(MultipartHttpServletRequest
			request) throws Exception{
		 String name=request.getParameter("name");
		 List<MultipartFile> fileList =request.getFiles("file");//=request.getFiles("file");�Ʊ� ���ε�?����? �̰��о�� .getFiles("file")÷�ε� ������ ����Ʈ�� ��ȯ
		 String uploadPath="C:\\Project\\upload\\";//���� ���ε�� ��ġ ����
		 
		 //������ 

			//�� ���� 			
			ModelAndView mav=new ModelAndView();
			mav.setViewName("download");
			
			ArrayList<String> orgfile_list=new ArrayList<String>();
			ArrayList<String> storedfile_list=new ArrayList<String>();
			ArrayList<Long> filesize_list=new ArrayList<Long>();
			
			for(MultipartFile mf: fileList) {
				String originFileName=mf.getOriginalFilename();//���� ���� ��
				long fileSize=mf.getSize();//���� ������ 
				
			
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
					System.out.println("���ε� ����!!!");
			}
				orgfile_list.add(originFileName);
				storedfile_list.add(storedFileName);
				filesize_list.add(fileSize);
			} 
			//�信 ����� ������ �𵨿� ����. 
			mav.addObject("name", name);
			mav.addObject("orgfile_list", orgfile_list);
			mav.addObject("storedfile_list", storedfile_list);
			mav.addObject("filesize_list", filesize_list);
			mav.addObject("uploafPath", uploadPath);
			
			return mav;
	}
	
		//���� �ٿ�ε� ��� 
	@RequestMapping("/fileDownload.bo")
	public void fileDownload(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("utf-8");
		
		String of =request.getParameter("of");//������ ���ε�� ����� ���� ���ϸ� 
		String of2=request.getParameter("of2");//�������� ���ϸ�

		
	/*//������Ʈ ��Ʈ���丮�� ���� ��ũ���� ��� �˾Ƴ���. 
	 String uploadPath=request.getSession().getServletContext().getRea
	 String fullPath=uploadPath+"/"+of;
	 
	 */
		
	String uploadPath="C:\\Project\\upload\\";//���� ��� ����
	 String fullPath=uploadPath + of ;
	 File downloadFile=new File(fullPath); //���ϰ�ü�� �������.
	 
	 //���� �ٿ�ε带 ���� ������ Ÿ���� application/download ���� 
	 response.setContentType("application/download; charset=UTF-8");
	 //���� ������ ���� //����
	 response.setContentLength((int)downloadFile.length());
	 //�ٿ�ε� â�� ���� ���� ��� ���� 
	 response.setHeader("Content-Disposition", "attachment;filename="
			 			+new String(of2.getBytes(),"ISO8859_1"));
	 response.setHeader("Content-Transfer-Encoding","binary");
	 
	 /*
	  * Content-disposition�Ӽ� 
	  * 1)"Content_disposition:attachment"������ �ν� ���� Ȯ���ڸ� �����Ͽ� ��� Ȯ����
	  *    ���ϵ鿡 ����, �ٿ�ε�� ������:"���� �ٿ�ε�"��ȭ���ڰ� �ߵ��� �ϴ� ��� �Ӽ��̴�.
	  *    2) "Content-disposition:inline"������ �ν� ����Ȯ���ڸ� ���� ���ϵ鿡 ���ؼ��� 
	  *    �������� �󿡼� �ٷ� ������ ����, �׿��� ���ϵ鿡 ���ؼ��� "���� �ٿ�ε�"��ȭ���ڰ� 
	  *    �ߵ��� �ϴ� ��� �Ӽ��̴�.
	  *    
	  * */
	 
	 FileInputStream fin= new FileInputStream(downloadFile);
	 ServletOutputStream sout=response.getOutputStream();
	 
	 byte[] buf = new byte[1024];
	 int size=-1;
	 
	 while((size=fin.read(buf, 0, buf.length))!=-1) {
		 sout.write(buf,0,size);//sout.��°�ü�� write�ϸ� ��� ���ϴ� ��. //jsp�� �ٿ�ε� ������ ��� 
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
