function loopDePares(numero){
    for (let i = 0; i<=100; i++){
        console.log(i);
        if((numero + i) % 2 == 0){
            console.log("El número " + (numero + i) + " es par");
        }
    }
}
loopDePares(1);

function loopDeImpares(numero,palabra){
    for (let i = 0; i <= 100; i++) {
        console.log(i);
        if((numero + i) % 2 != 0){
            console.log(palabra);
        }
    }
}
loopDeImpares(5,"Impar");

function sumatoria(numero){
    let i = numero;
    while (i > 1){
        numero+= i-1;
        i--;
    }
    return numero;
}
console.log(sumatoria(8));

function nuevoArreglo(numero){
    let arreglo = [];
    for (let i = 1; i <= numero; i++){
        arreglo.push(i);
    }
    return arreglo;
}
console.log(nuevoArreglo(10));

function split(string){
    let arreglo = [];
    for (let i = 0; i < string.length; i++){
        arreglo.push(string[i]);
    }
    return arreglo;
}
console.log(split("hola"));

function arrayHandler(array1, array2){
    for (let i = 0; i < array1.length; i++){
        console.log(`Soy ${array1[i]} y yo soy ${array2[i]}`);
    }
}
arrayHandler([1,2,3,4],["h","o","l","a"]);

function palindromo(palabra){
    for (let i = 0, j = palabra.length-1; i < palabra.length; i++,j--){
        if(palabra[i].toLowerCase() != palabra[j].toLowerCase()){
            return false;
        }
    }
    return true;
}
console.log(palindromo("Ana"));
