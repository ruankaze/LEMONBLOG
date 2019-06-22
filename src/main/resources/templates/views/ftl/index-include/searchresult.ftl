<#--
  Created by IntelliJ IDEA.
  User: NingZe
  Description: searchresult - 搜索结果
  Date: 2019/6/1 0028
  Time: 9:13
  To change this template use File | Settings | File Templates.
-->

<!-- 搜索结果 -->
<div class="modal fade" id="textSearch" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <!-- 弹窗位置 -->
    <div class="modal-dialog" style="position:absolute;width: 85%;">
        <section id="Search" class="price-table secPadding">
            <div class="container text-center">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="panel panel-default text-center" >
                            <div class="panel-body" style="height: 50px;">
                                <span style="font-size: 30px; color: #FFC400;">搜索结果</span>
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
                                                <a href="javascript:;" class="btn" data-toggle="modal">
                                                   正在努力发布中...
                                                </a> &nbsp;&nbsp;&nbsp;
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
        </section>
    </div>
</div>