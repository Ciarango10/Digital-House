const prompt = require("prompt-sync")({sigint:true});

let nombre = prompt("Ingrese su nombre: ");
console.log(`Hola ${nombre}!!!`);
