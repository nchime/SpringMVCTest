<?xml version="1.0" encoding="EUC-KR" ?>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Hello world!</h1>
    <h2>${model.sMessage}</h2>
    <P>The time on the server is ${model.serverTime}.</P>
    <table border="1">
        <tr>
            <th>uid</th>
            <th>msg</th>
            <th>logcode</th>
            <th>등록일</th>
        </tr>
        <c:forEach var="m" items="${model.rs}">
            <tr>
                <td><c:out value="${m.log_idx}"/></td>
                <td><c:out value="${m.msg}"/></td>
                <td><c:out value="${m.logcode}"/></td>
                <td><c:out value="${m.regi_date}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>