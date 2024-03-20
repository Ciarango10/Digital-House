window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const form = document.forms[0];
    const nombre = document.querySelector("#inputNombre");
    const apellido = document.querySelector("#inputApellido");
    const email = document.querySelector("#inputEmail");
    const password = document.querySelector("#inputPassword");
    const passwordConfirmation = document.querySelector("#inputPasswordRepetida");
    const url = "https://todo-api.ctd.academy/v1";


    

    /* -------------------------------------------------------------------------- */
    /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
    /* -------------------------------------------------------------------------- */
    form.addEventListener('submit', function (event) {
        event.preventDefault(); // prevenimos el comportamiento por defecto del formulario
        const payload = {
            firstName: nombre.value,
            lastName: apellido.value,
            email: email.value,
            password: password.value
        }

        let settings = {
            method: "POST",
            headers: { 
            "Content-Type": "application/json"
            },
            body: JSON.stringify(payload)
        }

        //Realizamos el registro
        realizarRegister(settings);
    });

    /* -------------------------------------------------------------------------- */
    /*                    FUNCIÓN 2: Realizar el signup [POST]                    */
    /* -------------------------------------------------------------------------- */
    function realizarRegister(settings) {
        
        fetch(`${url}/users`, settings)
        .then(response =>  {
            if(response.ok) return response.json();
            
            return Promise.reject(response);
        })
        .then(data => {
            console.log(data.jwt);
            if(data.jwt) {

                // Guardamos el dato jwt en el local storage (este token de autenticación)
                localStorage.setItem("jwt", JSON.stringify(data.jwt));

                // Limpiar el formulario
                form.reset();                       
                // redireccionamos a nuestro dashboard de la ToDo
                location.replace("./mis-tareas.html");
            }
        })
        .catch(error => {
            if(error.status == 400) {
                console.error("El usuario ya se encuentra registrado / Alguno de los datos requeridos está incompleto");
                alert("Usuario ya registrado, Ingresa con tus credenciales");
            } else {
                console.error("Error del servidor");
                alert("Error de Servidor, comúniquese con el proveedor");                
            }
        });
    };
});