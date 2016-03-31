function verifica() {
    if (window.confirm("Deseja apagar?")) {
        return true;
    }
    return false;
}

function msgEnviandoEmail() {
	msg.show();
	setTimeout(function() { 
		msg.hide();
	}, 2000);
}			
