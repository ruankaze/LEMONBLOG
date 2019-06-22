<#--
  Created by IntelliJ IDEA.
  User: NingZe
  Description: topLoadingStrip - 顶部加载条
  Date: 2019/6/1 0028
  Time: 9:13
  To change this template use File | Settings | File Templates.
-->

<script src="/js/pace.min.js"></script>
<link href="/css/pace-theme-flash.css" rel="stylesheet">
<!-- 1E92FB -->
<style>
    .pace .pace-progress {
        background: #00AEFB; /*进度条颜色*/
        height: 1px;
    }
    .pace .pace-progress-inner {
        box-shadow: 0 0 10px #00AEFB, 0 0 5px     #00AEFB; /*阴影颜色*/
    }
    .pace .pace-activity {
        border-top-color: #00AEFB;    /*上边框颜色*/
        border-left-color: #00AEFB;    /*左边框颜色*/
    }
    @media (min-width: 1200px) {
        .container {
            width: 85%;
        }
    }
    /** {*/
    /*    cursor: url('/images/nz.jpg'), default!important;*/
    /*}*/
</style>