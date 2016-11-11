<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/el.jspf"%>
<h1>게시글 정보</h1>
<table class="table table-bordered">
	<thead>
		<tr>
			<th colspan="2">
				<div class="row">
					<div class="col-md-8">${info.title}</div>
					<div class="col-md-2">
						[${info.regdate}]
					</div>
					<div class="col-md-2">
						read : ${info.view_cnt}
					</div>
				</div>
				
			</th>
		<tr>
		<tr>
			<td colspan="2">
				<textarea rows="15" cols="10" class="form-control" style="border: 0px;" readonly>${info.content}</textarea>
			</td>
		</tr>
		<c:if test="${not empty info.files }">
			<tr>
				<td colspan="2">
					<div class="row">
						<div class="col-md-2">기존 첨부파일</div>
						<div class="col-md-8">
							<c:forEach items="${info.files }" var="file">
								<p> 
									<a href="/cmm/fms/FileDown.do?atchFileId=${file.atch_file_id }&fileSn=${file.file_sn}" title="${file.orignl_file_nm }">${file.orignl_file_nm }</a>
								</p> 
							</c:forEach>
						</div>
					</div>
				</td>
			</tr>
		</c:if>
	</thead>
</table>

<form name="frm" method="post">
	<input type="hidden" name="p" value="${boardVO.p }" />
	<input type="hidden" name="idx" value="${info.idx }" />
	<input type="hidden" name="atch_file_id" value="${info.atch_file_id }" />
</form>

<button class="btn btn-default" onclick="goList()">목록</button>
<button class="btn btn-primary" onclick="goModify()">수정</button>
<button class="btn btn-danger" onclick="goDelete()">삭제</button>

<script type="text/javascript">
	//<![CDATA[
	function goList() {
		location.href = "./list.do";
	}

	function goModify() {
		var f = document.frm;
			f.action = "./modify.do";
			f.submit();
	}
	
	function goDelete() {
		if(confirm('삭제하시겠습니까?')) {
			var f = document.frm;
			f.action = "./delete.do"
			f.submit();
		}
	}
	//]]>
</script>