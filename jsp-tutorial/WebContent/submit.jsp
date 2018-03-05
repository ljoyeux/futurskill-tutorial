<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="controleur" class="fr.futurskill.tutorial.jsp.Controleur" scope="request"/>
<jsp:setProperty property="*" name="controleur"/>
<jsp:forward page="${controleur.login()}">
	<jsp:param name="message" value="${controleur.message}"/>
	<jsp:param name="login" value="${controleur.login}"/>
	<jsp:param name="password" value="${controleur.password}"/>
</jsp:forward>
</body>
</html>