<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<form name="form" action="/join/action.do" method="post">
		<div class="col-md-6 col-md-offset-3">
			<table class="table table-bordered">
				<tr>
					<th>username</th>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<th>password</th>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			<div style="text-align: right;">
				<button class="btn" onclick="join()">회원가입</button>
			</div>
		</div>
	</form>
</div>

<script type="text/javascript">
	function join() {
		var form = $("form");
		var username = $("[name='username']").val();
		var password = $("[name='password']").val();
		// false , 0 , null, "", 
		// if(username) == false
		if (username == "" || password == "") {
			alert('username / password 를 확인해주세요.');
			event.preventDefault();
			return;
		}
		form.submit();
	}
</script>