let peliculas = ["star wars", "totoro", "rocky", "pulp fiction", "la vida es bella"];

function toMayus(array){
    let mayus = [];
    for (let i = 0; i < array.length; i++){
        mayus[i] = array[i].toUpperCase();
    }
    return mayus;
}

peliculas = toMayus(peliculas);
console.log(peliculas);

let peliculasAnimadas = ["toy story", "finding Nemo", "kung-fu panda", "wally", "fortnite"];

let juego = peliculasAnimadas.pop();
console.log(juego);

function fusion(array, array2){
    for(let i=0; i < array2.length; i++){
       array.push(array2[i].toUpperCase());
    }
    return array;
}

peliculas = fusion(peliculas,peliculasAnimadas);
console.log(peliculas);

const asiaScores = [8, 10, 6, 9, 10, 6, 6, 8, 4];
const euroScores = [8, 10, 6, 8, 10, 6, 7, 9, 5];

function comparar(calificacion1,calificacion2){
    let diferente = 0;
    for (let i = 0; i < calificacion1.length; i++){
       if(calificacion1[i] !== calificacion2[i]){
            diferente++;
       } 
    }
    if(diferente > 0){
        console.log("Los arreglos son diferentes");
    }else{
        console.log("Los arreglos son iguales");
    }
}
comparar(asiaScores,euroScores);

//EXTRAS-------------------------------------------------

function imprimirInverso(array){
    for (let i = array.length; i >= 0; i--){
        console.log(array[i]);
    }
}
imprimirInverso(asiaScores);

function inversor(array){
    let invertido = [];
    for (let i = array.length -1; i >= 0; i--){
        invertido.push(array[i]);
    }
    return invertido;
}
console.log(inversor(asiaScores));

let suma = [-5,100,19];
function sumaArray(arreglo){
    total = 0;
    for (let i = 0; i < arreglo.length; i++){
        total += arreglo[i];
    }
    return total;
}
console.log(sumaArray(suma));

let letras = ["c","h","a","u"];
function join(arreglo){
    let palabra = "";
    for (let i = 0; i < arreglo.length; i++){
        palabra += arreglo[i];
    }
    return palabra;
}
console.log(join(letras));


