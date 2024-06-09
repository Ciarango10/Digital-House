const tableBody = document.querySelector("#turnosTable tbody");
const form = document.getElementById("editarForm");
const comboOdontologo = document.getElementById("cboOdontologoEdit");
const comboPaciente = document.getElementById("cboPacienteEdit");
let idTurno = null;

function fetchPacientes() {
    fetch(`/pacientes`)
        .then(response => response.json())
        .then(data => {
            console.log(data);

            // Insertar los datos en el select
            data.forEach((paciente) => {
                comboPaciente.innerHTML += `<option value="${paciente.id}">${paciente.nombre} ${paciente.apellido}</option>`
            });
        })
        .catch((error) => {
            console.error("Error fetching data:", error);
        });
}

function fetchOdontologos() {
    fetch(`/odontologos`)
        .then(response => response.json())
        .then(data => {
            console.log(data);

            // Insertar los datos en el select
            data.forEach((odontologo) => {
                comboOdontologo.innerHTML += `<option value="${odontologo.id}">${odontologo.nombre} ${odontologo.apellido}</option>`
            });
        })
        .catch((error) => {
            console.error("Error fetching data:", error);
        });
}

function fetchTurnos() {
    fetch(`/turnos`)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            // Limpiar el contenido actual de la tabla
            tableBody.innerHTML = "";

            // Insertar los datos en la tabla
            data.forEach((turno) => {
                const row = document.createElement("tr");

                row.innerHTML = `
                        <td>${turno.id}</td>
                        <td>${turno.odontologo.nombre} ${turno.odontologo.apellido}</td>
                        <td>${turno.paciente.nombre} ${turno.paciente.apellido}</td>
                        <td>${turno.fecha}</td>

                        <td>
                            <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editarTurno" onclick="editTurno(${turno.id}, 
                                '${turno.paciente.id}', '${turno.odontologo.id}', '${turno.fecha}')">Modificar</button>
                            <button class="btn btn-danger btn-sm" onclick="deleteTurno(${turno.id})">Eliminar</button>
                        </td>
                    `;

                tableBody.appendChild(row);
            });
        })
        .catch((error) => {
            console.error("Error fetching data:", error);
        });
}

// Modificar un Turno
function editTurno(id, paciente_id, odontologo_id, fecha) {
    //Cargamos el valor del id en la variable global
    idTurno = id;
    //Cargamos los valores a la ventana modal

    // Datos del turno
    comboPaciente.value = paciente_id;
    comboOdontologo.value = odontologo_id;
    document.querySelector("#fechaEdit").value = fecha;
}

form.addEventListener("submit", function (event) {
    event.preventDefault();

    // Datos del turno
    const paciente_id = comboPaciente.value;
    const odontologo_id = comboOdontologo.value;
    const fecha = document.getElementById("fechaEdit").value;

    // Validamos que se elija un odontólogo existente
    if(odontologo_id == 0) {
        alert("El odontólogo es requerido");
        return;
    }

    // Validamos que se elija un paciente existente
    if(paciente_id == 0) {
        alert("El paciente es requerido");
        return;
    }

    // llamando al endpoint de editar
    fetch(`/turnos/${idTurno}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ paciente_id, odontologo_id, fecha })
    })
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
            fetchTurnos();
            var modalElement = document.getElementById('editarTurno');
            var modalInstance = bootstrap.Modal.getInstance(modalElement);
            modalInstance.hide();
            alert("Turno modificado con éxito");
        })
        .catch((error) => {
            console.error("Error modificando Turno:", error);
        });
});

// Eliminar un Turno
function deleteTurno(id) {
    if(confirm("¿Está seguro de eliminar el Turno?")) {
        // llamando al endpoint de eliminar 
        fetch(`/turnos/${id}`, {
            method: "DELETE"
        })
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                fetchTurnos();
                alert("Turno eliminado con éxito");
            })
            .catch((error) => {
                console.error("Error eliminando Turno:", error);
            });
    }
}

fetchPacientes();
fetchOdontologos();
fetchTurnos();