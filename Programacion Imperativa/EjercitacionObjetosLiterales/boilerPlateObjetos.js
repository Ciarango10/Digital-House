//la lista de clientes.
let arrayCuentas = [
  {
    nroCuenta: 5486273622,
    tipoDeCuenta: "Cuenta Corriente",
    saldoEnPesos: 27771,
    titularCuenta: "Abigael Natte",
  },
  {
    nroCuenta: 1183971869,
    tipoDeCuenta: "Caja de Ahorro",
    saldoEnPesos: 8675,
    titularCuenta: "Ramon Connell",
  },
  {
    nroCuenta: 9582019689,
    tipoDeCuenta: "Caja de Ahorro",
    saldoEnPesos: 27363,
    titularCuenta: "Jarret Lafuente",
  },
  {
    nroCuenta: 1761924656,
    tipoDeCuenta: "Cuenta Corriente",
    saldoEnPesos: 32415,
    titularCuenta: "Ansel Ardley",
  },
  {
    nroCuenta: 7401971607,
    tipoDeCuenta: "Cuenta Unica",
    saldoEnPesos: 18789,
    titularCuenta: "Jacki Shurmer",
  },
];
// podes continuar tu codigo a partir de aca!

let banco = {
  clientes : arrayCuentas,
  consultarCliente : function(titular){
    for(let i = 0; i < arrayCuentas.length; i++){
      if(titular === arrayCuentas[i].titularCuenta){
        return arrayCuentas[i];
      }
    }
  },
  deposito : function(titular,dinero){
    let titularCuenta = this.consultarCliente(titular);
    if(titularCuenta != undefined){
      titularCuenta.saldoEnPesos += dinero;
      console.log("Depósito realizado, su nuevo saldo es: " + titularCuenta.saldoEnPesos);
    }else{
      console.log("No se encontro el titular de la cuenta");
    }
  },
  extraccion : function(titular,monto){
    let titularCuenta = this.consultarCliente(titular);
    if(titularCuenta != undefined){
      titularCuenta.saldoEnPesos -= monto;
      if(titularCuenta.saldoEnPesos < 0){
        console.log("Fondos Insuficientes");
      }else{
        console.log("Extracción realizada correctamente, su nuevo saldo es:" + titularCuenta.saldoEnPesos);
      }
    }else{
      console.log("No se encontro el titular de la cuenta");  
    }
  }
}

let clienteEncontrado = banco.consultarCliente("Jacki Shurmer");
console.log(clienteEncontrado);

banco.deposito("Ramon Connell", 35);
banco.extraccion("Ramon Connell",30);

let arreglo = [ { nombre: "Lean", edad: 27 }, { nombre: "Eze", edad: 49} ]

function propiedadUnica(array, string) {
  let unificar = [];
  for (let i = 0; i < array.length; i++) {
    let nuevoObjeto = {};
    nuevoObjeto[string] = array[i][string];
    unificar.push(nuevoObjeto);
  }
  return unificar;
}
console.log(propiedadUnica(arreglo,"nombre"));

let alumno = {
  nombre: "Carlos",
  numeroLegajo : "10143212421",
  listaNotas: [8, 7, 9, 6, 10],
  promedio : function(notas){
    let suma = 0;
    let promedio = 0;
    for(let i = 0; i < notas.length; i++){
      suma+= notas[i];
    }
    if(suma != 0){
      promedio = suma / notas.length;
    }
    return promedio;
  },
  aprobado : function(notas){
    let promedio = this.promedio(notas)
    if(promedio >= 7 ){
      console.log("Aprobado");
    }else{
      console.log("Reprobado");
    }
  }
}

alumno.aprobado([8, 7, 9, 6, 10]);


