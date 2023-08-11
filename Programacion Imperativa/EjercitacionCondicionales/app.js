const prompt = require("prompt-sync")({sigint:true});
function totalAPagar(vehiculo, litrosConsumidos){
    let total = 0;
    switch(vehiculo){
        case "coche":
            total = litrosConsumidos * 86;
            break;
        case "moto":
            total = litrosConsumidos * 70;
            break;
        case "autobus":
            total = litrosConsumidos * 55;
            break;
        default:
            console.log("Vehiculo no encontrado");
    }
    if (litrosConsumidos > 0 && litrosConsumidos <= 25){
        total += 50;
    } else if(litrosConsumidos > 25){
        total += 25;
    }
    return total;
}
console.log(totalAPagar("coche", 26));

function ventaSandwiches (sandwich, pan, queso,tomate,lechuga,cebolla, mayonesa, mostaza) {
    let precio = 0;
    switch(sandwich){
        case "pollo":
            precio = 150;
            break;
        case "carne":
            precio = 200;
            break;
        case "veggie":
            precio = 100;
        default: 
            console.log("No vendemos ese Sandwich");
    }
    switch(pan){
        case "blanco":
            precio+=50;
            break;
        case "negro":
            precio+=60;
            break;
        case "s/gluten":
            precio+=75;
            break;
        default:
            console.log("No tenemos ese tipo de pan");
    }
    if(queso) precio+=20;
    if(tomate) precio+=15;
    if(lechuga) precio+=10;
    if(cebolla) precio+=15;
    if(mayonesa) precio+=5;
    if(mostaza) precio+=5;

    return precio;
}
console.log(ventaSandwiches("pollo","blanco",true,true,false,true,false,true));

function numeroSecreto(numero){
    let secreto = Math.floor(Math.random() * 10 + 1);
    if (numero === secreto) {
        console.log("Felicitaciones, acertaste el numero!!");
    }else{
        console.log(`
        Tu numero: ${numero}
        Numero Secreto: ${secreto}
        Buena suerte para la proxima
        `);
    }
}
console.log(numeroSecreto(10));

function abrirParacaidas(velocidad, altura){
    if (velocidad < 1000 && (altura >= 2000 && altura < 3000)){
        console.log("El paracaidas debe abrirse");
    }
}
console.log(abrirParacaidas(900, 2000));

palabra = prompt("Ingrese la palabra a traducir: ");
function traductor(palabra){
    let word;
    switch(palabra){
        case "casa":
            word = "house";
            break;
        case "perro":
            word = "dog";
            break;
        case "pelota":
            word = "ball";
            break;
        case "arbol":
            word = "tree";
            break;
        case "genio":
            word = "genius";
            break;
        default:
            console.log("Palabra ingresada incorrecta");
            return;
    }
    return word;
}
console.log(traductor(palabra));

let valoracion = prompt("Ingresa tu valoracion de la pelicula: ");
function valoracionPelicula(puntaje){
    switch(puntaje.toLowerCase()){
        case "muy mala":
            console.log("Calificaste la película como Muy Mala. Lo lamentamos mucho.");
            break;
        case "mala":
            console.log("Calificaste la película como Mala. Lo lamentamos mucho.");
            break;
        case "mediocre":
            console.log("Calificaste la película como Mediocre. Lo lamentamos mucho.");
            break;
        case "buena":
            console.log("Calificaste la película como Buena. Nos alegra que te haya gustado.");
            break;
        case "muy buena":
            console.log("Calificaste la película como Muy Buena. Nos alegra que te haya encantado.");
            break;
        default:
            console.log("Ingresaste un valor inválido");
    }
    console.log("Gracias por su visita!");
}
console.log(valoracionPelicula(valoracion));

