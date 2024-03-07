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

window.onload = function() {
  let localName = localStorage.getItem("Nombre");
  if(localName !== null) {
    showSuccessMessage(localName);
  }
}

let btnIniciarSesion = document.querySelector(".login-btn");
btnIniciarSesion.addEventListener("click", function(e) {
  let errores = 0;
  let mensaje = document.querySelector("#loader");
  mensaje.classList.remove("hidden");
  setTimeout(function() {
    mensaje.classList.add("hidden");

    let inputEmail = document.querySelector("#email-input");
    if(!inputEmail.value.includes("@")) {
      errores++;
    }

    let inputPassword = document.querySelector("#password-input");
    if(inputPassword.value.length < 5) {
      errores++;
    }

    let baseDatos = false;
    baseDeDatos.usuarios.forEach(element => {
      if(element.email === inputEmail.value && element.password === inputPassword.value) {
        baseDatos = true;
        localStorage.setItem("Email", element.email);
        localStorage.setItem("Nombre", element.name);
      }
    });

    if(!baseDatos) {
      errores++;
    }

    if(errores > 0) {
      let errorContainer = document.querySelector("#error-container");
      errorContainer.innerHTML += "<small>Alguno de los datos ingresados son incorrectos</small";
      errorContainer.classList.remove("hidden");
    } else {
      let localName = localStorage.getItem("Nombre");
      if(localName !== null) {
        showSuccessMessage(localName);
      }
    }
  },3000);
});

function showSuccessMessage(name){
  let form = document.querySelector("form");
  form.classList.add("hidden");
  let h1 = document.querySelector("h1");
  h1.classList.add("hidden");
  let success = document.querySelector("#mensajeSuccess");
  success.innerHTML = `<h1> Bienvenido al sitio ${name}😀</h1>`;
  success.innerHTML += "<button id='btnCerrarSesion'>Cerrar Sesión</button>";

  document.querySelector("#btnCerrarSesion").addEventListener("click", function() {
    localStorage.removeItem("Email");
    localStorage.removeItem("Nombre");
    alert("Sesión cerrada");
    location.reload();
  });
}

// ACTIVIDAD

// Paso a paso:

// 1) Al momento de que la persona inicia sesión, si las validaciones que ya tenemos implementadas
// han sido exitosas, deberemos almacenar la información del usuario en el LocalStorage.

// 2) Al mensaje de bienvenida que ya teníamos implementado, deberemos agregarle el nombre de la
// persona y un botón de "Cerrar Sesión".

// 3) Una vez iniciada la sesión, la misma se deberá mantener en ese estado para el caso de que la persona
// recargue la página. Para ello, deberás validar si existe información del usuario al momento en
// que se produce la carga de la página, y en base a dicha condción decidir que elementos mostrar.

// 3) Para el caso de que la persona haga click en el botón "Cerrar Sesión", se deberá eliminar
// la información del usuario, mostrar un mensaje indicando que se ha cerrado la sesión, y recargar
// la página para mostrar nuevamente el formulario de login.

/* 
TIPS:
  - Para lograr los objetivos de este ejercicio, deberás valerte de algunos eventos y métodos que vimos en
    las clases anteriores. Te invitamos a que revises los recursos en caso de que tengas dudas, ya que allí
    encontrarás todas las respuestas que necesitas para completar la actividad.

  - Recuerda que puedes seleccionar y manipular los elementos del archivo index.html, usando los
    recursos que Javascript te ofrece para ello. Además, en el archivo styles.css tiene algunas clases y 
    estilos predefinidos para ayudarte a completar la actividad.

  - Al momento de guardar información del usuario en el navegador, recuerda que debemos almacenar solo la 
    información necesaria, y EN NINGUN CASO DEBEMOS GUARDAR LA CONTRASEÑA. Por ello, deberás seleccionar y
    separar la información que tienes que almacenar, a partir del objeto que contiene la información del 
    usuario.

   ¡Manos a la obra!
 */
