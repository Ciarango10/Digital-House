//Funcion Flecha sin parametro
let bienvenido = () => "Bienvenido";
console.log(bienvenido());

//Funcion Flecha con un parametro
let edad = añoNacimiento => 2023 - añoNacimiento;

let año = 2005;
console.log(edad(año));

//Funcion Flecha con mas de un parametro
let nombreCompleto = (nombre, apellido) => nombre + " " + apellido;

let nombre = "Carlos";
let apellido = "Arango";
console.log(nombreCompleto(nombre,apellido));

//Funcion Flecha multilinea
let horaActual = () => {
    let fecha = new Date();
    return fecha.getHours() + ":" + fecha.getMinutes();
}
console.log(horaActual());