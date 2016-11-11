<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/el.jspf"%>
<h1>게시글 목록</h1>
<table class="table table-bordered">
	<colgroup>
		<col width="10%" />
		<col width="25%" />
		<col width="10%" />
		<col width="10%" />
	</colgroup>
	<thead>
		<tr>
			<th>No</th>
			<th>title</th>
			<th>regdate</th>
			<th>read</th>
		<tr>
	</thead>
	<c:choose>
		<c:when test="${not empty listObj.list }">
			<c:forEach items="${listObj.list}" var="list">
				<tr onclick="goView('${list.idx}')" style="cursor: pointer;">
					<td>${list.idx}</td>
					<td>${list.title }</td>
					<td>
						${list.regdate }
					</td>
					<td>
						${list.view_cnt }
					</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="4">
					데이터가 존재하지 않습니다.
				</td>
			</tr>
		</c:otherwise>
	</c:choose>
</table>


<div class="pull-right">
	<button class="btn btn-primary" onclick="goWrite()">입력</button>
</div>

<!--// 페이징과 버튼 부분 -->
<div class="paging_all c_box">
	<!--// 페이징 부분 -->
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${listObj.paginationInfo}" type="text" jsFunction="getPageList" />
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
		location.href = "./view.do?idx=" + idx;
	}

	function getPageList(page) {
		var f = document.frm
		f.action = "./list.do"
		f.p.value = page;
		f.submit();
	}
	
	function goWrite() {
		location.href="./write.do?p=${boardVO.p}";
	}
</script>


