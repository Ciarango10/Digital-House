for(let i = 11; i <= 50; i++) {
    if (esPrimo(i)) console.log(i);
}

function esPrimo(numero){
    let i = numero-1;
    while(i > 1){
        if (numero % i === 0) return false;
        i--;
    }
    return true;
}