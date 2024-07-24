const lista = [
    "The big lebowski",
    "Mean Girls",
    "Die Hard",
    "Hot Fuzz",
    "Kill Bill",
    "John Wick",
    "Shrek",
    "Ted",
    "The Godfather",
    "Avengers",
    "Amelie",
    "The Dark Knight",
    "Angry Men",
    "Flashback",
    "Luca",
    "Cruella",
    "Pulp Fiction",
    "The Good, the Bad and the Ugly",
    "Fight Club",
    "Forrest Gump",
    "Inception",
    "Goodfellas",
    "Life Is Beautiful",
    "Spirited Away",
    "Interstellar",
    "The Pianist",
    "etc",
  ];

//   lista.forEach((item) => {
//     console.log(item);
//   });
//   const arrMap = lista.map((peli) => {
//     return `<li>${peli}</li>`;
//   });
//   const contenedorUl = `<ul>${lista
//   .map((peli) => `<li>${peli}</li>`)
//   .join("")}</ul>`;

//   console.log(arrMap);
//   console.log(contenedorUl);
  
  document.getElementById("root").innerHTML = `<ul>${lista
    .map((peli) => `<li>${peli}</li>`)
    .join("")}</ul>`;
  