//LENGTH
//Retornar cantidad de caracteres
let nombre = "Carlos";
console.log(nombre.length);

//Los espacios cuentan como un caracter
let serie = "Breaking bad";
console.log(serie.length)

//INDEX OF
//Devuelve el índice donde está el texto a buscar, si no existe devuelve -1.
let saludo = "Hola Estamos Programando";
console.log(saludo.indexOf("Estamos"));

//SLICE()
//Corta el string y devuelve la parte del string donde se aplica
let frase = "Breaking bad";
console.log(frase.slice(0,3)); //Devuelve los caracteres en la posicion entre 0 y 3 sin contar el 3
console.log(frase.slice(9)); //Devuelve todos los caracteres restantes desde la posicion 9
console.log(frase.slice(-10)); //Empieza en la posición n contando desde atrás hasta el final.

//TRIM()
//Elimina los espacios al principio y final de un string, no quita los espacios del medio
let nombreCompleto = "    Homero Simpson    ";
console.log(nombreCompleto.trim());

//REPLACE()
//Remplaza la parte del string por otra, recibe dos string como parametros
let oracion = "Aguante Python!";
console.log(oracion.replace("Python","JS"));

//SPLIT()
//Divide un string en partes, recibe un string que se usara como separador de las partes
let cancion = "And bingo was his name, oh!";
console.log(cancion.split(', '))//Separa el string por cada coma que encuentre


//Devuelve miTexto, pero convirtiendo todo a mayúsculas.
console.log(cancion.toUpperCase());
