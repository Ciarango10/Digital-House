const setErrors = (message, field, isError = true) => {
    if(isError) {
        field.classList.add("invalid");
        field.nextElementSibling.classList.add("error");
        field.nextElementSibling.textContent = message;
    }else {
        field.classList.remove("invalid");
        field.nextElementSibling.classList.remove("error");
        field.nextElementSibling.textContent = "";
    }
}

// Creamos un metodo para verificar si el input esta vacio
const isEmpty = (message, e) => {
    const field = e.target;
    const fieldValue = field.value;

    if(fieldValue.length == 0) {
        setErrors(message, field);
    }
}

/* ---------------------------------- texto --------------------------------- */
function validarTexto(e) {
    const field = e.target;
    const fieldValue = field.value; 

    const regex = new RegExp(/[^a-záéíóúñü ]/i);

    if (!regex.test(fieldValue)) {
        console.log("Cumple la validacion adelante");
        setErrors("", field, false);
    } else {
        console.log("No cumple la validacion CORRIGELO");
        setErrors(`Por favor ingrese un ${field.name} valido`, field);
    }
}

function normalizarTexto(texto) {
    let textoNormalizado = texto;
    // Reemplazamos cualquier secuencia de espacios en blanco con un solo espacio
    textoNormalizado = textoNormalizado.replace(/\s+/g, ' ');

    // Separamos el nombre en palabras
    var palabras = texto.split(' ');

    // Capitalizamos la primera letra de cada palabra y dejamos el resto en minúsculas
    for (var i = 0; i < palabras.length; i++) {
        palabras[i] = palabras[i].charAt(0).toUpperCase() + palabras[i].slice(1);
    }

    // Unimos las palabras de nuevo en una cadena
    textoNormalizado = palabras.join(' ');

    // Mostramos el nombre formateado
    console.log('El nombre formateado es: ', textoNormalizado);
    return textoNormalizado;
}

/* ---------------------------------- email --------------------------------- */
function validarEmail(e) {
    const field = e.target;
    const fieldValue = normalizarEmail(field.value);
    console.log(fieldValue);

    const regex = new RegExp(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/);
    //console.log(regex.test(fieldValue));
    if(fieldValue.length > 4 && regex.test(fieldValue)){
        console.log("Cumple la validacion adelante");
        setErrors("", field, false);
    }else {
        console.log("No cumple la validacion CORRIGELO");
        setErrors(`Por favor ingrese un ${field.name} valido`, field);
    }
}

function normalizarEmail(email) {
    return email.trim().toLowerCase();
}

/* -------------------------------- password -------------------------------- */
function validarContrasenia(e) {
    const field = e.target;
    const fieldValue = field.value;
    console.log(fieldValue);

    if(fieldValue.length < 6) {
        setErrors(`Por favor ingrese una ${field.name} valida que sea mayor a 6 caracteres`, field);
    }else {
        setErrors("", field, false);
    }
}

function compararContrasenias(e, contrasenia_2) {
    const field = e;
    let contrasenia_1 = field.value;
    if(contrasenia_1 != contrasenia_2) {
        setErrors(`Por favor ingrese una ${field.name} igual a la anterior`, field);
        return false;
    } else {
        setErrors("", field, false);
        return true;
    }
}

