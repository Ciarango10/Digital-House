let curso = {
    cantidadAlumnos:32,
    docentes: [ "Nacho", "Javier"],
    nombre: "Calculo Integral",
    notificaciones : function(){
        return "La cantidad de alumnos es de " + this.cantidadAlumnos;
    }
}
//Se puede definir un arreglo dentro de un objeto
console.log(curso.docentes);
console.log(curso.docentes[0]);
console.log(curso.docentes[1]);

//Se pueden definir funciones dentro de un objeto
console.log(curso.notificaciones());

