/**
 * Solicita un número entero en un rango.
 *
 * @param min Int - valor mínimo
 * @param max Int - valor máximo
 *
 * @return Int - número entero válido dentro del rango especificado
 */
fun pedirNum(min: Int, max: Int): Int {
        var num = min - 1

        do {
            print("Ingrese el número para la tabla de multiplicar entre $min y $max: ")
            try {
                num = readln().toInt()
            } catch (e: NumberFormatException) {
                println("*ERROR* Numero entero no valido (pulse ENTER para continuar)")
            }
        } while (num < min || num > max)

        return num
}

/**
 * Realiza una pregunta para contestar con s/si ó n/no
 *
 * @param text String - Texto de la pregunta
 *
 * @return Boolean - true/false dependiendo de la respuesta válida a la pregunta
 */
fun pregunta(texto: String): Boolean {

    var respuesta = ""

    do {
        print("$texto (s/n): ")
        respuesta = readln().lowercase().trim()
        if (respuesta !in listOf("s", "si", "n", "no")) {
            println("*ERROR*: Tienes que especificar si quieres continuar")
        }
    } while (respuesta !in listOf("s", "si", "n", "no"))

    return respuesta == "s" || respuesta == "si"

}

fun main() {
    //TODO: Solicitar la introducción de un número entre 1 y 100 y mostrar su table de multiplicar...
    //Hasta que se responda negativamente a la pregunta "¿Desea generar otra tabla de multiplicación? (s/n)"
    do {
        val num = pedirNum(1, 100)
        //Lo de Array es la cantidad o el tamaño de cuantos resultados se vana imprimir, esto agrega limites.
        val tabla = Array(12) { i -> (i + 1) * num }
        println("Tabla de Multiplicar de $num")
        for (i in 1..10) {
            println("$i -> $num x $i = ${tabla[i - 1]}")
        }
    } while (pregunta("¿Desea generar otra tabla de multiplicación?"))
    println("Programa terminado")
}