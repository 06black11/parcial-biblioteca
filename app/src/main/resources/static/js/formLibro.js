const API_URL = "/api/libros";

document.getElementById("formlibro").addEventListener("submit", async function (e) {
    e.preventDefault();

    // Obtener valores del formulario
    const titulo = document.getElementById("titulo").value.trim();
    const autor = document.getElementById("autor").value.trim();
    const anio = document.getElementById("anio").value.trim();
    const genero = document.getElementById("genero").value.trim(); // No se envía al backend

    // Como tu backend exige ISBN, creamos uno automáticamente
    const isbnGenerado = "AUTO-" + Math.floor(Math.random() * 1000000);

    const libro = {
        nombre: titulo,
        autor: autor,
        anio: anio,
        isbn: isbnGenerado
    };

    // Enviar al backend
    const resp = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(libro)
    });

    if (resp.ok) {
        alert("Libro registrado correctamente ✨📚");
        document.getElementById("formlibro").reset();
    } else {
        alert("Error al registrar el libro");
    }
});
