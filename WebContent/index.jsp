<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	
	<c:out value="${user.password}" default="Nie posiada hasła"/>
	
	<c:if test="${user.password eq 'tajnehaslo' }">
		<p>Ziusław ma hasło</p>
	</c:if>
	
	<c:set var="variable" scope="request" value="${user.name }" />
	
	${variable }
	
	<c:set target="${user}" property="name" value="New name" />
	
	${user.name }
	
	<c:catch var="Exception">
		<c:set target="${user }" value="asd" property="asdf" />
	</c:catch>
	
	${Exception }
	
	<br>
	
	<c:choose>
		<c:when test="${user.password eq 'tajnehaslo' }">
			<c:out value="Position 1" />
		</c:when>
		<c:otherwise>
			<c:out value="Position 2" />
		</c:otherwise>
	</c:choose>
	
	<c:forEach items="${List }" var="userInLoop">
		<br> ${userInLoop.name } 
	</c:forEach>
	
	<c:url value="/lista">
		<c:param name="id" value="1" />
	</c:url>
	
	${fn:length(List) }
</body>
</html>