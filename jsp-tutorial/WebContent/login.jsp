<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<meta http-equiv="Pragma" content="no-cache">
 	<meta http-equiv="Cache-Control" content="no-cache">
 	<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
 <title>Login page</title>
</head>
<body>
<jsp:useBean id="controleur" class="fr.futurskill.tutorial.jsp.Controleur" scope="request"/>
<jsp:setProperty property="*" name="controleur"/>
<div>
	<form action="submit.jsp">
		<span>${controleur.message}</span>
		<table>
		<tbody>
			<tr>
				<td>login</td>
				<td><input type="text" name="login" value="${controleur.login}"/>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="password" value="${controleur.password}"/>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><button type="submit">Submit</button></td>
			</tr>
		</tbody>
		</table>
	</form>
</div>
</body>
</html>