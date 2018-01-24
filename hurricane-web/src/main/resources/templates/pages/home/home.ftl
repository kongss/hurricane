<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <!--<link rel="stylesheet" href="/css/common/bootstrap.min.css">-->
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="/js/common/jquery.min.js"></script>
    <script src="/js/common/bootstrap.min.js"></script>
    <script src="/js/home.js"></script>

    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/search.css">
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<#-- 公共头 -->
<#include "../common/header.ftl">
<#-- 导航栏 -->
<#include "../common/navigationBar.ftl">
<div class="container-fluid seller-list">
    <div class="seller-content">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#" onclick="sellerList(1)">综合商城</a></li>
            <li><a href="#" onclick="sellerList(10)">理财保险</a></li>
            <li><a href="#" onclick="sellerList(2)">手机数码</a></li>
            <li><a href="#" onclick="sellerList(3)">珠宝首饰</a></li>
            <li><a href="#" onclick="sellerList(4)">服装服饰</a></li>
            <li><a href="#" onclick="sellerList(5)">家用电器</a></li>
            <li><a href="#" onclick="sellerList(6)">户外运动</a></li>
            <li><a href="#" onclick="sellerList(7)">汽车用品</a></li>
            <li><a href="#" onclick="sellerList(8)">医药保健</a></li>
            <li><a href="#" onclick="sellerList(9)">图书音像</a></li>
        </ul>
    </div>
    <div class="seller-show">
        <ul class="seller-ul" id="pic-list">
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
            <li class="seller-li"><img class="seller-pic" src="/doc/img/iq-logo.png"></li>
        </ul>
    </div>
</div>
<div class="container-fluid coupon-list">
    <div class="coupon-content" id="c-list">
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

    </div>
    <div class="seller-recommend">
        <div><h4>推荐商城</h4></div>
        <div class="recommend-list">
            <ul class="recommend-content" id="s-r-list">
                <li class="recommend-group"><img style="height: 60px;width: 160px;" src="/doc/img/iq-logo.png"></li>
                <li class="recommend-group"><img style="height: 60px;width: 160px;" src="/doc/img/iq-logo.png"></li>
                <li class="recommend-group"><img style="height: 60px;width: 160px;" src="/doc/img/iq-logo.png"></li>
            </ul>
        </div>
    </div>
</div>
<#include "../common/footer.ftl">
</body>
</html>