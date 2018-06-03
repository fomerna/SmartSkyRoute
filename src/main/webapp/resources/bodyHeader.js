// ==================왕복 Swap==================


$("#swap").click(function () {
    var temp = $('#dep').val();
    $('#dep').val($('#arv').val());
    $('#arv').val(temp);

});


// ===============다구간 추가 & 삭제===============
var count = 1;

function add_item() {


    if (count < 6) {

        var div = document.createElement('div');
        div.innerHTML = document.getElementById('pre_set').innerHTML;
        document.getElementById('multi-input').appendChild(div);

        count++;
    }

    else {
        alert("경유지 최대 개수 5개")
    }
    console.log(count);
}


function remove_item(obj) {


    document.getElementById('multi-input').removeChild(obj.parentNode.parentNode.parentNode);
    count--;
    console.log(count);
}


// ===============왕복 출발/도착일 sysDate===========

var today = new Date();
var dd = ("0" + (today.getDate())).slice(-2);
var mm = ("0" + (today.getMonth() + 1)).slice(-2);
var yyyy = today.getFullYear();
today = yyyy + '-' + mm + '-' + dd;
$("#depTime").attr("value", today);
$("#arvTime").attr("value", today);
$("#multi-time").attr("value", today);
$("#s1-time").attr("value", today);


// ====================자동완성======================

    var dep = new autoComplete({

        selector: '#dep',
        minChars: 0,
        source: function (term, suggest) {
            term = term.toLowerCase();
            var choices = [['인천', 'ICN'], ['베이징', 'PEK'], ['상하이', 'PVG'], ['도쿄', 'NRT'], ['런던', 'LHR'], ['파리', 'CDG'], ['로마', 'FCO'], ['밀라노', 'MXP'], ['마드리드', 'MAD'], ['바르셀로나', 'BCN']];
            var suggestions = [];

            for (i = 0; i < choices.length; i++)
                if (~(choices[i][0] + ' ' + choices[i][1]).toLowerCase().indexOf(term)) suggestions.push(choices[i]);
            suggest(suggestions);
        },
        renderItem: function (item, search) {
            search = search.replace(/[-\/\\^$*+?.()|[\]{}]/g, '\\$&amp;');
            var re = new RegExp("(" + search.split(' ').join('|') + ")", "gi");
            return '<div class="autocomplete-suggestion" data-langname="' + item[0] + '" data-lang="' + item[1] + '" data-val="' + search + '"> ' + item[0].replace(re, "<b>$1</b>") + '</div>';
        },
        onSelect: function (e, term, item) {
            console.log('Item "' + item.getAttribute('data-langname') + ' (' + item.getAttribute('data-lang') + ')" selected by ' + (e.type == 'keydown' ? 'pressing enter' : 'mouse click') + '.');
            document.getElementById('dep').value = item.getAttribute('data-langname') + ' (' + item.getAttribute('data-lang') + ')';
        }
    });


$(document).ready(function () {

    $('#s1').on()
});
        var s1 = new autoComplete({

            selector: '#s1',
            minChars: 0,
            source: function (term, suggest) {
                term = term.toLowerCase();
                var choices = [['인천', 'ICN'], ['베이징', 'PEK'], ['상하이', 'PVG'], ['도쿄', 'NRT'], ['런던', 'LHR'], ['파리', 'CDG'], ['로마', 'FCO'], ['밀라노', 'MXP'], ['마드리드', 'MAD'], ['바르셀로나', 'BCN']];
                var suggestions = [];

                for (i = 0; i < choices.length; i++)
                    if (~(choices[i][0] + ' ' + choices[i][1]).toLowerCase().indexOf(term)) suggestions.push(choices[i]);
                suggest(suggestions);
            },
            renderItem: function (item, search) {
                search = search.replace(/[-\/\\^$*+?.()|[\]{}]/g, '\\$&amp;');
                var re = new RegExp("(" + search.split(' ').join('|') + ")", "gi");
                return '<div class="autocomplete-suggestion" data-langname="' + item[0] + '" data-lang="' + item[1] + '" data-val="' + search + '"> ' + item[0].replace(re, "<b>$1</b>") + '</div>';
            },
            onSelect: function (e, term, item) {
                console.log('Item "' + item.getAttribute('data-langname') + ' (' + item.getAttribute('data-lang') + ')" selected by ' + (e.type == 'keydown' ? 'pressing enter' : 'mouse click') + '.');
                document.getElementById('s1').value = item.getAttribute('data-langname') + ' (' + item.getAttribute('data-lang') + ')';
            }
        });

/*var arv = new autoComplete({

    selector: '#arv',
    minChars: 1,
    source: function (term, suggest) {
        term = term.toLowerCase();
        var choices = [['인천', 'ICN'], ['베이징', 'PEK'], ['상하이', 'PVG'], ['도쿄', 'NRT'], ['런던', 'LHR'], ['파리', 'CDG'], ['로마', 'FCO'], ['밀라노', 'MXP'], ['마드리드', 'MAD'], ['바르셀로나', 'BCN']];
        var suggestions = [];

        for (i = 0; i < choices.length; i++)
            if (~(choices[i][0] + ' ' + choices[i][1]).toLowerCase().indexOf(term)) suggestions.push(choices[i]);
        suggest(suggestions);
    },
    renderItem: function (item, search) {
        search = search.replace(/[-\/\\^$*+?.()|[\]{}]/g, '\\$&amp;');
        var re = new RegExp("(" + search.split(' ').join('|') + ")", "gi");
        return '<div class="autocomplete-suggestion" data-langname="' + item[0] + '" data-lang="' + item[1] + '" data-val="' + search + '"> ' + item[0].replace(re, "<b>$1</b>") + '</div>';
    },
    onSelect: function (e, term, item) {
        console.log('Item "' + item.getAttribute('data-langname') + ' (' + item.getAttribute('data-lang') + ')" selected by ' + (e.type == 'keydown' ? 'pressing enter' : 'mouse click') + '.');
        document.getElementById('arv').value = item.getAttribute('data-langname') + ' (' + item.getAttribute('data-lang') + ')';
    }
});*/








