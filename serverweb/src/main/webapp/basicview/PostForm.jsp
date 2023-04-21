<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<jsp:include page="../top.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="/layout/servlet_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<h1>customer</h1>
				</br>
				<form method="post" action="/serverweb/post.do">
					<table>
						<tr>
							<td>user ID</td>
							<td>
								<input type="text" name="userId" size="10" />
							</td>
						</tr>
						<tr>
							<td>name</td>
							<td>
								<input type="text" name="userName" size="10" />
							</td>
						</tr>
						<tr>
							<td>password</td>
							<td>
								<input type="password" name="passwd" size="10" />
							</td>
						</tr>
						<tr>
							<td>gender</td>
							<td>
								<input type="radio" name="gender" value="male" />
								male
								<input type="radio" name="gender" value="female" />
								female
							</td>
						</tr>
						<tr>
							<td>JOB</td>
							<td>
								<select name="job">
									<option value="salary" />
									Salary
									<option value="houseKeeper" selected />
									HouseKeeper
									<option value="student" />
									Student
									<option value="other" />
									Other
								</select>
							</td>
						</tr>
						<tr>
							<td>Favorites</td>
							<td>
								<input type="checkbox" name="item" value="시사" />
								시사
								<input type="checkbox" name="item" value="경제" />
								경제
								<input type="checkbox" name="item" value="정치" />
								정치
								<input type="checkbox" name="item" value="연예" />
								연예
								<input type="checkbox" name="item" value="스포츠" />
								스포츠
								<input type="checkbox" name="item" value="광고" />
								광고
							</td>
						</tr>
					</table>
					<p />
					<input type="submit" value="입력완료" />
					<input type="reset" value="재입력" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>