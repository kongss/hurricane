<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>优惠券大全</title>
    <!--<link rel="stylesheet" href="/css/common/bootstrap.min.css">-->
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="/js/common/jquery.min.js"></script>
    <script src="/js/common/bootstrap.min.js"></script>

    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/search.css">
    <link rel="stylesheet" href="/css/couponList.css">
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
<div class="coupon-all">
    <div class="coupon-group">
        <div class="coupon-info">1</div>
        <div class="coupon-info">2</div>
    </div>
    <div class="coupon-group">
        <div class="coupon-info">1</div>
        <div class="coupon-info">2</div>
    </div>
    <div class="coupon-group">
        <div class="coupon-info">1</div>
        <div class="coupon-info">2</div>
    </div>
    <div class="coupon-group">
        <div class="coupon-info">1</div>
        <div class="coupon-info">2</div>
    </div>
    <div class="coupon-group">
        <div class="coupon-info">1</div>
        <div class="coupon-info">2</div>
    </div>
    <div class="coupon-group">
        <div class="coupon-info">1</div>
        <div class="coupon-info">2</div>
    </div>

</div>
<div class="coupon-list-page" style="text-align: center;">
    <ul class="pagination">
        <li><a href="#">&laquo;</a></li>
        <li class="active"><a href="#">1</a></li>
        <li class="disabled"><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">&raquo;</a></li>
    </ul>
</div>
<div class="container-fluid footer">
    5
</div>
</body>
</html>