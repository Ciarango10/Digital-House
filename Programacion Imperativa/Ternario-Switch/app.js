//If ternario
let fruta = "Manzana";

let resultado = fruta == "Manzana"? "La fruta es una manzana":"La fruta no es una manzana";
console.log(resultado);

//Switch
let semaforo = "Naranja";

switch(semaforo) {
    case "Verde":
        console.log("Puedes cruzar");
        break;
    case "Amarillo":
        console.log("Tener Precaucion");
        break;
    case "Naranja":
    case "Rojo":
        console.log("No cruces, hay que esperar");
        break;
    default:
        console.log("No funciona el semaforo");
}