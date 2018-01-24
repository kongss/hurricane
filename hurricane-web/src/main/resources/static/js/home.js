$(function () {
    sellerList(1);
    couponRecomList();
    sellerRecomList();
});

function sellerList(type) {
    $.ajax({
        type: "POST",
        url: "/seller/sellerList",
        timeout: 6000,
        data: {"sellerTypeUuid":type},
        success:function (data) {
            var sList = data.map.list;
            if (data.resCode == '0000' && sList.length > 0){
                var html = '';
                for(var i=0; i<sList.length; i++){
                    html+='<li class="seller-li"><img class="seller-pic" src="'+sList[i].logo_pic_url+'"></li>';
                }
                $("#pic-list").html(html);
            }
        }
    });

}
function couponRecomList() {
    $.ajax({
        type: "POST",
        url: "/coupon/couponRecomList",
        timeout: 6000,
        data: {"limitStart":0,"limitSize":5},
        success:function (data) {
            var cList = data.map.list;
            if (data.resCode == '0000' && cList.length > 0){
                var html = '';
                for(var i=0; i<cList.length; i++){
                    html+='<div class="coupon-group">';
                    html+='<div class="coupon-d sInfo">';
                    html+='<img style="height: 60px;width: 160px;" src="/doc/img/iq-logo.png">';
                    html+='<p style="font-size: 18px">金融理财</p>';
                    html+='</div>';
                    html+='<div class="coupon-d cInfo">';
                    html+='<span style="font-size: 50px">80</span><br>';
                    html+='<span>满600可用</span><br>';
                    html+='<span>2017-12至2018-12</span>';
                    html+='</div>';
                    html+='<div class="coupon-d cAction">';
                    html+='<span class="get-span">领<br>取</span>';
                    html+='</div>';
                    html+='</div>';
                }
                $("#c-list").html(html);
            }
        }
    });
}

function sellerRecomList() {
    $.ajax({
        type: "POST",
        url: "/seller/sellerRecomList",
        timeout: 6000,
        data: {"limitStart":0,"limitSize":5},
        success:function (data) {
            var sList = data.map.list;
            if (data.resCode == '0000' && sList.length > 0){
                var html = '';
                for(var i=0; i<sList.length; i++){
                    html+='<li class="recommend-group"><img style="height: 60px;width: 160px;" src="/doc/img/iq-logo.png"></li>';
                }
                $("#s-r-list").html(html);
            }
        }
    });
}
