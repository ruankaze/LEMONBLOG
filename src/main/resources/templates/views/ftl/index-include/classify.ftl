<#--
  Created by IntelliJ IDEA.
  User: NingZe
  Description: classify - 文章分类
  Date: 2019/6/1 0028
  Time: 9:13
  To change this template use File | Settings | File Templates.
-->

<!-- 分类区域 start -->
<section class="section transprant-bg pclear secPadding">
    <div class="container no-view" data-animation-effect="fadeIn">
        <h1 id="sort" class="title text-center">Classify</h1>
        <div class="separator"></div>
        <p class="lead text-center">Lorem ipsum dolor sit amet laudantium incidunt ut laboriosam.</p>
        <br>

        <div><br/></div>

        <#list ['linux', 'windows', 'mac', 'bootstrap', 'layui', 'js', 'html5', 'css3', 'ps', 'java', 'python'] as arr>
            <a href="javascript" onclick="collapseOneContent(this);" data-toggle="collapse" style="color: #836FFF;margin-left: 5%;font-size: 15px;text-decoration: none;">${arr}</a>
        </#list>

        <div><br/></div>

        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingOne">
                <h4 class="panel-title">
                    <a id="collapseOneContent1" style="height: 40px;" data-toggle="collapse" aria-expanded="true" data-parent="#accordion" href="#collapseOne" aria-controls="collapseOne">

                    </a>
                </h4>
            </div>

            <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                <div class="col-sm-12" style="margin-top: 10px;">
                    <div class="panel panel-default text-center" >
                        <div class="panel-body" style="height: 50px;">
                            <span style="font-size: 30px; color: #FFC400;">分类结果</span>
                        </div>
                        <div class="panel-body">
                            <!-- <h3 class="panel-title price">$19<span class="price-cents">99</span><span class="price-month">mo.</span></h3> -->
                        </div>
                        <ul class="list-group">
                            <#list 1..5 as i>
                                <li class="list-group-item" style="height: 70px;">
                                    <!-- 此A标签限制只能显示18字节 -->
                                    <#list [[10, 65], [40, 35], [70, 5]] as le>
                                        <span style="position: absolute;left: ${le[0]}%;">
                                            <a href="javascript:;" style="color: #7A67EE;" class="btn">
                                               正在努力发布中...
                                            </a>
                                            <span style="color: #8C8C8C; font-size: 12px;"> 06-14 </span>
                                        </span>
                                    </#list>
                                </li>
                            </#list>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>