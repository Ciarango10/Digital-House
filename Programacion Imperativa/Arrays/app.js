let notas = [3,5,10,9,8,8,8];
console.log(notas);

//PUSH----------------------------------
//Agregar elementos al final de un array
notas.push(1);
notas.push(2);
notas.push(4);

//UNSHIFT--------------------------------
//Agregar elementos al inicio de un array
notas.unshift(1)

//POP------------------------------------
//Extraer el ultimo elemento de un array
let ultimo = notas.pop();
console.log(ultimo);

//SHIFT----------------------------------
//Extraer el primer elemento de un array
let primer = notas.shift();
console.log(primer);

//INDEX OF--------------------------------
//Buscar en el array el elemento que recibe como parametro, retorna el primer indice donde lo encontró
let posicionOcho = notas.indexOf(8);
console.log(posicionOcho);

//Si el valor no se encuentra en el arreglo la respuesta es -1
let posicionNoEsta = notas.indexOf(7);
console.log(posicionNoEsta);

//LAST INDEX OF----------------------------
//Buscar en el array el elemento que recibe como parametro, retorna el primer indice donde lo encontró pero empieza a buscar desde el final del array (de atras hacia adelante)
let posicionOchoAlReves = notas.lastIndexOf(8);
console.log(posicionOchoAlReves);

//JOIN--------------------------------------
//Unificar todos los elementos presentes de un array, si no especificamos separador utiliza comas
let separadoPorComas = notas.join();
console.log(separadoPorComas);

let separadoPorGuion = notas.join('-');
console.log(separadoPorGuion);

//INCLUDES-----------------------------------
//Similar a index of, pero retorna un booleano. Si el elemento que buscabamos estaba en el array devulve true
let frutas = ['Manzana', 'Pera', 'Frutilla'];
console.log(frutas.includes('Frutilla'));
console.log(frutas.includes('Banana'));

