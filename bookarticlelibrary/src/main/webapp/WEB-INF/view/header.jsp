<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />" />
       
    </head>
    <body>
        <div id="nav_wrapper">
            <div id="nav">
                <ul>
                    <li>
                        <a <c:if test="${title == 'home'}"> class="active" </c:if> href="<c:url value="/home" />" >Home</a>
                    </li>
                    <li>
                        <a <c:if test="${title == 'authors'}"> class="active" </c:if> href="<c:url value="/authors" /> " >Authors</a>
                    </li>
                    <li>
                        <a <c:if test="${title == 'books'}"> class="active" </c:if> href="<c:url value="/books" /> " >Books</a>
                    </li>
                    <li>
                        <a <c:if test="${title == 'articles'}"> class="active" </c:if> href="<c:url value="/articles" /> " >Articles</a>
                    </li>
                </ul>
                
            </div>            
        </div>