<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : frmpost
    Created on : 24 may. de 2024, 19:16:40
    Author     : Personal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${post.id==0}">Nueva Entrada</c:if>
            <c:if test="${post.id!=0}">Editar Entrada</c:if>
            </h1>
            <form action="PostController" method="post">
                <input type="hidden" name="id" value="${post.id}">
            <table>
                <tr>
                    <td>Fecha: </td>
                    <td><input type="date" name="fecha" value="${post.fecha}"/></td>
                </tr>
                <tr>
                    <td>Titulo: </td>
                    <td><input type="text" name="titulo" value="${post.titulo}"/></td>
                </tr>
                <tr>
                    <td>Contenido: </td>
                    <td><textarea  name="contenido" rows="4" cols="20">${post.contenido}</textarea></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"></td>
                </tr>

            </table>
        </form>


    </body>
</html>
