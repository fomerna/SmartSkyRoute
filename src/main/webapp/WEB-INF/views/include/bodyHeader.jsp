<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="head.jsp" %>
<script src="/resources/auto-complete.js"></script>
<script src="/resources/bodyHeader.js"></script>
<link rel="stylesheet" href="/resources/css/auto-complete.css">


<%@ include file="footer.jsp" %>

<%--=================상단 Nav===================--%>

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
                    <a href="">
                        <img src="/resources/img/SSR.PNG" alt="SmartSkyRoute"
                             style="height: 3.8rem;">
                    </a>
                </span>

            </div>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav nav-dropdown" data-app-modern-menu="true">
                <li class="nav-item">
                    <a class="nav-link link text-warning display-4"
                       href="indexEng.jsp"><span
                            class="mbrib-globe-2 mbr-iconfont mbr-iconfont-btn"></span>
                        Languages
                    </a>
                </li>
            </ul>
            <div class="navbar-buttons mbr-section-btn"><a
                    class="btn btn-sm btn-primary-outline display-4"
                    href="">

                ko-KRW</a> <a class="btn btn-sm btn-primary-outline display-4"
                              href="">

                로그인</a></div>
        </div>
    </nav>
</section>

<%--====================검색창============================--%>

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
                    <span class="nav-link" id="pills-profile-tab"
                          data-toggle="pill" href="#pills-profile" role="tab"
                          aria-controls="pills-profile" aria-selected="false">다구간</span>
            </li>
        </ul>
        <div class="tab-content" id="pills-tabContent">

            <%-- ===============왕복================ --%>
            <div class="tab-pane fade show active" id="pills-home"
                 role="tabpanel" aria-labelledby="pills-home-tab">
                <form>
                    <div class="row justify-content-md-center">

                        <%-- 출발지 --%>
                        <div class="autocomplete">
                            <label for="dep"
                                   class="col-form-label">출발지</label>
                            <input class="rounded-left" id="dep" type="text"
                                   name="dep" placeholder="도시 또는 공항">
                        </div>

                        <%-- Swap 버튼 --%>
                        <div class="swapWrapper">
                            <br/>
                            <label for="dep"
                                   class="col-form-label"></label><br/>
                            <button type="button" id="swap" class="border-0"
                                    style="background-color: #f1f1f1; height: 48px;">
                                <svg xmlns="http://www.w3.org/2000/svg"
                                     viewBox="0 0 24 24" width="18" height="17"
                                     style="width: 1.125rem;; ">
                                    <path d="M9.1 11.2V9.5H15c.8 0 1.5-.7 1.5-1.5s-.7-1.5-1.5-1.5H9.1V4.8c0-.6-.6-.9-1.1-.7L2.4 7.3c-.5.3-.5 1 0 1.3L8 11.9c.5.3 1.1-.1 1.1-.7zm12.5 4.1L16 12.1c-.5-.3-1.1.1-1.1.7v1.7H9c-.8 0-1.5.7-1.5 1.5s.7 1.5 1.5 1.5h5.9v1.7c0 .6.6.9 1.1.7l5.6-3.2c.5-.3.5-1.1 0-1.4z"></path>
                                </svg>
                            </button>
                        </div>

                        <%-- 도착지 --%>
                        <div class="autocomplete">
                            <label for="arv"
                                   class="col-form-label">도착지</label>
                            <input class="border-right border-left " id="arv"
                                   type="text"
                                   name="arv" placeholder="도시 또는 공항">
                        </div>

                        <%-- 가는날 --%>
                        <div class="form-group">
                            <label for="depTime"
                                   class="col-form-label">가는날</label>
                            <input class="border-right " id="depTime"
                                   type="date">
                        </div>

                        <%-- 오는날 --%>
                        <div class="form-group">
                            <label for="arvTime"
                                   class="col-form-label">오는날</label>
                            <input class="border-right rounded" id="arvTime"
                                   type="date">
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
            <div class="tab-pane fade" id="pills-profile" role="tabpanel"
                 aria-labelledby="pills-profile-tab">

                <form>
                    <div class="row justify-content-md-center" id="multi-input">

                        <%-- 출발지 --%>
                        <div class="autocomplete2">
                            <label for="multi-dep"
                                   class="col-form-label">출발지</label>
                            <input class="rounded" id="multi-dep"
                                   type="text"
                                   name="multi-dep" placeholder="도시 또는 공항">
                        </div>

                        <%-- 화살표 --%>
                        <div class="array">
                            <br/>
                            <label
                                    class="col-form-label"></label><br/>
                            <svg xmlns="http://www.w3.org/2000/svg"
                                 viewBox="0 0 24 24" width="25" height="25"
                                 style="width: 1.125rem; height: 1.125rem;margin-top: 13px;margin-left: 5px;margin-right: 5px">
                                <path d="M9.9 19.7L17 12 9.9 4.4c-.7-.7-1.7-.2-1.7.7v14c0 .8 1 1.3 1.7.6z"></path>
                            </svg>
                        </div>

                        <%-- 도착지 --%>
                        <div class="autocomplete2"
                             style="margin-right: 30px">
                            <label for="arv"
                                   class="col-form-label">도착지</label>
                            <input class="border rounded" id="multi-arv"
                                   type="text"
                                   name="multi-arv" placeholder="도시 또는 공항">
                        </div>

                            <%-- 가는날 --%>
                        <div class="form-group2" style="margin-right: 30px">
                            <label for="multi-time"
                                   class="col-form-label">가는날</label><br/>
                            <input class="border rounded"
                                   id="multi-time"
                                   type="date" style="width: 300px">
                        </div>

                        <%-- 삭제 공간 --%>
                        <div class="delete">
                            <br/>
                            <label
                                    class="col-form-label"></label><br/>
                            <svg id="delete" xmlns="http://www.w3.org/2000/svg"
                                 viewBox="0 0 24 24" width="18" height="18"
                                 style="width: 1.125rem; height: 1.125rem; margin-top: 13px">
                            </svg>
                        </div>

                    </div>

                    <%-- 추가 & 검색 버튼 --%>
                    <div class="mbr-section-btn align-center"
                         style="margin-top: 30px">
                        <button type="button"
                                class="btn btn-md btn-primary display-4 rounded"
                                id="more" onclick="add_item()">
                            <span class="mbri-plus mbr-iconfont mbr-iconfont-btn"></span>
                            구간 추가
                        </button>

                        <button class="btn btn-md btn-primary display-4 rounded" type="button">
                            <span class="mbrib-search mbr-iconfont mbr-iconfont-btn"></span>
                            항공권 검색
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</section>


