
var working = false;


$(document).ready(function () {

    $('.login').on('submit', function (e) {
        e.preventDefault();

        if ($('#confirmPass').val() != '' && $('#pass').val() == $('#confirmPass').val()) {


            if (working)
                return;
            working = true;
            var $this = $(this),
                    $state = $this.find('button > .state');
            $this.addClass('loading');
            $state.html('Cambiando contraseña..');
            var ruta = "../UserServlet";
            $.ajax({
                url: ruta,
                type: "POST",
                data: $("#ChangePasss").serialize(),
                success: function (datos)
                {
                    if (datos == '1') {
                        setTimeout(function () {
                            $this.addClass('ok');
                            $state.html('Se ha cambiado la contraseña');
                            setTimeout(function () {
                                $state.html('Cambiar Contraseña');
                                $this.removeClass('ok loading');
                                working = false;
                                location.replace("../index.jsp");
                            }, 900);
                        }, 3000);
                    }
                    else if (datos == '0') {
                        setTimeout(function () {
                            $this.addClass('fail');
                            $state.html('Hubo un error al tratar de cambiar la contraseña');
                            setTimeout(function () {
                                $state.html('Cambiar Contraseña');
                                $this.removeClass('fail loading');
                                working = false;
                            }, 4000);
                        }, 3000);

                    }
                }
            });


        } else {
            $("#confirmPass").focus();
            $("#confirmPass").css("border-color", "red");


        }


    });

});
