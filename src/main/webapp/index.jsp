
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%
    String prologue = "Ты стоишь в космическом порту и готов подняться на борт <br>" +
            "своего коробля. Разве ты не об этом мечтал? Стать капитаном <br>" +
            "галактического судна с экипажем, который будет совершать <br>" +
            "подвиги под твоим командованием. <br>" +
            "Так что вперед!!!";
    String acquaintance = "Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках: <br>" +
            "- Здраствуйте, командир! Я Небула - ваша помощница. Видите? Там в углу пьет кофе <br>" +
            "наш штурман  - сержант Ракета, под штурманом спит наш бортмеханик - Грут, <br>" +
            "а фотографирует его Дракс - наш навигатор.<br>" +
            "А как обращаться к вам?";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Star_Trek</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/css/bootstrap.css">
</head>
<body>
<div class="p-3 mb-2 bg-info text-dark">
<h3><%= "Пролог" %></h3>
<h5><%= prologue%></h5>
<h3><%= "Знакомство с экипажем" %></h3>
<h5><%= acquaintance%></h5>
<form action="${pageContext.request.contextPath}/index" method="post" >
    <input type="text" name="name">
    <input type="submit" value="Представиться" class="btn btn-success">
    <img src="img/NLO.gif" class="rounded mx-auto d-block"/>
</form>
</div>
</body>
</html>