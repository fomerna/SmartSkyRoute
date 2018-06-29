<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>


<%@ include file="../include/head.jsp" %>
<body>
<%@include file="../include/bodyHeader.jsp" %>

<c:forEach var="listSch" items="${result}" varStatus="j">

    <section class="bg-white" id="portfolio"
             style="padding-top: 50px; padding-bottom: 50px">
        <div class="container">
            <h4>${j.index+1}번째 최저가 경로</h4>
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
                </tr>
                </thead>

                <tbody id="tbody_${j.index}" class="collapse in show">
                <!-- DB에서 Plan_code에 해당하는 정보 가져오기 -->

                <c:set var="total" value="0"/>
                <c:forEach var="sch" items="${listSch}" varStatus="i">

                    <tr>
                        <th scope="row">${i.index+1 }</th>
                        <td>${sch.dep} </td>
                        <td>${sch.depDay}</td>
                        <td>${sch.depTime}</td>
                        <td>${sch.arv} </td>
                        <td>${sch.arvDay}</td>
                        <td>${sch.arvTime}</td>
                        <td>${sch.airlineCode}</td>
                        <td>${sch.price}</td>
                    </tr>
                    <c:set var="total" value="${total+sch.price}"/>
                </c:forEach>
                <tr>
                    <td colspan="5" style="border-top: #9fcdff 1px solid">총가격</td>
                    <td colspan="5" id="total_price_${j.index}" style="border-top: #9fcdff 1px solid">${total}</td>
                </tr>
                </tbody>
            </table>

        </div>
    </section>
</c:forEach>
<script>
    $("#total_price_0").text("￦"+numeral($("#total_price_0").text()).format('0,0'));
    $("#total_price_1").text("￦"+numeral($("#total_price_1").text()).format('0,0'));
    $("#total_price_2").text("￦"+numeral($("#total_price_2").text()).format('0,0'));
</script>

<%@ include file="../include/bodyFooter.jsp" %>
</body>
<%@ include file="../include/footer.jsp" %>


</html>