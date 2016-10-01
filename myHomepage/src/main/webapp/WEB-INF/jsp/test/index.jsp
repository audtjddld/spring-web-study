<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<h2>ajax test</h2>
<input type="button" class="btn" value="click" onclick="ajaxTest();" />

<script type="text/javascript">
	function ajaxTest() {
		$.ajax({
			type : "GET" //"POST", "GET"
			,
			url : "/index.ajax" //Request URL
			,
			dataType : "json" //전송받을 데이터의 타입
			,
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			error : function(request, status, error) {
				//통신 에러 발생시 처리
				alert("code : " + request.status + "\r\nmessage : "
						+ request.reponseText);
			},
			success : function(response, status, request) {
				//통신 성공시 처리
				alert(response.message);
			}
		});
	}
</script>