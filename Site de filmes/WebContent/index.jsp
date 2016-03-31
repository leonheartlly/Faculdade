<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="icon" href="images/Videos-icon.png">
<title>KuTube</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">

<!-- Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">


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
	<nav class="navbar navbar-custom navbar-fixed-top wp1"
		role="navigation">
		<div class="container">
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-main-collapse">
					<i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="#page-top"> <i
					class="fa fa-video-camera"></i><span class="font-light rainbow makeItBold" style="color: red; "> Ku</span>Tube
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div
				class="collapse navbar-collapse navbar-right navbar-main-collapse">
				<ul class="nav navbar-nav">
					<!-- Hidden li included to remove active class from about link when scrolled up past about section -->
					<li class="hidden"><a href="#page-top"></a></li>
					<li class="page-scroll"><a href="#page-top">Destaque</a></li>
					<li class="page-scroll"><a href="#about">Sobre</a></li>
					<li class="page-scroll"><a href="#movies">Filmes</a></li>
					<li class="page-scroll"><a href="#contact">Contato</a></li>
					<li class="page-scroll"><a id="Kutlogin" href="#" data-toggle="modal"
						data-target="#modalLogin">Login</a></li>
					<li class="page-scroll"><a href="#" data-toggle="modal" class="fa fa-video-camera hasVideo" data-target="#modalMoviesUnfinished" style="display:none;" onclick="watch();" ></a></li>
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
								<h1 class="text-center">
									VINGADORES <span class="text-color font-light">2</span>
								</h1>
								<div id="owl-intro" class="owl-carousel owl-theme">

									<div class="item">
										<p class="font-similar">
											Os super-heróis Capitão América, Homem de Ferro, Thor, Hulk,
											Viúva Negra e Gavião Arqueiro retornam mais uma vez para
											proteger o planeta, após o projeto de Tony Stark dar errado,
											gerando o nascimento de <b>Ultron</b>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /.intro-info-wrapper -->

					<div class="media-btns buttons page-scroll">
						<div class="btn btn-default play-btn" id="play-button">
							Assistir Filme<i class="fa fa-play animated"></i>
						</div>
						<div class="btn btn-default pause-btn" id="pause-button">
							Parar Filme<i class="fa fa-pause animated"></i>
						</div>
					</div>

				</div>
			</div>


			<div class="video-container">
				<div id="player"></div>
			</div>
		</div>

	</section>
	<!-- /#intro -->

	<!-- About Section -->
	<section id="about">
		<div class="more page-scroll" id="more">
			<a href="#about"><i class="fa fa-angle-down"></i></a>
		</div>

		<div class="container wp2">
			<h1 class="section-title">Sobre</h1>


			<div class="container">
				<div class="col-md-4 advantages-item wp7 delay-05s">
					<div class="advantages-item-icon">
						<i class="fa fa-star-o"></i>
					</div>
					<h3>Conteúdo Exclusivo</h3>
					<p>
						Assinantes do KuTube tem acesso ao conteúdo exclusivo. São
						milhares de filmes para aproveitar sessão pipoca com toda sua
						família <span class="text-light"><i class="fa fa-heart"></i></span>
					</p>
				</div>
				<!-- /.col-md-4 -->

				<div class="col-md-4 advantages-item wp7">
					<div class="advantages-item-icon">
						<i class="glyphicon glyphicon-film"></i>
					</div>
					<h3>Filmes em HD</h3>
					<p>
						Só no KuTube você conta com milhares de filmes em alta definição.
						É isso mesmo que você leu... <span class="text-light">ALTA
							DEFINIÇÃO</span> ! Aproveite agora mesmo e assine nossos serviços ;)
					</p>
				</div>
				<!-- /.col-md-4 -->

				<div class="col-md-4 advantages-item wp7 delay-05s">
					<div class="advantages-item-icon">
						<i class="fa fa-thumbs-o-up"></i>
					</div>
					<h3>Rápido e Fácil</h3>
					<p>
						O KuTube conta com uma infraestrutura fodástica que garante tudo
						que oferece. Esqueça o NetFlix, aproveite as vantagens que só o <b><span class="rainbow">Ku</span>Tube</b>
						oferece.
					</p>
				</div>
				<!-- /.col-md-4 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</section>
	<!-- /#about -->



	<!-- Gallery Section -->
	<section id="movies">
		<div class="overlay"></div>

		<div class="section-wrapper wp8 delay-05s">
			<h1 class="section-title">GÊNEROS</h1>

			<div id="owl-gallery">

				<div class="item">
					<a href="#" data-toggle="modal" data-target="#modalMovies"> <img
						src="img/movies_genre/Action.png" title="Ação"></a>
				</div>
				<div class="item">
					<a href="#" data-toggle="modal" data-target="#modalMovies"> <img
						src="img/movies_genre/Animation.png" title="Animação"></a>
				</div>
				<div class="item">
					<a href="#" data-toggle="modal" data-target="#modalMovies"> <img
						src="img/movies_genre/Adventure.png" title="Aventura"></a>
				</div>
				<div class="item">
					<a href="#" data-toggle="modal" data-target="#modalMovies"> <img
						src="img/movies_genre/RomCom.png" title="Comédia Romântica"></a>
				</div>
				<div class="item">
					<a href="#" data-toggle="modal" data-target="#modalMovies"> <img
						src="img/movies_genre/Comedy.png" title="Comédia"></a>
				</div>
				<div class="item">
					<a href="#" data-toggle="modal" data-target="#modalMovies"> <img
						src="img/movies_genre/Drama.png" title="Drama"></a>
				</div>
				<div class="item">
					<a href="#" data-toggle="modal" data-target="#modalMovies"> <img
						src="img/movies_genre/Documentary.png" title="Documentário"></a>
				</div>
				<div class="item">
					<a href="#" data-toggle="modal" data-target="#modalMovies"> <img
						src="img/movies_genre/Sci-fi.png" title="Ficção"></a>
				</div>
				<div class="item">
					<a href="#" data-toggle="modal" data-target="#modalMovies"> <img
						src="img/movies_genre/Family.png" title="Infantil"></a>
				</div>
				<div class="item">
					<a href="#" data-toggle="modal" data-target="#modalMovies"> <img
						src="img/movies_genre/Crime.png" title="Policial"></a>
				</div>
				<div class="item">
					<a href="#" data-toggle="modal" data-target="#modalMovies"> <img
						src="img/movies_genre/Romance.png" title="Romance"></a>
				</div>
				<div class="item">
					<a href="#" data-toggle="modal" data-target="#modalMovies"> <img
						src="img/movies_genre/Thriller.png" title="Suspense"></a>
				</div>
				<div class="item">
					<a href="#" data-toggle="modal" data-target="#modalMovies"> <img
						src="img/movies_genre/Horror.png" title="Terror"></a>
				</div>

			</div>
			<!-- /#owl-gallery -->
		</div>
	</section>
	<!-- /#gallery -->

	<!-- Contact Section -->
	<section id="contact">
		<div class="overlay"></div>
		<div class="container text-center">
			<div class="row">
				<div class="col-lg-12 wp11">

					<ul class="social-buttons">
						<li><a href="https://twitter.com/"><i
								class="fa fa-twitter fa-fw"></i> <span>Twitter</span></a></li>
						<li><a href="https://www.facebook.com/"><i
								class="fa fa-facebook fa-fw"></i> <span>Facebook</span></a></li>
						<li><a href="https://plus.google.com/"><i
								class="fa fa-google-plus fa-fw"></i> <span>Google+</span></a></li>
						<li><a href="https://www.flickr.com/"><i
								class="fa fa-flickr fa-fw"></i> <span>Flickr</span></a></li>
						<li><a href="https://youtube.com/"><i
								class="fa fa-youtube fa-fw"></i> <span>YouTube</span></a></li>
					</ul>

				</div>
				<!-- /.col-lg-12 -->

			</div>
			<!-- /.row -->
			<div class="row">

				<div class="copyright">
					© LuLu Company, Inc <br> 2015
				</div>
				<p>
					<a href="#page-top"> <i class="glyphicon glyphicon-chevron-up"></i>
					</a>
				</p>

				<div class="footer-line"></div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</section>
	<!-- /#contact -->




	<!-- Modal Movies-->
	<div id="modalMovies" class="modal fade">
		<div class="modal-dialog" style="width: auto; height: auto;">
			<div class="modal-content"
				style="background-color: rgba(255, 255, 255, 0.2);">

				<!-- Modal content-->
				<!-- <div class="modal-content"> -->
				<div class="modal-body">

					<div class="container">
						<div id="main_area" align="center">
							<h1>Filmes</h1>

							<div class="table-responsive">
								<table class="table table-hover">
									<ul class="pagination" id="list"></ul>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
				</div>

			</div>
		</div>
		<!-- /#modal movies -->


		<!-- Modal Play Movie -->
		<div class="modal fade" id="playMovie" data-backdrop="static">
			<div class="modal-dialog">
				<div class="container"></div>
				<div class="modal-body">
					<video controls>
						<source src="video/mad_max_2015.mp4" type="video/mp4">
					</video>
				</div>
				<div align="right">
					<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
				</div>
			</div>
		</div>
		
		
	</div>



	<!-- /#modal play movies -->

	<!-- modal play movies UNFINISHED-->
	<div id="modalMoviesUnfinished" class="modal fade">
		<div class="modal-dialog" style="width: auto; height: auto;">
			<div class="modal-content"
				style="background-color: rgba(255, 255, 255, 0.2);">

				<!-- Modal content-->
				<!-- <div class="modal-content"> -->
				<div class="modal-body">

					<div class="container">
						<div id="main_area" align="center">
							<h1>Filmes Iniciados</h1>

							<div class="table-responsive">
								<table class="table table-hover">
									<ul class="pagination" id="listUnfinished"></ul>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
				</div>
				</div>
		</div>
