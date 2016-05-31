<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% response.sendRedirect("load_login.html"); %>
<html>
<body>
<table>
    <c:forEach var="result" items="${results}">
        <tr>
            <td>
                <c:out value="${result.message}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>