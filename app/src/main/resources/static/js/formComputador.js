const API_URL = "/api/computadores"; // Endpoint correcto

document.getElementById("formcomputador").addEventListener("submit", async function (e) {
    e.preventDefault();

    const nombre = document.getElementById("nombre").value.trim();
    const marca = document.getElementById("marca").value.trim();
    const modelo = document.getElementById("modelo").value.trim();

    const computador = {
        nombre: nombre,
        marca: marca,
        modelo: modelo,
        descripcion: "" // aunque tu DTO actual lo ignora, mejor incluirlo por si acaso
    };

    try {
        const resp = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(computador)
        });

        if (!resp.ok) {
            throw new Error("No se pudo guardar");
        }

        alert("Computador registrado correctamente 💻✨");
        document.getElementById("formcomputador").reset();

    } catch (error) {
        console.error(error);
        alert("Error al registrar el computador");
    }
});
