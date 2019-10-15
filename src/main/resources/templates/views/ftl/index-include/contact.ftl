<#--
  Created by IntelliJ IDEA.
  User: NingZe
  Description: contact - 联系
  Date: 2019/6/1 0028
  Time: 9:13
  To change this template use File | Settings | File Templates.
-->

<!-- footer start -->
<footer id="footer">

    <!-- .footer start -->
    <div class="footer section">
        <div class="container">
            <h1 class="title text-center" id="contact">Contact Lin Ze</h1>
            <div class="space"></div>
            <div class="row">

                <div class="col-sm-6">
                    <div class="footer-content">
                        <form method="POST" role="form" id="footer-form" action="contactengine.php" onSubmit="alert('Thank you for your feedback!');">
                            <div class="form-group has-feedback">
                                <label class="sr-only" for="name2">Name</label>
                                <input type="text" name="Name" id="Name" class="form-control wow fadeInUp" placeholder="Enter Name"required/>
                                <i class="fa fa-user form-control-feedback"></i>
                            </div>
                            <div class="form-group has-feedback">
                                <label class="sr-only" for="email2">Email address</label>
                                <input type="text" name="Name" id="Name" class="form-control wow fadeInUp" placeholder="Enter Email" required/>
                                <i class="fa fa-envelope form-control-feedback"></i>
                            </div>
                            <div class="form-group has-feedback">
                                <label class="sr-only" for="message2">Message</label>
                                <textarea name="Message" rows="8" cols="20" id="Message" class="form-control input-message wow fadeInUp"  placeholder="Message" required></textarea>
                                <i class="fa fa-pencil form-control-feedback"></i>
                            </div>
                            <input type="submit" value="Send" class="btn btn-default">
                        </form>

                    </div>
                </div>

                <div class="col-sm-6">
                    <div class="footer-content">

                        <div class="widget-content">

                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel nam magnam natus tempora cumque, aliquam deleniti voluptatibus voluptas. Maecenas ultrices finibus erat sit amet auctor. Curabitur et metus laoreet, fermentum quam sagittis, cursus augue. </p><br/>

                            <p class="contacts"><i class="fa fa-map-marker"></i> 1508 Kembery Drive, Chicago, IL 60605 </p>

                            <p class="contacts"><i class="fa fa-phone"></i> 202-314-1583</p>

                            <p class="contacts"><i class="fa fa-envelope"></i> 2226205749@qq.com</p>

                        </div>

                        </aside>
                        <ul class="social-links">
                            <li class="facebook"><a target="_blank" href="#"><i class="fa fa-facebook"></i></a></li>
                            <li class="twitter"><a target="_blank" href="#"><i class="fa fa-twitter"></i></a></li>
                            <li class="googleplus"><a target="_blank" href="#"><i class="fa fa-google-plus"></i></a></li>
                            <li class="skype"><a target="_blank" href="#"><i class="fa fa-skype"></i></a></li>
                            <li class="linkedin"><a target="_blank" href="#"><i class="fa fa-linkedin"></i></a></li>
                            <li class="youtube"><a target="_blank" href="#"><i class="fa fa-youtube"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- .footer end -->

</footer>
<!-- footer end -->