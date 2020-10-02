$(document).ready(function() {

	if ($("body").find(".accountManagementPanel").length > 0){

        $("form:not(.filter) :input:visible:enabled").eq(0).attr("placeholder", "Ingrese nombre de usuario");
        $("form:not(.filter) :input:visible:enabled").eq(1).attr("placeholder", "Ingrese contraseña");

        $("button.btn[type=submit]").addClass("btn");

        $('h1').css('margin-top', '-80px');
        $('h2').css('margin-top', '-40px');

    	}
});