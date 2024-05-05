// Función para limpiar el formulario
function resetForm() {
    document.getElementById("userForm").reset();
}
// Evitar que el usuario retroceda hacia atrás en la historia del navegador
history.pushState(null, null, location.href);
window.onpopstate = function () {
    history.go(1);
};

