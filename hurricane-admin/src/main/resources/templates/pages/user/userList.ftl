<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/js/user/user.js"></script>
</head>
<body>
<ol class="breadcrumb">
    <li><a href="javascript:void(0)">Home</a></li>
    <li><a href="javascript:void(0)">优惠券管理</a></li>
    <li class="active">优惠券列表</li>
</ol>
<form class="navbar-form navbar-left" role="search" style="margin-left: 6px;">
    <div class="form-group">
        <span style="font-size: 16px;">城市：</span><input type="text" class="form-control" />
        &ensp;&ensp;&ensp;
        <span style="font-size: 16px;">性别：</span><input type="text" class="form-control" />
    </div>
    <button type="submit" class="btn btn-default">搜索</button>
</form>
<br>

<div class="container" style="overflow: auto;margin-left: 5px;margin-top: 10px;width: 98%;">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th style="white-space: nowrap;word-break: keep-all;">nickname</th>
            <th style="white-space: nowrap;word-break: keep-all;">gender</th>
            <th style="white-space: nowrap;word-break: keep-all;">province</th>
            <th style="white-space: nowrap;word-break: keep-all;">city</th>
        </tr>
        </thead>
        <tbody id="userList">
        <tr>
            <td>John</td>
            <td>John</td>
            <td>John</td>
            <td>Doe</td>
        </tr>
        </tbody>
    </table>
</div>
<ul class="pagination" id="page" style="float: right; margin-right: 5px;">
    <li><a href="#">&laquo;</a></li>
    <li class="active"><a href="#">1</a></li>
    <li class="disabled"><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
</ul>
</body>
</html>