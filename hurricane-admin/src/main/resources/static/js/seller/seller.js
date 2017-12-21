$(function () {
    sellerList();
    //绑定模态框展示的方法
    $('#myModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);// 触发事件的按钮
        var uuid = button.context.dataset.id;
        var name = button.context.innerHTML;
        $("#myModalLabel").html(name+'商城信息');
        if (uuid != null && uuid != '' && uuid != 'null'){
            toEditSellerPageShow(uuid);
        }

    })
});

function toEditSellerPageShow(uuid) {
    console.log("uuid>>>>>>>>>>>>>>>>>>>>>>>>>"+uuid);
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/seller/getSeller",
        timeout: 6000,
        data: {"uuid":uuid},
        //dataType: "json",
        success:function (data) {
            if ("0000" != data.resCode){
                alert("查询商城信息失败失败！！！连管理员");
                return false;
            }
            var sel = data.map.seller;
            $("#uuid").val(sel.uuid);
            $("#name").val(sel.name);
            $("#logoPicUrl").val(sel.logoPicUrl);
            $("#siteUrl").val(sel.siteUrl);
            $("#source").val(sel.source);
            $("#status").val(sel.status);
            $("#shortUrl").val(sel.shortUrl);
            $("#longUrl").val(sel.longUrl);
        }
    });
}

function sellerList() {
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/seller/sellerList",
        timeout: 6000,
        data: {},
        //dataType: "json",
        success:function (data) {
            if ("0000" != data.resCode){
                alert("查询失败！！！连管理员");
                return false;
            }
            var object = data.map.list;
            if (object.length >0){
                var htmlStr = '';
                $.each(object, function(name, value) {
                    htmlStr+='<tr>';
                    htmlStr+='<td><input type="checkbox"/></td>';
                    htmlStr+='<td>'+checkEmpty(value.name)+'</td>';
                    htmlStr+='<td><img style="height: 60px;" src="'+checkEmpty(value.logo_pic_url)+'"></td>';
                    htmlStr+='<td>'+checkEmpty(value.site_url)+'</td>';
                    var sourceStr = (value.source == null || value.source == '') ? "" : (value.source == 1) ? "多麦" :"亿起发";
                    htmlStr+='<td>'+sourceStr+'</td>';
                    var statusStr = (value.status == null || value.status == '') ? "" : (value.status == 1) ? "启用" :"禁用";
                    htmlStr+='<td>'+statusStr+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.short_url)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.long_url)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.create_time)+'</td>';
                    htmlStr+='<td><button class="btn btn-default" data-toggle="modal" data-id="'+value.uuid+'" data-target="#myModal">修改</button><button class="btn btn-default" data-toggle="modal" onclick="deleteSeller(\''+value.uuid+'\')">删除</button></td>';
                    htmlStr+='<tr>';
                });
                $("#sellerList").html(htmlStr);
                //分页
                page(data);
            }
        }
    });
}

function checkEmpty(param) {
    if (param == null || param == '' || param == 'undefined'){
        return '';
    }
    return param;
}

function deleteSeller(uuid) {
    console.log("uuid>>>>>>>>>>>>>>>>>>>>>>>>>"+uuid);
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/seller/deleteSeller",
        timeout: 6000,
        data: {"uuid":uuid},
        //dataType: "json",
        success:function (data) {
            if ("0000" != data.resCode){
                alert("删除商城信息失败失败！！！连管理员");
                return false;
            }
            alert("已删除");
            window.location.reload();
        }
    });
}