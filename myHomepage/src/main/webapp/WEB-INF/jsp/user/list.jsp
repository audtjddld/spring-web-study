<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/el.jspf" %>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>username</th>
			<th>password</th>
		<tr>
	</thead>
	<c:forEach items="${list}" var="list">
		<tr onclick="getUser('${list.username}')" style="cursor: pointer;">
			<td>${list.username}</td>
			<td>${fn:substring(list.password,0,2)}**</td>
		</tr>
	</c:forEach>
</table>
<!--// 페이징과 버튼 부분 -->
<div class="paging_all c_box">
	<!--// 페이징 부분 -->
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${paginationInfo}" type="text" jsFunction="getPageList" />
		</ul>
	</div>
	<!-- 페이징 부분 //-->
</div>
<!-- 페이징과 버튼 부분 //-->
<form name="frm">
	<input type="hidden" name="p" value="${vo.p }" />
</form>

<script type="text/javascript">
	function getUser(username) {
		location.href = "/member/" + username + ".do";
	}
	
	
	function getPageList() {
		var f = document.frm	
		f.action = "./list.do"
		f.p.value = num;
		f.submit();
	}
</script>


