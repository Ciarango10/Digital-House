//RANDOM
//Retorna un punto flotante, un número pseudoaleatorio dentro del rango [0, 1).
let randomEscalado = Math.random()*(100-1)+1; // 86.5806550233727
parseInt(randomEscalado); // 86

//ROUND
//Retorna el valor de un número redondeado al entero más cercano.
let num = Math.round(20.49); // 20
let aleatorio = Math.random()*(100-1)+1; // 86.5806550233727
Math.round(aleatorio); // 87

//MAX
//Retorna el mayor de cero o más números.
let numUno = Math.max(10, 20);   //  20
let numDos = Math.max(10, 20, 30.58);   //  30.58
let numTres = Math.max(10, 20, 30.58, "No");   //  NaN