
var working = false;


$(document).ready(function () {

    $('.login').on('submit', function (e) {


        if ($('#Username').val() != '') {
            if ($('#Pass').val() != '') {

                e.preventDefault();
                if (working)
                    return;
                working = true;
                var $this = $(this),
                        $state = $this.find('button > .state');
                $this.addClass('loading');
                $state.html('Autenticando..');
                var ruta = "../ServletLogin";
                $.ajax({
                    url: ruta,
                    type: "POST",
                    data: $("#Login").serialize(),
                    success: function (datos)
                    {
                        if (datos == '1') {
                            setTimeout(function () {
                                $this.addClass('ok');
                                $state.html('Bienvenido de nuevo!');
                                setTimeout(function () {
                                    $state.html('Log in');
                                    $this.removeClass('ok loading');
                                    working = false;
                                    location.replace("../Home/home.jsp");
                                }, 900);
                            }, 2000);
                        }
                        else if (datos == '2') {
                            setTimeout(function () {
                                $this.addClass('fail');
                                $state.html('El usuario se encuentra inactivo');
                                setTimeout(function () {
                                    $state.html('Log in');
                                    $this.removeClass('fail loading');
                                    working = false;
                                }, 4000);
                            }, 3000);

                        }
                        else if (datos == '3') {
                            setTimeout(function () {
                                $this.addClass('fail');
                                $state.html('Usuario y/o contraseña incorrectos');
                                setTimeout(function () {
                                    $state.html('Log in');
                                    $this.removeClass('fail loading');
                                    working = false;
                                }, 4000);
                            }, 3000);

                        }
                        else if (datos == '4') {
                            setTimeout(function () {
                                $this.addClass('fail');
                                $state.html('Ingrese usuario y contraseña');
                                setTimeout(function () {
                                    $state.html('Log in');
                                    $this.removeClass('fail loading');
                                    working = false;
                                }, 4000);
                            }, 3000);

                        }
                        else if (datos == '0') {
                            setTimeout(function () {
                                $this.addClass('fail');
                                $state.html('Ha ocurrido un error al intentar ingresar');
                                setTimeout(function () {
                                    $state.html('Log in');
                                    $this.removeClass('fail loading');
                                    working = false;
                                }, 4000);
                            }, 3000);

                        }

                    }
                });


            } else {
                $("#Pass").focus();
                $("#Pass").css("border-color", "red");


            }


        } else {

            $("#Username").focus();
            $("#Username").css("border-color", "red");

        }









    });

});
