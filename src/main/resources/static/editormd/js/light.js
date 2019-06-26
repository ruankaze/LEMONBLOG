$(function () {
    $("#test-editormd").removeAttr("class");
    let md = $("#mdeditor-textarea").text();
    $("#test-editormd").html("");
    editormd("test-editormd", {
        width: "100%",
        height: 740,
        path: '/editormd/lib/',
        syncScrolling: "single", // 异步加载
        theme: "eclipse", // 工具栏主题
        previewTheme: "eclipse", // 预览主题
        editorTheme: "eclipse", // 编辑主题
        markdown: md,
        codeFold: true,
        saveHTMLToTextarea: true, // 保存 HTML 到 Textarea
        searchReplace: true,
        htmlDecode: "style,script,iframe|on*", // 开启 HTML 标签解析，为了安全性，默认不开启
        emoji: true, // 开启表情
        taskList: true,
        watch: true, // 是否开启预览窗口
        tocm: true, // Using [TOCM]
        tex: true, // 开启科学公式TeX语言支持，默认关闭
        flowChart: true, // 开启流程图支持，默认关闭
        sequenceDiagram: true, // 开启时序/序列图支持，默认关闭,
        imageUpload: true, // 开启图片上传
        imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"], // 允许图片格式
        imageUploadURL: "/file/fileUpload", // 返回格式如：{ success : 0 | 1（0 失败，1 成功）, message : "提示的信息", url : "图片地址"}
        onload: function () {
            this.fullscreen();
        },
        toolbarIcons: function () {
            // Or return editormd.toolbarModes[name]; // full, simple, mini
            // Using "||" set icons align right.
            let toolBarIconArray = editormd.toolbarModes["full"];
            toolBarIconArray.push("download");
            toolBarIconArray.push("save");
            return toolBarIconArray;
        },
        toolbarIconsClass: {
            download: "fa-download",  // 指定一个FontAawsome的图标类
            save: "fa-save"
        },
        toolbarIconTexts: {
            download: "download",  // 如果没有图标，则可以这样直接插入内容，可以是字符串或HTML标签
            save: "save"
        },
        // 自定义工具栏按钮的事件处理
        toolbarHandlers: {
            download: function () {
                this.executePlugin("downloadDialog", "download-dialog/download-dialog");
            },
            save: function (cm, icon, cursor, selection) {
                contentCommit();//提交表单代码在下面
            }
        }
    });

    /*提交表单的js*/
    function contentCommit() {
        mdEditorForm.method = "post";
        mdEditorForm.action = "/vs/test";//提交至服务器的路径
        mdEditorForm.submit();
    }

    editormd.emoji = {
        path: "/editormd/plugins/emoji-dialog/emoji/",
        ext: ".png"
    }

});