$(function () {
    sellerList();
});

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
            var object = data.map.sellerList;
            if (object.length >0){
                $.each(object, function(name, value) {
                    console.log("value "+value)

                });
            }
        }
    });
}