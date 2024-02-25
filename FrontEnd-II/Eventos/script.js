//FORMAS DE USAR EVENTOS
window.addEventListener("load", function () {
    let youtubeButton = this.document.querySelector(".youtube-button"); // OBTENEMOS EL BOTON
    youtubeButton.addEventListener("click", function (e) { //EVENTO CLICK DEL BOTON 
        console.log(e.target.id); //OBTENER EL ID DEL BOTON
        alert("Nos redirigimos hacia Youtube");
    });

    let googleButton = this.document.querySelector(".google-button"); // OBTENEMOS EL BOTON
    googleButton.addEventListener("click", function(e) { //EVENTO CLICK DEL BOTON 
        
        e.preventDefault(); // EVITA QUE SE EJECUTE EL EVENTO PREDETERMINADO

        console.log(this);

        alert("No nos redirigimos hacia Google");
    })
});

// OTRA FORMA DE USAR EVENTOS, PERO SOLO SE EJECUTA UNA POR ARCHIVO
window.onload = function () {

}

// EVENTOS DEL MOUSE 

// MOUSEOVER
let botonMouse = document.querySelector(".mouse-button");
botonMouse.addEventListener("mouseover", function() {
    alert('pasaste el mouse');
});

// MOUSEOUT
botonMouse.addEventListener("mouseout", function() {
    alert('quitaste el mouse');
});

// EVENTOS DEL TECLADO 

// KEYDOWN
let inputTeclado = document.querySelector(".keyboard-input");
inputTeclado.addEventListener("keydown", function(e) {
    alert("Se presionó la tecla: "+ e.key);
});

//KEYUP
inputTeclado.addEventListener("keyup", function(e) {
    alert("Se soltó la tecla:: "+ e.key);
});

//KEYPRESS
inputTeclado.addEventListener("keypress", (e) => {
    console.log(e);
    alert("Se presionó la tecla: "+ e.key);
});

