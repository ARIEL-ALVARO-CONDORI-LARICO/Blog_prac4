<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="text-align: center;">BLOG DE TECNOLOGIA</h1>
        <p style="text-align: center;">Autor: Ariel Alvaro Condori Larico</p>
        <button style="display: inline-block; float: right;" onclick="window.location.href='PostController?action=add'">Nueva Entrada</button>
        
        <c:forEach var="item" items="${posts}">
            <h2>${item.titulo}</h2>
            <p>Fecha ${item.fecha}</p>
            <p>${item.contenido}</p>
            <p style="text-align: right;"><a href="PostController?action=edit&id=${item.id}">Editar</a>   <a href="PostController?action=delete&id=${item.id}">Eliminar</a></P>
            <p style="text-align: center;">____________________________________________________________</p>
        </c:forEach>
            
    </body>
</html>
