function esqueci(){
	
	alert("foda-se, lembre ou desista!");
}

function cadastro(){
	
	alert("No momento não estamos aceitando novos usuários!\n Tente novamente em 1 ano");
}
var email;
var hasVideo;
function validacao(){
	this.email = $("#email").val();
	var passwd = $("#passwd").val();
	
	if(passwd !== "1" && email !== "kutubeguy"){
		alert("não existe sua conta!");
	}else{
		$("#Kutlogin").text("Bem Vindo "+ this.email);
		localStorage.setItem("email",this.email);
		hasVideo = "has";
		localStorage.setItem("hasVideo",this.hasVideo);
	}
}

$( document ).ready(function() {
	var val = localStorage.getItem("email");
	  if(val === "kutubeguy"){
		  $("#Kutlogin").text("Bem Vindo "+ val);
		 var hasvid = localStorage.getItem("hasVideo");
		 hasvid = "has";
		 if(hasvid !== ""){
			 $(".hasVideo").css("display","")
		 }
	  }else{
		  localStorage.setItem("email","");
	  }
	  localStorage.setItem("email","");
	});


$('.rainbow').rainbow({
    colors: [
        '#FF0000',
        '#B22222',
        '#A52A2A',
        '#8B0000',
        '#800000',
        '#000000'
    ],
    animate: true,
    animateInterval: 200,
    pad: false,
    pauseLength: 1000
});

/**
 * 		EXEMPLO CONSUMIR XML
 */

/*
$.ajax({
    type: 'POST',
    url: 'web service link',
    dataType: 'xml',
    success: function (response) {
        $('MobileConfiguration', response).each(function() {
            var id = $(this).find('Id').text();
            var key = $(this).find('Key').text();
            var value = $(this).find('Value').text();

            console.log(id, key, value);
        });
    },
    error: function (error) {
        console.log(error);
    }
});

*/