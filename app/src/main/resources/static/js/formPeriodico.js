document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("formperiodico");

    form.addEventListener("submit", async (e) => {
        e.preventDefault();

        const nombre = document.getElementById("nombre").value;
        const editorial = document.getElementById("editorial").value;

        
        const fecha = document.getElementById("fecha").value;
        const anio = new Date(fecha).getFullYear(); 

        const dto = {
            id: null,
            nombre: nombre,
            editorial: editorial,
            anio: anio.toString(),
            otro: ""
        };

        try {
            const response = await fetch("http://localhost:8080/api/periodicos", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(dto)
            });

            if (response.ok) {
                alert("Periódico registrado correctamente ✨");
                form.reset();
            } else {
                alert("Error guardando el periódico 😭");
            }
        } catch (error) {
            console.error("Error enviando datos:", error);
            alert("No se pudo conectar con el servidor.");
        }
    });
});
