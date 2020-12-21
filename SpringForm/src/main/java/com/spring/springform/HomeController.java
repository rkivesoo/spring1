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
		Connection con=null; //������ Ȱ���ϱ� ���� ���� ����, ������Ʈ �Ҷ��� ���̹�Ƽ���� ����� ��
		PreparedStatement pstmt=null;
		
		try {
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String sql="insert into emp_copy values (?,?,?,?,sysdate,?,?,?)";
			Class.forName(driver);
			con=DriverManager.getConnection(url,"scott","123456");//���ᰴü�� �����������
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
		return"index";//�ε����� ~
	}
	
	@RequestMapping(value = "selectProcess.me")//��ü ����Ʈ ���ϴ� �۾�. 
	public String selectProcess(Model model) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<EmpVO>list=new ArrayList<EmpVO>();//��̸���Ʈ�� Ÿ���� empvo��� ������ ���. 
		
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
			
			    list.add(empvo);//����Ʈ�� �߰� �Ѵ�. //�ᱹ ��̸���Ʈ���� empvo�� ����
			}
			model.addAttribute("list", list);//�� �� ��ü�� �������̽��� �Ǿ� �־ ���� ��ü�� ����� ����. 
			//�� ���� ������ ���� ��ü�� ���� ���� ���  �Ķ���ͷ� (������ ���� ����� �̿��ؼ� ó�� �� �� �ֵ��� �Ķ���ͷ� ����Ѵ�.��l65)
		}
		catch(Exception e)
		{
			
		}
		return "list";
	}
	
	/* delProcess ------*/	
	@RequestMapping(value = "delProcess.me")//������ �غ���. 
	public String delProcess(Model model, 
			@RequestParam(value="Empno", required=false,        
			defaultValue="1") int Empno){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<EmpVO>list=new ArrayList<EmpVO>();//try_202011252013_�����ϴµ� �ش� ������ �ʿ� �ұ�? 
		
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
	@RequestMapping(value = "selectDept.me")//�μ�....
	public String selectDept(Model model,					     //������̼� @RequestParam....//required=false,-> �ݵ�� �������� �־�� �� ������ ����???
			@RequestParam(value="deptno", required=false,         //@RequestParam-> �Ķ���ͷ� ���� �Ǿ�� ������ �߿��� �� �̸��� deptno�� ���� �����͸� �����Ҷ� ����.
			defaultValue="1") int deptno) {                       //���� 103�������� ���� ���ؼ� 104������ int deptno�� ������ �ش�. 
				                                                       //afterall...�Ķ���ͷ� ���� �Ǿ�� Ư�� �Ķ���� ���� ó�� �Ҷ� ������̼Ǹ�����Ʈ�Ķ��� ���ٴ�.... 
		
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

	@RequestMapping(value = "joinProcess.me")//���θ���Ʈ�������� ���� ��ü ����Ʈ ��� ȭ�� ���� �ؿ�. 
	public String joinProcess(Model model) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<EmpDeptVO>list=new ArrayList<EmpDeptVO>();//��̸���Ʈ�� Ÿ���� empvo��� ������ ���. 
		
		try {
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			con=DriverManager.getConnection(url, "scott","123456");
			pstmt=con.prepareStatement("select E.empno, E.ename, E.job, E.deptno, D.dname, D.loc\n" + 
					"from emp_copy E, dept_copy D\n" + 
					"where e.deptno=d.deptno");//���⿡ ���� ���� �־� ��� �Ѵ�.1756
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
				
				list.add(empdeptvo);//����Ʈ�� �߰� �Ѵ�.
				//�ᱹ ��̸���Ʈ���� empvo�� ����
			}
			model.addAttribute("list", list);//202011251821_�ϴ� ����Ʈ�� �״�� �ΰ� �׽�Ʈ ����1821
			//model.addAttribute("empdept_list", empdept_list);//202011251821_�ϴ� ����Ʈ�� �״�� �ΰ� �׽�Ʈ ����1821
			
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
