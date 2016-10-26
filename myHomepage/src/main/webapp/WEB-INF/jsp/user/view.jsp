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
	<tbody>
		<c:choose>
			<c:when test="${user ne null }">
				<tr>
					<td>${user.username}</td>
					<td>${user.password}</td>
				</tr>
			</c:when>

			<c:otherwise>
				<tr>
					<td colspan="2">존재하지 않습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>