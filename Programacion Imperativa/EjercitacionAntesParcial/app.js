const edades = [11, 12, 15, 18, 25, 22, 10, 33, 18, 5];

//Punto 1
function menores(arreglo){
    let menores = []
    for (let i = 0; i < arreglo.length; i++){
        if(arreglo[i] < 18){
            menores.push(arreglo[i]);
        }
    }
    return menores;
}
console.log(menores(edades));

function mayorIgual(arreglo){
    let mayorIgual = []
    for (let i = 0; i < arreglo.length; i++){
        if(arreglo[i] >= 18){
            mayorIgual.push(arreglo[i]);
        }
    }
    return mayorIgual;
}
console.log(mayorIgual(edades));

function igual(arreglo){
    let igual = []
    for (let i = 0; i < arreglo.length; i++){
        if(arreglo[i] == 18){
            igual.push(arreglo[i]);
        }
    }
    return igual;
}
console.log(igual(edades));

function mayor(arreglo){
    let valor = 0;
    for (let i = 0; i < arreglo.length; i++){
        if(i == 0){
            valor = arreglo[i];
        }
        if (valor < arreglo[i]){
            valor = arreglo[i];
        }
    }
    return valor;
}
console.log(mayor(edades));

function menor(arreglo){
    let valor = 0;
    for (let i = 0; i < arreglo.length; i++){
        if(i == 0){
            valor = arreglo[i];
        }
        if (valor > arreglo[i]){
            valor = arreglo[i];
        }
    }
    return valor;
}
console.log(menor(edades));

function promedio(arreglo){
    let sumatoria = 0;
    let promedio = 0;
    for (let i = 0; i < arreglo.length; i++){
        sumatoria += arreglo[i];
    }
    promedio = sumatoria / arreglo.length;
    return promedio;
}
console.log(promedio(edades));

function incrementar(arreglo){
    for (let i = 0; i < arreglo.length; i++){
        arreglo[i]+=1;
    }
    return arreglo
}
console.log(incrementar(edades));

//Punto 2
const arrayCuentas =
[
    {
      titular: "Arlene Barr",
      estaHabilitada: false,
      saldo: 3253.40,
      edadTitular: 33,
      tipoCuenta: "sueldo"
    },
    {
      titular: "Roslyn Torres",
      estaHabilitada: false,
      saldo: 3229.45,
      edadTitular: 27,
      tipoCuenta: "sueldo"
    },
    {
      titular: "Cleo Lopez",
      estaHabilitada: true,
      saldo: 1360.19,
      edadTitular: 34,
      tipoCuenta: "corriente"
    },
    {
      titular: "Daniel Malone",
      estaHabilitada: true,
      saldo: 3627.12,
      edadTitular: 30,
      tipoCuenta: "sueldo"
    },
    {
      titular: "Ethel Leon",
      estaHabilitada: true,
      saldo: 1616.52,
      edadTitular: 34,
      tipoCuenta: "sueldo"
    },
    {
      titular: "Harding Mitchell",
      estaHabilitada: true,
      saldo: 1408.68,
      edadTitular: 25,
      tipoCuenta: "corriente"
    }
]

function menor30(arreglo){
    let menores30 = []
    for (let i = 0; i < arreglo.length; i++){
        if (arreglo[i].edadTitular < 30){
            menores30.push(arreglo[i].edadTitular);
        }
    }
    return menores30;
}
console.log(menor30(arrayCuentas));

function mayorIgual30(arreglo){
    let mayorIgual30 = []
    for (let i = 0; i < arreglo.length; i++){
        if (arreglo[i].edadTitular >= 30){
            mayorIgual30.push(arreglo[i].edadTitular);
        }
    }
    return mayorIgual30;
}
console.log(mayorIgual30(arrayCuentas));

function menorIgual30(arreglo){
    let menorIgual30 = []
    for (let i = 0; i < arreglo.length; i++){
        if (arreglo[i].edadTitular <= 30){
            menorIgual30.push(arreglo[i].edadTitular);
        }
    }
    return menorIgual30;
}
console.log(menorIgual30(arrayCuentas));

