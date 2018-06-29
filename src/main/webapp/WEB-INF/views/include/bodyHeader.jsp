<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<%------------------- 자동완성 플러그인--------------------%>
<script src="/resources/js/tether.min.js"></script>
<script src="/resources/js/typeahead.bundle.min.js"></script>

<body>

<%------------------- 상단 Nav--------------------%>
<section class="menu cid-qSQttKSGm1" once="menu" id="menu2-9">


    <nav class="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm">
        <button class="navbar-toggler navbar-toggler-right" type="button"
                data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
        </button>
        <div class="menu-logo">
            <div class="navbar-brand">
                <span class="navbar-logo">
                    <a id="logo">
                        <img src="/resources/img/SSR.PNG" alt="SmartSkyRoute"
                             style="height: 3.8rem;">
                    </a>
                </span>

            </div>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav nav-dropdown" data-app-modern-menu="true">
                <li class="nav-item">
                    <a class="nav-link link text-warning display-4">
                        <span class="mbrib-globe-2 mbr-iconfont mbr-iconfont-btn"></span>
                        Languages
                    </a>
                </li>
            </ul>
            <div class="navbar-buttons mbr-section-btn">
                <a class="btn btn-sm btn-primary-outline display-4"
                   href=""> ko-KRW</a>


            </div>
        </div>
    </nav>
</section>


<%------------------- 검색창 --------------------%>

