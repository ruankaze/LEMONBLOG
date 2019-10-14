<#--
  Created by IntelliJ IDEA.
  User: NingZe
  Description: l2dwidget - 2D模型
  Date: 2019/6/1 0028
  Time: 9:13
  To change this template use File | Settings | File Templates.
-->

<div id="live2d-widget">
    <canvas id="live2dcanvas"></canvas>
</div>

<script type="text/javascript" src="/live2dw/lib/L2Dwidget.min.js"></script>

<script  type="text/javascript">

    let modelNames = ['haruto', 'koharu'];
    let name = modelNames[1];
    let isMobile = false; // 是否在手机显示
    if (!isMobile) { // 手机不显示就隐藏div
        document.getElementById("live2d-widget").style.display = "none";
    }

    L2Dwidget.init({
        pluginRootPath: "live2dw/", // 资源root路径
        pluginJsPath: "lib/", // js相对root的路径
        pluginModelPath: "/" + name + "", // 模型相对root的路径
        tagMode: !1,
        debug: !1,
        model: {
            scale: 2,
            jsonPath: "/live2dw/" + name + "/" + name + ".model.json"
        },
        display: { // 大小位置什么的自己慢慢调就是了
            position: "right",//定位
            width: 90, // 实际宽度X2
            height: 150, // 实际宽度X2
            // hOffset: -10, // right
            // vOffset: -30// bottom
            hOffset: 30, // right
            vOffset: 0 // bottom
        },
        mobile: {
            show: isMobile ? 1 : !1 // 是否在手机显示
        },
        log: !1
    });

    // !1 - false , 1 - true

</script>