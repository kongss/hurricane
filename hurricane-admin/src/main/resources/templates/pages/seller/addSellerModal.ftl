<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    商城信息
                </h4>
            </div>
            <div class="modal-body">
                <input type="hidden" id="uuid" name="uuid" value=""/>
                <div class="form-group">
                    <label for="name">商城名称</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="请输入商城名称">
                </div>
                <div class="form-group">
                    <label for="name">来源</label>
                    <input type="hidden" id="source" value="1"/>
                    <select class="form-control" id="sellerSource" onchange="changeSource(this.value)">
                        <option value="0">请选择</option>
                        <option value="1">多麦</option>
                        <option value="2">亿起发</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="inputfile">商城LOGO上传</label>
                    <input type="file" name="logoFile" id="logoFile" onchange="uploadLogo()">
                    <textarea readonly="readonly" id="logoPicUrl" name="logoPicUrl" style="height: 90px;width: 570px;"></textarea>
                </div>
                <div class="form-group">
                    <label for="siteUrl">网站链接</label>
                    <input type="text" class="form-control" id="siteUrl" name="siteUrl" placeholder="请输入网站链接">
                </div>
                <div class="form-group" id="status_div">
                    <label for="status">启用状态</label><br/>
                    <input type="hidden" id="status" value="1"/>
                    <input type="radio" checked onclick="changeStatus(1)" name="status"/>启用
                    <input type="radio" onclick="changeStatus(0)" name="status"/>禁用
                </div>
                <div class="form-group">
                    <label for="shortUrl">短链接</label>
                    <input type="text" class="form-control" id="shortUrl" name="shortUrl" placeholder="请输入短链接">
                </div>
                <div class="form-group">
                    <label for="longUrl">长链接</label>
                    <input type="text" class="form-control" id="longUrl" name="longUrl" placeholder="请输入长链接">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="saveSeller()">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script type="text/javascript">
    function changeStatus(statusValue) {
        $("#status").val(statusValue);
    }
    function changeSource(thisObj) {
        console.log(thisObj);
        $("#source").val(thisObj);
    }

    function uploadLogo() {
        var formData = new FormData();
        formData.append("file",$("#logoFile")[0].files[0]);
        $.ajax({
            url : '/admin/seller/uploadLogo',
            type : 'POST',
            data : formData,
            // 告诉jQuery不要去处理发送的数据
            processData : false,
            // 告诉jQuery不要去设置Content-Type请求头
            contentType : false,
            //dataType : 'json',
            success : function(data) {
                console.log("data="+data)
                $("#logoPicUrl").val(data.map.url);
            },
            error : function(data) {
                console.log("error "+data);
            }
        });
    }

    function saveSeller() {
        var name = $("#name").val();
        var logoPicUrl = $("#logoPicUrl").val();
        var siteUrl = $("#siteUrl").val();
        var source = $("#source").val();
        var status = $("#status").val();
        var shortUrl = $("#shortUrl").val();
        var longUrl = $("#longUrl").val();
        console.log("添加信息："+name+" "+logoPicUrl+" "+siteUrl+" "+source+" "+status+" "+shortUrl+" "+longUrl);
        if (checkNotEmpty(name) && checkNotEmpty(longUrl) && checkNotEmpty(logoPicUrl) && checkNotEmpty(siteUrl) &&
                checkNotEmpty(source) && checkNotEmpty(status) && checkNotEmpty(shortUrl)){
            //发生ajax保存数据
            $.ajax({
                type: 'POST',
                url: "/admin/seller/editSeller",
                data: {"name": name, "longUrl": longUrl, "logoPicUrl": logoPicUrl, "siteUrl": siteUrl, "source": source, "status": status, "shortUrl": shortUrl },
                dataType: "json",
                success: function(data){
                    console.log(data);
                    if ("0000" != data.resCode){
                        alert("添加商城信息异常！！！联系管理员");
                        return false;
                    }
                    window.location.reload();
                }
            });
        }else {
            alert("选项都不能为空");
            return false;
        }
    }
    function checkNotEmpty(obj) {
        if (obj == null || obj == '' || typeof(obj) == "undefined"){
            alert("不能输入空值");
            return false;
        }
        return true;
    }
</script>