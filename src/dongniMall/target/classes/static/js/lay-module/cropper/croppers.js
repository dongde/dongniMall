/*!
 * Cropper v3.0.0
 */

layui.define(['jquery', 'layer', 'cropper'], function (exports) {
    var $ = layui.jquery
        , layer = layui.layer
        , cropper = layui.cropper;
    var html = "<link rel=\"stylesheet\" href=\"../js/lay-module/cropper/cropper.css\">\n" +
        "<div class=\"layui-fluid showImgEdit\" style=\"display: none;\padding:30px;\">\n" +
        "    <div class=\"layui-form-item\">\n" +
        "        <div class=\"layui-input-inline layui-btn-container\" style=\"width: auto;\">\n" +
        "            <label for=\"cropper_avatarImgUpload\" class=\"layui-btn layui-btn-primary\">\n" +
        "                <i class=\"layui-icon\">&#xe67c;</i>选择图片\n" +
        "            </label>\n" +
        "            <input class=\"layui-upload-file\" id=\"cropper_avatarImgUpload\" type=\"file\" value=\"选择图片\" name=\"file\">\n" +
        "        </div>\n" +
        "        <div class=\"layui-form-mid layui-word-aux\">请上传图片进行头像截取，完成后保存修改即可</div>\n" +
        "    </div>\n" +
        "    <div class='imageContainer' hidden>\n" +
        "    <div class=\"layui-row layui-col-space15\">\n" +
        "        <div >\n" +
        "            <div class=\"readyimg\" style=\"height:200px;background-color: rgb(247, 247, 247);\">\n" +
        "                <img src=\"\" >\n" +
        "            </div>\n" +
        "        </div>\n" +
        "    </div>\n" +
        "    <div class=\"layui-row layui-col-space15\">\n" +
        "            <div class=\"layui-row\">\n" +
        "                <div class=\"layui-col-xs9\">\n" +
        "                    <button type=\"button\" class=\"layui-btn layui-icon layui-icon-left\" cropper-event=\"rotate\" data-option=\"-15\" title=\"Rotate -90 degrees\"> 向左旋转</button>\n" +
        "                    <button type=\"button\" class=\"layui-btn layui-icon layui-icon-right\" cropper-event=\"rotate\" data-option=\"15\" title=\"Rotate 90 degrees\"> 向右旋转</button>\n" +
        "                </div>\n" +
        "                <div class=\"layui-col-xs3\" style=\"text-align: right;\">\n" +
        "                    <button type=\"button\" class=\"layui-btn layui-icon layui-icon-refresh\" cropper-event=\"reset\" title=\"重置图片\">&nbsp;复位</button>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "    </div>\n" +
        "</div>\n" +
        "   <div class=\"layui-form-item\" style='margin-top: 30px'>\n" +
        "        <label class=\"layui-form-label\">链接地址：</label>\n" +
        "        <div class=\"layui-input-block\">\n" +
        "            <input type=\"text\" id=\"url\" lay-verify=\"url\" autocomplete=\"off\" placeholder=\"url\"\n" +
        "                   class=\"layui-input\">\n" +
        "        </div>\n" +
        "    </div>\n" +
        "    <div class=\"layui-form-item distance\">\n" +
        "        <div class=\"layui-input-block\">\n" +
        "            <button class=\"layui-btn\" type=\"submit\"cropper-event=\"confirmSave\" lay-submit=\"\" lay-filter=\"demo1\" cropper-event=\"confirmSave\"\n" +
        "                    id=\"upload\">立即上传\n" +
        "            </button>\n" +
        "            <button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\n" +
        "        </div>\n" +
        "    </div>\n" +
        "</div>";
    var obj = {
        render: function (e) {
            $('body').append(html);
            console.log("执行");
            var self = this,
                elem = e.elem,
                saveW = e.saveW,
                saveH = e.saveH,
                mark = e.mark,
                area = e.area,
                url = e.url,
                done = e.done;

            var content = $('.showImgEdit')
                , image = $(".showImgEdit .readyimg img")
                , urlInput = $("#url")
                , file = $(".showImgEdit input[name='file']")
                , options = {aspectRatio: mark, viewMode: 1, responsive: false};


            if (image.hasClass('cropper-hidden')){
                image.cropper("destroy");
            }

            $(elem).on('click', function () {
                layer.open({
                    type: 1
                    , title: '上传轮播图'
                    , shadeClose: true
                    , shade: 0.8
                    , content: content
                    , area: area
                    , offset: '50px'
                    , success: function () {
                        // image.cropper('destroy');
                    }
                    , cancel: function (index) {
                        $(".imageContainer").attr("hidden", "hidden");

                        $('.showImgEdit').remove();
                        // image.attr('src', "");
                        layer.close(index);
                        image.cropper('destroy');
                    }
                });
            });
            $(".layui-btn").on('click', function () {
                var event = $(this).attr("cropper-event");
                //监听确认保存图像
                if (event === 'confirmSave') {
                    if (image.attr("src") != null && image.attr("src") != "") {
                        console.log(urlInput.val());
                        if (urlInput.val() != null) {
                            image.cropper("getCroppedCanvas", {
                                width: saveW,
                                height: saveH
                            }).toBlob(function (blob) {
                                var formData = new FormData();
                                formData.append('file', blob, "banner.jpg");
                                formData.append('url', urlInput.val());
                                $.ajax({
                                    method: "post",
                                    url: url, //用于文件上传的服务器端请求地址
                                    data: formData,
                                    processData: false,
                                    contentType: false,
                                    success: function (res) {
                                        done();
                                        // $(".imageContainer").attr("hidden", "hidden");
                                        image.attr('src', "");
                                        if (res.status === 200) {
                                            //如果上传失败
                                            if (res.code > 0) {
                                                layer.msg('上传失败');
                                            } else {
                                                layer.closeAll('page'); //关闭所有页面层
                                                layer.msg("上传成功");
                                            }

                                        } else if (res.status === 500) {
                                            layer.msg(res.msg)
                                        }
                                    }
                                    , error: function (res) {
                                        layer.msg(res.msg);
                                    }
                                });
                            });
                        } else {
                            layer.msg("url不能为空");
                        }
                    } else {
                        layer.msg("请选择上传图片");
                    }
                    //监听旋转
                } else if (event === 'rotate') {
                    var option = $(this).attr('data-option');
                    image.cropper('rotate', option);
                    //重设图片
                } else if (event === 'reset') {
                    image.cropper('reset');
                }
                //文件选择
                file.change(function () {
                    var r = new FileReader();
                    var f = this.files[0];
                    r.readAsDataURL(f);
                    r.onload = function (e) {
                        console.log(e);
                        $(".imageContainer").removeAttr("hidden");
                        image.attr('src', r.result).cropper(options);
                    };
                });
            });
        }

    };
    exports('croppers', obj);
});