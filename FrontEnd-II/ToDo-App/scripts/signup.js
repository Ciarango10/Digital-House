window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const form = document.forms[0];
    const nombre = document.querySelector("#inputNombre");
    const apellido = document.querySelector("#inputApellido");
    const email = document.querySelector("#inputEmail");
    const password = document.querySelector("#inputPassword");
    const passwordConfirmation = document.querySelector("#inputPasswordRepetida");
    const url = "https://todo-api.ctd.academy/v1";

    //Aqui en este punto nos encargamos de mandar a llamar a las funciones normalizar Texto y las validaciones
    //Cuando modifico el contenido del input se desencadena el evento el cual lo capturará la función que se encargará de validar
    nombre.addEventListener("input", e => validarTexto(e));
    apellido.addEventListener("input", e => validarTexto(e));
    email.addEventListener("input", e => validarEmail(e));
    password.addEventListener("input", e => validarContrasenia(e));
    passwordConfirmation.addEventListener("input", e => compararContrasenias(e.target, password.value));
    
    // El evento blur desencadenar el evento una vez que abandono el input,
    // por eso si esta vacio, le indico que lo obligue a cargarlo
    nombre.addEventListener("blur", e => isEmpty(`Se requiere que ingrese su ${nombre.name}`, e));
    apellido.addEventListener("blur", e => isEmpty(`Se requiere que ingrese su ${apellido.name}`, e));
    email.addEventListener("blur", e => isEmpty(`Se requiere que ingrese su ${email.name}`, e));
    password.addEventListener("blur", e => isEmpty(`Se requiere que ingrese su ${password.name}`, e));
    passwordConfirmation.addEventListener("blur", e => isEmpty(`Se requiere que ingrese su ${passwordConfirmation.name}`, e));

    /* -------------------------------------------------------------------------- */
    /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
    /* -------------------------------------------------------------------------- */
    form.addEventListener('submit', function (event) {
        event.preventDefault(); // prevenimos el comportamiento por defecto del formulario
        const payload = {
            firstName: normalizarTexto(nombre.value),
            lastName: normalizarTexto(apellido.value),
            email: normalizarEmail(email.value),
            password: password.value
        }

        let settings = {
            method: "POST",
            headers: { 
            "Content-Type": "application/json"
            },
            body: JSON.stringify(payload)
        }

        //Validamos si hay contenido en los inputs
        if(email.value.length > 0 && password.value.length > 0 && nombre.value.length > 0 && apellido.value.length > 0 && compararContrasenias(passwordConfirmation, password.value)) {
            console.log("Todo OK, pasamos a hacer la request");
            //Realizamos el registro
            realizarRegister(settings);
        }
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