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
<title>Kutube Movies</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/carousel.css" rel="stylesheet">
</head>


<body>

	<!-- NavBar -->
	<div class="navbar-wrapper">
		<div class="container">
			<nav class="navbar navbar-default navbar-fixed-top"
				style="height: auto;">
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
						<li><a href="kutubeIndex.jsp">Home</a></li>
						<!-- Dropdown Todos Filmes / Seriados -->
						<li class="dropdown active"><a href="#" class="dropdown-toggle"
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

	<!-- Section: Movie Action -->
	<section id="maction">
	<div class="container marketing">
		<div class="row">
			<div class="section-heading">
			<br> <br>
				<center>
					<h2>Ação</h2>
				</center>
				<br> <br>
			</div>
			<div class="col-lg-16">
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
			<!-- /.col-lg-16-->
			<br>
			<div class="col-lg-16">
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
			<!-- /.col-lg-16-->
			<br>
			<div class="col-lg-16">
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
			<!-- /.col-lg-16-->
			<br>
			<div class="col-lg-16">
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
			<br>
			<div class="col-lg-16">
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
			<br>
			<div class="col-lg-16">
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
	<!-- /Section: Movie Action -->
	
	<!-- Section: Movie Comedy -->
	<section id="mcomedy">
	<div class="container marketing">
		<div class="row">
			<div class="section-heading">
			<br> <br>
				<center>
					<h2>Comédia</h2>
				</center>
				<br> <br>
			</div>
			<div class="col-lg-16">
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
			<!-- /.col-lg-16-->
			<br>
			<div class="col-lg-16">
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
			<!-- /.col-lg-16-->
			<br>
			<div class="col-lg-16">
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
			<!-- /.col-lg-16-->
			<br>
			<div class="col-lg-16">
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
			<br>
			<div class="col-lg-16">
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
			<br>
			<div class="col-lg-16">
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
	<!-- /Section: Movie Comedy -->
	
	<!-- Section: Movie Horror -->
	<section id="mhorror">
	<div class="container marketing">
		<div class="row">
			<div class="section-heading">
			<br> <br>
				<center>
					<h2>Terror</h2>
				</center>
				<br> <br>
			</div>
			<div class="col-lg-16">
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
			<!-- /.col-lg-16-->
			<br>
			<div class="col-lg-16">
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
			<!-- /.col-lg-16-->
			<br>
			<div class="col-lg-16">
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
			<!-- /.col-lg-16-->
			<br>
			<div class="col-lg-16">
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
			<br>
			<div class="col-lg-16">
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
			<br>
			<div class="col-lg-16">
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
	<!-- /Section: Movie Horror -->

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
		System.out.println("KuTube Movies");
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