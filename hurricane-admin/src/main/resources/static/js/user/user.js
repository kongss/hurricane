$(function () {
    userList();
});

function userList() {
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/user/userList",
        timeout: 6000,
        data: {},
        //dataType: "json",
        success:function (data) {
            if ("0000" != data.resCode){
                alert("查询失败！！！连管理员");
                return false;
            }
            var object = data.map.userList;
            if (object.length >0){
                var htmlStr = '';
                $.each(object, function(name, value) {
                    console.log("value "+value)
                    htmlStr+='<tr>';
                    htmlStr+='<td>'+checkEmpty(value.nickname)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.gender)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.province)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.city)+'</td>';
                    htmlStr+='<tr>';
                });
                $("#userList").html(htmlStr);
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