<section class="header1 cid-qSQtzmmY7v" id="header1-a">


    <div class="mbr-overlay"
         style="opacity: 0.3; background-color: rgb(193, 193, 193);">
    </div>

    <div class="container">
        <ul class="nav nav-tabs mb-3" id="pills-tab" role="tablist">
            <li class="nav-item">
    <span class="nav-link active" id="pills-home-tab"
          data-toggle="pill" href="#pills-home" role="tab"
          aria-controls="pills-home"
          aria-selected="true"
          style="margin-right: 20px">왕복</span>
            </li>

            <li class="nav-item">
    <span class="nav-link" id="multiCityInput"
          data-toggle="pill" href="#multi-city" role="tab"
          aria-controls="pills-profile" aria-selected="false"
          style="margin-right: 20px">다구간</span>
            </li>

            <li class="nav-item">
    <span class="nav-link" id="lowestInput"
          data-toggle="pill" href="#lowest" role="tab"
          aria-controls="pills-profile" aria-selected="false">최저가</span>
            </li>
        </ul>
        <div class="tab-content" id="pills-tabContent">

            <%-- ===============왕복================ --%>
            <div class="tab-pane fade show active" id="pills-home"
                 role="tabpanel" aria-labelledby="pills-home-tab">
                <form action="/round" method="post" name="baseForm"
                      id="ScheduleVO">
                    <div class="row justify-content-md-center">

                        <%--출발지--%>
                        <div class="autocomplete">
                            <label for="d1"
                                   class="col-form-label">출발지</label>
                            <input class="rounded-left typeahead" id="d1"
                                   type="text"
                                   name="dep" placeholder="도시 또는 공항"
                                   value="ICN">
                        </div>

                        <%--Swap 버튼--%>
                        <div class="swapWrapper">
                            <br/>
                            <label for="swap"
                                   class="col-form-label"></label><br/>
                            <button type="button" id="swap" class="border-0"
                                    style="background-color: #f1f1f1; height: 46px;">
                                <svg xmlns="http://www.w3.org/2000/svg"
                                     viewBox="0 0 24 24" width="18" height="17"
                                     style="width: 1.125rem;; ">
                                    <path d="M9.1 11.2V9.5H15c.8 0 1.5-.7 1.5-1.5s-.7-1.5-1.5-1.5H9.1V4.8c0-.6-.6-.9-1.1-.7L2.4 7.3c-.5.3-.5 1 0 1.3L8 11.9c.5.3 1.1-.1 1.1-.7zm12.5 4.1L16 12.1c-.5-.3-1.1.1-1.1.7v1.7H9c-.8 0-1.5.7-1.5 1.5s.7 1.5 1.5 1.5h5.9v1.7c0 .6.6.9 1.1.7l5.6-3.2c.5-.3.5-1.1 0-1.4z"></path>
                                </svg>
                            </button>
                        </div>

                        <%--도착지--%>
                        <div class="autocomplete">
                            <label for="a1"
                                   class="col-form-label">도착지</label>
                            <input class="border-right border-left typeahead"
                                   id="a1"
                                   type="text"
                                   name="arv" placeholder="도시 또는 공항"
                                   value="NRT">
                        </div>

                        <%--가는날--%>
                        <div class="form-group">
                            <label for="dTime"
                                   class="col-form-label">가는날</label>
                            <input class="border-right " id="dTime"
                                   name="depDay"
                                   type="date" value="2018-07-01"
                                   onchange="search()">
                        </div>

                        <%--오는날--%>
                        <div class="form-group">
                            <label for="aTime"
                                   class="col-form-label">오는날</label>
                            <input class="border-right rounded-right" id="aTime"
                                   name="arvDay"
                                   type="date" value="2018-07-05"
                                   onchange="search()">
                        </div>
                    </div>

                    <%-- 검색 버튼 --%>
                    <div class="mbr-section-btn align-center">
                        <button class="btn btn-md btn-primary display-4 rounded">
                            <span class="mbrib-search mbr-iconfont mbr-iconfont-btn"></span>
                            항공권 검색
                        </button>

                    </div>
                </form>
            </div>

            <%-- ===================다구간================== --%>
            <div class="tab-pane fade justify-content-md-center"
                 id="multi-city" role="tabpanel"
                 aria-labelledby="pills-profile-tab">

                <form name="baseForm" action="/" method="post"
                      id="ScheduleVO">
                    <div class="row justify-content-md-center" id="input">
                        <ul class="list-group-flush">
                            <input type="hidden" name="count" value="0">
                            <li style="list-style-type: none;">
                                <div class="d-inline-block">
                                    <div class="input-group input-group-sm mb-3 ">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">출발지</span>
                                        </div>
                                        <div class=" d-inline-block">
                                            <input type="text"
                                                   class="rounded-right typeahead"
                                                   name="dep" id="dep"
                                                   value="ICN"
                                                   style="width: 300px;"></div>
                                    </div>
                                </div>
                                <div class="d-inline-block">
                                    <div class="input-group input-group-sm mb-3 ">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">가는날</span>
                                        </div>
                                        <div class=" d-inline-block">
                                            <input type="date"
                                                   class="rounded-right "
                                                   name="depDay"
                                                   id="depDay"
                                                   value="2018-07-01"
                                                   style="width: 300px"></div>
                                    </div>
                                </div>
                            </li>


                            <li style="list-style-type: none"
                                id="addedFormDiv"></li>
                            <li style="list-style-type: none">
                                <div class="d-inline-block">
                                    <div class="input-group input-group-sm mb-3 ">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">도착지</span>
                                        </div>
                                        <div class=" d-inline-block">
                                            <input type="text"
                                                   class="rounded-right typeahead"
                                                   name="arv" value="LHR"
                                                   id="arv"
                                                   style="width: 300px;"></div>
                                    </div>
                                </div>
                                <div class="d-inline-block">
                                    <div class="input-group input-group-sm mb-3 ">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">도착일</span>
                                        </div>
                                        <div class=" d-inline-block">
                                            <input type="date"
                                                   class="rounded-right"
                                                   name="arvDay"
                                                   id="arvDay"
                                                   value="2018-07-05"
                                                   style="width: 300px"></div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="row justify-content-md-center" id="button_list">
                        <button type="Button" value="추가" onclick="addForm()"
                                class="btn btn-md btn-primary display-4 rounded">
                            <span class="mbri-plus mbr-iconfont mbr-iconfont-btn"></span>
                            경유지 추가
                        </button>

                        <button type="Button" value="삭제" onclick="delForm()"
                                class="btn btn-md btn-primary display-4 rounded">
                            <span class="mbri-close mbr-iconfont mbr-iconfont-btn"></span>
                            경유지 삭제
                        </button>

                        <button class="btn btn-md btn-warning display-4 rounded"
                                type="submit">
                            <span class="mbrib-search mbr-iconfont mbr-iconfont-btn"></span>
                            항공권 검색
                        </button>
                    </div>
                </form>
            </div>

            <%-- ===================최저가================== --%>
            <div class="tab-pane fade justify-content-md-center"
                 id="lowest" role="tabpanel"
                 aria-labelledby="pills-profile-tab">

                <form name="baseForm" action="/LowestPrice" method="post"
                      id="">
                    <div class="row justify-content-md-center" id="input2">
                        <ul class="list-group-flush" style="padding-left: 0;">
                            <input type="hidden" name="count" value="0">
                            <li style="list-style-type: none;">
                                <div class="d-inline-block">
                                    <div class="input-group input-group-sm mb-3 ">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">출발지</span>
                                        </div>
                                        <div class=" d-inline-block">
                                            <input type="text"
                                                   class="rounded-right typeahead"
                                                   name="dep" id="dep2"
                                                   value="ICN"
                                                   style="width: 300px;"></div>
                                    </div>
                                </div>
                                <div class="d-inline-block">
                                    <div class="input-group input-group-sm mb-3 ">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">가는날</span>
                                        </div>
                                        <div class=" d-inline-block">
                                            <input type="date"
                                                   class="rounded-right"
                                                   name="depDay"
                                                   id="depDay2"
                                                   style="width: 300px"></div>
                                    </div>
                                </div>
                            </li>


                            <li style="list-style-type: none"
                                id="addedFormDiv2"></li>
                            <li style="list-style-type: none">
                                <div class="d-inline-block">
                                    <div class="input-group input-group-sm mb-3 ">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">도착지</span>
                                        </div>
                                        <div class=" d-inline-block">
                                            <input type="text"
                                                   class="rounded-right typeahead"
                                                   name="arv" value="LHR"
                                                   style="width: 300px;"></div>
                                    </div>
                                </div>

                            </li>
                        </ul>
                    </div>
                    <div class="row justify-content-md-center" id="button_list">
                        <button type="Button" value="추가" onclick="addForm2()"
                                class="btn btn-md btn-primary display-4 rounded">
                            <span class="mbri-plus mbr-iconfont mbr-iconfont-btn"></span>
                            경유지 추가
                        </button>

                        <button type="Button" value="삭제" onclick="delForm2()"
                                class="btn btn-md btn-primary display-4 rounded">
                            <span class="mbri-close mbr-iconfont mbr-iconfont-btn"></span>
                            경유지 삭제
                        </button>

                        <button class="btn btn-md btn-warning display-4 rounded"
                                type="submit">
                            <span class="mbrib-search mbr-iconfont mbr-iconfont-btn"></span>
                            항공권 검색
                        </button>
                    </div>
                </form>

            </div>
        </div>
    </div>

</section>

</body>

<%------------------- bodyHeader.js--------------------%>
<script src="/resources/js/bodyHeader.js"></script>

<script type="text/javascript">
    $("#logo").click(function () {
        location.href = " http://localhost:8080/";
    });

</script>

