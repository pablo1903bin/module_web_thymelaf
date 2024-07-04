$(document).ready(function () {
    // Deshabilitar el botón de envío al cargar la página
    var $submitButton = $('input[type="submit"]');
    // $submitButton.prop('disabled', true);

    // Función para verificar y habilitar/deshabilitar el botón de envío
    function verificarCampos() {
        var emailOrPhone = $('input[name="emailOrPhone"]').val();
        var password = $('input[name="password"]').val();

        if (emailOrPhone !== '' && password !== '') {
            $submitButton.prop('disabled', false);
        } else {
            $submitButton.prop('disabled', true);
        }
    }

    // Mostrar alerta al hacer clic en el botón de enviar
    $submitButton.on('click', function (event) {
        event.preventDefault(); // Evita que el formulario se envíe

        var usuario = $('#username').val();

        var password =  $('#password').val();

        console.log("usuario: " + usuario);
        console.log("password: " + password);

        if (usuario === '') {
            // Mostrar alerta con SweetAlert2
            Swal.fire({
                icon: 'error',
                title: 'Campo usuario vacio',
                text: 'Por favor, escribe un usuario',
            });
        } else if (password === '') {
            // Mostrar alerta con SweetAlert2
            Swal.fire({
                icon: 'error',
                title: 'Campo contraseña vacio',
                text: 'Por favor, escribe tu contraseña.',
            });
        } else if (usuario === '' || password === '') {
            // Mostrar alerta con SweetAlert2
            Swal.fire({
                icon: 'error',
                title: 'Campos vacios',
                text: 'Por favor, escribe un usuario y contraseña.',
            });
        }

        else {
            // Aquí puedes enviar el formulario o realizar otra acción
            // Por ejemplo, puedes hacer submit del formulario:
            $('#userForm').submit();
        }
    });

    // Llamar a la función verificarCampos() en el evento keyup de los campos de texto y contraseña
    $('input[name="emailOrPhone"], input[name="password"]').on('keyup', function () {
        verificarCampos();
    });

    $('#togglePassword').on('click', function() {
        var passwordField = $('#password');
        var fieldType = passwordField.attr('type');

        if (fieldType === 'password') {
            passwordField.attr('type', 'text');
            $(this).text('Ocultar');
        } else {
            passwordField.attr('type', 'password');
            $(this).text('Mostrar');
        }
    });
    
});
