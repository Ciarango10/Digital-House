//LEER O MODIFICAR EL CONTENIDO DE UNA ETIQUETA HTML, INCLUYENDO TANTO TEXTO COMO ETIQUETAS HTML DENTRO DEL ELEMENTO
let titulo = document.querySelector('h1');
console.log(titulo.innerHTML);
titulo.innerHTML += " Soy un contenido nuevo desde JS";

let parrafoEspecial = document.querySelector('.parrafo-especial');
parrafoEspecial.innerHTML = "Un texto con algo <i>en cursiva</i>"

//LEER O MODIFICAR EL CONTENIDO DE UNA ETIQUETA HTML, SIN INCLUIR ETIQUETAS HTML DENTRO DEL ELEMENTO
let parrafoEspecial2 = document.querySelector('.parrafo-especial2');
parrafoEspecial2.innerText = "Un texto con algo <i>en cursiva</i>"