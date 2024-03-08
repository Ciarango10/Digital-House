const jsonData = `
{
  "squadName": "Super hero squad",
  "homeTown": "Metro City",
  "formed": 2016,
  "secretBase": "Super tower",
  "active": true,
  "members": [
    {
      "name": "Molecule Man",
      "age": 29,
      "secretIdentity": "Dan Jukes",
      "powers": ["Radiation resistance", "Turning tiny", "Radiation blast"]
    },
    {
      "name": "Madame Uppercut",
      "age": 39,
      "secretIdentity": "Jane Wilson",
      "powers": [
        "Million tonne punch",
        "Damage resistance",
        "Superhuman reflexes"
      ]
    },
    {
      "name": "Eternal Flame",
      "age": 1000000,
      "secretIdentity": "Unknown",
      "powers": [
        "Immortality",
        "Heat Immunity",
        "Inferno",
        "Teleportation",
        "Interdimensional travel"
      ]
    }
  ]
}
`;

//Recorrer el JSON e insertar en el listado del html los nombres de los miembros
function recorrerMiembros() {
    //escribe la lógica
    let datos = JSON.parse(jsonData);
    let miembros = document.querySelector("#miembros");
    for (let i = 0; i < datos.members.length; i++) {
      miembros.innerHTML += 
      `<li>
        <h2>Héroe: ${datos.members[i].name}</h2>
        <h5>Identidad Ouclta: ${datos.members[i].secretIdentity}</h5>
        <p>Edad: ${datos.members[i].age}</p>
      </li>`
    };
}
recorrerMiembros();