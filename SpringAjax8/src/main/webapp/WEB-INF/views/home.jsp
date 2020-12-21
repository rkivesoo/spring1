<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>데이터베이스 연동</title>
	<style type="text/css">
	form{
	width:500px;
	margin:10px auto;
	}
	ul{
	padding:0;
	margin:0;
	list-style:none;
	}
	
	ul li{
	padding:0;
	margin:0 0 10px 0;
	}
	
	label{
	width:150px;
	float:left;
	}
	table{
	border:1px solid gray;
	width:500px;
	margin:0 auto;
	border-collapse: collapse;
	}
	td{
	border:1px solid gray;
	}
	</style>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
	//목록 
	function selectData(){
		$('#output').empty(); //table내부 내용을 제거(초기화)
		
		$.ajax({
		url:'/springajax/getPeopleJSON.do',
		type:'POST',
		//dataType:'json', // 서버에서 보내줄 데이터 타입
		contentType:'application/x-www-form-urlencoded;charset=utf-8',
		
		success:function(data){
			$.each(data, function(index, item){
				var output=' ' ;
				output += '<tr>';
				output += '<td>'+item.id+'</td>';
				output += '<td>'+item.name+'</td>';
				output += '<td>'+item.job+'</td>';
				output += '<td>'+item.address+'</td>';
				output += '<td>'+item.bloodtype+'</td>';
				
				output += '<td><a href="/springajax/updatePeople.do"'; //add
				output += 'class="update_data"'; //add
				output += 'id=' + item.id + '>수정</a>';//add12060308
				
				output += '<a href="/springajax/deletePeople.do"'; 
				output += 'class="delete_data"'; //				
				output += 'id=' + item.id + '>삭제</a></td>';
				
				output += '<tr>';
				console.log("output:"+output);
				$('#output').append(output);
			});
		},
		error:function(){
			alert("ajax통신 실패1!!!");			
		}
		});			
	}
	
	$(document).ready(function(){
		
		$('#input_data').click(function(event){
			var params = $("#insert_form").serialize();
			alert(params);
			jQuery.ajax({
				url: '/springajax/insertPeople.do',
				type:'POST',
				data: params, //서버로 보낼 데이터 
				/* (참고)파일 첨부시 필요함 
				-cache: false 로 선언시 ajax로 통신 중 cache가 남아서 갱신된 데이터를 받아오지 못할 경우를 대비
			 	-contentType: flase 로 선언시 content-type 헤더가 multipart/form-data로 전송되게 함
			 	-processData: false로 선언시 formData를 string으로 변환하지 않음
			 	*/ 
			 contentType: 'application/x-www-form-urlencoded;charset=utf-8',
			 dataType: 'json', //서버에게 보내줄 데이터 타입
			 success: function(retVal){
				 if(retVal.res =="OK"){
					 //데이터 성공일때 이벤트 작성
					selectData();
					 //초기화
					 $('#id').val('');
					 $('#name').val('');
					 $('#job').val('');
					 $('#address').val('');
					 $('#bloodtype').val('');
				 }
				 else
					 {
					 alert("Insert Fail!!!");
					 }					
				 },
				 error:function(){
					 alert("ajax통신 실패!!!");					 
				 }
			 });
			//기본이벤트 제거 
			event.preventDefault(); 
   });
	//
	$(document).on('click', '.delete_data', function(event){
		alert($(this).attr("href"));
		jQuery.ajax({
			url: $(this).attr("href"),
			type:'POST',
			data:{'id':$(this).attr("id")},
			contentType: 'application/x-www-form-urlencoded;charset=utf-8',	
			dataType:'json',
			success:function(retVal){
				if(retVal.res=="OK"){//데이타 성공일때 이벤트 작성    
					selectData();				
				}
				else
				{
					alert("Delete Fail!!!");					
				}
			},
			error:function(){
				alert("ajax통신 실패2!!!");
			}
		});
		//기본 이벤트 제거 
		event.preventDefault();				
	});
	
	//수정을  시작
	//
	$(document).on('click', '.update_data', function(event){
		alert($(this).attr("href"));
		jQuery.ajax({
			url: $(this).attr("href"),
			type:'POST',
			data:{'id':$(this).attr("id")},
			contentType: 'application/x-www-form-urlencoded;charset=utf-8',	
			dataType:'json',
			//--------------------------------------------
			success:function(){
				//$(".selectData").text();
				//$(".update_date").text();
				$("input[type=hidden][name=id]").val();
				$("input[type=text][name=name]").val();
				$("input[type=text][name=job]").val();
				$("input[type=text][name=adress]").val();
				$("input[type=text][name=bloodtype]").val();
				//$('#id').val(data.id);
		        //$('#name').val(data.name);
		     //   $('#name').text();
			//	$('#job').val(data.job);
			//	$('#adress').val(data.adress);
			//	$('#bloodtype').val(data.bloodtype);
			//----------------------------------------------------------	
				selectData();
			},
			error:function(){
				alert("ajax통신 실패2!!!");
			}
		});
		//기본 이벤트 제거 
		event.preventDefault();				
	});
	//수정 종료 
	
	selectData();
});		
	
</script>	
</head>
<body>
	<form id="insert_form" method="post">
		<fieldset>
			<legend>데이터 추가</legend>
				<ul>
					<li>
						<label for="id">아이디</label>
						<input type="text" name="id" id="id">
					</li>
					<li>
						<label for="name">이름</label>
						<input type="text" name="name" id="name">
					</li>
					<li>
						<label for="job">직업</label>
						<input type="text" name="job" id="job">
					</li>
					<li>
						<label for="name">주소</label>
						<input type="text" name="address" id="address">
					</li>
					<li>
						<label for="bloodtype">혈액형</label>
						<input type="text" name="bloodtype" id="bloodtype">
					</li>
					<li>
						<input type="button"value="추가" id="input_data">
					</li>							
				</ul>
		</fieldset>
	</form>
	<form id ="updata_form" method="post">
		<table id="output"></table>
	</form>	
</body>
</html>
