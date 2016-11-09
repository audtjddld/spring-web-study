<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/el.jspf" %>
<h1>게시글 목록</h1>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>No</th>
			<th>title</th>
			<th>regdate</th>
			<th>read</th>
		<tr>
	</thead>
	<c:forEach items="${list}" var="list">
		<tr onclick="goView('${list.idx}')" style="cursor: pointer;">
			<td>${list.idx}</td>
			<td>${list.title }</td>
			<td>${list.regdate }</td>
			<td>${list.view_cnt }</td>
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
	function goView(idx) {
		location.href = "/list/view.do?idx=" + idx;
	}
	
	function getPageList(page) {
		var f = document.frm	
		f.action = "./list.do"
		f.p.value = page;
		f.submit();
	}
</script>


