const prompt = require("prompt-sync")({sigint:true});
//Datos del negocio
let nombreLocal = "Granero Los Pacos";
let horaApertura = 8;
let horaCierre = 16;
let precioProducto = 16000;

//Datos ingresados por el cliente
let nombreComprador = prompt("Ingrese su nombre: ");
let producto = prompt("Ingrese el producto a comprar: ");
let dinero = prompt("Cuanto dinero tienes: ");
let horaActual = prompt("Ingrese la hora actual: ");

//Verificamos si el local esta abierto
if(horaActual >= horaApertura && horaActual <= horaCierre){
    //Calculo del cambio
    if (dinero >= precioProducto){
        console.log(`
        --------RECIBO DE PAGO------- 
        Local: ${nombreLocal}
        Cliente: ${nombreComprador}
        Producto: ${producto}
        Precio: ${precioProducto}
        Dinero: ${dinero}
        Cambio: ${(dinero - precioProducto )} pesos
        Hora: ${horaActual}
        Gracias por su compra!`
        );
    }else {
        console.log("No te alcanza el dinero para comprar este producto")
    }
}else {
    console.log("El local se encuentra cerrado, vuelve mas tarde");
}

//DESAFIO EXTRA
let remeras = "pantalones";
let pantalones = "remeras";
let escritorio;

//Imprimimos el orden actual
console.log(`
Cajon Remeras: ${remeras}
Cajon Pantalones: ${pantalones}`
);

//Ponemos las pantalones en el escritorio
escritorio = remeras;
//Ponemos las remeras en donde estaban los pantalones
remeras = pantalones;
//Ponemos los pantalones en donde estaban las remeras
pantalones = escritorio;

//Organizado
console.log(`
Cajon Remeras: ${remeras}
Cajon Pantalones: ${pantalones}`
);


