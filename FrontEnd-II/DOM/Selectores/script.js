//ENCONTRAR EL PRIMER ELEMENTO DENTRO DE UN DOCUMENTO HTML QUE COINCIDE CON UN SELECTOR CSS ESPECIFICO.
let elh1 = document.querySelector('h1');
console.log(elh1);

let navBar = document.querySelector('.nav-bar');
if(navBar != null) {
    console.log(navBar);
}

let strong = document.querySelector('.parrafo-especial strong');
if (strong != null) {
    console.log(strong);
}

//PERMITE SELECCIONAR TODOS LOS ELEMENTOS DENTRO DE UN DOCUMENTO HTML QUE COINCIDEN CON UN SELECTOR CSS.
let losParrafos = document.querySelectorAll('p');
for (const unParrafo of losParrafos) {
    console.log(unParrafo);
}

//PERMITE OBTENER UNA REFERENCIA AL PRIMER ELEMENTO DENTRO DE UN DOCUMENTO HTML QUE COINCIDE CON ID ESPECIFICO.
let titulo = document.getElementById('titulo');
if(titulo != null) {
    console.log(titulo);
}