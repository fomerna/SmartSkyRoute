<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="../include/head.jsp" %>
<body>
<%@ include file="../include/bodyHeader.jsp" %>


<% String dep = request.getParameter("dep");
    String arv = request.getParameter("arv"); %>

<%=dep%>----<%=arv%>

${airport}km


<%@ include file="../include/bodyFooter.jsp" %>
</body>
<%@ include file="../include/footer.jsp" %>
</html>
