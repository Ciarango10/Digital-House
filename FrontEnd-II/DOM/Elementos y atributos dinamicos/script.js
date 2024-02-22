//Seleccionamos un elemento del HTML
let elemento = document.querySelector("#portada");

//Consultamos si tiene un atributo src
elemento.hasAttribute("src"); // true

//Pedimos el valor del atributo
elemento.getAttribute("src"); // imagen_portada.jpg

//Pedimos el valor del atributo
elemento.removeAttribute("src");

//Pedimos el valor del atributo
elemento.setAttribute("src", "imagenportada.jpg");