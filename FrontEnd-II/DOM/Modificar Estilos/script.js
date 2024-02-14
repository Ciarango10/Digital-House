let confirmaCambios = confirm("Queres cambiar el color del titulo?");
if(confirmaCambios) {
  let titulo = document.querySelector("h1");
  titulo.innerHTML += ' Soy un contenido nuevo desde JS';
  
  //EDITAR LOS ESTILOS DEL HTML DESDE JS 
  titulo.style.color = "crimson";
  titulo.style.fontSize = "50px";

  let eliminarPropiedad = confirm("Queres eliminar la propiedad de color?");
  if(eliminarPropiedad) {
    //ELIMINAR UNA PROPIEDAD DE LOS ESTILOS 
    titulo.style.color = "";
  }
} 



