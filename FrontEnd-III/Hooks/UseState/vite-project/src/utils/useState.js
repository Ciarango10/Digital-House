// Este método no es el Hook de React Real, sino una representación
export const useState = (valorInicial) => {
  let estado = valorInicial;

  function modificarEstado(nuevoValor) {
    estado = nuevoValor;
    // Vuelve a renderizar el componente que contiene al estado
  }

  return [estado, modificarEstado];
};
//Esto es una representación básica de useState
