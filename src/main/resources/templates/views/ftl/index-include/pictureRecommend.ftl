<#--
  Created by IntelliJ IDEA.
  User: NingZe
  Description: pictureRecommend - 图片推荐
  Date: 2019/6/1 0028
  Time: 9:13
  To change this template use File | Settings | File Templates.
-->

<!-- section start -->
<section class="section secPadding">
    <div class="container">
        <h1 class="text-center title" id="picture">Picture</h1>
        <div class="separator"></div>
        <p class="lead text-center">Lorem ipsum dolor sit amet laudantium molestias simi Quisquam incidunt.</p>
        <br>
        <div class="row no-view" data-animation-effect="fadeIn">

            <div class="col-md-12">
                <!-- isotope filters start -->
                <div class="filters text-center">
                    <ul class="nav nav-pills">
                        <li class="active"><a href="#" data-filter="*">All</a></li>
                        <#list Application.picrecInfo.picrecheads as phs>
                            <li><a href="${phs.href}" data-filter="${phs.filter}">${phs.text}</a></li>
                        </#list>
                    </ul>
                </div>
                <!-- isotope filters end -->

                <!-- portfolio items start -->
                <div class="isotope-container row grid-space-20">

                    <#list Application.picrecInfo.picrecinfos as pis>
                        <!-- Item -->
                        <div class="col-sm-6 col-md-3 isotope-item ${pis.code}">
                            <div class="image-box">
                                <div class="overlay-container">
                                    <img src="/images/portfolio-${pis.key}.jpg" alt="">
                                    <a href="/images/portfolio-${pis.key}.jpg" download="${pis.key}" class="overlay" data-target="#project-${pis.key}">
                                        <i class="fa fa-search-plus"></i>
                                        <span>${pis.name} ${pis.key}</span>
                                    </a>
                                </div>
                                <a class="btn btn-default btn-block" data-target="#project-${pis.key}">${pis.title} ${pis.key}</a>
                            </div>
                        </div>
                        <!-- Item end -->
                    </#list>

                </div>
                <!-- portfolio items end -->

            </div>
        </div>
    </div>
</section>
<!-- section end -->
