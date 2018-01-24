$(function () {
    sellerList(1)
});

function sellerList(type) {
    $.ajax({
        type: "POST",
        async: "true",
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
