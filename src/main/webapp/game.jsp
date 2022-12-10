<%@ page import="javax.xml.namespace.QName" %><%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 20.11.2022
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Game</title>
</head>
<body>
<h1>${question}</h1>
<c:if test="${finish == false}">
<form action="${pageContext.request.contextPath}/game" method="post">
    <c:forEach items="${answers}" var="answer" varStatus="loop">
        <input required type="radio" name="nextQuestion" value="${loop.index}"> ${answer}
        <br>
    </c:forEach>
    <button type="submit">Выбрать</button>
</form>
</c:if>
<c:if test="${finish == true}">
    <h1>Конец игры!</h1>
</c:if>
</body>
</html>
