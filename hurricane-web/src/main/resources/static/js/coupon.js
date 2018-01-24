$(function () {
    couponList();
});

function couponList() {
    $.ajax({
        type: "POST",
        url: "/coupon/couponList",
        timeout: 6000,
        data: {"currentPage":1,"pageSize":8},
        success:function (data) {
            var cList = data.map.list;
            if (data.resCode == '0000' && cList.length > 0){
                var html = '';
                for(var i=0; i<cList.length; i++){
                    html+='<div class="coupon-group">';
                    html+='<div class="coupon-info">111111</div>';
                    html+='</div>';
                }
                $("#coupon-all").html(html);
            }
        }
    });
}