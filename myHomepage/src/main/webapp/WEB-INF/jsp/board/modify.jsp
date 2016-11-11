<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/el.jspf"%>
<h1>게시글 정보 수정</h1>
<form name="frm" method="post" enctype="multipart/form-data">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th colspan="2">
					<input type="text" name="title" value="${info.title }" class="form-control" maxlength="80" />
				</th>
			<tr>
			<tr>
				<td colspan="2">
					<textarea rows="15" cols="10" name="content" class="form-control">${info.content}</textarea>
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
			<tr>
				<td colspan="2">
					<input type="file" name="atchFile" />
				</td>
			</tr>
		</thead>
	</table>
	<input type="hidden" name="p" value="${boardVO.p }" />
	<input type="hidden" name="idx" value="${boardVO.idx }" />
</form>
<button class="btn btn-default" onclick="goList()">목록</button>
<button class="btn btn-default" onclick="goModify()">수정</button>

<script type="text/javascript">
	//<![CDATA[
	function goList() {
		location.href = "./list.do?p=${boardVO.p}";
	}

	function goModify(idx) {
		if(confirm('수정하시겠습니까?')) {
			var f = document.frm;
			f.action="./update.do";
			f.submit();
		}
	}
	//]]>
</script>