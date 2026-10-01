package com.example.kotlin_ud02cp02

fun main() {
    print("Introduce un texto: ")
    val texto = readlnOrNull().orEmpty()


    val frecuencia = mutableMapOf<Char, Int>()


    for (caracter in texto.lowercase()) {
        if (caracter != ' ') {

            frecuencia[caracter] = (frecuencia[caracter] ?: 0) + 1
        }
    }


    val resultadoOrdenado = frecuencia.toList()
        .sortedByDescending { (_, contador) -> contador }


    println("\n--- Frecuencia de letras (de mayor a menor) ---")
    for ((caracter, contador) in resultadoOrdenado) {
        println("Letra '$caracter': $contador vez/veces")
    }
}