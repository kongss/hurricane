function page(data) {
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
    html+='<input id="toJumpValue" type="hidden"/>';
    html+='<input id="toJump" onkeyup="getJumpPage(this,'+pageTotal+')" value="'+currentPage+'" type="text" style="width: 36px;height: 30px;text-align: center;"/>';
    html+='&ensp;页&ensp;共&ensp;'+recordTotal+'&ensp;条&ensp;';
    html+='<button type="button" class="btn btn-default" onclick="toJumpPage('+pageSize+')">确定</button>';
    $(".pagination").html(html);
}
function getJumpPage(obj,pageTotal) {
    var currPage = obj.value;
    if (currPage < 1){
        currPage = 1;
    }
    if (currPage > pageTotal){
        currPage = pageTotal;
    }
    $("#toJumpValue").val(currPage);
}
function toJumpPage(pageSize) {
    var currPage = $("#toJumpValue").val();
    var reg = /^[1-9]\d*$/;
    if(!reg.test(currPage)){
        alert("请输入正整数");
        return false;
    }
    couponList(currPage,pageSize);
}

