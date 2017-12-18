<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    优惠券信息
                </h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="name">商城名称</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="请输入商城名称">
                </div>
                <div class="form-group">
                    <label for="inputfile">优惠券类型</label>
                    <input type="radio" name="type"/>链接券
                    <input type="radio" name="type"/>密码券
                </div>
                <div class="form-group">
                    <label for="inputfile">上传EXCEL</label>
                    <input type="file" name="logoFile" id="logoFile">
                    <input type="text"  id="logoPicUrl" name="logoPicUrl">
                </div>
                <div class="form-group">
                    <label for="siteUrl">网站链接</label>
                    <input type="text" class="form-control" id="siteUrl" name="siteUrl" placeholder="请输入网站链接">
                </div>
                <div class="form-group">
                    <label for="source">来源</label>
                    <input type="text" class="form-control" id="source" name="source" placeholder="请输输入来源">
                </div>
                <div class="form-group">
                    <label for="status">启用状态</label>
                    <input type="text" class="form-control" id="status" name="status" placeholder="请选择状态">
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
    function checkNotEmpty(obj) {
        if (obj == null || obj == '' || typeof(obj) == "undefined"){
            alert("不能输入空值");
            return false;
        }
        return true;
    }
</script>