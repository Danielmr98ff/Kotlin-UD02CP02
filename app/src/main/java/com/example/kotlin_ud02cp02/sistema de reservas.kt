package com.example.kotlin_ud02cp02

fun main() {


    val asientos = mutableMapOf<String, Boolean?>()

    val filas = listOf('A', 'B', 'C', 'D', 'E')
    for (fila in filas) {
        for (numero in 1..5) {
            asientos["$fila$numero"] = false
        }
    }


    fun mostrarMapa() {
        println("\n=== ESTADO DE LA SALA DE CINE ===")
        println("   1  2  3  4  5")
        for (fila in filas) {
            print("$fila ")
            for (numero in 1..5) {
                val estado = asientos["$fila$numero"]
                val simbolo = when (estado) {
                    false -> "[O]"
                    true  -> "[X]"
                    null  -> "[?]"
                }
                print("$simbolo")
            }
            println()
        }
        println("(Leyenda: [O] Libre | [X] Ocupado)\n")
    }

    var opcion = 0
    while (opcion != 4) {
        println("--- MINI SISTEMA DE RESERVAS ---")
        println("1. Mostrar mapa de asientos")
        println("2. Reservar asiento")
        println("3. Cancelar reserva")
        println("4. Salir")
        print("Elige una opción: ")


        try {
            val entrada = readlnOrNull() as? String
            opcion = entrada?.toIntOrNull() ?: 0
        } catch (e: Exception) {
            println("Error al procesar la opción introducida.")
            opcion = 0
        }

        when (opcion) {
            1 -> mostrarMapa()
            2 -> {
                print("Introduce el código del asiento a reservar (ej. A1): ")
                val codigo = readlnOrNull()?.uppercase()?.trim() ?: ""


                val estaOcupado: Boolean? = asientos[codigo]

                when (estaOcupado) {
                    false -> {
                        asientos[codigo] = true
                        println("¡Reserva realizada con éxito para el asiento $codigo!")
                    }
                    true -> println("El asiento $codigo ya está ocupado.")
                    null -> println("El asiento $codigo no existe. Debe estar entre A1 y E5.")
                }
            }
            3 -> {
                print("Introduce el código del asiento a cancelar (ej. A1): ")
                val codigo = readlnOrNull()?.uppercase()?.trim() ?: ""

                val estaOcupado: Boolean? = asientos[codigo]

                when (estaOcupado) {
                    true -> {
                        asientos[codigo] = false
                        println("¡Reserva cancelada con éxito para el asiento $codigo!")
                    }
                    false -> println("El asiento $codigo no estaba reservado.")
                    null -> println("El asiento $codigo no existe. Debe estar entre A1 y E5.")
                }
            }
            4 -> println("¡Gracias por usar el sistema de reservas!")
            else -> println("Opción no válida. Inténtalo de nuevo.")
        }
    }
}