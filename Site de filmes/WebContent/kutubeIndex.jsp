<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="images/Videos-icon.png">
<title>Kutube Home</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/carousel.css" rel="stylesheet">
</head>


<body>

	<!-- NavBar -->
	<div class="navbar-wrapper">
		<div class="container">
			<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="kutubeIndex.jsp">Kutube</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="kutubeIndex.jsp">Home</a></li>
						<!-- Dropdown Todos Filmes / Seriados -->
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Todos<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li role="separator" class="divider"></li>
								<li class="dropdown-header">Filmes</li>
								<li><a href="kutubeAllMovies.jsp#maction">Ação</a></li>
								<li><a href="kutubeAllMovies.jsp#mcomedy">Comédia</a></li>
								<li><a href="kutubeAllMovies.jsp#mhorror">Terror</a></li>
								<li role="separator" class="divider"></li>
								<li class="dropdown-header">Seriados</li>
								<li><a href="kutubeAllSeries.jsp#saction">Ação</a></li>
								<li><a href="kutubeAllSeries.jsp#scomedy">Comédia</a></li>
								<li><a href="kutubeAllSeries.jsp#shorror">Terror</a></li>
							</ul>
						<li><a href="#">Sobre</a></li>
						<li><a href="#">Contato</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</div>
	</div>
	</nav>
	<!-- /NavBar -->

	<br>
	<br>
	<!-- Section: carousel -->
	<section id="carousel">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="second-slide" src="images/banner2.jpg"
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Game of Thrones</h1>
						<p>Game of Thrones se passa em Westeros, uma terra
							reminiscente da Europa Medieval, onde as estações duram por anos
							ou até mesmo décadas. A história gira em torno de uma batalha
							entre os Sete Reinos, onde duas famílias dominantes estão lutando
							pelo controle do Trono de Ferro, cuja posse assegura a
							sobrevivência durante o inverno de 40 anos que está por vir.</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Assistir</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide" src="images/banner1.jpg"
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Transformers</h1>
						<p>Durante anos os Autobots e os Decepticons, duas raças
							alienígenas robóticas, duelaram em Cybertron, seu planeta natal.
							Esta guerra fez com que o planeta fosse destruído, resultando que
							os robôs se espalhassem pelo universo. Megatron (Hugo Weaving), o
							líder dos Decepticons, vem à Terra em busca da Allspark, um cubo
							de Cybertron que possibilita que qualquer aparelho eletrônico
							seja transformado num robô com inteligência própria.</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Assistir</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide" src="images/banner.jpg" alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Guardiões da Galáxia</h1>
						<p>Na trama, o piloto americano Peter Quill se vê alvo de uma
							caçada quando ele rouba um objeto desejado pelo alien da raça
							kree Ronan, o Acusador. O humano acaba se juntando a um grupo de
							renegados alienígenas - Rocket Raccoon, Groot, Drax - O
							Destruidor e Gamora -, formando os Guardiões da Galáxia.</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Assistir</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	</section>

	<!-- /Section: carousel -->

	<!-- Section: list -->
	<section id="list">
	<div class="container marketing">
		<div class="row">
			<div class="section-heading">
				<center>
					<h2>Destaques</h2>
				</center>
				<br> <br>
			</div>
			<div class="col-lg-4">
				<img class="img-circle" src="images/limitless.jpg"
					alt="Generic placeholder image" width="140" height="140">
				<h2>Sem Limites</h2>
				<p>Eddie Morra (Bradley Cooper) sofre de bloqueio de escritor.
					Um dia, ele reencontra na rua seu ex-cunhado, Vernon (Johnny
					Whitworth), que lhe apresenta um remédio revolucionário que permite
					o uso de 100% da capacidade cerebral.
				<p>
				<p>
					<a class="btn btn-default" href="#" role="button">Mais Detalhes
						&raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle" src="images/starwars.jpg"
					alt="Generic placeholder image" width="140" height="140">
				<h2>Star Wars</h2>
				<p>A prequela da trilogia segue a juventude de Anakin Skywalker.
					Ele é descoberto no planeta Tatooine pelo Cavaleiro Jedi Qui-Gon
					Jinn, que acredita que ele seja o "Escolhido" previsto por uma
					profecia para trazer equilíbrio à Força.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">Mais Detalhes
						&raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle" src="images/spiderman.jpg"
					alt="Generic placeholder image" width="140" height="140">
				<h2>Homem Aranha</h2>
				<p>Peter foi morar junto com seus tios Benjamin e May Parker em
					Forest Hills, Queens, na cidade de Nova York. O garoto cresceu e se
					tornou um adolescente muito inteligente mas bastante tímido. Era
					muito desajeitado, não tinha muitos amigos e nem fazia sucesso com
					as garotas.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">Mais Detalhes
						&raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle" src="images/hobbit.jpg"
					alt="Generic placeholder image" width="140" height="140">
				<h2>Hobbit</h2>
				<p>Gandalf envolve Bilbo em uma festa para Thorin e seu grupo de
					anões, que cantam sobre recuperar a Montanha Solitária e seu vasto
					tesouro do dragão Smaug. Quando a música termina, Gandalf revela um
					mapa que mostra uma porta secreta na montanha e propõe que um
					estupefato Bilbo sirva como "ladrão" da expedição.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">Mais Detalhes
						&raquo;</a>
				</p>
			</div>
			<div class="col-lg-4">
				<img class="img-circle" src="images/interestelar.jpg"
					alt="Generic placeholder image" width="140" height="140">
				<h2>Interestelar</h2>
				<p>Pragas nas colheitas fizeram a civilização humana regredir
					para uma sociedade agrária em um futuro desconhecido. Cooper, um
					ex-piloto da NASA, tem uma fazenda com sua família. Murphy, a filha
					de dez anos de Cooper, acredita que seu quarto está assombrado por
					um fantasma que tenta comunicar com ela.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">Mais Detalhes
						&raquo;</a>
				</p>
			</div>
			<div class="col-lg-4">
				<img class="img-circle" src="images/madMex.jpg"
					alt="Generic placeholder image" width="140" height="140">
				<h2>Mad Max</h2>
				<p>Em um futuro não muito distante e pós apocalíptico, a Lei e
					Ordem da Austrália começam a ruir. Um membro de uma gangue de
					motociclistas Crawford "Nightrider" Montizano escapa de sua
					custódia policial roubando um Especial de Perseguição.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">Mais Detalhes
						&raquo;</a>
				</p>
			</div>
		</div>
	</div>
	</section>
	<!-- /Section: list -->

	<!-- /.row -->
	<!-- START THE FEATURETTES -->

	<!--       <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It'll blow your mind.</span></h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider"> -->
	<!-- /END THE FEATURETTES -->


	<!-- FOOTER -->
	<footer>
	<p class="pull-right">
			<a href="#">
		<i class="glyphicon glyphicon-chevron-up"></i> Back to top</a>
	</p>
	<p>
		&copy; 2015 LuLu Company, Inc. &middot; <a href="#">Privacy</a>
		&middot; <a href="#">Terms</a>
	</p>
	</footer>
	</div>
	</div>
	<%
		System.out.println("KuTube Index");
	%>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="js/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>