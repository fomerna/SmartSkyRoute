// ==================왕복 Swap==================


$("#swap").click(function () {
    var temp = $('#dep').val();
    $('#dep').val($('#arv').val());
    $('#arv').val(temp);

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
            "                            <input type=\"text\" class=\"rounded\"\n" +
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
            "                            <span class=\"input-group-text rounded-left\">경유지</span>\n" +
            "                        </div>\n" +
            "                        <div class=\" d-inline-block\" >\n" +
            "                            <input type=\"text\" class=\"rounded-right\"\n" +
            "                                   aria-describedby=\"inputGroup-sizing-sm\" style=\"width: 300px;\" name=\"s" + count2 + "\"  >" +
            "               </div>     </div>\n" +
            "                </div>";

        str += " <div class=\"d-inline-block\">\n" +
            "                    <div class=\"input-group mb-3\" style=\"width:360px\">\n" +
            "                        <div class=\"input-group-prepend d-inline-block \" style=\"width:100px\">\n" +
            "                            <label class=\"input-group-text\" style='height: 45px' for=\"col${j.index}\">예상 경유일</label>\n" +
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


// ===============왕복 출발/도착일 sysDate===========

/*var today = new Date();
var dd = ("0" + (today.getDate())).slice(-2);
var mm = ("0" + (today.getMonth() + 1)).slice(-2);
var yyyy = today.getFullYear();
today = yyyy + '-' + mm + '-' + dd;
$("#dTime").attr("value", today);
$("#aTime").attr("value", today);
$("#depDay").attr("value", today);
$("#arvDay").attr("value", today);*/



function search() {
    var dep=$("#d1").val();
    var depDay=$("#dTime").val();
    var str="";
    var count =0;

   $.getJSON('input/'+ dep + "/" + depDay, function (data) {
       $(data).each(function () {

           str+= "<div class=\"img-cont thumbnail\"\n" +
               "style=\"margin-right: 5px\">\n";
           if(count==0){
               str+=  "<img class=\"img-responsive rounded img\"\n" +
                   "                                                     src=\"/resources/img/city/"+this.arv+".PNG\"\n" +
                   "                                                     style=\"width: 500px; height: 300px\">\n";
           }else{
               str+= "<img class=\"img-responsive rounded img\"\n" +
               "                                                     src=\"/resources/img/city/"+this.arv+".PNG\"\n" +
               "                                                     style=\"width: 360px; height: 300px\">\n";
           }
           str+= "                                        <div class=\"caption row\">\n" +
               "                                            <h4>\n" +
               "                                                <span id=\"city\">\n"+this.arv+","+"</span>\n" +
               "                                                <span id=\"country\">dd </span>\n" +
               "                                            </h4>\n" +
               "                                            <h6>가격 확인 <img\n" +
               "                                                    src=\"/resources/img/right.png\"\n" +
               "                                                    id=\"right\"></h6>\n" +
               "                                        </div>\n" +
               "                                    </div>";
           count++;
       });
        $("#main1").html(str);
     //  $(str).appendTo("#main1");
   })

}