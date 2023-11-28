const { generateText, validateInput } = require('../util.js');

describe('Pruebas Positivas', () => {
    test('Salida de datos edad >= a 18 y edad <= a 65', () => {
        const text = generateText('Carlos',18,'Licenciatura');
        expect(text).toBe('Registro OK de Carlos en: Licenciatura.');
    });
    test('Inputs no vacio o null', () => {
        const input = validateInput('Comida', true);
        expect(input).toBeTruthy();
    });
});

describe('Pruebas Negativas', () => {
    test('Salida de datos edad > a 65', () => {
        const text = generateText('Iván',66,'Maestría');
        expect(text).toBe('No pudimos registrar a: Iván. Por favor contactá a soporte@dh.com para más información.');
    });
    test('Salida de datos edad no valida', () => {
        const text = generateText('Carlos',17,'Doctorado');
        expect(text).toBe('Edad ingresada no válida. Por favor intentá nuevamente.');
    });
    test('Input null', () => {
        const input = validateInput(null, true);
        expect(input).toBeFalsy();
    });
    test('Input vacio', () => {
        const input = validateInput('', true);
        expect(input).toBeFalsy();
    });
    test('Input undefined', () => {
        const input = validateInput(undefined, true);
        expect(input).toBeFalsy();
    });
    test('Input vacio con espacio', () => {
        const input = validateInput(' ', true);
        expect(input).toBeFalsy();
    });
});