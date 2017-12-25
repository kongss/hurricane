<!-- 模态框（Modal） -->
<div class="modal fade" id="couponDetailsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="margin-top: 0px;width: 100%;">
        <div class="modal-content" style="height: auto;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    优惠券详情
                </h4>
            </div>
            <div class="modal-body" style="float: left;width: 350px;">
                <div class="form-group">
                    <input type="hidden" id="sellerUuid" value=""/>
                    <label for="sellerUuid">商城名称：</label>
                    <span>京东商城</span>
                </div>
                <div class="form-group">
                    <input type="hidden" id="sellerUuid" value=""/>
                    <label for="sellerUuid">优惠券名称：</label>
                    <span>满30-10元</span>
                </div>
                <div class="form-group">
                    <input type="hidden" id="sellerUuid" value=""/>
                    <label for="sellerUuid">优惠券类型：</label>
                    <span>密码券</span>
                </div>
                <div class="form-group">
                    <input type="hidden" id="sellerUuid" value=""/>
                    <label for="sellerUuid">是否过期：</label>
                    <span>未过期</span>
                </div>
                <div class="form-group">
                    <input type="hidden" id="sellerUuid" value=""/>
                    <label for="sellerUuid">状态：</label>
                    <span>启用</span>
                </div>
                <div class="form-group">
                    <input type="hidden" id="sellerUuid" value=""/>
                    <label for="sellerUuid">是否推荐：</label>
                    <span>推荐</span>
                </div>
                <div class="form-group">
                    <input type="hidden" id="sellerUuid" value=""/>
                    <label for="sellerUuid">开始时间：</label>
                    <span>2017-12-12</span>
                </div>
                <div class="form-group">
                    <input type="hidden" id="sellerUuid" value=""/>
                    <label for="sellerUuid">结束时间：</label>
                    <span>2018-12-12</span>
                </div>
                <div class="form-group">
                    <input type="hidden" id="sellerUuid" value=""/>
                    <label>总数量：</label>
                    <span>100</span>
                </div>
                <div class="form-group">
                    <label>领取：</label><span>30</span>
                </div>
                <div class="form-group">
                    <input type="hidden" id="sellerUuid" value=""/>
                    <label>剩余：</label><span>70</span>
                </div>
                <hr>
                <div class="form-group">
                    <label>导入EXCEL：</label>
                    <input type="file" id="couponData" onchange="uploadExcel('show')"/>
                </div>
                <div>
                    <span>导入预览</span>
                    <textarea id="couponListShow" style="height: 600px;width: 310px;"></textarea>
                    <button onclick="uploadExcel('save')" >确定上传</button>
                </div>
            </div>
            <div class="" style="height: 1500px;margin-left: 350px;border-left: solid 1px #949494;">
                <div style="height: 50px">
                    <h2>兑换码列表</h2>
                </div>
                <div>
                    sldfksdflkaj lsjdf<br/>
                    alsjdflasffp weoiro<br/>
                    zxnvnaslfjff qwoipo<br/>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script type="text/javascript">
    function uploadExcel(flag) {
        var formData = new FormData();
        formData.append("file",$("#couponData")[0].files[0]);
        formData.append("flag",flag);
        $.ajax({
            url : 'admin/coupon/analysisExcel',
            type : 'POST',
            data : formData,
            // 告诉jQuery不要去处理发送的数据
            processData : false,
            // 告诉jQuery不要去设置Content-Type请求头
            contentType : false,
            //dataType : 'json',
            success : function(data) {
                console.log("data="+data)
                $("#couponListShow").html(data.map.cv);
            },
            error : function(data) {
                console.log("error "+data);
            }
        });
    }
</script>
