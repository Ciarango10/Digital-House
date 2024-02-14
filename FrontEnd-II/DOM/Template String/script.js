function escribirHTML(titulo, texto) {
    const body = document.getElementById('body');
    const miTemplate = `
      <h1>${titulo}</h1>
      <p>${texto}</p>
    `;
    body.innerHTML += miTemplate;
  }  
  
  escribirHTML('Hola', 'Esto es un ejemplo de template string en html.');
  escribirHTML('Es dinámico', 'Podemos insertar elementos HTML mediante <b>JavaScript</b>');
  escribirHTML('Facilita la programación', 'Evita escribir mucho código y reutilizar el que si escribamos.');
  escribirHTML('En este ejemplo', 'Hemos utilizado una única función para poder escribir 4 veces en HTML, ¿te imaginás lo que sería esto sin esta función?');