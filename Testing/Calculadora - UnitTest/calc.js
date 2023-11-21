function suma (a,b) {
    if(isNaN(a) || isNaN(b)) {
        return 0;
    } else {
        return a+b;
    }
}

module.exports = suma;
// //CASO PRUEBA #1
// console.assert(suma(1,2)==3, "Error: el resultado esperado de 1+2 es 3");
// //CASO PRUEBA #2
// console.assert(suma(0,0)==0, "Error: el resultado esperado de 0+0 es 0");

