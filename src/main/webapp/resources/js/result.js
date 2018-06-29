function Search(i) {
    $("#input_" + i).val(0);
    var dep = $("#dep" + i).val();
    var depDay = $("#depDay" + i).val();
    var arv = $("#arv" + i).val();
    var col = $("#col" + i).val();
    var order = $("#order" + i).val();
    var city1 = "";
    var city2 = "";
    var name1 = "";
    var name2 = "";
    $.getJSON("/Airport/" + dep + "/" + arv, function (data) {
        var temp = 0;
        $(data).each(
            function () {
                if (temp == 0) {
                    city1 = this.city;
                    name1 = this.airportName;
                    temp++;
                } else {
                    city2 = this.city;
                    name2 = this.airportName;
                }
            });
    });
    $.getJSON("/reRoute/" + dep + "/" + depDay + "/" + arv + "/" + col + "/" + order, function (data) {
        var str = "";
        var count = 0;
        $(data).each(
            function () {
                ++count;
                str += "<tr>" +
                    "<th scope=\"row\">" + count + "</th>" +
                    "<td>\n" +
                    "<a data-toggle=\"tooltip\" \n" +
                    "title=\"" + city1 + "," + name1 + "\">" + this.dep + "</a>\n" +
                    "</td>" +
                    "<td>" + this.depDay + "</td>\n" +
                    "<td>" + this.depTime + "</td>\n" +
                    "<td>\n" +
                    "<a data-toggle=\"tooltip\"\n" +
                    "title=\"" + city2 + "," + name2 + "\">" + this.arv + "</a>\n" +
                    "</td>" +
                    "<td>" + this.arvDay + "</td>\n" +
                    "<td>" + this.arvTime + "</td>\n" +
                    "<td>" + this.airlineCode + "</td>\n" +
                    "<td>" + this.price + "</td>" +
                    "<td><a href=\"javascript:select(" + this.sno + ");\"\n" +
                    "class=\"badge badge-pill badge-info\"  >선택</a></td>\n" +
                    "<input type=\"hidden\" value=\"" + this.sno + "\" id=\"sno_" + this.sno + "\">" +
                    "</tr>";
            });
        alert("항공권이 변경됩니다.");
        $("#tbody_" + i).html(str);
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });
        $("#more_" + i).remove();
        var button = " <div id=\"more_" + i + "\"><a href=\"javascript:moreList(" + i + ");\"\n" +
            "class=\"badge badge-pill badge-success\" style=\"margin-left:510px\" >더보기</a></div>";
        $("#table_" + i).after(button);
    });


}

//더보기
function moreList(i) {
    var str_input = $("#input_" + i).val();
    str_input = Number(str_input) + 1;
    $("#input_" + i).val(str_input);
    var dep = $("#dep" + i).val();
    var depDay = $("#depDay" + i).val();
    var arv = $("#arv" + i).val();
    var col = $("#col" + i).val();
    var order = $("#order" + i).val();
    var city1 = "";
    var city2 = "";
    var name1 = "";
    var name2 = "";
    $.getJSON("/Airport/" + dep + "/" + arv, function (data) {
        var temp = 0;
        $(data).each(
            function () {
                if (temp == 0) {
                    city1 = this.city;
                    name1 = this.airportName;
                    temp++;
                } else {
                    city2 = this.city;
                    name2 = this.airportName;
                }
            });
    });
    $.getJSON("/routeMore/" + dep + "/" + depDay + "/" + arv + "/" + col + "/" + order + "/" + str_input, function (data) {
        if ($(data).length == 0) {
            alert("더 이상 항공권이 존재하지 않습니다.");
            $("#more_" + i).remove();
        }
        var str = "";
        var count = 5 * (str_input);
        $(data).each(
            function () {
                ++count;
                str += "<tr>" +
                    "<th scope=\"row\">" + count + "</th>" +
                    "<td>\n" +
                    "<a data-toggle=\"tooltip\" \n" + "id='temp'" +
                    "title=\"" + city1 + "," + name1 + "\">" + this.dep + "</a>\n" +
                    "</td>" +
                    "<td>" + this.depDay + "</td>\n" +
                    "<td>" + this.depTime + "</td>\n" +
                    "<td>\n" +
                    "<a data-toggle=\"tooltip\" \n" + "id='temp'" +
                    "title=\"" + city2 + ", " + name2 + "\">" + this.arv + "</a>\n" +
                    "</td>" +
                    "<td>" + this.arvDay + "</td>\n" +
                    "<td>" + this.arvTime + "</td>\n" +
                    "<td>" + this.airlineCode + "</td>\n" +
                    "<td>" + this.price + "</td>" +
                    "  <td><a href=\"javascript:select(" + this.sno + ");\"\n" +
                    "class=\"badge badge-pill badge-info\"  >선택</a></td>\n" +
                    "<input type=\"hidden\" value=\"" + this.sno + "\" id=\"sno_" + this.sno + "\">" +
                    "</tr>";
            });
        $(str).appendTo("#table_" + i);
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });
    });
}

//페이지 이동 전역변수
var tabNum = 0;
var tabNum2 = 0;

//추가
function select(i) {
    var list_count = Number($("#list_count").val()) + 1;
    $("#count").text(list_count);
    $("#list_count").val(list_count);
    var total_price = parseInt($("#total_price").val());
    var sno = $("#sno_" + i).val();
    $.getJSON("/routeSno/" + sno, function (data) {
        var str = "";
        $(data).each(
            function () {
                str += "<tr id='tr_" + this.sno + "'>" +
                    "<td>" + this.dep + "</td>\n" +
                    "<td>" + this.depDay + "</td>\n" +
                    "<td>" + this.depTime + "</td>\n" +
                    "<td>" + this.arv + "</td>\n" +
                    "<td>" + this.arvDay + "</td>\n" +
                    "<td>" + this.arvTime + "</td>\n" +
                    "<td>" + this.airlineCode + this.fno + "</td>\n" +
                    "<td id='price_" + this.sno + "'>" + this.price + "</td>" +
                    "<td><a href=\"javascript:delete_list(" + this.sno + ");\"\n" +
                    "class=\"badge badge-pill badge-danger\"  >삭제</a></td>\n" +
                    "</tr>";
                total_price = total_price + parseInt(this.price);
            });
        $("#total_price").val(total_price);
        $("#total_price_real").text("￦" + numeral(total_price).format('0,0'));

        $(str).appendTo("#table_select");

        if (true) {
            tabNum2++;
            $('#tab_' + tabNum2).trigger('click');

        }

        if (tabNum == 0) {

            $('#tab2').trigger('click');
            tabNum++;
            console.log(tabNum);
        }

        else if (tabNum == 1) {

            $('#tab3').trigger('click');
            tabNum++;
            console.log(tabNum);
        }

    });
}

//리스트 제거
function delete_list(i) {
    $("#total_price").val(parseInt($("#total_price").val()) - parseInt($("#price_" + i).text()));
    $("#total_price_real").text("￦" + numeral(parseInt($("#total_price").val())).format('0,0'));
    $("#tr_" + i).remove();
    var list_count = Number($("#list_count").val()) - 1;
    $("#count").text(list_count);
    $("#list_count").val(list_count);
    alert('항공권이 삭제됩니다.');
    tabNum2 = 0;
}
