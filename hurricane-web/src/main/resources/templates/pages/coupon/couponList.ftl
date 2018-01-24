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
<#-- 公共头 -->
<#include "../common/header.ftl">
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
<#include "../common/footer.ftl">
</body>
</html>