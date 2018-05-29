<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="../include/head.jsp" %>
<body>
<%@ include file="../include/bodyHeader.jsp" %>
<h2>최단거리</h2>


<!-- Nav pills -->
<ul class="nav nav-pills">
    <li class="nav-item">
        <a class="nav-link active" data-toggle="pill" href="#home">직항</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="pill" href="#menu1">경유 1</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="pill" href="#menu2">경유 2</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="pill" href="#menu3">경유 3</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="pill" href="#menu4">경유 4</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="pill" href="#menu5">경유 5</a>
    </li>
</ul>

<!-- Tab panes -->
<div class="tab-content">
    <div class="tab-pane container active" id="home">
        <form action="/airport/route0" method="get">
            출발지: <input type="text" name="dep"/> <br/>
            도착지: <input type="text" name="arv"/><br/>
            <button class="btn btn-primary" type="submit">검색</button>
        </form>
    </div>

    <div class="tab-pane container fade" id="menu1">
        <form action="/airport/route1" method="get">
            출발지: <input type="text" name="dep"/> <br/>
            도착지: <input type="text" name="arv"/><br/>
            경유지1: <input type="text" name="s1"/><br/>
            <button class="btn btn-primary" type="submit">검색</button>
        </form>
    </div>

    <div class="tab-pane container fade" id="menu2">
        <form action="/airport/route2" method="get">
            출발지: <input type="text" name="dep"/> <br/>
            도착지: <input type="text" name="arv"/><br/>
            경유지1: <input type="text" name="s1"/><br/>
            경유지2: <input type="text" name="s2"/><br/>
            <button class="btn btn-primary" type="submit">검색</button>
        </form>
    </div>

    <div class="tab-pane container fade" id="menu3">
        <form action="/airport/route3" method="get">
            출발지: <input type="text" name="dep"/> <br/>
            도착지: <input type="text" name="arv"/><br/>
            경유지1: <input type="text" name="s1"/><br/>
            경유지2: <input type="text" name="s2"/><br/>
            경유지3: <input type="text" name="s3"/><br/>
            <button class="btn btn-primary" type="submit">검색</button>
        </form>
    </div>

    <div class="tab-pane container fade" id="menu4">
        <form action="/airport/route4" method="get">
            출발지: <input type="text" name="dep"/> <br/>
            도착지: <input type="text" name="arv"/><br/>
            경유지1: <input type="text" name="s1"/><br/>
            경유지2: <input type="text" name="s2"/><br/>
            경유지3: <input type="text" name="s3"/><br/>
            경유지3: <input type="text" name="s4"/><br/>
            <button class="btn btn-primary" type="submit">검색</button>
        </form>
    </div>

    <div class="tab-pane container fade" id="menu5">
        <form action="/airport/route5" method="get">
            출발지: <input type="text" name="dep"/> <br/>
            도착지: <input type="text" name="arv"/><br/>
            경유지1: <input type="text" name="s1"/><br/>
            경유지2: <input type="text" name="s2"/><br/>
            경유지3: <input type="text" name="s3"/><br/>
            경유지3: <input type="text" name="s4"/><br/>
            경유지3: <input type="text" name="s5"/><br/>
            <button class="btn btn-primary" type="submit">검색</button>
        </form>
    </div>
</div>

<%@ include file="../include/bodyFooter.jsp" %>
</body>

<%@ include file="../include/footer.jsp" %>

</html>
