<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>username</th>
			<th>password</th>
		<tr>
	</thead>
	<c:forEach items="${list }" var="list">
		<tr onclick="getUser('${list.username}')" style="cursor:pointer;">
			<td>${list.username}</td>
			<td>${list.password}</td>
		</tr>
	</c:forEach>
</table>

<script type="text/javascript">
	function getUser(username) {
		location.href = "/member/" + username + ".do";
	}
</script>


