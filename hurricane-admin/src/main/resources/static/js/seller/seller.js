$(function () {
    couponList(1,10);
    //绑定模态框展示的方法
    $('#myModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);// 触发事件的按钮
        var uuid = button.context.dataset.id;
        //var name = button.context.innerHTML;
        //$("#myModalLabel").html(name+'商城信息');
        if (uuid != null && uuid != '' && uuid != 'null'){
            toEditSellerPageShow(uuid);
        }else {
            //添加时，清除文本框残留的数值
            cleanValue();
        }

    })
});

function cleanValue() {
    $("#uuid").val("");
    $("#name").val("");
    $("#logoPicUrl").val("");
    $("#siteUrl").val("");
    $("#source").val("");
    $("#status").val("");
    $("#shortUrl").val("");
    $("#longUrl").val("");
    initCouponType(-1);
    initSellerStatus(-1);
}

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

            //加载商城来源 {多麦/亿起发}
            initCouponType(sel.source);
            //加载商城启用状态
            initSellerStatus(sel.status)
        }
    });
}

function initSellerStatus(status) {
    var htmlStr = '';
    htmlStr +='<label for="status">启用状态</label><br/>';
    htmlStr +='<input type="hidden" id="status" value="1"/>';
    if(status == 1){
        htmlStr +='<input type="radio" checked onclick="changeStatus(1)" name="status"/>启用';
        htmlStr +='<input type="radio" onclick="changeStatus(0)" name="status"/>禁用';
    }
    if(status == 0){
        htmlStr +='<input type="radio" onclick="changeStatus(1)" name="status"/>启用';
        htmlStr +='<input type="radio" checked onclick="changeStatus(0)" name="status"/>禁用';
    }
    if(status == -1){
        htmlStr +='<input type="radio" checked onclick="changeStatus(1)" name="status"/>启用';
        htmlStr +='<input type="radio" onclick="changeStatus(0)" name="status"/>禁用';
    }
    $("#status_div").html(htmlStr);
}

function initCouponType(source) {
    var htmlStr = '';
    htmlStr+='<option value="0">请选择</option>';
    if(source == 1){
        htmlStr+='<option selected value="1">多麦</option>';
        htmlStr+='<option value="2">亿起发</option>';
    }
    if(source == 2){
        htmlStr+='<option value="1">多麦</option>';
        htmlStr+='<option selected value="2">亿起发</option>';
    }
    if(source == -1){
        htmlStr+='<option value="1">多麦</option>';
        htmlStr+='<option value="2">亿起发</option>';
    }
    $("#sellerSource").html(htmlStr);
}

function couponList(currentPage,pageSize) {
    var sourceL = $("#sourceL").val();
    sourceL = (sourceL == null || sourceL == '' || sourceL == 'undefined') ? "" : sourceL;
    var statusL = $("#statusL").val();
    statusL = (statusL == null || statusL == '' || statusL == 'undefined') ? "" : statusL;
    var sellerTypeUuidL = $("#sellerTypeUuidL").val();
    sellerTypeUuidL = (sellerTypeUuidL == null || sellerTypeUuidL == '' || sellerTypeUuidL == 'undefined') ? "" : sellerTypeUuidL;
    var nameL = $("#nameL").val();
    nameL = (nameL == null || nameL == '' || nameL == 'undefined') ? "" : nameL;
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/seller/sellerList",
        timeout: 6000,
        data: {"currentPage":currentPage,"pageSize":pageSize,"source":sourceL,"status":statusL,"sellerTypeUuid":sellerTypeUuidL,"name":nameL},
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
                    /*htmlStr+='<td><input type="checkbox"/></td>';*/
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.name)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;"><img style="height: 60px;" src="'+checkEmpty(value.logo_pic_url)+'"></td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.site_url)+'</td>';
                    var sourceStr = (value.source == null || value.source == '') ? "" : (value.source == 1) ? "多麦" :"亿起发";
                    htmlStr+='<td style="white-space: nowrap;">'+sourceStr+'</td>';
                    var statusStr = (value.status == null || value.status == '') ? "" : (value.status == 1) ? "启用" :"禁用";
                    htmlStr+='<td style="white-space: nowrap;">'+statusStr+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.short_url)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.long_url)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.create_time)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;"><button class="btn btn-default" data-toggle="modal" data-id="'+value.uuid+'" data-target="#myModal">修改</button><button class="btn btn-default" data-toggle="modal" onclick="deleteSeller(\''+value.uuid+'\')">删除</button></td>';
                    htmlStr+='<tr>';
                });
                $("#sellerList").html(htmlStr);
                //分页
                page(data);
            }else{
                $("#sellerList").html('');
                $(".pagination").html('');
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
function onChangeSearchParam(key,v) {
    if (v.value == '-1'){
        $("#"+key+"").val('');
    }else {
        $("#"+key+"").val(v.value);
    }
}