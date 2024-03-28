// SEGURIDAD: Si no se encuentra en localStorage info del usuario
// no lo deja acceder a la página, redirigiendo al login inmediatamente.
console.log(localStorage.jwt);
if(!localStorage.jwt) {
  location.replace("./index.html");
}


/* ------ comienzan las funcionalidades una vez que carga el documento ------ */
window.addEventListener('load', function () {
  renderizarSkeletons(5, ".tareas-pendientes");

  /* ---------------- variables globales y llamado a funciones ---------------- */
  const btnCerrarSesion = document.querySelector("#closeApp");
  const formCrearTarea = document.querySelector(".nueva-tarea");
  const nuevaTarea = document.querySelector("#nuevaTarea");

  // Variables de conexion a la api
  const url = "https://todo-api.ctd.academy/v1";
  const urlUsuario = `${url}/users/getMe`;
  const urlTareas = `${url}/tasks`;
  const token = JSON.parse(localStorage.jwt);

  obtenerNombreUsuario();
  setTimeout(consultarTareas, 1000);

  /* -------------------------------------------------------------------------- */
  /*                          FUNCIÓN 1 - Cerrar sesión                         */
  /* -------------------------------------------------------------------------- */

  btnCerrarSesion.addEventListener('click', function () {

    const cerrarSesion = confirm("¿Está seguro que desea cerrar sesion?");
    
    if(cerrarSesion) {
      // Limpiar el LocalStorage
      localStorage.clear();
      // Redirigir a la pagina de inicio
      location.replace("./index.html");
    }

  });

  /* -------------------------------------------------------------------------- */
  /*                 FUNCIÓN 2 - Obtener nombre de usuario [GET]                */
  /* -------------------------------------------------------------------------- */

  function obtenerNombreUsuario() {
   
    const settings =  {
      method: "GET",
      headers: { 
        "authorization": token
      }
    };

    fetch(urlUsuario, settings)
      .then(response => response.json())
      .then(userData => {
        console.log(userData);
        console.log(userData.firstName);

        const nombreUsuario = document.querySelector(".user-info p");
        nombreUsuario.innerText = userData.firstName;
      })
      .catch(err => console.error(err));

  };


  /* -------------------------------------------------------------------------- */
  /*                 FUNCIÓN 3 - Obtener listado de tareas [GET]                */
  /* -------------------------------------------------------------------------- */

  function consultarTareas() {
    
    const settings =  {
      method: "GET",
      headers: { 
        "authorization": token
      }
    };

    fetch(urlTareas, settings)
      .then(response => response.json())
      .then(tareas => {
        removerSkeleton(".tareas-pendientes");
        console.log(tareas);
        renderizarTareas(tareas);
        botonesCambioEstado();
        botonBorrarTarea();
      })
      .catch(err => console.error(err));

  };


  /* -------------------------------------------------------------------------- */
  /*                    FUNCIÓN 4 - Crear nueva tarea [POST]                    */
  /* -------------------------------------------------------------------------- */

  formCrearTarea.addEventListener('submit', function (event) {
    event.preventDefault(); // Prevenimos el comportamiento por defecto 
    console.log(nuevaTarea.value);

    const payload = {
      description: nuevaTarea.value.trim()
    };

    const settings =  {
      method: "POST",
      headers: { 
        "Content-Type": "application/json",
        "authorization": token
      },
      body: JSON.stringify(payload)
    };

    fetch(urlTareas,settings)
      .then(response => response.json())
      .then(tarea => {
        console.log(tarea);
        consultarTareas();
      })
      .catch(err => console.log(err));
    
    // Limpieza del formulario
    formCrearTarea.reset();
  });


  /* -------------------------------------------------------------------------- */
  /*                  FUNCIÓN 5 - Renderizar tareas en pantalla                 */
  /* -------------------------------------------------------------------------- */
  function renderizarTareas(listado) {

    // Obtengo listados y limpio cualquier contenido interno
    const tareasPendientes = document.querySelector(".tareas-pendientes");
    const tareasTerminadas = document.querySelector(".tareas-terminadas");

    tareasPendientes.innerHTML = "";
    tareasTerminadas.innerHTML = "";

    const cantidadFinalizadas = document.querySelector("#cantidad-finalizadas");
    let contador = 0;
    cantidadFinalizadas.innerText = contador;

    listado.forEach(tarea => {
      // La variable intermedia de la fecha
      let fecha = new Date(tarea.createdAt);

      // Renderizo las tarjetas dependiendo de si tienen la propiedad completed en true/false
      if(tarea.completed) {
        contador++; // Sumamos el contador pues esta completed

        // Imprimir las tareas completadas
        tareasTerminadas.innerHTML += `
        <li class="tarea">
          <div class="hecha">
            <i class="fa-regular fa-circle-check"></i>
          </div>
          <div class="descripcion">
            <p class="nombre">${tarea.description}</p>
            <div class="cambios-estados">
              <button class="change incompleta" id="${tarea.id}"><i class="fa-solid fa-rotate-left"></i></button>
              <button class="borrar" id="${tarea.id}"><i class="fa-regular fa-trash-can"></i></button>
            </div>
          </div>
        </li>
        `;
      } else {
        // Imprimir las tareas pendientes
        tareasPendientes.innerHTML += `
        <li class="tarea">
          <button class="change" id="${tarea.id}"><i class="fa-regular fa-circle"></i></button>
          <div class="descripcion">
            <p class="nombre">${tarea.description}</p>
            <p class="timestamp">${fecha.toLocaleDateString()}</p>
          </div>
        </li>
        `;
      }
    });

    // Actualizar el contador en pantalla
    cantidadFinalizadas.innerText = contador;

  };

  /* -------------------------------------------------------------------------- */
  /*                  FUNCIÓN 6 - Cambiar estado de tarea [PUT]                 */
  /* -------------------------------------------------------------------------- */
  function botonesCambioEstado() {
    const btnCambioEstado = document.querySelectorAll(".change");
    // console.log(btnCambioEstado);

    // A cada boton le asignamos una funcionalidad
    btnCambioEstado.forEach(boton => {
      boton.addEventListener("click", ev => {
        console.log(ev.target.id);
        const id = ev.target.id;
        const urlChange = `${urlTareas}/${id}`;

        const payload = {};

        // Segun el tipo de boton que fue clickeado, cambiamos el estado de la tarea
        if(ev.target.classList.contains("incompleta")) {
          // Si esta completada la paso a pendiente
          payload.completed = false;
        } else {
          // Si no esta pendiente, la paso completada
          payload.completed = true;
        }
        console.log(payload);

        const settings =  {
          method: "PUT",
          headers: { 
            "Content-Type": "application/json",
            "authorization": token
          },
          body: JSON.stringify(payload)
        };

        fetch(urlChange, settings)
          .then(response => {
            console.log(response);

            // Vuelvo a consultar las tareas actualizadas y pintarlas nuevamente en la pantalla
            consultarTareas();
          })
          .catch(err => console.log(err));
      
      });    
    });

  }


  /* -------------------------------------------------------------------------- */
  /*                     FUNCIÓN 7 - Eliminar tarea [DELETE]                    */
  /* -------------------------------------------------------------------------- */
  function botonBorrarTarea() {

    btnEliminar = document.querySelectorAll(".borrar");
    console.log(btnEliminar);

    // A cada boton le asignamos una funcionalidad
    btnEliminar.forEach(boton => {
      boton.addEventListener('click', ev => {
        let confirmarEliminarTarea = confirm("¿Está seguro que desea eliminar la tarea?");
  
        if(confirmarEliminarTarea) {
          console.log(ev.target.id);
  
          const id = ev.target.id;
          const urlDelete = `${urlTareas}/${id}`;
      
          const settings =  {
            method: "DELETE",
            headers: { 
              "authorization": token
            }
          };
  
          fetch(urlDelete, settings)
            .then(response => response.json())
            .then(data =>{
                alert(data);
               // Vuelvo a consultar las tareas actualizadas y pintarlas nuevamente en la pantalla
               consultarTareas();
            })
            .catch(err => console.log(err));
        }
      });
    });
  }
    
});