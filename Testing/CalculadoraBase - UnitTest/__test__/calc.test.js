const {suma,resta,multiplicacion,division} = require('../calc.js');

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

    test('Suma de strings', () => {
        expect(suma('a','c')).toBe(0);
    });
    
    test('Suma de undefined', () => {
        expect(suma(undefined,undefined)).toBe(0);
    });

    test('Suma de numerico mas texto', () => {
        expect(suma(10,'a')).toBe(0);
    });
});

describe('Prueba de restas', () => {
    test('Resta de dos numeros', () => {
        expect(resta(10,5)).toBe(5);
    });

    test('Resta de ceros', () => {
        expect(resta(0,0)).toBe(0);
    });

    test('Resta de null', () => {
        expect(resta(null,null)).toBe(0);
    });

    test('Resta de strings', () => {
        expect(resta('a','c')).toBe(0);
    });

    test('Resta de undefined', () => {
        expect(resta(undefined,undefined)).toBe(0);
    });

    test('Resta de numerico mas texto', () => {
        expect(resta(10,'a')).toBe(0);
    });
});

describe('Prueba de multiplicacion', () => {
    test('Multiplicacion de dos numeros', () => {
        expect(multiplicacion(10,5)).toBe(50);
    });

    test('Multiplicacion de ceros', () => {
        expect(multiplicacion(0,0)).toBe(0);
    });

    test('Multiplicacion de null', () => {
        expect(multiplicacion(null,null)).toBe(0);
    });

    test('Multiplicacion de strings', () => {
        expect(multiplicacion('a','c')).toBe(0);
    });

    test('Multiplicacion de undefined', () => {
        expect(multiplicacion(undefined,undefined)).toBe(0);
    });

    test('Multiplicacion de numerico mas texto', () => {
        expect(multiplicacion(10,'a')).toBe(0);
    });
});

describe('Prueba de division', () => {
    test('Division de dos numeros', () => {
        expect(division(10,5)).toBe(2);
    });

    test('Division de ceros', () => {
        expect(division(0,0)).toBe(0);
    });

    test('Division de null', () => {
        expect(division(null,null)).toBe(0);
    });

    test('Division de strings', () => {
        expect(division('a','c')).toBe(0);
    });

    test('Division de undefined', () => {
        expect(division(undefined,undefined)).toBe(0);
    });

    test('Division de numerico mas texto', () => {
        expect(division(10,'a')).toBe(0);
    });
});
