<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/el.jspf"%>
<h1>게시글 정보</h1>
<table class="table table-bordered">
	<thead>
		<tr>
			<th colspan="2">${info.title }[${info.regdate}]</th>
		<tr>
		<tr>
			<td colspan="2">
				<textarea rows="15" cols="10" style="border: 0px;" readonly>${info.content}</textarea>
			</td>
		</tr>
	</thead>
</table>

<button class="btn btn-default" onclick="goList()">목록</button>
<button class="btn btn-default" onclick="goModify()">수정</button>

<script type="text/javascript">
	//<![CDATA[
	function goList() {
		location.href = "./list.do";
	}

	function goModify(idx) {
		location.href = "./modify.do?idx=" + idx;
	}
	//]]>
</script>