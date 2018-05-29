<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="../include/head.jsp" %>
<body>
<%@ include file="../include/bodyHeader.jsp" %>

<form action="/airport/calkm" method="get">
    출발지: <input type="text" name="dep"/> <br/>
    도착지: <input type="text" name="arv"/><br/>
    <button class="btn btn-primary" type="submit">검색</button>
</form>
<%@ include file="../include/bodyFooter.jsp" %>
</body>
<%@ include file="../include/footer.jsp" %>
</html>
