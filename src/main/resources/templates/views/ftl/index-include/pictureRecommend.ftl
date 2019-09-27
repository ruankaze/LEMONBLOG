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
                                    <a class="overlay" data-toggle="modal" data-target="#project-${pis.key}">
                                        <i class="fa fa-search-plus"></i>
                                        <span>${pis.name} ${pis.key}</span>
                                    </a>
                                </div>
                                <a class="btn btn-default btn-block" data-toggle="modal" data-target="#project-${pis.key}">${pis.title} ${pis.key}</a>
                            </div>
                        </div>
                        <!-- Item end -->

                        <!-- Modal -->
                        <div class="modal fade" id="project-${pis.key}" tabindex="-1" role="dialog" aria-labelledby="project-${pis.key}-label" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">
                                            <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                                        </button>
                                        <h4 class="modal-title" id="project-${pis.key}-label">${pis.modeltitle} ${pis.key}</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <img src="/images/portfolio-${pis.key}.jpg" alt="">
                                                <br/>
                                                <h3>Project Description ${pis.key}</h3>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque sed,
                                                    quidem quis praesentium, ut unde. Quae sed, incidunt laudantium
                                                    nesciunt,
                                                    optio corporis quod earum pariatur omnis illo saepe numquam
                                                    suscipit,
                                                    nemo placeat dignissimos eius mollitia et quas officia doloremque
                                                    ipsum labore rem deserunt.
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">
                                            Close
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Modal end -->
                    </#list>

                </div>
                <!-- portfolio items end -->

            </div>
        </div>
    </div>
</section>
<!-- section end -->
