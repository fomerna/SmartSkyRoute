<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>


<%@ include file="../include/head.jsp" %>
<script src="/resources/js/route.js"></script>

<body>

<%@ include file="../include/bodyHeader.jsp" %>
<h2>최단거리</h2>

<form name="baseForm" action="route" method="post" id="ScheduleVO" style="margin-left: 350px ">
    <div id="input">
        <ul class="list-group-flush" style="margin-bottom: 0px">
            <input type="hidden" name="count" value="0">
            <li style="list-style-type: none;" >
                <div class="d-inline-block" >
                    <div class="input-group input-group-sm mb-3 ">
                        <div class="input-group-prepend">
                            <span class="input-group-text">출발지</span>
                        </div>
                        <div class=" d-inline-block" >
                            <input type="text" class="form-control-sm" name="dep" id="dep" value="ICN"
                                   aria-describedby="inputGroup-sizing-sm" style="width: 300px;" ></div>
                    </div>
                </div>
                <div class="d-inline-block">
                    <div class="input-group input-group-sm mb-3 ">
                        <div class="input-group-prepend">
                            <span class="input-group-text">출발일</span>
                        </div>
                        <div class=" d-inline-block">
                            <input type="date" class="form-control-sm"  name="depDay" value="2018-07-01"
                                   aria-describedby="inputGroup-sizing-sm" style="width: 300px"></div>
                    </div>
                </div>
            </li>


            <li style="list-style-type: none" id="addedFormDiv"></li>
            <li style="list-style-type: none" >
                <div class="d-inline-block" >
                    <div class="input-group input-group-sm mb-3 ">
                        <div class="input-group-prepend">
                            <span class="input-group-text">도착지</span>
                        </div>
                        <div class=" d-inline-block" >
                            <input type="text" class="form-control-sm" name="arv" value="LHR"
                                   aria-describedby="inputGroup-sizing-sm" style="width: 300px;" ></div>
                    </div>
                </div>
                <div class="d-inline-block">
                    <div class="input-group input-group-sm mb-3 ">
                        <div class="input-group-prepend">
                            <span class="input-group-text">도착일</span>
                        </div>
                        <div class=" d-inline-block">
                            <input type="date" class="form-control-sm" name="arvDay"  value="2018-07-01"
                                   aria-describedby="inputGroup-sizing-sm" style="width: 300px"></div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
    <div id="button_list" style="margin-left: 280px">
        <input type="Button" value="추가" onclick="addForm()" class="btn btn-primary btn-sm" style="margin: 0px">
        <input type="Button" value="삭제" onclick="delForm()" class="btn btn-danger btn-sm" style="margin: 0px">
        <input type="Submit" value="완료" class="btn btn-success btn-sm" style="margin:0px" >
    </div>
</form>



<%@ include file="../include/bodyFooter.jsp" %>
</body>

<%@ include file="../include/footer.jsp" %>

</html>
