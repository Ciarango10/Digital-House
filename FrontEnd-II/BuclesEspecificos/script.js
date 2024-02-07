let personaje = {
    nombre: "Luke",
    apellido: "Skywalker",
    edad: 25
}

let series = ["The Mandalorian", "The Office", "Breaking Bad"];

//FOR-IN
for (let caracteristica in personaje) {
    console.log(caracteristica); //PROPIEDADES
    console.log(personaje[caracteristica]); //VALOR DE LAS PROPIEDADES
}

//FOR-OF
for(let serie of series) {
    console.log(serie);
}