<!-- modal Play unfinished movie -->
		<div class="modal fade" id="playMovieUnfinished" data-backdrop="static">
			<div class="modal-dialog">
				<div class="container"></div>
				<div class="modal-body">
					<video controls>
						<source src="video/mad_max_2015.mp4" type="video/mp4">
					</video>
				</div>
				<div align="right">
					<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
				</div>
			</div>
		</div>
</div>
<!-- /#modal play movies UNFINISHED -->

	<!-- Modal Login-->
	<div class="modal fade"  id="modalLogin" role="dialog">
		<div class="modal-content"
			style="background-color: rgba(255, 255, 255, 0.2);">
			<div class="modal-dialog">
				<div class="modal-header">
					<button type="button" class="close rainbow" data-dismiss="modal">x</button>
					<h3>
						<i class="fa fa-video-camera"></i> <span class="rainbow">Ku</span>Tube Login
					</h3>
				</div>
				<div class="modal-body">
					<form method="post" action='' name="login_form">
						<p>
							<input type="text" class="span3" name="eid" id="email"
								placeholder="E-mail" value="">
						</p>
						<p>
							<input type="password" class="span3" name="passwd"
								placeholder="Senha">
						</p>
						<p>
							<button type="submit" onclick="validacao();" class="btn btn-default">Entrar</button>
							<br> <a href="#" onclick="esqueci();">Esqueceu a senha?</a>

						</p>
					</form>
				</div>
				<div class="modal-footer">
					Novo por aqui?! <br> <br> <a href="#"
						onclick="cadastro();" class="btn btn-default">Cadastre-se!</a>
				</div>
			</div>
		</div>
		<span style="display: none;" value="" id="hiddenLogin"></span>
	</div>
	<!-- /#modal login -->



	<!-- Core JavaScript Files -->
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.easing.min.js"></script>
	<script src="js/lib/rainbow.js"></script>

	<!-- JavaScript -->
	<script src="js/lib/jquery.appear.js"></script>
	<script src="js/lib/owl-carousel/owl.carousel.min.js"></script>
	<script src="js/lib/magnific-popup/jquery.magnific-popup.min.js"></script>
	<script src="js/lib/video/jquery.mb.YTPlayer.js"></script>
	<script src="js/lib/flipclock/flipclock.js"></script>
	<script src="js/lib/jquery.animateNumber.js"></script>
	<script src="js/lib/waypoints.min.js"></script>
	<script src="js/kutube.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/main.js"></script>
	<script src="js/interactive-list.js"></script>
</body>

</html>