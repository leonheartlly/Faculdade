$(function() {
	// foreach do jquery(for each movie in movies){
	var i = 0;
	var listContainer = $('#list');


	listContainer
	.prepend('<thead><tr><th width="20%">Título do Filme</th><th width="10%">Ano</th><th width="60%">Descrição</th><th width="10%">Assistir</th><th></th></tr></thead>');
	
	for (i = 0; i < 5; i++) {
		inputValue = $('#input').val();
		// add new list item
		listContainer
				.prepend('<tr><td>Mad Max: A estrada da fúria</td><td>2015</td><td>Após ser capturado por Immortan Joe, um guerreiro dasestradas chamado Max (Tom Hardy) se vê no meio de uma guerramortal, iniciada pela Imperatriz Furiosa (Charlize Theron) natentativa se salvar um grupo de garotas. Também tentanto fugir, Max aceita ajudar Furiosa em sua luta contra Joe e se vê dividido entre mais uma vez seguir sozinho seu caminho ou ficar com o grupo.</td> <td align="center"><a href="#" data-toggle="modal" data-target="#playMovie"><i class="fa fa-video-camera"></i></a></td></tr>');
		// clear value input
		$('#input').val('');
	}

});

function watch() {
	// foreach do jquery(for each movie in movies){
	var i = 0;
	var listContainer = $('#listUnfinished');


	listContainer
	.prepend('<thead><tr><th width="20%"></th><th width="20%">Título do Filme</th><th width="10%">Ano</th><th width="60%">Descrição</th><th width="10%">Assistir</th><th></th></tr></thead>');
	
	for (i = 0; i < 5; i++) {
		inputValue = $('#input').val();
		// add new list item
		listContainer
				.prepend('<tr><td><img class="img-circle" src="img/mad.jpg" alt="Smiley face" height="100" width="100"></td><td>Mad Max: A estrada da fúria</td><td>2015</td><td>Após ser capturado por Immortan Joe, um guerreiro dasestradas chamado Max (Tom Hardy) se vê no meio de uma guerramortal, iniciada pela Imperatriz Furiosa (Charlize Theron) natentativa se salvar um grupo de garotas. Também tentanto fugir, Max aceita ajudar Furiosa em sua luta contra Joe e se vê dividido entre mais uma vez seguir sozinho seu caminho ou ficar com o grupo.</td> <td align="center"><a href="#" data-toggle="modal" data-target="#playMovieUnfinished"><i class="fa fa-video-camera"></i></a></td></tr>');
		// clear value input
		$('#input').val('');
	}

}

