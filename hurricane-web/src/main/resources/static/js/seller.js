$(function () {
    sellerTypeList();
    sellerList(1);
});

function sellerTypeList() {
    $.ajax({
        type: "POST",
        url: "/seller/sellerTypeList",
        timeout: 6000,
        success:function (data) {
            var cList = data.map.list;
            if (data.resCode == '0000' && cList.length > 0){
                var html = '';
                for(var i=0; i<cList.length; i++){
                    html+='<div class="coupon-group">';
                    html+='<div class="coupon-info">111111</div>';
                    html+='</div>';
                }
                $("#seller-menu").html(html);
            }
        }
    });
}

function sellerList(type) {
    $.ajax({
        type: "POST",
        url: "/seller/sellerList",
        timeout: 6000,
        data: {"sellerTypeUuid":type},
        success:function (data) {
            var sList = data.map.list;
            if (data.resCode == '0000' && sList.length > 0){
                var html = '2222';
                for(var i=0; i<sList.length; i++){

                }
                $("#seller-all").html(html);
            }
        }
    });

}
