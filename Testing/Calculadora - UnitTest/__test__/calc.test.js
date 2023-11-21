const suma = require('../calc.js');

describe('Prueba de sumas', () => {
    test('Suma de dos numeros', () => {
        expect(suma(1,2)).toBe(3);
    });

    test('Suma de ceros', () => {
        expect(suma(0,0)).toBe(0);
    });

    test('Suma de null', () => {
        expect(suma(null,null)).toBe(0);
    });

    test('Suma de texto', () => {
        expect(suma('a','b')).toBe(0);
    });
});


