let numeros = [6, 5, 1, 2, 4, 3, 8, 7];

for (let i = 0; i < numeros.length; i++) {
  for (let j = 0; j < numeros.length -1; j++) {
    if (numeros[j] > numeros[j + 1]) {
      let temp = numeros[j];
      numeros[j] = numeros[j + 1];
      numeros[j + 1] = temp;
    }
  }
}
console.log(numeros);