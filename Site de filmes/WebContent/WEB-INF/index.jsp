<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

	<link rel="icon" href="images/Videos-icon.png">    
	<title>KuTube</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">

    <!-- Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


    <!-- Custom Theme CSS -->
    <link href="css/style.css" rel="stylesheet">
   
    <!-- Advanced CSS -->
    <link href="css/animate.css" rel="stylesheet">
	<link href="js/lib/owl-carousel/owl.carousel.css" rel="stylesheet">
	<link href="js/lib/owl-carousel/owl.theme.css" rel="stylesheet">
	<link href="js/lib/owl-carousel/owl.transitions.css" rel="stylesheet">
	<link href="js/lib/magnific-popup/magnific-popup.css" rel="stylesheet">
    <link href="js/lib/video/YTPlayer.css" rel="stylesheet">
    
</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-custom">

	<!-- Navigation -->
    <nav class="navbar navbar-custom navbar-fixed-top wp1" role="navigation">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="#page-top">
                    <i class="fa fa-video-camera"></i><span class="font-light" style=" background-color: red;"> Ku</span>Tube
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="#about">Sobre</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#movies">Filmes</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#contact">Contato</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

   
    <!-- Intro Section -->
    <section id="intro">
    <div class="video-content">  
    <div class="video-image wp1 delay-1s">
    	<img src="img/video-img.jpg" alt="">
    </div>
    
    <div class="overlay">

        <div class="container-wrapper">
           <div class="container">
            <div class="col-md-12 wp1 delay-05s">
            
            <div class="intro-info-wrapper">
            <h1 class="text-center">VINGADORES <span class="text-color font-light">2</span></h1>
                <div id="owl-intro" class="owl-carousel owl-theme">
                    
                    <div class="item">
                       <p class="font-similar">Os super-heróis Capitão América, Homem de Ferro, Thor, Hulk, Viúva Negra e Gavião Arqueiro retornam mais uma vez para proteger o planeta, 
                       após o projeto de Tony Stark dar errado, gerando o nascimento de <b>Ultron</b> </p>
                    </div>
                </div>
            </div>
        	</div>
			</div><!-- /.intro-info-wrapper -->

            <div class="media-btns buttons page-scroll">
                <div class="btn btn-default play-btn" id="play-button">Assistir Filme<i class="fa fa-play animated"></i></div>
                <div class="btn btn-default pause-btn" id="pause-button">Parar Filme<i class="fa fa-pause animated"></i></div>
            </div>

        </div>
		</div>
       

        <div class="video-container">
            <div id="player"></div>
        </div>
        </div>

    </section><!-- /#intro --> 

  <!-- About Section -->
    <section id="about">
            <div class="more page-scroll" id="more">
            <a href="#about"><i class="fa fa-angle-down"></i></a>
            </div>
            
    <div class="container wp2">
    <h1 class="section-title">Sobre</h1>
 
	        
        <div class="container">
        <div class="col-md-4 advantages-item wp7 delay-05s">
            <div class="advantages-item-icon"><i class="fa fa-star-o"></i></div>
            <h3>Conteúdo Exclusivo</h3>
            <p>
            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
            </p> 
  		</div><!-- /.col-md-4 -->        
        
        <div class="col-md-4 advantages-item wp7">
            <div class="advantages-item-icon"><i class="glyphicon glyphicon-film"></i></div>
            <h3>Filmes em HD</h3>
            <p>
            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. <span class="text-light"><i class="fa fa-user"></i>- 2062 Actors. </span> Aenean commodo ligula eget dolor. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
            </p> 
  		</div><!-- /.col-md-4 -->   
        
        <div class="col-md-4 advantages-item wp7 delay-05s">
            <div class="advantages-item-icon"><i class="fa fa-thumbs-o-up"></i></div>
            <h3>Rápido e Fácil</h3>
            <p>
            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
            </p> 
  		</div><!-- /.col-md-4 -->            
    	</div><!-- /.row -->
    </div><!-- /.container --> 
    </section><!-- /#about -->     
          
    
    
    <!-- Gallery Section -->
    <section id="movies">
 	<div class="overlay"></div>
    
    <div class="section-wrapper wp8 delay-05s">
    <h1 class="section-title">Filmes</h1>
            <div id="owl-gallery">
                  
				<div class="item"><a href="img/gallery/01.jpg" class="popup"><img src="img/gallery/01.jpg" alt=""></a></div>
				<div class="item"><a href="img/gallery/02.jpg" class="popup"><img src="img/gallery/02.jpg" alt=""></a></div>
				<div class="item"><a href="img/gallery/03.jpg" class="popup"><img src="img/gallery/03.jpg" alt=""></a></div>
                <div class="item"><a href="img/gallery/04.jpg" class="popup"><img src="img/gallery/04.jpg" alt=""></a></div>
                <div class="item"><a href="img/gallery/05.jpg" class="popup"><img src="img/gallery/05.jpg" alt=""></a></div>
                <div class="item"><a href="img/gallery/06.jpg" class="popup"><img src="img/gallery/06.jpg" alt=""></a></div>
                <div class="item"><a href="img/gallery/07.jpg" class="popup"><img src="img/gallery/07.jpg" alt=""></a></div>
                <div class="item"><a href="img/gallery/08.jpg" class="popup"><img src="img/gallery/08.jpg" alt=""></a></div>
          
            </div><!-- /#owl-gallery -->  
    </div>
	</section><!-- /#gallery -->    

	<!-- Contact Section -->
    <section id="contact">
    <div class="overlay"></div>
    <div class="container text-center">
        <div class="row">
            <div class="col-lg-12 wp11">
                
                <ul class="social-buttons">
                    <li><a href="https://twitter.com/"><i class="fa fa-twitter fa-fw"></i> <span>Twitter</span></a></li>
                    <li><a href="https://www.facebook.com/"><i class="fa fa-facebook fa-fw"></i> <span>Facebook</span></a></li>
                    <li><a href="https://plus.google.com/"><i class="fa fa-google-plus fa-fw"></i> <span>Google+</span></a></li>
                    <li><a href="https://www.flickr.com/"><i class="fa fa-flickr fa-fw"></i> <span>Flickr</span></a></li>
                    <li><a href="https://youtube.com/"><i class="fa fa-youtube fa-fw"></i> <span>You Tube</span></a></li>
                </ul>
                
            </div><!-- /.col-lg-12 --> 
            
        </div><!-- /.row --> 
        <div class="row">
        
        <div class="copyright">
          ©  LuLu Company, Inc 
       	<br>
        2015 
        </div>
        <div class="footer-line"></div>
        </div><!-- /.row --> 
    </div><!-- /.container -->     	  
    </section><!-- /#contact --> 


    <!-- Core JavaScript Files -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.easing.min.js"></script>

    <!-- JavaScript -->
    <script src="js/lib/jquery.appear.js"></script>
    <script src="js/lib/owl-carousel/owl.carousel.min.js"></script>
    <script src="js/lib/magnific-popup/jquery.magnific-popup.min.js"></script>
    <script src="js/lib/video/jquery.mb.YTPlayer.js"></script> 		
    <script src="js/lib/flipclock/flipclock.js"></script>
    <script src="js/lib/jquery.animateNumber.js"></script>
    <script src="js/lib/waypoints.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/main.js"></script>
    

</body>

</html>