function titularMenor(arreglo){
    let valor = 0;
    let titular = "";
    for (let i = 0; i < arreglo.length; i++){
        if(i == 0){
            valor = arreglo[i].edadTitular;
        }
        if (valor > arreglo[i].edadTitular){
            valor = arreglo[i].edadTitular;
            titular = arreglo[i].titular;
        }
    }
    return titular;
}
console.log(titularMenor(arrayCuentas));

function cuentasHabilitadas(arreglo){
    let habilitadas = [];
    for (let i = 0; i < arreglo.length; i++){
        if (arreglo[i].estaHabilitada === true){
            habilitadas.push(arreglo[i]);
        }
    }
    return habilitadas;
}
console.log(cuentasHabilitadas(arrayCuentas));

function cuentasDeshabilitadas(arreglo){
    let deshabilitadas = [];
    for (let i = 0; i < arreglo.length; i++){
        if (arreglo[i].estaHabilitada === false){
            deshabilitadas.push(arreglo[i]);
        }
    }
    return deshabilitadas;
}
console.log(cuentasDeshabilitadas(arrayCuentas));

function menorSaldo(arreglo){
    let saldo = 0;
    let cuenta = {
        titular: "",
        estaHabilitada: false,
        saldo: 0,
        edadTitular: 0,
        tipoCuenta: ""
    };
    for (let i = 0; i < arreglo.length; i++){
        if(i == 0){
            saldo = arreglo[i].saldo;
        }
        if (saldo > arreglo[i].saldo){
            saldo = arreglo[i].saldo;
            cuenta.titular = arreglo[i].titular;
            cuenta.estaHabilitada = arreglo[i].estaHabilitada;
            cuenta.saldo = arreglo[i].saldo;
            cuenta.edadTitular = arreglo[i].edadTitular;
            cuenta.tipoCuenta = arreglo[i].tipoCuenta;
        }
    }
    return cuenta;
}
console.log(menorSaldo(arrayCuentas));

function mayorSaldo(arreglo){
    let saldo = 0;
    let cuenta = {
        titular: "",
        estaHabilitada: false,
        saldo: 0,
        edadTitular: 0,
        tipoCuenta: ""
    };
    for (let i = 0; i < arreglo.length; i++){
        if(i == 0){
            saldo = arreglo[i].saldo;
        }
        if (saldo < arreglo[i].saldo){
            saldo = arreglo[i].saldo;
            cuenta.titular = arreglo[i].titular;
            cuenta.estaHabilitada = arreglo[i].estaHabilitada;
            cuenta.saldo = arreglo[i].saldo;
            cuenta.edadTitular = arreglo[i].edadTitular;
            cuenta.tipoCuenta = arreglo[i].tipoCuenta;
        }
    }
    return cuenta;
}
console.log(mayorSaldo(arrayCuentas));

//Extras
function generarId(array){
    for (let i = 0; i < array.length; i++){
        array[i].id = 1;
    }
    return array;
}
console.log(generarId(arrayCuentas));

function buscarPorId(array, id){
    for (let i = 0; i < array.length; i++){
        if(array[i].id === id){
            return array[i];
        }
    }
    return null;
}
console.log(buscarPorId(arrayCuentas, 1));

function filtrarPorSaldos(array, saldo){
    let debajoDelSaldo = []
    for (let i = 0; i < array.length; i++){
        if(array[i].saldo < saldo){
            debajoDelSaldo.push(array[i]);
        }
    }
    return debajoDelSaldo;
}
console.log(filtrarPorSaldos(arrayCuentas,1700));

function incrementarSaldo(array, id, saldo) {
    let cuenta = buscarPorId(array, id);
    if (cuenta !== null) {
        cuenta.saldo += saldo;
        return cuenta;
    } else {
        return undefined;
    }
}
console.log(incrementarSaldo(arrayCuentas,1,10000));
console.log(incrementarSaldo(arrayCuentas,0,10000));

