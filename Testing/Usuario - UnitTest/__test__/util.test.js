const {generateText} = require('../util.js');

describe('Pruebas de salida de datos', () => {
    test('Salida de Nombre y Edad', () => {
        const text = generateText('Carlos', 18);
        expect(text).toBe('Carlos (18 years old)');
    });
});

