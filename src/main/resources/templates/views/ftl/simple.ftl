<#assign contextPath = request.contextPath/>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <title>Simple example - Editor.md examples</title>
    <link rel="stylesheet" href="editormd/css/style.css"/>
    <link rel="stylesheet" href="editormd/css/editormd.css"/>
    <link rel="shortcut icon" href="icon/favicon.ico" type="image/x-icon"/>
</head>
<body>
<div id="layout">
    <header>
        <h1>Simple example</h1>
    </header>
    <form name="mdEditorForm">
        <div id="test-editormd">
            <textarea name="text" id="text" style="display:none;"> </textarea>
        </div>
    </form>
</div>
<script src="editormd/js/jquery.min.js"></script>
<script src="editormd/js/editormd.min.js"></script>
<script type="text/javascript">
    let testEditor;
    $(function () {
        testEditor = editormd("test-editormd", {
            width: "90%",
            height: 640,
            syncScrolling: "single",
            path: "${contextPath}/editormd/lib/",
            toolbarIcons : function() {
                return ["undo", "redo", "|","bold", "italic","ucwords","uppercase","lowercase","|","h1","h2","h3","h4","h5","h6","|","list-ul","list-ol","table","datetime","hr",  "||",  "watch", "fullscreen", "preview", "releaseIcon", "index"]
            },

            /*自定义功能按钮，下面我自定义了2个，一个是发布，一个是返回首页*/
            toolbarIconTexts : {
                releaseIcon : "<span bgcolor=\"gray\">发布</span>",
                index : "<span bgcolor=\"red\">返回首页</span>",
            },

            /*给自定义按钮指定回调函数*/
            toolbarHandlers:{
                releaseIcon : function(cm, icon, cursor, selection) {
                    contentCommit();//提交表单代码在下面
                },
                index : function(){
                    window.location.href = '${contextPath}/vs/index';
                },
            }
        });
        /*提交表单的js*/
        function contentCommit(){
            mdEditorForm.method = "post";
            mdEditorForm.action = "${contextPath}/vs/test";//提交至服务器的路径
            mdEditorForm.submit();
        }
    });
</script>
</body>
</html>