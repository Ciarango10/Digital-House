const tableBody = document.querySelector("#odontologosTable tbody");
const form = document.getElementById("editarForm");
let idOdontologo = null;

function fetchOdontologos() {
    fetch(`/odontologos`)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            // Limpiar el contenido actual de la tabla
            tableBody.innerHTML = "";

            // Insertar los datos en la tabla
            data.forEach((odontologo) => {
                const row = document.createElement("tr");

                row.innerHTML = `
                        <td>${odontologo.id}</td>
                        <td>${odontologo.nombre}</td>
                        <td>${odontologo.apellido}</td>
                        <td>${odontologo.nroMatricula}</td>
                        <td>
                            <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editarOdontologo" onclick="editOdontologo(${odontologo.id}, '${odontologo.nombre}', '${odontologo.apellido}', '${odontologo.nroMatricula}')">Modificar</button>
                            <button class="btn btn-danger btn-sm" onclick="deleteOdontologo(${odontologo.id})">Eliminar</button>
                        </td>
                    `;

                tableBody.appendChild(row);
            });
        })
        .catch((error) => {
            console.error("Error fetching data:", error);
        });
}

// Modificar un odontologo
function editOdontologo(id, nombre, apellido, nroMatricula) {
    //Cargamos el valor del id en la variable global
    idOdontologo = id;
    //Cargamos los valores a la ventana modal
    document.querySelector("#nombreEdit").value = nombre;
    document.querySelector("#apellidoEdit").value = apellido;
    document.querySelector("#matriculaEdit").value = nroMatricula;
}

form.addEventListener("submit", function (event) {
    event.preventDefault();

    const nombre = document.getElementById("nombreEdit").value;
    const apellido = document.getElementById("apellidoEdit").value;
    const matricula = document.getElementById("matriculaEdit").value;

    // llamando al endpoint de editar
    fetch(`/odontologos`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({id: idOdontologo, nombre, apellido, nroMatricula: matricula })
    })
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
            fetchOdontologos();
            var modalElement = document.getElementById('editarOdontologo');
            var modalInstance = bootstrap.Modal.getInstance(modalElement);
            modalInstance.hide();
            alert("Odontólogo modificado con éxito");
        })
        .catch((error) => {
            console.error("Error modificado odontólogo:", error);
        });
});

// Eliminar un odontologo
function deleteOdontologo(id) {
    if(confirm("¿Está seguro de eliminar el odontólogo?")) {
        // llamando al endpoint de eliminar 
        fetch(`/odontologos/${id}`, {
            method: "DELETE"
        })
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                fetchOdontologos();
                alert("Odontólogo eliminado con éxito");
            })
            .catch((error) => {
                console.error("Error eliminando odontólogo:", error);
            });
    }
}

fetchOdontologos();