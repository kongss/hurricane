<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/js/seller/seller.js"></script>
</head>
<body>
<ol class="breadcrumb">
    <li><a href="javascript:void(0)">Home</a></li>
    <li><a href="javascript:void(0)">优惠券管理</a></li>
    <li class="active">优惠券列表</li>
</ol>
<form class="navbar-form navbar-left" role="search" style="margin-left: 6px;">
    <div class="form-group">
        <span style="font-size: 16px;">来源：</span><input type="text" class="form-control" />
        &ensp;&ensp;&ensp;
        <span style="font-size: 16px;">商城名称：</span><input type="text" class="form-control" />
        &ensp;&ensp;&ensp;
        <span style="font-size: 16px;">券类型：</span><input type="text" class="form-control" />
    </div>
    <button type="submit" class="btn btn-default">搜索</button>
</form>
<br>
<#include "addCouponModal.ftl">
<div class="container" style="float: left;margin-left: 6px;">
    <!-- 按钮触发模态框 -->
    <button class="btn btn-default" data-toggle="modal" data-target="#myModal">添加</button>
    &ensp;
    <button type="button" class="btn btn-default">批量删除</button>
</div>
<div class="container" style="overflow: auto;margin-left: 5px;margin-top: 10px;width: 98%;">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th style="white-space: nowrap;word-break: keep-all;">商城id</th>
            <th style="white-space: nowrap;word-break: keep-all;">券名称</th>
            <th style="white-space: nowrap;word-break: keep-all;">减免金额说明</th>
            <th style="white-space: nowrap;word-break: keep-all;">此券类型开始时间</th>
            <th style="white-space: nowrap;word-break: keep-all;">此券类型结束时间</th>
            <th style="white-space: nowrap;word-break: keep-all;">链接URL</th>
            <th style="white-space: nowrap;word-break: keep-all;">券类型</th>
            <th style="white-space: nowrap;word-break: keep-all;">是否过期</th>
            <th style="white-space: nowrap;word-break: keep-all;">是否推荐</th>
            <th style="white-space: nowrap;word-break: keep-all;">总数量</th>
            <th style="white-space: nowrap;word-break: keep-all;">领取数量</th>
            <th style="white-space: nowrap;word-break: keep-all;">剩余数量</th>
            <th style="white-space: nowrap;word-break: keep-all;">创建时间</th>
        </tr>
        </thead>
        <tbody id="sellerList">
        <tr>
            <td><img src=""></td>
            <td>John</td>
            <td>John</td>
            <td>Doe</td>
            <td>Doe</td>
            <td>Doe</td>
            <td>john@example.com</td>
            <td>john@example.com</td>
            <td>john@example.com</td>
            <td>john@example.com</td>
            <td>john@example.com</td>
            <td>john@example.com</td>
            <td>john@example.com</td>
            <td>john@example.com</td>
        </tr>
        </tbody>
    </table>
</div>
<ul class="pagination" style="float: right; margin-right: 5px;">
    <li><a href="#">&laquo;</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
</ul>
</body>
</html>