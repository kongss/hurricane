<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <!--<link rel="stylesheet" href="/css/common/bootstrap.min.css">-->
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="/js/common/jquery.min.js"></script>
    <script src="/js/common/bootstrap.min.js"></script>

    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/search.css">
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<div class="container-fluid header">
    <div class="login-info">
        <span class="glyphicon glyphicon-home"></span>
        <span style="cursor: pointer">首页</span>
        &ensp;
        &ensp;
        <span class="center-info" style="cursor: pointer">沧海，</span>
        &ensp;
        <span class="center-info" style="cursor: pointer">注销</span>
        &ensp;
        <span class="click-surprise" style="cursor: pointer">点击惊喜</span>
    </div>
    <div class="login-button">
        <img src="/doc/img/qq_login_button.png">
        <img src="/doc/img/qq_login_button.png">
    </div>
</div>
<#-- 导航栏 -->
<#include "../common/navigationBar.ftl">
<div class="container-fluid seller-list">
    <div class="seller-content">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#">综合商城</a></li>
            <li><a href="#">理财保险</a></li>
            <li><a href="#">手机数码</a></li>
            <li><a href="#">珠宝首饰</a></li>
            <li><a href="#">服装服饰</a></li>
            <li class="active"><a href="#">家用电器</a></li>
            <li><a href="#">户外运动</a></li>
            <li><a href="#">汽车用品</a></li>
            <li><a href="#">医药保健</a></li>
            <li class="active"><a href="#">图书音像</a></li>
        </ul>
    </div>
    <div class="seller-show">
        <ul class="seller-ul">
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
        </ul>
    </div>
</div>
<div class="container-fluid coupon-list">
    <div class="coupon-content">
        <div class="coupon-group">
            <div class="coupon-d sInfo">
                <img style="height: 60px;width: 160px;" src="/doc/img/iq-logo.png">
                <p style="font-size: 18px">金融理财</p>
            </div>
            <div class="coupon-d cInfo">
                <span style="font-size: 50px">80</span><br>
                <span>满600可用</span><br>
                <span>2017-12至2018-12</span>
            </div>
            <div class="coupon-d cAction">
                <span class="get-span">领<br>取</span>
            </div>
        </div>
        <div class="coupon-group">
            <div class="coupon-d sInfo">
                <img style="height: 60px;width: 160px;" src="/doc/img/iq-logo.png">
                <p style="font-size: 18px">金融理财</p>
            </div>
            <div class="coupon-d cInfo">
                <span style="font-size: 50px">80</span><br>
                <span>满600可用</span><br>
                <span>2017-12至2018-12</span>
            </div>
            <div class="coupon-d cAction">
                <span class="get-span">领<br>取</span>
            </div>
        </div>
        <div class="coupon-group">
            <div class="coupon-d sInfo">1</div>
            <div class="coupon-d cInfo">2</div>
            <div class="coupon-d cAction">3</div>
        </div>

    </div>
    <div class="seller-recommend">
        <div><h4>推荐商城</h4></div>
        <div class="recommend-list">
            <ul class="recommend-content">
                <li class="recommend-group"><img style="height: 60px;width: 160px;" src="/doc/img/iq-logo.png"></li>
                <li class="recommend-group"><img style="height: 60px;width: 160px;" src="/doc/img/iq-logo.png"></li>
                <li class="recommend-group"><img style="height: 60px;width: 160px;" src="/doc/img/iq-logo.png"></li>
            </ul>
        </div>
    </div>
</div>
<div class="container-fluid footer">
    5
</div>
</body>
</html>