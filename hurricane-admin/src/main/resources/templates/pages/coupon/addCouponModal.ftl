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
                    <label for="source">来源</label>
                    <#--<input type="text" class="form-control" id="source" name="source" placeholder="请输输入来源">-->
                    <select class="form-control">
                        <option>请选择</option>
                        <option>多麦</option>
                        <option>亿起发</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="name">商城名称</label>
                    <#--<input type="text" class="form-control" id="name" name="name" placeholder="请输入商城名称">-->
                    <select class="form-control">
                        <option>请选择</option>
                        <option>京东商城</option>
                        <option>天猫超市</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="inputfile">优惠券类型</label><span style="color: red;">(若选择密码券,请完基本信息添加后在详情页导入兑换码)</span>
                    <select class="form-control">
                        <option>请选择</option>
                        <option>密码券</option>
                        <option>链接券</option>
                        <option>通用券</option>
                    </select>
                </div>
                <#--<div class="form-group">
                    <label for="inputfile">上传EXCEL</label>
                    <input type="file" name="logoFile" id="logoFile">
                    <input type="text"  id="logoPicUrl" name="logoPicUrl">
                </div>-->
                <div class="form-group">
                    <label for="status">启用状态</label><br/>
                    <input type="radio" checked name="status"/>启用
                    <input type="radio" name="status"/>禁用
                </div>
                <div class="form-group">
                    <label for="status">是否推荐</label><br/>
                    <input type="radio" checked name="isRecom"/>推荐
                    <input type="radio" name="isRecom"/>不推荐
                </div>
                <div class="form-group">
                    <label for="siteUrl">券名称</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="券名称">
                </div>
                <div class="form-group">
                    <label for="siteUrl">减免金额</label>
                    <input type="text" class="form-control" id="derateAmount" name="derateAmount" placeholder="减免金额说明">
                </div>
                <div class="form-group">
                    <label for="siteUrl">开始时间</label>
                    <input type="text" class="form-control" id="startTime" name="startTime" placeholder="开始时间">
                </div>
                <div class="form-group">
                    <label for="siteUrl">结束时间</label>
                    <input type="text" class="form-control" id="endTime" name="endTime" placeholder="结束时间">
                </div>
                <div class="form-group">
                    <label for="siteUrl">链接URL</label>
                    <input type="text" class="form-control" id="activityLinkUrl" name="activityLinkUrl" placeholder="请输入网站链接">
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