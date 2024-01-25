<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.7.1.js"></script>



<script type="text/javascript">

$(document).ready(function(){
	
	// 우편번호 검색 결과 에서 하나를 선택하면 
	$(document).on('click', '.zip-tr', function(){
		zcode = $('td', this).eq(0).text();
		addr = $('td', this).eq(1).text();
		
		console.log(zcode);
		console.log(addr);
		
		// 부모 창 input에 출력
		$(opener.document).find('#zip').val(zcode);
		$(opener.document).find('#add1').val(addr);
		
		window.close();
	});
	
	// 확인버튼 클릭
	$('input[type=button]').on('click', function(){
		// 입력한 동이름 가져오기
		dongvalue = $('#dong').val();
		
		// 입력여부 체크
		if(dongvalue == null || dongvalue.length < 1){
			alert("동 입력하세요");
			return;
		}
		
		// 서버로 전송
		$.ajax({
			url : '/jqpro/member/searchPostServlet.jsp',
			type : 'post',
			data : { "dong" : dongvalue	},
			success : function(res){
				alert(res.zipcode);
				let code = `<table>`;
				code += `<tr><td>우편번호</td>`;
				code += `<td>주소</td>`;
				code += `<td>번지</td></tr>`;
				
				$.each(res, function(i, v){
					
					bunji = v.bunji;
					if(bunji == null) bunji = "";
					
					code += `<tr class="zip-tr"><td>${v.zipcode}</td>`;
					code += `<td>${v.sido} ${v.gugun} ${v.dong}</td>`;
					code += `<td>${bunji}</td>`;
					code += `</tr>`;
				});
				
				code += `</table>`;
				
				$('#result').append(code);
			},
			error : function(xhr){
				alert(xhr.status);
			},
			dataType : 'json' // json.parse() 자동으로 해줌
		});
	});
});

</script>

<style type="text/css">
.zip-tr:hover{
	background: lime;
}
</style>

</head>
<body>
<h2>우편번호 찾기</h2>
동이름 입력
<input type="text" id="dong">
<input type="button" value="확인">
<div id="result"></div>
</body>
</html>