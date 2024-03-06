// Esta es la base de datos de nuestros usuarios
const baseDeDatos = {
  usuarios: [
    {
      id: 1,
      name: "Steve Jobs",
      email: "steve@jobs.com",
      password: "Steve123",
    },
    {
      id: 2,
      name: "Ervin Howell",
      email: "shanna@melissa.tv",
      password: "Ervin345",
    },
    {
      id: 3,
      name: "Clementine Bauch",
      email: "nathan@yesenia.net",
      password: "Floppy39876",
    },
    {
      id: 4,
      name: "Patricia Lebsack",
      email: "julianne.oconner@kory.org",
      password: "MysuperPassword345",
    },
  ],
};

// ACTIVIDAD

// Paso a paso:

// 1) Escuchar el evento necesario para reaccionar cuando la persona
// haga click en el botón iniciar sesión.
let errores = 0;
let btnIniciarSesion = document.querySelector(".login-btn");
btnIniciarSesion.addEventListener("click", function(e) {
  // 2) El proceso de inicio de sesión deberá tener una demora de 3 segundos.
// Deberás agregar la función correspondiente para simular dicha demora.
  let mensaje = document.querySelector("#loader");
    // 3) Durante el tiempo indicado anteriormente, se deberá mostrar el mensaje "Iniciando sesión..."
  mensaje.classList.remove("hidden");
  setTimeout(function() {
    mensaje.classList.add("hidden");
    // 4) A partir de los inputs ingresados en el formulario, se deberan realizar las siguientes validaciones:
    // 1) Que el primer input sea un email válido.
    let inputEmail = document.querySelector("#email-input");
    if(!inputEmail.value.includes("@")) {
      errores++;
    }
    // 2) Que la contraseña tenga al menos 5 caracteres.
    let inputPassword = document.querySelector("#password-input");
    if(inputPassword.value.length < 5) {
      errores++;
    }
    // 3) Que los datos ingresados corresponden a una
    // persona que se encuentre registrada en la base de datos.
    let baseDatos = false;
    baseDeDatos.usuarios.forEach(element => {
      if(element.email === inputEmail.value && element.password === inputPassword.value) {
        baseDatos = true;
      }
    });
    if(!baseDatos) {
      errores++;
    }
    // En caso de que alguna de las validaciones no sea exitosa,
    // se deberá mostrar un mensaje de error que diga "Alguno de los datos ingresados son incorrectos"
    if(errores > 0) {
      let errorContainer = document.querySelector("#error-container");
      errorContainer.innerHTML += "<small>Alguno de los datos ingresados son incorrectos</small";
      errorContainer.classList.remove("hidden");
    } else {
    // 5) En caso de que los datos ingresados sean correctos, se deberá ocultar el formulario y mostrar
    // un mensaje de bienvenida al sitio.
      let form = document.querySelector("form");
      form.classList.add("hidden");
      let h1 = document.querySelector("h1");
      h1.classList.add("hidden");
      let success = document.querySelector("#mensajeSuccess");
      success.innerHTML = "<h1> Bienvenido al sitio 😀 </h1>";
    }
  },3000);

});

/* 
TIPS:
  - Puedes averiguar acerca de la manera de validar el formato de un email utilizando Javascript, buscando
    en internet frases como "Validar email con Javascript o similar".

  - Recuerda que puedes seleccionar y manipular los elementos del archivo index.html, usando los
    recursos que Javascript te ofrece para ello. Además, en el archivo styles.css tiene algunas clases y 
    estilos predefinidos para ayudarte a completar la actividad.

  - También te dejamos algunos mensajes que te pueden ser de utilidad:
  
   Mensaje de error => <small>Alguno de los datos ingresados son incorrectos</small>

   Mensaje de bienvenida => "<h1> Bienvenido al sitio 😀 </h1>";

   ¡Manos a la obra!
 */
