$(function () {
    couponList(1,10);
    $("#toJump").bind("input propertychange change",function(event){
        console.log("值："+$(this).val());
        $("#toJumpValue").val($(this).val());
    });
});

function couponList(currentPage,pageSize,couponList) {
    //console.log("currentPage="+currentPage+" pageSize="+pageSize);
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/coupon/couponList",
        timeout: 6000,
        data: {"currentPage":currentPage,"pageSize":pageSize},
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
                    htmlStr+='<td>'+checkEmpty(value.seller_uuid)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.name)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.derate_amount)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.start_time)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.end_time)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.activity_link_url)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.type)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.is_overdue)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.is_recom)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.total)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.receive_num)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.unreceive_num)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.create_time)+'</td>';
                    htmlStr+='<td><a href="">详情</a></td>';
                    htmlStr+='<tr>';
                });
                $("#couponList").html(htmlStr);
                //分页
                var currentPage = data.map.currentPage;
                var previousPage = data.map.previousPage;
                var nextPage = data.map.nextPage;
                var firstPage = data.map.firstPage;
                var lastPage = data.map.lastPage;
                var pageTotal = data.map.pageTotal;
                var pageSize = data.map.pageSize;
                var recordTotal = data.map.recordTotal;
                var html = '';
                html+='<li><a href="#" onclick="couponList('+firstPage+','+pageSize+',couponList)">&laquo;</a></li>';
                html+='<li><a href="#" onclick="couponList('+previousPage+','+pageSize+',couponList)">&lsaquo;</a></li>';
                if(pageTotal == 1){
                    html+='<li class="active"><a href="#" onclick="couponList('+firstPage+','+pageSize+',couponList)">1</a></li>';
                }
                if(pageTotal > 1 && pageTotal < 5){
                    for(var i=1;i<=pageTotal;i++){
                        if (i == currentPage){
                            html+='<li class="active"><a href="#" onclick="couponList('+i+','+pageSize+',couponList)">'+i+'</a></li>';
                        }else{
                            html+='<li><a href="#" onclick="couponList('+i+','+pageSize+',couponList)">'+i+'</a></li>';
                        }
                    }
                }
                if(pageTotal >= 5){
                    if (currentPage > 2){
                        for(var i=(currentPage-2);i<=(currentPage+2);i++){
                            if (i == currentPage){
                                html+='<li class="active"><a href="#" onclick="couponList('+i+','+pageSize+',couponList)">'+i+'</a></li>';
                            }else{
                                html+='<li><a href="#" onclick="couponList('+i+','+pageSize+',couponList)">'+i+'</a></li>';
                            }
                        }
                    }else {
                        for(var i=1;i<=5;i++){
                            if (i == currentPage){
                                html+='<li class="active"><a href="#" onclick="couponList('+i+','+pageSize+',couponList)">'+i+'</a></li>';
                            }else{
                                html+='<li><a href="#" onclick="couponList('+i+','+pageSize+',couponList)">'+i+'</a></li>';
                            }
                        }
                    }
                }
                html+='<li><a href="#" onclick="couponList('+nextPage+','+pageSize+',couponList)">&rsaquo;</a></li>';
                html+='<li><a href="#" onclick="couponList('+lastPage+','+pageSize+',couponList)">&raquo;</a></li>';
                html+='&ensp;跳转到&ensp;';
                html+='<input id="toJumpValue" type="hidden" value=""/>';
                html+='<input id="toJump" type="text" style="width: 36px;height: 30px;text-align: center;"/>';
                html+='&ensp;页&ensp;共&ensp;'+recordTotal+'&ensp;条&ensp;';
                html+='<button type="button" class="btn btn-default" onclick="toJumpPage('+pageSize+')">确定</button>';
                $(".pagination").html(html);
            }
        }
    });
}
function toJumpPage(pageSize) {
    var currPage = $("#toJumpValue").val();
    couponList(currPage,pageSize);
}
function checkEmpty(param) {
    if (param == null || param == '' || param == 'undefined'){
        return '';
    }
    return param;
}