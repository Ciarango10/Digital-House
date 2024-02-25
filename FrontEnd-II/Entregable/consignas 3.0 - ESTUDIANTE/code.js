/* --------------------------- NO TOCAR DESDE ACÁ --------------------------- */
let datosPersona = {
  nombre: "",
  edad: 0,
  ciudad: "",
  interesPorJs: "",
};

const listado = [{
    imgUrl: "https://huguidugui.files.wordpress.com/2015/03/html1.png",
    lenguajes: "HTML y CSS",
    bimestre: "1er bimestre",
  },
  {
    imgUrl: "https://jherax.files.wordpress.com/2018/08/javascript_logo.png",
    lenguajes: "Javascript",
    bimestre: "2do bimestre",
  },
  {
    imgUrl: "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/React.svg/1200px-React.svg.png",
    lenguajes: "React JS",
    bimestre: "3er bimestre",
  },
];

const profileBtn = document.querySelector("#completar-perfil");
const materiasBtn = document.querySelector("#obtener-materias");
const verMasBtn = document.querySelector("#ver-mas");
const cambiarTema = document.querySelector('#cambiar-tema');

profileBtn.addEventListener("click", renderizarDatosUsuario);
materiasBtn.addEventListener("click", recorrerListadoYRenderizarTarjetas);
cambiarTema.addEventListener("click", alternarColorTema);
/* --------------------------- NO TOCAR HASTA ACÁ --------------------------- */

function obtenerDatosDelUsuario() {
  /* --------------- PUNTO 1: Escribe tu codigo a partir de aqui --------------- */
  let nombre, nacimiento, ciudad;
  do{
    nombre = prompt("Ingrese su nombre: ");
    if(nombre === '' || !/^[a-zA-Z\s]*$/.test(nombre) || nombre === null) {
      alert("Por favor ingrese un nombre válido");
    }
  }
  while(nombre === '' || !/^[a-zA-Z\s]*$/.test(nombre) || nombre === null);
  
  do{
    nacimiento = prompt("Ingrese su año de nacimiento: ");
    if(nacimiento === '' || nacimiento === null || !Number.isInteger(Number(nacimiento)) || Number(nacimiento) >= 2024 || Number(nacimiento) < 1900) {
      alert("Por favor ingrese un año de nacimiento válido");
    }
  }while(nacimiento === '' || nacimiento === null || !Number.isInteger(Number(nacimiento)) || Number(nacimiento) >= 2024 || Number(nacimiento) < 1900);

  do{
    ciudad = prompt("Ingrese la ciudad en la que vive: ");
    if(ciudad === '' || !/^[a-zA-Z\s]*$/.test(ciudad) || ciudad === null) {
      alert("Por favor ingrese una ciudad valida");
    }
  }while(ciudad === '' || !/^[a-zA-Z\s]*$/.test(ciudad) || ciudad === null);

  let interes = confirm("¿Te interesa JavaScript?");
  if(interes) {
    interes = "Sí";
  } else {
    interes = "No";
  }

  datosPersona.nombre = nombre;
  datosPersona.edad = 2024 - parseInt(nacimiento);
  datosPersona.ciudad = ciudad;
  datosPersona.interesPorJs = interes;
  }

function renderizarDatosUsuario() {
  /* ------------------- NO TOCAR NI ELIMINAR ESTA FUNCION. ------------------- */
  obtenerDatosDelUsuario();
  /* --------------- PUNTO 2: Escribe tu codigo a partir de aqui --------------- */
  
  let nombre = document.querySelector("#nombre");
  nombre.innerText = datosPersona.nombre;

  let edad = document.querySelector("#edad");
  edad.innerText = datosPersona.edad;

  let ciudad = document.querySelector("#ciudad");
  ciudad.innerText = datosPersona.ciudad;

  let js = document.querySelector("#javascript");
  js.innerText = datosPersona.interesPorJs;
  
}


function recorrerListadoYRenderizarTarjetas() {
  /* ------------------ PUNTO 3: Escribe tu codigo desde aqui ------------------ */
  let fila = document.querySelector("#fila");
  listado.forEach( lista => {
    fila.innerHTML += 
    `
      <div class='caja'>
        <img src='${lista.imgUrl}' alt='${lista.lenguajes}' />
        <p class='lenguajes'>${lista.lenguajes}</p>
        <p class='bimestre'>${lista.bimestre}</p>
      </div>
    ` 
  });
  materiasBtn.disabled = true;
}

function alternarColorTema() {
  /* --------------------- PUNTO 4: Escribe tu codigo aqui --------------------- */
  let sitio = document.querySelector("#sitio");
  sitio.classList.toggle("dark");
}

/* --------------------- PUNTO 5: Escribe tu codigo aqui --------------------- */
window.addEventListener('keypress', (evento) => {
  if(evento.key.toLowerCase() === "f" ) {
    let sobremi = document.querySelector("#sobre-mi");
    sobremi.classList.remove("oculto");
  }
});
