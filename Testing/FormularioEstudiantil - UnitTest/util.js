exports.generateText = (name, age, level) => {
  // Se crea un objeto con los datos del registro y se retorna un mensaje con el estado del registro
  if(age >= 18 && age <= 65) {
    student = {
      "name": name,
      "age": true,
      "level": level
    }; 
    return `Registro OK de ${student.name} en: ${student.level}.`;
  }
  if(age>65) {
    student = {
      "name": name,
      "age": false,
      "level": null
    }; 
    return `No pudimos registrar a: ${student.name}. Por favor contactá a soporte@dh.com para más información.`;
  }
  return `Edad ingresada no válida. Por favor intentá nuevamente.`
};

exports.validateInput = (text, notEmpty) => {
  //Valida la entrada de datos en los inputs
  if (!text) {
    return false;
  }
  if (notEmpty && text.trim().length === 0) {
    return false;
  }
  return true;
};