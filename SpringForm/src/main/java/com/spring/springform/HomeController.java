package com.spring.springform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "inputForm.me")
	public String inputForm() {
		return "inputform";
	}
	
	@RequestMapping(value = "inputProcess.me")
	public String inputProcess(EmpVO vo) {
		Connection con=null; //배운개념을 활용하기 위해 직접 연결, 프로젝트 할때는 마이바티스를 사용할 것
		PreparedStatement pstmt=null;
		
		try {
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String sql="insert into emp_copy values (?,?,?,?,sysdate,?,?,?)";
			Class.forName(driver);
			con=DriverManager.getConnection(url,"scott","123456");//연결객체를 직접만들었지
			System.out.println("con=" + con);
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1,vo.getEmpno());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3,vo.getJob());
			pstmt.setInt(4, vo.getMgr());
			pstmt.setDouble(5, vo.getSal());
			pstmt.setDouble(6, vo.getComm());
			pstmt.setInt(7, vo.getDeptno());
			System.out.println("AAAAAAA1111111");
			int res = pstmt.executeUpdate();
			System.out.println("res=" + res);
			
		}
		catch(Exception e)
		{
		}
		return"index";//인덱스로 ~
	}
	
	@RequestMapping(value = "selectProcess.me")//전체 리스트 구하는 작업. 
	public String selectProcess(Model model) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<EmpVO>list=new ArrayList<EmpVO>();//어레이리스트의 타입을 empvo라고 지정해 줬다. 
		
		try {
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			con=DriverManager.getConnection(url, "scott","123456");
			pstmt=con.prepareStatement("select*from emp_copy order by ename asc");
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				EmpVO empvo=new EmpVO();
				empvo.setEmpno(rs.getInt("empno"));
				empvo.setEname(rs.getString("ename"));
				empvo.setJob(rs.getString("job"));
				
				empvo.setMgr(rs.getInt("mgr"));
			    empvo.setHiredate(rs.getDate("hiredate"));
			    empvo.setSal(rs.getDouble("sal"));
			    empvo.setComm(rs.getDouble("comm"));
			    empvo.setDeptno(rs.getInt("deptno"));
			
			    list.add(empvo);//리스트에 추가 한다. //결국 어레이리스트에는 empvo가 저장
			}
			model.addAttribute("list", list);//이 모델 객체는 인터페이스로 되어 있어서 직접 객체로 만들수 없다. 
			//이 모델을 가지고 직접 객체를 만들 수는 없어서  파라미터로 (의존성 주입 기법을 이용해서 처리 할 수 있도록 파라미터로 사용한다.ㅣl65)
		}
		catch(Exception e)
		{
			
		}
		return "list";
	}
	
	/* delProcess ------*/	
	@RequestMapping(value = "delProcess.me")//삭제를 해본다. 
	public String delProcess(Model model, 
			@RequestParam(value="Empno", required=false,        
			defaultValue="1") int Empno){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<EmpVO>list=new ArrayList<EmpVO>();//try_202011252013_삭제하는데 해당 정보가 필요 할까? 
		
		try {
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			con=DriverManager.getConnection(url, "scott","123456");
			pstmt=con.prepareStatement("Delete from emp_copy where empno=?");
			pstmt.setInt(1, Empno);
			rs=pstmt.executeQuery();			
					
			model.addAttribute("list", list);
		}
		catch(Exception e)
		{
			
		}
		return "index";
	}
	
	/* ---------delProcess */	
	@RequestMapping(value = "selectDept.me")//부서....
	public String selectDept(Model model,					     //어노테이션 @RequestParam....//required=false,-> 반드시 뎁엔오가 있어야 해 없으면 에러???
			@RequestParam(value="deptno", required=false,         //@RequestParam-> 파라미터로 전달 되어온 데이터 중에서 그 이름이 deptno에 대한 데이터를 추출할때 쓴다.
			defaultValue="1") int deptno) {                       //값이 103뎁엔오인 놈을 구해서 104라인의 int deptno에 대입해 준다. 
				                                                       //afterall...파라미터로 전달 되어온 특정 파라미터 값을 처리 할때 어노테이션리퀘스트파람을 쓴다는.... 
		
		Connection con=null;
		PreparedStatement pstmt=null;
	
		ResultSet rs= null;
		DeptVO deptvo=null;
		
		try {
			String driver="oracle.jdbc.driver.OracleDriver";			
			
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			con=DriverManager.getConnection(url, "scott","123456");
			pstmt=con.prepareStatement("select*from dept_copy where deptno=?");
			pstmt.setInt(1, deptno);
			rs=pstmt.executeQuery();
			rs.next();
			deptvo=new DeptVO();
			deptvo.setDeptno(rs.getInt("deptno"));
			deptvo.setDname(rs.getString("dname"));
			deptvo.setLoc(rs.getString("loc"));
			
			model.addAttribute("deptvo", deptvo);
		}
		catch(Exception e)
		{			
		}
		return "deptview";
	}

	@RequestMapping(value = "joinProcess.me")//조인리스트결과출력을 위해 전체 리스트 출력 화면 복하 해옴. 
	public String joinProcess(Model model) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<EmpDeptVO>list=new ArrayList<EmpDeptVO>();//어레이리스트의 타입을 empvo라고 지정해 줬다. 
		
		try {
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			con=DriverManager.getConnection(url, "scott","123456");
			pstmt=con.prepareStatement("select E.empno, E.ename, E.job, E.deptno, D.dname, D.loc\n" + 
					"from emp_copy E, dept_copy D\n" + 
					"where e.deptno=d.deptno");//여기에 조인 쿼리 넣어 줘야 한다.1756
			rs=pstmt.executeQuery();			
			//202011251805
			
			while(rs.next()) {
				EmpDeptVO empdeptvo=new EmpDeptVO();
				empdeptvo.setEmpno(rs.getInt("empno"));
				empdeptvo.setEname(rs.getString("ename"));
				empdeptvo.setJob(rs.getString("job"));
				
				empdeptvo.setDeptno(rs.getInt("deptno"));
				
				empdeptvo.setDname(rs.getString("dname"));
				empdeptvo.setLoc(rs.getString("loc"));
				
				list.add(empdeptvo);//리스트에 추가 한다.
				//결국 어레이리스트에는 empvo가 저장
			}
			model.addAttribute("list", list);//202011251821_일단 리스트를 그대로 두고 테스트 수행1821
			//model.addAttribute("empdept_list", empdept_list);//202011251821_일단 리스트를 그대로 두고 테스트 수행1821
			
		}
		catch(Exception e)
		{
			
		}
	
		return "empdept_list";
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
	*/
}
