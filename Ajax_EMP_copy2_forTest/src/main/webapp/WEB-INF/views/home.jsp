<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>동적SQL연습</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
	//목록 
	function selectData(){
		$('#output').empty(); //table내부 내용을 제거(초기화)
		
		$.ajax({
		url:'/empcopy01/getEmpEx.do', // 고민 고민 
		type:'POST',
		//dataType:'json', // 서버에서 보내줄 데이터 타입 //오라클에서 받아 올때도 json으로 받아 오나? m.m 아니지 않나 알아보자. 
		contentType:'application/x-www-form-urlencoded;charset=utf-8',
		
		success:function(data){
			$.each(data, function(index, item){
				
				
				
				
				
				
				
				var output=' ' ;
				output += '<tr>';
				output += '<td>'+item.empno+'</td>';
				output += '<td>'+item.ename+'</td>';
				output += '<td>'+item.job+'</td>';
				output += '<td>'+item.mgr+'</td>';
				output += '<td>'+item.hiredate+'</td>';
				output += '<td>'+item.sal+'</td>';
				output += '<td>'+item.comm+'</td>';
				output += '<td>'+item.deptno+'</td>';
				output += '<tr>';
				console.log("output:"+output);
				$('#output').append(output);
			});
		},
		error:function(){
			alert("ajax통신 실패1!!!");			
		}
		});			
	//}
//	selectData();
//});	
};
selectData();//일부러 뺀거임  
//$(document).ready(function(){---->원래 이 것 밖에 셀렉트가 마지막으로 안에 있었던 (재확인 요망 )
//제이쿼리 기본 학습 및 코드 이해가 급함. js 마찬 가지 

	</script>
</head>

<body>
	<!-- 데이터 가져 오고 나면 체크 박스 자리  -->
	
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
