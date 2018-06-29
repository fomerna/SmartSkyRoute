<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="include/head.jsp" %>

<link rel="stylesheet"
      href="/resources/css/index.css">
<body>
<%@ include file="include/bodyHeader.jsp" %>


<section class="timeline2 cid-qTuNeSRYnV" id="timeline2">

    <div class="panel panel-default">

        <%--===============특가 경로=================--%>
        <div class="panel-body">
            <ul class="timeline" id="ultimeline">
                <li class="timeline-inverted">
                    <div class="timeline-badge info"><i
                            class="fa fa-credit-card"></i>
                    </div>
                    <div class="panel" id="tpanel">
                        <div class="timeline-heading" id="head1">
                            <h3 style="color: #524c61; padding-left: 65px">특가경로</h3> <br/>
                            <h6 style="margin-left: 70px; color: grey">출발지: </h6>


                            <div class="row" id="main1">

                               <%-- &lt;%&ndash; 1번 &ndash;%&gt;
                                <div class="img-cont thumbnail"
                                     style="margin-right: 5px">
                                    <img class="img-responsive rounded img"
                                         src="/resources/img/city/LHR.PNG"
                                         style="width: 500px ; height:300px">
                                    <div class="caption row" id="dealFormDiv">
                                        <h4>
                                            <span id="city">런던,</span>
                                            <span id="country">영국</span>
                                        </h4>
                                        <form action="/round" method="post" id="scheduleVO" name="baseForm">
                                            <input type="hidden" name="dep" value="ICN">
                                            <input type="hidden" name="arv" value="LHR">
                                            <input type="hidden" name="depDay" value="2018-07-01">
                                            <input type="hidden" name="arvDay" value="2018-07-08">
                                            <button id="dealBtn"><span>가격 확인</span> <img
                                                src="/resources/img/right.png"
                                                id="right"></button>

                                        </form>
                                    </div>
                                </div>

                                &lt;%&ndash; 2번 &ndash;%&gt;
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
                                        <h6>가격 확인 <img
                                                src="/resources/img/right.png"
                                                id="right"></h6>
                                    </div>
                                </div>

                                &lt;%&ndash; 3번 &ndash;%&gt;
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
                                        <h6>가격 확인 <img
                                                src="/resources/img/right.png"
                                                id="right"></h6>
                                    </div>
                                </div>
--%>

                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>

        <%--===============추천 경로=================--%>
        <div class="panel-body">
            <ul class="timeline" id="ultimeline">
                <li class="timeline-inverted">
                    <div class="timeline-badge info"><i
                            class="fa fa-credit-card"></i>
                    </div>
                    <div class="panel" id="tpanel">
                        <div class="timeline-heading">
                            <h3 style="color: #524c61; padding-left: 65px" id="re">
                                추천 경로</h3> <br/>
                            <h6 style="margin-left: 70px; color: grey">2018년
                                7월</h6>
                            <div class="row">

                                <%-- 1번 --%>
                                <div class="img-cont thumbnail"
                                     style="margin-right: 5px">
                                    <img class="img-responsive rounded img"
                                         src="/resources/img/city/LHR.PNG"
                                         style="width: 500px ; height:300px">
                                    <div class="caption row">
                                        <h4>
                                            <span id="city">런던,</span>
                                            <span id="country0">영국</span>
                                        </h4>
                                        <h6>가격 확인 <img
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
                                            <span id="country1">일본</span>
                                        </h4>
                                        <h6>가격 확인 <img
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
                                            <span id="country2">이탈리아</span>
                                        </h4>
                                        <h6>가격 확인 <img
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

<%-- ====================자동완성======================--%>

<%--<script type="text/javascript">

    var aa = {
        data: [
            {name: "ICN", type: "인천", icon: ""},
            {name: "NRT", type: "도쿄", icon: ""},
            {name: "PVG", type: "상하이", icon: ""},
            {name: "PEK", type: "베이징", icon: ""},
            {name: "LHR", type: "런던", icon: ""},
            {name: "CDG", type: "파리", icon: ""},
            {name: "MXP", type: "밀라노", icon: ""},
            {name: "FCO", type: "로마", icon: ""},
            {name: "MAD", type: "마드리드", icon: ""},
            {name: "BCN", type: "바르셀로나", icon: ""}
        ],

        getValue: "name",

        template: {
            type: "custom",
            method: function (value, item) {
                return " " + item.type + " | " + value;
            }
        }
    };

    $("#d1").easyAutocomplete(aa);
    $("#a1").easyAutocomplete(aa);
    $("#dep").easyAutocomplete(aa);
    $("#arv").easyAutocomplete(aa);

$(document).on("click",".selected",function () {

    var dep=$("#d1").val();

    search();
})


</script>--%>


<%@ include file="include/footer.jsp" %>
</html>