<#--
  Created by IntelliJ IDEA.
  User: NingZe
  Description: title - 文章
  Date: 2019/6/1 0028
  Time: 9:13
  To change this template use File | Settings | File Templates.
-->

<!-- section start -->
<section class="price-table secPadding">
    <div class="container text-center">
        <div class="heading">
            <h1 class="text-center title" id="article">Article</h1>
            <div class="separator"></div>
            <p class="lead text-center">Lorem ipsum dolor sit amet laudantium incidunt ut laboriosam.</p>
            <br>
        </div>

        <div class="row">
            <#list ['最热下载', '最近更新', '推荐下载'] as li>
                <div class="col-sm-4">
                    <div class="panel panel-default text-center">
                        <div class="panel-body" style="height: 50px;">
                            <span style="font-size: 30px;color: #FFC400;">${li}</span>
                            <!-- <span style="position: absolute;top: 5px;right: 5px;left: 260px;font-size: 10px;">
                                <a href="javascript:;" class="btn" style="color: red;">更多</a>
                            </span> -->
                        </div>
                        <div class="panel-body">
                            <!-- <h3 class="panel-title price">$9<span class="price-cents">99</span><span class="price-month">mo.</span></h3> -->
                        </div>
                        <ul class="list-group">
                            <#list 1..5 as i>
                                <li class="list-group-item" >
                                    <!-- 此A标签限制只能显示18字节 -->
                                    <a href="javascript:;" class="btn" data-toggle="modal" >
                                        正在努力发布中...
                                    </a>&nbsp;&nbsp;&nbsp;
                                    <span style="color:#8C8C8C;font-size: 12px;">06-14</span>
                                </li>
                            </#list>
                        </ul>
                    </div>
                </div>
            </#list>
        </div>

    </div>
</section>