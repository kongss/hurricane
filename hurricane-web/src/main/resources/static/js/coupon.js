$(function () {
    sellerList();
});

function sellerList() {
    $.ajax({
        type: "POST",
        url: "/seller/sellerList",
        timeout: 6000,
        data: {"sellerTypeUuid":""},
        success:function (data) {
            var sList = data.map.list;
            if (data.resCode == '0000' && sList.length > 0){
                var html = '';
                for(var i=0; i<sList.length; i++){
                    html+='<div class="coupon-group">';
                    html+='<div class="coupon-info">111111</div>';
                    html+='</div>';
                }
                $("#coupon-all").html(html);
            }
        }
    });
}