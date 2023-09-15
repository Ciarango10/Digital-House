// EJERCICIO 1
let likes = [45, 67, 12, 89, 34, 56, 78, 90, 23, 67, 45, 12, 78, 56, 34];
for (let i = 0; i < likes.length; i++) {
    for (let j = 0; j < likes.length-1; j++) {
        if (likes[j] > likes[j+1]) {
            let temp = likes[j];
            likes[j] = likes[j+1];
            likes[j+1] = temp;
        }
    }
}
console.log(`La mayor cantidad de likes obtenidos fue: ${likes[likes.length-1]} likes`);
console.log(`La segunda mayor cantidad de likes obtenidos fue: ${likes[likes.length-2]} likes`);
console.log(`La Tercera mayor cantidad de likes obtenidos fue: ${likes[likes.length-3]} likes`);
console.log(`La menor cantidad de likes obtenidos fue: ${likes[0]} likes`);

//EJERCICIO 2
const temperaturas = [
    { dia: 1, mes: 9, maxima: 30, minima: 20 },
    { dia: 2, mes: 9, maxima: 28, minima: 18 },
    { dia: 3, mes: 9, maxima: 32, minima: 22 },
    { dia: 4, mes: 9, maxima: 40, minima: 10 },
];
// A) Ordenar por temperatura mínima de menor a mayor.
for (let i = 0; i < temperaturas.length; i++) {
    for (let j = 0; j < temperaturas.length-1; j++) {
        if (temperaturas[j].minima > temperaturas[j+1].minima) {
            let temp = temperaturas[j];
            temperaturas[j] = temperaturas[j+1];
            temperaturas[j+1] = temp;
        }
    }
}
console.log(temperaturas);

// B) Ordenar por temperatura máxima de mayor a menor.
for (let i = 0; i < temperaturas.length; i++) {
    for (let j = 0; j < temperaturas.length-1; j++) {
        if (temperaturas[j].maxima < temperaturas[j+1].maxima) {
            let temp = temperaturas[j];
            temperaturas[j] = temperaturas[j+1];
            temperaturas[j+1] = temp;
        }
    }
}
console.log(temperaturas);
