// EJERCICIO #1
const autos = [
    {
        marca: 'Toyota',
        modelo: 2022,
        color: 'rojo'
    },
    {
        marca: 'Renault',
        modelo: 2015,
        color: 'gris'
    },
    {
        marca: 'Peugeot',
        modelo: 2017,
        color: 'rojo'
    },
    {
        marca: 'Fiat',
        modelo: 2020,
        color: 'negro'
    }
]

function autosMayor2020 (arreglo) {
    let arregloNuevo = [];
    for (let i = 0; i < arreglo.length; i++) {
        if (arreglo[i].modelo >= 2020) {
            arregloNuevo.push(arreglo[i]);
        }
    }
    return arregloNuevo;
} 
console.log(autosMayor2020(autos));

// EJERCICIO #2
let arrayDeNumeros = [10, 22, 3, 8, 9, 104, 5, 6, 7, 15];
console.log(arrayDeNumeros);

function bubbleSort (arreglo, texto) {
    if (texto === "ASC") {
        for (let i = 0; i < arreglo.length; i++) {
            for (let j = 0; j < arreglo.length-1; j++) {
                if (arreglo[j] > arreglo[j+1]) {
                    let temp = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = temp;
                }
            }
        }
    } else if (texto === "DESC") {
        for (let i = 0; i < arreglo.length; i++) {
            for (let j = 0; j < arreglo.length-1; j++) {
                if (arreglo[j] < arreglo[j+1]) {
                    let temp = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = temp;
                }
            }
        }
    }
    return arreglo;
}
console.log(bubbleSort(arrayDeNumeros, "ASC"));
console.log(bubbleSort(arrayDeNumeros, "DESC"));

// EJERCICIO #3
let matrix = [
    [1, 4, 7, 4],
    [5, 7, 6, 2],
    [6, 2, 3, 3],
    [2, 6, 8, 1],
]

// 1)
function elementosColumna (matriz, posicionColumna) {
    let arregloColumna = [];
    for (let i = 0; i < matriz.length; i++) {
        arregloColumna.push(matriz[i][posicionColumna]); 
    }
    return arregloColumna;
}
console.log(elementosColumna(matrix, 3));

// 2) 
console.table(matrix);
function cambiarImpar(matriz) {
    for (let i = 0; i < matriz.length; i++) {
        for (let j = 0; j < matriz[i].length; j++) {
            if (matriz[i][j] % 2 != 0) {
                matriz[i][j] = 0;
            }
        }
    }
}
cambiarImpar(matrix);
console.table(matrix);


