//TODAS LAS FUNCIONAS SE EJECUTAN SOBRE UN ARRAY Y RECIBEN COMO UN PARAMETRO UN CALLBACK
let notas = [10,4,5,8,9,2,7];

// MAP(CALLBACK(ELEMENTO)) => RECORRE EL ARRAY Y RETORNA UN NUEVO ARRAY MODIFICADO
let notasHastaEl100 = notas.map(function(numero) {
    return numero * 10;
});
console.log(notasHastaEl100);

// FILTER(CALLBACK(ELEMENTO)) => RETORNA UN ARRAY CON LOS ELEMENTOS QUE CUMPLAN LA CONDICION
let notasAprobadas = notas.filter(function(numero) {
    return numero >= 7;
});
console.log(notasAprobadas);

// REDUCE(CALLBACK(ACUMULADOR, ELEMENTO)) => RECUCIR A LA MAS MINIMA EXPRESION EL ARRAY DADO, RETORNANDO UN UNICO VALOR
let sumaNotas = notas.reduce(function(estado, numero){
    return estado + numero;
});
console.log(sumaNotas);

// FOREACH(CALLBACK(ELEMENTO)) => ITERA SOBRE UN ARRAY DADO SIN RETORNAR NADA
notas.forEach(function(valor, indice){
    console.log(`En la posicion ${indice} tengo el valor ${valor}`);
});