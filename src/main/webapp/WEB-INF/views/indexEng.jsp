<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="include/head.jsp" %>
<script src="/resources/index.js"></script>
<body>
<%@ include file="include/bodyHeader.jsp" %>

<section class="timeline2 cid-qTuNeSRYnV" id="timeline2">

    <div class="panel panel-default">

        <%--===============추천 경로=================--%>
        <div class="panel-body">
            <ul class="timeline" id="ultimeline">
                <li class="timeline-inverted">
                    <div class="timeline-badge info"><i
                            class="fa fa-credit-card"></i>
                    </div>
                    <div class="panel" id="tpanel">
                        <div class="timeline-heading">
                            <h3 style="color: #524c61; padding-left: 65px">
                                Our Recommend Route</h3> <br/>
                            <div class="row">

                                <%-- 1번 --%>
                                <div class="img-cont thumbnail"
                                     style="margin-right: 5px">
                                    <img class="img-responsive rounded img"
                                         src="/resources/img/city/ICN.PNG"
                                         style="width: 500px ; height:300px">
                                    <div class="caption row">
                                        <h4>
                                            <span id="city">Seoul,</span>
                                            <span id="country">South Korea</span>
                                        </h4>
                                        <h6>Get Prices <img
                                                src="/resources/img/right.png"
                                                id="right"></h6>
                                    </div>
                                </div>

                                <%-- 2번 --%>
                                <div class="img-cont thumbnail"
                                     style="margin-right: 5px">
                                    <img class="img-responsive rounded img"
                                         src="/resources/img/city/BCN.PNG"
                                         style="width: 360px ; height:300px">
                                    <div class="caption row">
                                        <h4>
                                            <span id="city2">바르셀로나,</span>
                                            <span id="country2">스페인</span>
                                        </h4>
                                        <h6>Get Prices <img
                                                src="/resources/img/right.png"
                                                id="right"></h6>
                                    </div>
                                </div>

                                <%-- 3번 --%>
                                <div class="img-cont thumbnail"
                                     style="margin-right: 5px">
                                    <img class="img-responsive rounded img"
                                         src="/resources/img/city/CDG.PNG"
                                         style="width: 360px ; height:300px">
                                    <div class="caption row">
                                        <h4>
                                            <span id="city3">파리,</span>
                                            <span id="country3">프랑스</span>
                                        </h4>
                                        <h6>Get Prices <img
                                                src="/resources/img/right.png"
                                                id="right"></h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>

        <%--===============특가 경로=================--%>
        <div class="panel-body">
            <ul class="timeline" id="ultimeline">
                <li class="timeline-inverted">
                    <div class="timeline-badge info"><i
                            class="fa fa-credit-card"></i>
                    </div>
                    <div class="panel" id="tpanel">
                        <div class="timeline-heading">
                            <h3 style="color: #524c61; padding-left: 65px">
                                July deals</h3> <br/>
                            <h6 style="margin-left: 70px; color: grey">July 2018</h6>
                            <div class="row">

                                <%-- 1번 --%>
                                <div class="img-cont thumbnail"
                                     style="margin-right: 5px">
                                    <img class="img-responsive rounded img"
                                         src="/resources/img/city/LHR.PNG"
                                         style="width: 500px ; height:300px">
                                    <div class="caption row">
                                        <h4>
                                            <span id="city">${airport.city},</span>
                                            <span id="country">${airport.country}</span>
                                        </h4>
                                        <h6>Get Prices <img
                                                src="/resources/img/right.png"
                                                id="right"></h6>
                                    </div>
                                </div>

                                <%-- 2번 --%>
                                <div class="img-cont thumbnail"
                                     style="margin-right: 5px">
                                    <img class="img-responsive rounded img"
                                         src="/resources/img/city/NRT.PNG"
                                         style="width: 360px ; height:300px">
                                    <div class="caption row">
                                        <h4>
                                            <span id="city2">도쿄,</span>
                                            <span id="country2">일본</span>
                                        </h4>
                                        <h6>Get Prices <img
                                                src="/resources/img/right.png"
                                                id="right"></h6>
                                    </div>
                                </div>

                                <%-- 3번 --%>
                                <div class="img-cont thumbnail"
                                     style="margin-right: 5px">
                                    <img class="img-responsive rounded img"
                                         src="/resources/img/city/MXP.PNG"
                                         style="width: 360px ; height:300px">
                                    <div class="caption row">
                                        <h4>
                                            <span id="city3">밀라노,</span>
                                            <span id="country3">이탈리아</span>
                                        </h4>
                                        <h6>Get Prices <img
                                                src="/resources/img/right.png"
                                                id="right"></h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</section>


<%@ include file="include/bodyFooter.jsp" %>
</body>

<%@ include file="include/footer.jsp" %>
</html>