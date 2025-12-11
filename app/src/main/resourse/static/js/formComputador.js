const API_URL = "/api/computadores";

document.getElementById("formcomputador").addEventListener("submit", async function (e) {
    e.preventDefault();

    const nombre = document.getElementById("nombre").value.trim();
    const marca = document.getElementById("marca").value.trim();
    const modelo = document.getElementById("modelo").value.trim();

    const computador = {
        nombre: nombre,
        marca: marca,
        modelo: modelo
    };

    const resp = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(computador)
    });

    if (resp.ok) {
        alert("Computador registrado correctamente 💻✨");
        document.getElementById("formcomputador").reset();
    } else {
        alert("Error al registrar el computador");
    }
});
