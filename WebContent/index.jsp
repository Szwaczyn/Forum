<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>10.23.4</h1>
	${requestScope.imie} 	<!--  Atrybut ustawiony w serwlecie -->
	${param.imie}			<!--  Parametr przekazany w zaptraniu ?imie=jan -->
	${cookie.imie }			<!--  Odwołanie się do ciasteczka -->
	
	${user.name }
	
	<!--  Akcja zezwalająca na dołączenie zewnętrznego pliku include/forward -->
	<jsp:include page="/content.jsp">
		<jsp:param name="toShow" value="content" />
		<jsp:param name="club" value="len" />
	</jsp:include>
	
	
	<jsp:useBean id="active" scope="session" class="javaee.Users">
		<jsp:setProperty name="active" property="name" value="empty"/>
	</jsp:useBean>
	
	<jsp:getProperty property="name" name="active"/>
	
</body>
</html>