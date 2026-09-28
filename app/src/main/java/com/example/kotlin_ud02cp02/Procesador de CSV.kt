package com.example.kotlin_ud02cp02


fun main() {
    val csv = """
        nombre,nota1,nota2,nota3
        Ana,7,8,9
        Luis,5,6,4
        Marta,9,10,8
    """.trimIndent()


    val lineas = csv.split("\n")


    for (linea in lineas.drop(1)) {

        val datos = linea.split(",")
        val nombre = datos[0]


        val nota1 = datos[1].toDouble()
        val nota2 = datos[2].toDouble()
        val nota3 = datos[3].toDouble()


        val media = (nota1 + nota2 + nota3) / 3.0

        val calificacion = when {
            media < 5.0 -> "Suspenso"
            media < 7.0 -> "Aprobado"
            media < 9.0 -> "Notable"
            else -> "Sobresaliente"
        }


        println("Alumno: $nombre | Notas: $nota1, $nota2, $nota3 | Media: $media | Calificación: $calificacion")
    }
}

