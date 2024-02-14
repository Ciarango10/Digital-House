let titulo = document.querySelector("h1");
titulo.innerHTML += ' Soy un contenido nuevo desde JS';

//VERIFICAMOS SI EL TITULO TIENE LA CLASE 
if(titulo.classList.contains('titulo-destacado')) {
  //REMOVER UNA CLASE
  titulo.classList.remove('titulo-destacado');  
} else {
  //AGREGAR UNA CLASE
  titulo.classList.add('titulo-destacado');
}

//SI LA CLASE NO ESTA PRESENTE, LA AGREGA; SI YA ESTA PRESENTA, LA ELIMINA
titulo.classList.toggle('fondo');





