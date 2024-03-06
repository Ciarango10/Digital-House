let formulario = document.querySelector("form.reservation");
formulario.addEventListener("submit", function(e){
    let errores = [];
    let campoNombre = document.querySelector("input.nombre");
    let campoFecha = document.querySelector("input.fecha");

    if(campoNombre.value == ""){
        errores.push("El campo nombre está vacío");
    }
    if(campoFecha.value == ""){
        errores.push("El campo fecha está vacío");
    }

    if(errores.length > 0){
        e.preventDefault();
        let ulErrores = document.querySelector(".errores ul");
        errores.forEach(error => {
            ulErrores.innerHTML += `<li>${error}</li>`
        });
    }
});
