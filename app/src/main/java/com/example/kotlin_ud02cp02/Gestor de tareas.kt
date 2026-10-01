package com.example.kotlin_ud02cp02


fun List<String>.pendientes(): List<String> {
    return this.filter { !it.startsWith("[X]") }
}

fun main() {
    val tareas = mutableListOf<String>()

    fun añadir(tarea: String) {
        tareas.add(tarea)
        println("Tarea añadida con éxito.")
    }

    fun completar(indice: Int) {
        if (indice in 0 until tareas.size) {

            if (!tareas[indice].startsWith("[X]")) {
                tareas[indice] = "[X] ${tareas[indice]}"
                println("Tarea completada.")
            } else {
                println("La tarea ya estaba completada.")
            }
        } else {
            println("Índice no válido.")
        }
    }

    fun listar() {
        if (tareas.isEmpty()) {
            println("No hay tareas.")
        } else {
            for ((i, tarea) in tareas.withIndex()) {
                println("$i. $tarea")
            }
        }
    }


    var opcion = 0
    while (opcion != 5) {
        println("\n--- GESTOR DE TAREAS ---")
        println("1. Añadir tarea")
        println("2. Completar tarea")
        println("3. Listar tareas")
        println("4. Ver pendientes")
        println("5. Salir")
        print("Elige una opción: ")

        opcion = readlnOrNull()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                print("Escribe la tarea: ")
                val nuevaTarea = readlnOrNull().orEmpty()
                añadir(nuevaTarea)
            }
            2 -> {
                print("Introduce el número/índice de la tarea: ")
                val idx = readlnOrNull()?.toIntOrNull() ?: -1
                completar(idx)
            }
            3 -> listar()
            4 -> {
                val listaPendientes = tareas.pendientes()
                println("--- Tareas Pendientes ---")
                if (listaPendientes.isEmpty()) {
                    println("¡No hay tareas pendientes!")
                } else {
                    listaPendientes.forEach { println(it) }
                }
            }
            5 -> println("¡Hasta luego!")
            else -> println("Opción no válida, intenta de nuevo.")
        }
    }
}