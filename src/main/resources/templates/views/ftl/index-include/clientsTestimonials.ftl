<#--
  Created by IntelliJ IDEA.
  User: NingZe
  Description: clientsTestimonials - 顾客感言
  Date: 2019/6/1 0028
  Time: 9:13
  To change this template use File | Settings | File Templates.
-->

<section class="default-bg secPadding">

    <div class="container">
        <div class="row">
            <div class="col-md-offset-2 col-md-8 text-center">
                <h2>Clients Testimonials</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-offset-2 col-md-8">
                <div class="carousel slide" data-ride="carousel" id="quote-carousel">
                    <!-- Bottom Carousel Indicators -->
                    <ol class="carousel-indicators">
                        <#list [[0, 'active'], [1, ''], [2, '']] as arr>
                            <li data-target="#quote-carousel" data-slide-to="${arr[0]}" class="${arr[1]}"></li>
                        </#list>
                    </ol>

                    <!-- Carousel Slides / Quotes -->
                    <div class="carousel-inner">
                        <#list [[0, 'active'], [1, ''], [2, '']] as arr>
                            <div class="item ${arr[1]}">
                                <blockquote>
                                    <div class="row">
                                        <div class="col-sm-3 text-center">
                                            <img class="img-circle" src="/images/nz.jpg" style="width: 100px;height:100px;">
                                        </div>
                                        <div class="col-sm-9">
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut rutrum elit in arcu blandit, eget pretium nisl accumsan. Sed ultricies commodo tortor, eu pretium mauris.</p>
                                            <small>Someone famous <sm style="color: #ff7d49;">${arr[0] + 1}</sm></small>
                                        </div>
                                    </div>
                                </blockquote>
                            </div>
                        </#list>
                    </div>

                </div>
            </div>
        </div>
    </div>

</section>