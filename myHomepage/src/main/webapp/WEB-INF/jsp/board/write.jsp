<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/el.jspf" %>
<h1>게시글 정보 작성</h1>
<form name="frm" enctype="multipart/form-data">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>
					title
				</th>
				<td>
					<input type="text" name="title" value="" />
				</td>
			<tr>
			<tr>
				<td colspan="2">
					<textarea rows="15" cols="10" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="file" name="atchFile" />
				</td>
			</tr>
		</thead>
	</table>
	
	<button class="btn btn-default" onclick="goList()">목록</button>
	<button class="btn btn-default" onclick="goInsert()">입력</button>
</form>
<script type="text/javascript">
	//<![CDATA[
	function goList() {
		location.href = "./list.do";
	}

	function goInsert() {
		if(confirm('입력하시겠습니까?')) {
			// validation check 부분 추가
			var f = document.frm;
			f.action="./insert.do";
			f.submit();
		}
	}
	//]]>
</script>


