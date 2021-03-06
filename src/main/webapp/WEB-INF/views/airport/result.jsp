<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<script src="/resources/js/result.js"></script>
<link rel="stylesheet"
      href="/resources/css/roundResult.css">


<%@ include file="../include/head.jsp" %>


<body>
<%@include file="../include/bodyHeader.jsp" %>

<section style="background-color: white" >
    <%--목록 선택--%>
    <ul class="nav nav-tabs mb-3" id="round-bar" role="tablist">
        <c:forEach var="list_big" items="${list}" varStatus="j">
            <c:choose>
                <c:when test="${j.index eq 0}">
                    <li class="nav-item" style="margin-left: 600px">
    <span class="nav-link active" id="tab_${j.index}"
          data-toggle="pill" href="#${j.index}" role="tab"
          aria-controls="pills-home"
          aria-selected="true"
          style="margin-right: 20px">${j.index+1}번째 여정</span>
                    </li>
                </c:when>
                <c:when test="${j.index eq list.size()-1}">
                    <li class="nav-item">
    <span class="nav-link" id="tab_${j.index}"
          data-toggle="pill" href="#${j.index}" role="tab"
          aria-controls="pills-profile" aria-selected="false"
          style="margin-right: 20px">${j.index+1}번째 여정</span>
                    </li>
                    <li class="nav-item">
    <span class="nav-link" id="tab_${j.index+1}"
          data-toggle="pill" href="#final" role="tab"
          aria-controls="pills-profile" aria-selected="false">여정 요약</span>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
    <span class="nav-link" id="tab_${j.index}"
          data-toggle="pill" href="#${j.index}" role="tab"
          aria-controls="pills-profile" aria-selected="false"
          style="margin-right: 20px">${j.index+1}번째 여정</span>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

    </ul>

    <div class="container">

        <div class="tab-content" id="pills-tabContent">
            <%-- ==============첫번째 여정================ --%>
            <c:forEach var="list_big" items="${list}" varStatus="j" end="0">
                <div class="tab-pane fade show active" id="${j.index}"
                     role="tabpanel" aria-labelledby="pills-home-tab">
                    <div class="row" style="margin-bottom: 10px">
                        <h4 style="margin-right: 600px; margin-left: 30px">1번째 여정 선택</h4><br>

                        <h4><span
                                class="badge badge-primary">Departure-${list_big.get(j.index).dep}</span>
                            <span class="badge badge-danger">Destination-${list_big.get(j.index).arv}</span>
                        </h4>

                        <form action="reRoute" method="get" id="form_${j.index}">
                            <div class="d-inline-block">
                                <div class="input-group mb-3 ">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">출발지</span>
                                    </div>
                                    <div class=" d-inline-block">
                                        <input type="text" class="input-group-text"
                                               name="dep" id="dep${j.index}"
                                               value="${list_big.get(0).dep}"
                                               aria-describedby="inputGroup-sizing-sm"
                                               style="width: 100px;background-color:#fff">
                                    </div>
                                </div>
                            </div>
                            <div class="d-inline-block">
                                <div class="input-group  mb-3 ">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">출발일</span>
                                    </div>
                                    <div class=" d-inline-block">
                                        <input type="date" class="input-group-text"
                                               name="dep" id="depDay${j.index}"
                                               value="${list_big.get(0).depDay}"
                                               aria-describedby="inputGroup-sizing-sm"
                                               style="width: 170px;background-color:#fff">
                                    </div>
                                </div>
                            </div>
                            <div class="d-inline-block">
                                <div class="input-group  mb-3 ">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">도착지</span>
                                    </div>
                                    <div class=" d-inline-block">
                                        <input type="text" class="input-group-text"
                                               name="dep" id="arv${j.index}"
                                               value="${list_big.get(0).arv}"
                                               aria-describedby="inputGroup-sizing-sm"
                                               style="width: 100px;background-color:#fff">
                                    </div>
                                </div>
                            </div>
                            <div class="d-inline-block">
                                <div class="input-group mb-3" style="width:200px">
                                    <div class="input-group-prepend d-inline-block "
                                         style="width:90px">
                                        <label class="input-group-text" for="col${j.index}">정렬기준</label>
                                    </div>
                                    <select class="custom-select" id="col${j.index}">
                                        <option value="가격">Choose...</option>
                                        <option value="가격">가격</option>
                                        <option value="도착시간">도착시간</option>
                                        <option value="출발시간">출발시간</option>
                                        <option value="소요시간">소요시간</option>
                                    </select>
                                </div>
                            </div>
                            <div class="d-inline-block">
                                <div class="input-group mb-3" style="width:200px">
                                    <div class="input-group-prepend d-inline-block "
                                         style="width:90px">
                                        <label class="input-group-text" for="col${j.index}">정렬방법</label>
                                    </div>
                                    <select class="custom-select" id="order${j.index}">
                                        <option value="오름차순">Choose...</option>
                                        <option value="오름차순">오름차순</option>
                                        <option value="내림차순">내림차순</option>
                                    </select>
                                </div>
                            </div>
                            <input type="button" class="btn-black" value="다시검색"
                                   onclick="Search(${j.index})">
                            <input type="hidden" id="input_${j.index}" value='0'>
                        </form>


                        <table class="table table-striped" id="table_${j.index}"
                               style="text-align: center">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">출발지</th>
                                <th scope="col">출발일</th>
                                <th scope="col">출발시간</th>
                                <th scope="col">도착지</th>
                                <th scope="col">도착일</th>
                                <th scope="col">도착시간</th>
                                <th scope="col">항공사</th>
                                <th scope="col">가격</th>
                                <th scope="col"><a id="a_${j.index}" class="collapse show"
                                                   data-toggle="collapse"
                                                   data-target="#tbody_${j.index}">접기</a>
                                </th>
                            </tr>
                            </thead>

                            <tbody id="tbody_${j.index}" class="collapse in show">
                            <!-- DB에서 Plan_code에 해당하는 정보 가져오기 -->


                            <c:forEach var="list" items="${list_big}" varStatus="i">

                                <tr>
                                    <th scope="row">${i.index+1 }</th>
                                    <td>
                                        <a data-toggle="tooltip" id="temp"
                                           title="${city.get(j.index).get(0).city},${city.get(j.index).get(0).airportName}"> ${list.dep}</a>
                                    </td>
                                    <td>${list.depDay}</td>
                                    <td>${list.depTime}</td>
                                    <td>
                                        <a data-toggle="tooltip"
                                           title="${city.get(j.index).get(1).city},${city.get(j.index).get(1).airportName}"> ${list.arv}</a>
                                    </td>
                                    <td>${list.arvDay}</td>
                                    <td>${list.arvTime}</td>
                                    <td>${list.airlineCode}</td>
                                    <td>${list.price}</td>
                                    <td><a href="javascript:select(${list.sno});"
                                           class="badge badge-pill badge-info">선택</a></td>
                                    <input type="hidden" value="${list.sno}"
                                           id="sno_${list.sno}">
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div id="more_${j.index}"><a href="javascript:moreList(${j.index});"
                                                     class="badge badge-pill badge-success"
                                                     style="margin-left:510px">더보기</a></div>
                    </div>
                </div>
            </c:forEach>


            <%-- ===================2,3번째 그 이후 여정================== --%>
            <c:forEach var="list_big" items="${list}" varStatus="j" begin="1">
                <div class="tab-pane fade justify-content-md-center"
                     id="${j.index}" role="tabpanel"
                     aria-labelledby="pills-profile-tab">
                    <div class="row" style="margin-bottom: 10px">
                        <h4 style="margin-right: 600px; margin-left: 30px">${j.index}번째 여정
                            선택</h4>
                        <h4><span
                                class="badge badge-primary">Departure-${list_big.get(j.index).dep}</span>
                            <span class="badge badge-danger">Destination-${list_big.get(j.index).arv}</span>
                        </h4>

                        <form action="reRoute" method="get" id="form_${j.index}">
                            <div class="d-inline-block">
                                <div class="input-group mb-3 ">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">출발지</span>
                                    </div>
                                    <div class=" d-inline-block">
                                        <input type="text" class="input-group-text"
                                               name="dep" id="dep${j.index}"
                                               value="${list_big.get(0).dep}"
                                               aria-describedby="inputGroup-sizing-sm"
                                               style="width: 100px;background-color:#fff">
                                    </div>
                                </div>
                            </div>
                            <div class="d-inline-block">
                                <div class="input-group  mb-3 ">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">출발일</span>
                                    </div>
                                    <div class=" d-inline-block">
                                        <input type="date" class="input-group-text"
                                               name="dep" id="depDay${j.index}"
                                               value="${list_big.get(0).depDay}"
                                               aria-describedby="inputGroup-sizing-sm"
                                               style="width: 170px;background-color:#fff">
                                    </div>
                                </div>
                            </div>
                            <div class="d-inline-block">
                                <div class="input-group  mb-3 ">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">도착지</span>
                                    </div>
                                    <div class=" d-inline-block">
                                        <input type="text" class="input-group-text"
                                               name="dep" id="arv${j.index}"
                                               value="${list_big.get(0).arv}"
                                               aria-describedby="inputGroup-sizing-sm"
                                               style="width: 100px;background-color:#fff">
                                    </div>
                                </div>
                            </div>
                            <div class="d-inline-block">
                                <div class="input-group mb-3" style="width:200px">
                                    <div class="input-group-prepend d-inline-block "
                                         style="width:90px">
                                        <label class="input-group-text" for="col${j.index}">정렬기준</label>
                                    </div>
                                    <select class="custom-select" id="col${j.index}">
                                        <option value="가격">Choose...</option>
                                        <option value="가격">가격</option>
                                        <option value="도착시간">도착시간</option>
                                        <option value="출발시간">출발시간</option>
                                        <option value="소요시간">소요시간</option>
                                    </select>
                                </div>
                            </div>
                            <div class="d-inline-block">
                                <div class="input-group mb-3" style="width:200px">
                                    <div class="input-group-prepend d-inline-block "
                                         style="width:90px">
                                        <label class="input-group-text" for="col${j.index}">정렬방법</label>
                                    </div>
                                    <select class="custom-select" id="order${j.index}">
                                        <option value="오름차순">Choose...</option>
                                        <option value="오름차순">오름차순</option>
                                        <option value="내림차순">내림차순</option>
                                    </select>
                                </div>
                            </div>
                            <input type="button" class="btn-black" value="다시검색"
                                   onclick="Search(${j.index})">
                            <input type="hidden" id="input_${j.index}" value='0'>
                        </form>


                        <table class="table table-striped" id="table_${j.index}"
                               style="text-align: center">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">출발지</th>
                                <th scope="col">출발일</th>
                                <th scope="col">출발시간</th>
                                <th scope="col">도착지</th>
                                <th scope="col">도착일</th>
                                <th scope="col">도착시간</th>
                                <th scope="col">항공사</th>
                                <th scope="col">가격</th>
                                <th scope="col"><a id="a_${j.index}" class="collapse show"
                                                   data-toggle="collapse"
                                                   data-target="#tbody_${j.index}">접기</a>
                                </th>
                            </tr>
                            </thead>

                            <tbody id="tbody_${j.index}" class="collapse in show">
                            <!-- DB에서 Plan_code에 해당하는 정보 가져오기 -->


                            <c:forEach var="list" items="${list_big}" varStatus="i">

                                <tr>
                                    <th scope="row">${i.index+1 }</th>
                                    <td>
                                        <a data-toggle="tooltip" id="temp"
                                           title="${city.get(j.index).get(0).city},${city.get(j.index).get(0).airportName}"> ${list.dep}</a>
                                    </td>
                                    <td>${list.depDay}</td>
                                    <td>${list.depTime}</td>
                                    <td>
                                        <a data-toggle="tooltip"
                                           title="${city.get(j.index).get(1).city},${city.get(j.index).get(1).airportName}"> ${list.arv}</a>
                                    </td>
                                    <td>${list.arvDay}</td>
                                    <td>${list.arvTime}</td>
                                    <td>${list.airlineCode}</td>
                                    <td>${list.price}</td>
                                    <td><a href="javascript:select(${list.sno});"
                                           class="badge badge-pill badge-info">선택</a></td>
                                    <input type="hidden" value="${list.sno}"
                                           id="sno_${list.sno}">
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div id="more_${j.index}"><a href="javascript:moreList(${j.index});"
                                                     class="badge badge-pill badge-success"
                                                     style="margin-left:510px">더보기</a></div>
                    </div>
                </div>
            </c:forEach>


            <%-- ===================여정 요약================== --%>
            <div class="tab-pane fade justify-content-md-center"
                 id="final" role="tabpanel"
                 aria-labelledby="pills-profile-tab">

                <div class="row" style="margin-bottom: 10px">
                    <h4 style="margin-right: 700px; margin-left: 30px">
                        여정 요약</h4>
                    <input type="hidden" id="total_price" value="0">
                    <FORM>
                        <INPUT class="btn btn-success" type='BUTTON' value='캡쳐'
                               onclick='html2img()'> <!-- 버튼 클릭 이벤트-->
                    </FORM>
                    <button id="foo" class="btn btn-success"
                            style="height: 60px">저장
                    </button>
                </div>
                <div id="SavePart">
                    <input type="hidden" id="list_count" value="0">
                    <table class="table table-striped" id="table_select"
                           style="text-align: center">
                        <thead>
                        <tr>
                            <th scope="col">출발지</th>
                            <th scope="col">출발일</th>
                            <th scope="col">출발시간</th>
                            <th scope="col">도착지</th>
                            <th scope="col">도착일</th>
                            <th scope="col">도착시간</th>
                            <th scope="col">편명</th>
                            <th scope="col">가격</th>
                            <th scope="col"><a id="" class="collapse show"
                                               data-toggle="collapse"
                                               data-target="#tbody_select">접기</a>
                            </th>
                        </tr>
                        </thead>

                        <tbody id="tbody_select" class="collapse in show">
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="3"
                                style="border-top: #9fcdff 1px solid">항공권 개수
                            </td>
                            <td style="border-top: #9fcdff 1px solid"
                                id="count"></td>
                            <td style="border-top: #9fcdff 1px solid"></td>
                            <td style="border-top: #9fcdff 1px solid"
                                colspan="2">총가격
                            </td>
                            <td style="border-top: #9fcdff 1px solid"
                                id="total_price_real">0
                            </td>
                            <td style="border-top: #9fcdff 1px solid"></td>
                        </tr>
                        </tfoot>
                    </table>
                </div>


                <div class="row border-top border-dark"
                     style="margin-bottom: 10px; margin-top: 30px">
                    <h4 style="margin-top: 30px; margin-left: 30px">캡쳐 영역</h4>
                </div>
                <image id="theimage" style="background: aliceblue"></image>

            </div>
        </div>

    </div>
</section>




<%@ include file="../include/bodyFooter.jsp" %>
</body>
<%@ include file="../include/footer.jsp" %>


<script type="text/javascript">
    function html2img() {
        var canvas = "";
        html2canvas($("#SavePart"), {
            onrendered: function (canvas) {
                // canvas is the final rendered <canvas> element
                document.getElementById("theimage").src = canvas.toDataURL();
                /* Canvas2Image.saveAsPNG(canvas);*/

                /*location.href = canvas.toDataURL('image/png').replace(/^data:image\/png/, 'data:application/octet-stream');*/
            }
        });
    }

    var node = document.getElementById('theimage');
    var btn = document.getElementById('foo');

    btn.onclick = function () {
        node.innerHTML = "I'm an image now."
        domtoimage.toBlob(document.getElementById('theimage'))
            .then(function (blob) {
                window.saveAs(blob, 'my-itinerary.png');
            });
    }


</script>

<script>
    $(document).ready(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>

</html>