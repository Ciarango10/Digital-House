window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const form = document.querySelector("form");
    const email = document.querySelector("#inputEmail");
    const password = document.querySelector("#inputPassword");
    const url = "https://todo-api.ctd.academy/v1";

    //Aqui en este punto nos encargamos de mandar a llamar a las funciones normalizar Texto y las validaciones
    //Cuando modifico el contenido del input se desencadena el evento el cual lo capturará la función que se encargará de validar
    email.addEventListener("input", e => validarEmail(e));
    password.addEventListener("input", e => validarContrasenia(e));

    // El evento blur desencadenar el evento una vez que abandono el input,
    // por eso si esta vacio, le indico que lo obligue a cargarlo
    email.addEventListener("blur", e => isEmpty(`Se requiere que ingrese su ${email.name}`, e));
    password.addEventListener("blur", e => isEmpty(`Se requiere que ingrese su ${password.name}`, e));

    /* -------------------------------------------------------------------------- */
    /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
    /* -------------------------------------------------------------------------- */
    form.addEventListener('submit', function (event) {
       event.preventDefault(); // Prevenimos el comportamiento por defecto del formulario
        
       // Objeto de lo que capturamos en los inputs para mandarlo en el fetch
        const payload = {
            email : normalizarEmail(email.value),
            password: password.value
        }

        // Configuramos nuestro objeto de configuraciones que le pasaremos por parametro al fetch 
        let settings = {
            method : "POST",
            headers: { 
                "Content-Type": "application/json"
            },
            body: JSON.stringify(payload)
        }

        //Validamos si hay contenido en los inputs
        if(email.value.length > 0 && password.value.length > 0) {
            console.log("Todo OK, pasamos a hacer la request");
            // Lanzamos la consulta del login a la API
            realizarLogin(settings);
        }
    });


    /* -------------------------------------------------------------------------- */
    /*                     FUNCIÓN 2: Realizar el login [POST]                    */
    /* -------------------------------------------------------------------------- */
    function realizarLogin(settings) {
       
        fetch(`${url}/users/login`, settings)
        .then(response =>{
            if(response.ok) return response.json();
            
            return Promise.reject(response);
        })
        .then(data => {
            if(data.jwt) {
                // Guardamos el dato jwt en el local storage (este token de autenticación)
                localStorage.setItem("jwt", JSON.stringify(data.jwt));

                // Limpiar el formulario
                form.reset()

                // Redireccionamos a nuestro dashboard de la ToDo
                location.replace("./mis-tareas.html");
            }
        })
        .catch(err => {
            console.error(err.status);
            if (err.status == 400) {
                console.warn("Contraseña Incorreta");
                alert("Contraseña Incorreta, por favor revísela");
            } else if (err.status == 404) {
                console.warn("El usuario no existe");
                alert("El usuario no existe, por favor revise su email");
            } else {
                console.error("Error de Servidor");
                alert("Error de Servidor, comúniquese con el proveedor");                
            }
        })
  
    };


});