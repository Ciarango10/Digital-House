let arrayMatriz = [];
let arrayX=["x0","x1","x2"];
let arrayY=["y0","y1","y2"];
arrayMatriz[0] = arrayX;
arrayMatriz[1] = arrayY;

//Mostrar la tabla
console.table(arrayMatriz);

for (let i=0; i<arrayMatriz.length; i++) {
    console.log(arrayMatriz[i]);
}

//Recorrer la columna
for (let i=0; i<arrayMatriz.length; i++) {
    console.log(arrayMatriz[i][0]);
}

//Recorrer la fila
for(let i=0; i<arrayMatriz[0].length; i++) {
    console.log(arrayMatriz[0][i]);
}

//Recorrer la matriz
for (let i=0; i<arrayMatriz.length; i++){
    for (let j=0; j<arrayMatriz[i].length; j++){
        console.log(arrayMatriz[i][j]);
    }
}


