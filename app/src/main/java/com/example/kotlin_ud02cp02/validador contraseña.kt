package com.example.kotlin_ud02cp02

fun validarContrasena(password: String): Boolean {
    var esValida = true


    if (password.length < 8) {
        println("Error: Debe tener al menos 8 caracteres.")
        esValida = false
    }


    if (!password.any { it.isUpperCase() }) {
        println("Error: Debe contener al menos una letra mayúscula.")
        esValida = false
    }


    if (!password.any { it.isLowerCase() }) {
        println("Error: Debe contener al menos una letra minúscula.")
        esValida = false
    }


    if (!password.any { it.isDigit() }) {
        println("Error: Debe contener al menos un número.")
        esValida = false
    }


    if (!password.any { !it.isLetterOrDigit() }) {
        println("Error: Debe contener al menos un carácter especial (p. ej. @, #, !, *).")
        esValida = false
    }

    return esValida
}

fun main() {
    print("Introduce una contraseña para validar: ")
    val clave = readlnOrNull().orEmpty()

    println("\nValidando...")
    val esCorrecta = validarContrasena(clave)

    if (esCorrecta) {
        println("¡La contraseña es segura y válida!")
    } else {
        println("\nLa contraseña no cumple todos los requisitos.")
    }
}