
var working = false;


$(document).ready(function () {

    $('.login').on('submit', function (e) {


        if ($('#Email').val() != '') {

            e.preventDefault();
            if (working)
                return;
            working = true;
            var $this = $(this),
                    $state = $this.find('button > .state');
            $this.addClass('loading');
            $state.html('Enviando correo..');
            var ruta = "../ServletLogin";
            $.ajax({
                url: ruta,
                type: "POST",
                data: $("#ChangePass").serialize(),
                success: function (datos)
                {
                    if (datos == '1') {
                        setTimeout(function () {
                            $this.addClass('ok');
                            $state.html('Se ha enviado un link a tu correo');
                            setTimeout(function () {
                                $state.html('Recuperar Contraseña');
                                $this.removeClass('ok loading');
                                working = false;
                            }, 900);
                        }, 3000);
                    }
                    else if (datos == '2') {
                        setTimeout(function () {
                            $this.addClass('fail');
                            $state.html('No se encuentra el usuario');
                            setTimeout(function () {
                                $state.html('Recuperar Contraseña');
                                $this.removeClass('fail loading');
                                working = false;
                            }, 4000);
                        }, 3000);

                    }
                    else if (datos == '0') {
                        setTimeout(function () {
                            $this.addClass('fail');
                            $state.html('Hubo un error al tratar de enviar el correo');
                            setTimeout(function () {
                                $state.html('Recuperar Contraseña');
                                $this.removeClass('fail loading');
                                working = false;
                            }, 4000);
                        }, 3000);

                    }
                }
            });


        } else {
            $("#Email").focus();
            $("#Email").css("border-color", "red");


        }


    });

});
