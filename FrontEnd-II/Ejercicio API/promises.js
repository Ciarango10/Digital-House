// en un mundo ideal la api me trae la info casi al instante
// const getData = () => { 
//     return listadoComentarios
//  }

//  console.log(getData());
// Qué son las promesas? Son un objeto de javascript que me permite evaluar la promesa de recibir algo y que puede tardar en el tiempo,
// en un mundo real la api puede tardar en traerme la info incluso por mas de un segundo
// const getData = () => { 
//     setTimeout(() => {
//         console.log("Resuelvo peticion");
//         return listadoComentarios
//     }, 2500);
//  }

//  console.log(getData());


//  const getData = () => { 
//     console.log("inicio de petición");

//     return new Promise ((resolve, reject) => { 
//         setTimeout(() => {
//             console.log("Resuelvo peticion");
//             resolve(listadoComentarios)
//         }, 2500);        
//      })    
//  }

//  console.log(getData());
 
// listadoComentarios = [] // simulo que el array respuesta del API esta vacio
 
 const getData = () => { 
    console.log("inicio de petición");

    return new Promise ((resolve, reject) => { 
        // diferentes funciones para ir a buscar ese recurso a la API, e inclusive trasformar esa data
        if (listadoComentarios.length > 0) {
            setTimeout(() => {
                console.log("Resuelvo peticion");
                resolve(listadoComentarios)
            }, 2500);                    
        } else { // indicar que el recurso no tiene contenido y tengo que manejar el rechazo de la respuesta
            console.log("Rechazo promesa");
            reject( { message: "Recurso no enncontrado", status: 404 } )
        }
     })    
 }

//  console.log(getData());
getData()
.then( (datos) => {
    console.log("desde el .then");
    console.log(datos);
})
.catch((error) => console.log(error))
