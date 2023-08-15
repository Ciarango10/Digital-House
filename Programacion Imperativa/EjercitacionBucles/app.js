function numerosSiguientes(n){
    for (let i = 1; i <= 10; i++)
    {
        console.log(n+i);
    }
}
numerosSiguientes(4);

function imprimirNumerosDeATres(){
    for (let i = 5; i <= 20; i += 3) {
        console.log(i);
    }
}
imprimirNumerosDeATres();

function sumatoria() {
    let suma = 0;
    for (let i = 0; i <= 100; i++) {
        suma += i;
    }
    console.log(suma);
}
sumatoria();

function factorial(numero) {
    if (numero == 0) return 1;
    else {
        for (let i = numero; i > 1; i--){
            numero *= (i-1);
        }
        return numero;
    }
}
console.log(factorial(4));

function fibonacci(n) {
    let resultado = 0;
    if(n === 0) resultado = 0;
    if(n === 1) resultado = 1;
    
    let prev = 0;
    let actual = 1;

    let i = 2;
    
    while (i <= n){
        resultado = actual + prev;
        prev = actual;
        actual = resultado;
        i++;
    }
    return actual;
    
}
console.log(fibonacci(8));