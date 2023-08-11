const prompt = require("prompt-sync")({sigint:true});

// //Declaracion de funciones
function inchesToCm(pulgadas){
    return pulgadas * 2.54;
}

function url(string){
    return "http://www." + string + ".com"
}

function admiracion(string){
    return `${string}!`
}

function edadPerruna(edad){
    return edad * 7;
}

function valorHora(sueldo){
    return sueldo / 40;
}

function calculadorIMC(altura, peso){
    return (peso / (altura * altura));
}

let pulgadas = prompt("Ingrese las pulgadas: ");
console.log(inchesToCm(pulgadas));

let string = prompt("Ingrese el nombre de la url: ");
console.log(url(string));

let palabra = prompt("Ingrese la palabra para añadir admiracion: ");
console.log(admiracion(palabra));

let edadPerro = prompt("Ingrese la edad de su perro: ");
console.log(edadPerruna(edadPerro));

let horaTrabajo = prompt("Ingrese su sueldo mensual: ");
console.log(valorHora(horaTrabajo));

let altura = prompt("Ingrese su altura en cm: ");
let peso = prompt("Ingrese su peso en kg: ");

console.log(calculadorIMC(altura, peso));

//Funciones flecha
let minToMayus = string => string.toUpperCase();

let type = variable => typeof variable;

let circunferencia = radio => 2 * Math.PI * radio;

let min = prompt("Ingrese la palabra en minusculas: ");
console.log(minToMayus(min));

let tipoDato = prompt("Ingrese el tipo de dato: ");
console.log(type(tipoDato));

let radio = prompt("Ingrese el radio del circulo: ");
console.log(circunferencia(radio));