let butacasCine = [
    ["ocupado", "libre", "libre", "libre"],
    ["libre", "libre", "libre", "libre"],
    ["libre", "libre", "ocupado", "ocupado"],
    ["ocupado", "ocupado", "ocupado", "ocupado"],
    ["libre", "libre", "libre", "libre", "ocupado"]
];
// Recorrer filas 
butacasCine.length;
// Recorrer columnas
butacasCine[0].length;

// Recorrer por fila
for (let fila = 0; fila < butacasCine.length; fila++) {
    for (let columna = 0; columna < butacasCine[fila].length; columna++) {
        console.log(butacasCine[fila][columna]);
    }
}

// Recorrer por Columna
for (let columna = 0; columna < butacasCine[0].length; columna++) {
    for (let fila = 0; fila < butacasCine.length; fila++) { 
        console.log(butacasCine[fila][columna]);
    }
}