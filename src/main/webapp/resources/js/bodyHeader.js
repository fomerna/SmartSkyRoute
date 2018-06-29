// ==================왕복 Swap==================


$("#swap").click(function () {
    var temp = $('#d1').val();
    $('#d1').val($('#a1').val());
    $('#a1').val(temp);

    search();

});


// ===============다구간 추가 & 삭제===============
var count = 1;
var count2 = 1;


function addForm() {

    if (count < 6) {


        var addedFormDiv = document.getElementById("addedFormDiv");//
        var str = "";

        str += " <div class=\"d-inline-block\" >\n" +
            "                    <div class=\"input-group input-group-sm mb-3 \">\n" +
            "                        <div class=\"input-group-prepend\">\n" +
            "                            <span class=\"input-group-text\">경유지</span>\n" +
            "                        </div>\n" +
            "                        <div class=\" d-inline-block\" >\n" +
            "                            <input type=\"text\" class=\"rounded-right\"\n" +
            "                                   aria-describedby=\"inputGroup-sizing-sm\"  style=\"width: 300px;\" name=\"s" + count + "\" id=\"s" + count + "\"  >" +
            "               </div>     </div>\n" +
            "                </div>";
        // 추가할 폼(에 들어갈 HTML)


        var addedDiv = document.createElement("div"); // 폼 생성

        addedDiv.id = "added_" + count; // 폼 Div에 ID 부여 (삭제를 위해)

        addedDiv.innerHTML = str; // 폼 Div안에 HTML삽입

        addedFormDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입

        count++;

    }

    else {
        alert("경유지는 5개까지 검색 가능");
        console.log(count);
    }

}


function delForm() {

    var addedFormDiv = document.getElementById("addedFormDiv");

    if (count > 1) { // 현재 폼이 두개 이상이면

        var addedDiv = document.getElementById("added_" + (--count));

        // 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴

        addedFormDiv.removeChild(addedDiv); // 폼 삭제

    } else { // 마지막 폼만 남아있다면

        document.baseForm.reset(); // 폼 내용 삭제

    }

}

function addForm2() {

    if (count2 < 6) {


        var addedFormDiv2 = document.getElementById("addedFormDiv2");//


        var str = "";
        str += " <div class=\"d-inline-block\" >\n" +
            "                    <div class=\"input-group input-group-sm mb-3 \">\n" +
            "                        <div class=\"input-group-prepend\">\n" +
            "                            <label class=\"input-group-text\" for='s"+count2+"'>경유지</label>\n" +
            "                        </div>\n" +
            "                        <div class=\" d-inline-block\" >\n" +
            "                            <input type=\"text\" class=\"rounded-right\"\n" +
            "                                   aria-describedby=\"inputGroup-sizing-sm\" style=\"width: 300px;\" id='s"+count2+"' name=\"s" + count2 + "\" >" +
            "               </div>     </div>\n" +
            "                </div>";

        str += " <div class=\"d-inline-block\">\n" +
            "                    <div class=\"input-group mb-3\" style=\"width:360px\">\n" +
            "                        <div class=\"input-group-prepend d-inline-block \" style=\"width:63px\">\n" +
            "                            <label class=\"input-group-text\" style='height: 45px' for=\"col${j.index}\">경유일</label>\n" +
            "                        </div>\n" +
            "                        <select class=\"custom-select\" style='height: 45px' name=\"day" + count2 + "\">\n" +
            "                            <option value=\"가격\">일 수</option>\n" +
            "                            <option value=\"1\">1일</option>\n" +
            "                            <option value=\"2\">2일</option>\n" +
            "                            <option value=\"3\">3일</option>\n" +
            "                            <option value=\"4\">4일</option>\n" +
            "                            <option value=\"5\">5일</option>\n" +
            "                            <option value=\"6\">6일</option>\n" +
            "                            <option value=\"7\">7일</option>\n" +
            "                        </select>\n" +
            "                    </div>\n" +
            "                </div>";
        // 추가할 폼(에 들어갈 HTML)


        var addedDiv2 = document.createElement("div"); // 폼 생성

        addedDiv2.id = "added_" + count2; // 폼 Div에 ID 부여 (삭제를 위해)

        addedDiv2.innerHTML = str; // 폼 Div안에 HTML삽입

        addedFormDiv2.appendChild(addedDiv2); // 삽입할 DIV에 생성한 폼 삽입

        count2++;


    }


    else {
        alert("경유지는 5개까지 검색 가능");
        console.log(count);
    }
}


