async function cargarRecursos() {
    try {
        const respuesta = await fetch("/api/recursos");

        if (!respuesta.ok) {
            throw new Error("Error al consultar la API");
        }

        const datos = await respuesta.json();
        const tabla = document.getElementById("tablaRecursos");
        tabla.innerHTML = "";

        datos.forEach(recurso => {
            const fila = `
                <tr>
                    <td>${recurso.id}</td>
                    <td>${recurso.tipo}</td>
                    <td>${recurso.nombre}</td>
                    <td>Sí</td>
                    <td>
                        <button onclick="editar(${recurso.id})">Editar</button>
                        <button onclick="eliminar(${recurso.id})">Eliminar</button>
                    </td>
                </tr>
            `;
            tabla.innerHTML += fila;
        });

    } catch (error) {
        console.error("Error cargando recursos:", error);
    }
}

function editar(id) {
    alert("Editar recurso ID: " + id);
}

function eliminar(id) {
    alert("Eliminar recurso ID: " + id);
}

cargarRecursos();