<%--===============경유지 추가===================--%>
<div id="pre_set" style="display:none" class="justify-content-md-center">
    <div class="row justify-content-md-center" id="multi-input2">

        <%-- 경유지 --%>
        <div class="autocomplete3" style="margin-right: 30px">
            <label for="s1"
                   class="col-form-label">경유지</label>
            <input class="rounded" id="s1" name="s1"
                   type="text"
                   placeholder="도시 또는 공항">
        </div>

            <%-- 가는날 --%>
        <div class="form-group3" style="margin-right: 30px">
            <label for="s1-time"
                   class="col-form-label">가는날</label><br/>
            <input class="border-right rounded"
                   id="s1-time"
                   type="date" style="width: 300px">
        </div>

            <%-- 삭제 --%>
        <div class="delete">
            <br/>
            <label
                    class="col-form-label"></label><br/>
            <svg id="delete" xmlns="http://www.w3.org/2000/svg"
                 onclick="remove_item(this)"
                 viewBox="0 0 24 24" width="18" height="18"
                 style="width: 1.125rem; height: 1.125rem; margin-top: 13px;">
                <path d="M12 9.172l4.243-4.243a2 2 0 1 1 2.828 2.828L14.828 12l4.243 4.243a2 2 0 1 1-2.828 2.828L12 14.828l-4.243 4.243a2 2 0 1 1-2.828-2.828L9.172 12 4.929 7.757A2 2 0 1 1 7.757 4.93L12 9.172z"></path>
            </svg>
        </div>
    </div>
</div>



<script src="/resources/bodyHeader.js"></script>



