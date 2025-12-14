async function cargarRecursos() {
    try {
        const respuesta = await fetch("/api/recursos");
        const datos = await respuesta.json();

        const tabla = document.getElementById("tablaRecursos");
        tabla.innerHTML = "";

        datos.forEach(recurso => {
            const fila = `
                <tr>
                    <td>${recurso.id}</td>
                    <td>${recurso.tipo}</td>
                    <td>${recurso.nombre}</td>
                    <td>${recurso.fechaRegistro}</td>
                    <td>Sí</td>
                    <td>
                        <button onclick="editarRecurso(${recurso.id}, '${recurso.tipo}')">
                            Editar
                        </button>
                        <button onclick="eliminarRecurso(${recurso.id}, '${recurso.tipo}')">
                            Eliminar
                        </button>
                    </td>
                </tr>
            `;
            tabla.innerHTML += fila;
        });

    } catch (error) {
        console.error(error);
    }
}

// ===============================
// EDITAR SOLO ESA SECCIÓN
// ===============================
async function editarRecurso(id, tipo) {
    const nuevoNombre = prompt("Nuevo nombre:");
    if (!nuevoNombre) return;

    await fetch(`/api/recursos/${tipo}/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ nombre: nuevoNombre })
    });

    cargarRecursos();
}

// ===============================
// ELIMINAR SOLO ESA SECCIÓN
// ===============================
async function eliminarRecurso(id, tipo) {
    if (!confirm("¿Eliminar este recurso?")) return;

    await fetch(`/api/recursos/${tipo}/${id}`, {
        method: "DELETE"
    });

    cargarRecursos();
}

document.addEventListener("DOMContentLoaded", cargarRecursos);
