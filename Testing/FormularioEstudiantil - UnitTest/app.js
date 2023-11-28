const { generateText, validateInput } = require('./util');

createElement = (type, text, className) => {
  // Crea y retorna un nuevo elemento HTML
  const newElement = document.createElement(type);
  newElement.classList.add(className);
  newElement.textContent = text;
  return newElement;
};

const initApp = () => {
  // Permite inicializar el aplicativo
  // y tiene un "listener" para cuando se le de click al botón "Agregar estudiante"
  const newUserButton = document.querySelector('#btnAddUser');
  newUserButton.addEventListener('click', addUser);
};

const addUser = () => {
  //Se crea un nuevo elemento HTML en el DOM cada vez que se agregue un estudiante
  const newUserNameInput = document.querySelector('input#name');
  const newUserAgeInput = document.querySelector('input#age');
  const newUserLevelInput = document.querySelector('#userLevel');

  if (
    !validateInput(newUserNameInput.value, true, false) ||
    !validateInput(newUserAgeInput.value, false, true)
  ) {
    return;
  }

  const userList = document.querySelector('.user-list');
  const outputText = generateText(
    newUserNameInput.value,
    newUserAgeInput.value,
    newUserLevelInput.value,
  );
  const element = createElement('li', outputText, 'user-item');
  userList.appendChild(element);
};

// Inicializa el aplicativo
initApp();