
//Exibe a dialog com o progresso de uma operação
function start() {  
    PF('statusDialog').show();  
}  

//Interrompe a dialog com o progresso de uma operação
function stop() {  
	PF('statusDialog').hide();  
}  

// Verificar se o combobox selecionado eh para calcular porcentagem
function changeEvent(element) {
    var val = $(element).find('option:selected').text();
    if(val.indexOf('X') > -1) {
    	filtroPorcent.show();
    }
}

function changeEventCompare(element) {
    var val = $(element).find('option:selected').text();
    if(val.indexOf('#') > -1){
    	filtroValor.show();
    }
}

function exportChart() {
    //export image
    $('#output').empty().append(PF('chart').exportAsImage());

    //show the dialog
    PF('dlg').show();
}

function handleDrop(event, ui) {
    var droppedCar = ui.draggable;

    droppedCar.fadeOut('fast');
}

function getCurrentDate () {
	
	// Obtém a data/hora atual
	var data = new Date();

	// Guarda cada pedaço em uma variável
	var dia     = data.getDate();           // 1-31
	var dia_sem = data.getDay();            // 0-6 (zero=domingo)
	var mes     = data.getMonth();          // 0-11 (zero=janeiro)
	var ano2    = data.getYear();           // 2 dígitos
	var ano4    = data.getFullYear();       // 4 dígitos
	var hora    = data.getHours();          // 0-23
	var min     = data.getMinutes();        // 0-59
	var seg     = data.getSeconds();        // 0-59
	var mseg    = data.getMilliseconds();   // 0-999
	var tz      = data.getTimezoneOffset(); // em minutos

	if ( min < 10 ) {
		min = "0" + min;
	}
	
	if ( seg < 10 ) {
		seg = "0" + seg;
	}
	
	// Formata a data e a hora (note o mês + 1)
	var str_data = dia + '/' + (mes+1) + '/' + ano4;
	var str_hora = hora + ':' + min + ':' + seg;

	// Mostra o resultado
	return str_data + ' às ' + str_hora;
}