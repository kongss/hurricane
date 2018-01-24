<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商城详情</title>
    <!--<link rel="stylesheet" href="../css/common/bootstrap.min.css">-->
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="../js/common/jquery.min.js"></script>
    <script src="../js/common/bootstrap.min.js"></script>

    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/footer.css">
    <link rel="stylesheet" href="../css/search.css">
    <link rel="stylesheet" href="../css/details.css">
</head>
<body>
<#-- 公共头 -->
<#include "../common/header.ftl">
<#-- 导航栏 -->
<#include "../common/navigationBar.ftl">
<div class="seller-content">
    <div class="seller-info">
        <img height="180px" src="../doc/img/sInfo.png">
    </div>
    <div class="coupon-list">商城下所有优惠券</div>
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