function delForm2() {

    var addedFormDiv2 = document.getElementById("addedFormDiv2");

    if (count2 > 1) { // 현재 폼이 두개 이상이면

        var addedDiv2 = document.getElementById("added_" + (--count2));

        // 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴

        addedFormDiv2.removeChild(addedDiv2); // 폼 삭제

    } else { // 마지막 폼만 남아있다면

        document.baseForm.reset(); // 폼 내용 삭제

    }

}


// ======================특가 경로 & 비동기 특가 경로 ====================

function search() {
    var dep = $("#d1").val();
    var depDay = $("#dTime").val();
    var arvDay = $("#aTime").val();
    var str = "";
    var count = 0;

    var city = new Array();
    var country = new Array();

    $.getJSON('LowestAirport/'+ dep + "/" + depDay, function (data) {
        var idx=0;
        $(data).each(function () {
            city[idx]=this.city;
            country[idx]=this.country;
            idx++;
        });
        $.getJSON('input/' + dep + "/" + depDay, function (data) {
            var idx=0;
            $(data).each(function () {
                if(count==0){
                    str+=    "<h3 style=\"color: #524c61; padding-left: 65px\">특가경로</h3> <br/>\n" +
                        "                            <h6 style=\"margin-left: 70px; color: grey\">출발지: " + this.dep + "</h6>\n" +
                        "\n" +
                        "\n" +
                        "                            <div class=\"row\">";
                }
                str += "<div class=\"img-cont thumbnail\"\n" +
                    "style=\"margin-right: 5px\">\n";


                if (count === 0) {
                    str += "<img class=\"img-responsive rounded img\"\n" +
                        "src=\"/resources/img/city/" + this.arv + ".PNG\"\n" +
                        "style=\"width: 500px; height: 300px\">\n";
                } else {
                    str += "<img class=\"img-responsive rounded img\"\n" +
                        "src=\"/resources/img/city/" + this.arv + ".PNG\"\n" +
                        "style=\"width: 360px; height: 300px\">\n";
                }

                str += " <div class=\"caption row\" id=\"dealFormDiv\">\n" +
                    "<h4>\n" +
                    "<span id=\"city\">\n" +city[idx]+ "," + "</span>\n" +
                    "<span id='country"+idx+"'>"+country[idx]+"</span>\n" +
                    "</h4>\n" +
                    "<form action=\"/round\" method=\"post\" id=\"scheduleVO\" name=\"baseForm\">\n" +
                    "<input type=\"hidden\" name=\"dep\" value=\"" + this.dep + "\">\n" +
                    "<input type=\"hidden\" name=\"arv\" value=\"" + this.arv + "\">\n" +
                    "<input type=\"hidden\" name=\"depDay\" value=\"" + this.depDay + "\">\n" +
                    "<input type=\"hidden\" name=\"arvDay\" value=\"" + arvDay + "\">\n" +
                    "<button id=\"dealBtn\" style=\"cursor:pointer\"><span>가격 확인</span> <img\n" +
                    "src=\"/resources/img/right.png\"\n" +
                    "id=\"right\"></button>\n" +
                    "\n" +
                    "</form>\n" +
                    "</div>\n" +
                    "</div>";
                count++;
                idx++;
            });
            $("#head1").html(str);
        })
    });


}


// ====================== 자동완성 ====================

// Bootstrap 4 + typeahead label fix
//Add class typeahead to your text input invoking typeahead

$('.typeahead').on('focus', function () {
    $(this).parent().siblings().addClass('active');
}).on('blur', function () {
    if (!$(this).val()) {
        $(this).parent().siblings().removeClass('active');
    }
});

var airport = ['ICN', 'BCN', 'CDG', 'NRT', 'PVG', 'PEK', 'MAD', 'LHR', 'FCO', 'MXP'];

//bloodhound demo
//documentation : https://github.com/corejavascript/typeahead.js/blob/master/doc/bloodhound.md

var states = new Bloodhound({
    datumTokenizer: Bloodhound.tokenizers.whitespace,
    queryTokenizer: Bloodhound.tokenizers.whitespace,
    // `airport` is an array of state names defined in "The Basics"
    local: airport
});

//Documentation : https://github.com/corejavascript/typeahead.js/blob/master/doc/jquery_typeahead.md

$('.typeahead').typeahead({
    highlight: true,
    hint: true,
    minLength: 1
}, {
    name: 'states',
    source: states,
    limit: 10
});

$(document).on("click", ".tt-dataset", function () {

    var dep = $("#d1").val();

    search();
});

$(document).ready(function () {

    search();
});







