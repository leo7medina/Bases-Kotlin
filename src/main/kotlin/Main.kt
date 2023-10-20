import java.util.*
import javax.print.attribute.IntegerSyntax

const val PI = 3.1416

const val RESPONSE_AFFIRMATIVE = "✅"
const val RESPONSE_NEGATIVE = "❌"
const val RESPONSE_QUESTIONABLE = "\uD83E\uDD14"

//Unimos las respuestas con los valores
val respuestas = mapOf(
    "Sí" to RESPONSE_AFFIRMATIVE,
    "Es cierto" to RESPONSE_AFFIRMATIVE,
    "Totalmente" to RESPONSE_AFFIRMATIVE,
    "Sin duda" to RESPONSE_AFFIRMATIVE,
    "Pregunta en otro momento" to RESPONSE_QUESTIONABLE,
    "No puedo decirte en este momento" to RESPONSE_QUESTIONABLE,
    "Puede que si o puede que no" to RESPONSE_QUESTIONABLE,
    "No va a suceder" to RESPONSE_NEGATIVE,
    "No cuentes con ello" to RESPONSE_NEGATIVE,
    "Definitivamente no" to RESPONSE_NEGATIVE,
    "No lo creo" to RESPONSE_NEGATIVE,
)

fun main(args: Array<String>) {
    menuPrincipal(args)
}

private fun menuPrincipal(args: Array<String>) {
    println()
    println("HOLA, BIENVENIDO A CONOCIMIENTO BASICOS DE KOTLIN")
    println("Selecione una opcion")
    println("1. Hello world")
    println("2. Variables y tipos")
    println("3. Condicional IF")
    println("4. Condicional WHEN")
    println("5. While")
    println("6. For")
    println("7. Try/catch")
    println("8. Elvis operator")
    println("9. List")
    println("10. Sort List")
    println("11. Maps")
    println("12. Sets")
    println("13. Functions")
    println("14. Lambda")
    println("15. High order functions")
    println("16. Let")
    println("17. With")
    println("18. Run")
    println("19. Apply")
    println("20. Also")
    println("21. Project Ball 8")
    println("22. Salir")

    print("Ingrese una opcion: ")
    when(readLine()) {
        "1" -> helloWorld(args)
        "2" -> exampleVariableAndType()
        "3" -> exampleIF()
        "4" -> exampleWhen()
        "5" -> exampleWhile()
        "6" -> exampleFor()
        "7" -> exampleTryCatch()
        "8" -> exampleElvisOperator()
        "9" -> exampleList()
        "10" -> exampleSortList()
        "11" -> exampleMaps()
        "12" -> exampleSets()
        "13" -> exampleFunctions()
        "14" -> exampleLambda()
        "15" -> exampleHighOrderFunctions()
        "16" -> exampleLet()
        "17" -> exampleWith()
        "18" -> exampleRun()
        "19" -> exampleApply()
        "20" -> exampleAlso()
        "21" -> projectBall8()
        "22" -> salir()
        else -> {
            println("Opcion desconocida, vuelva a ingresar una opcion del menu.")
            menuPrincipal(args)
        }
    }
}

fun helloWorld(args: Array<String>) {
    println("Hello World!")
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}


fun exampleVariableAndType() {
    // VARIABLES y TIPOS
    var dinero = 10
    println(dinero)
    dinero = 5
    println(dinero)

    val nombre = "Jose"
    println(nombre)

    println(PI)

    val boolean = true
    val numberLong = 3L
    val double = 2.7102
    val float = 1.1f

    val primerValor = 20
    val segundoValor = 10
    val thirdValue = primerValor - segundoValor;
    println(thirdValue)

    val firstName = "Leonardo"
    val lastName = "Medina"
    val nameComplete = firstName + lastName
    println(nameComplete)
}

//CONCIDIONALES
fun exampleIF() {
    println()
    print("Ingrese un nombre: ")
    val name = readLine()!!.toString()
    if (name.isNotEmpty()) println("El largo del nombre es de ${name.length}") else print("Error, la variable esta vacoia")

    val message : String = if (name.length > 4) {
        "Tu nombre es largo"
    } else if (name.isEmpty()) {
        "Nombre esta vacio"
    } else {
        "Tienes un nombre corto"
    }
    println(message)
}

fun exampleWhen() {
    val nameColor = readLine()!!.toString()
    when(nameColor) {
        "Amarillo" -> println("El amarillo es el color de la alegria")
        "Rojo", "Carmesi" -> println("Este color simboliza al colo")
        else -> println("Error, no tengo informacion de ese color")
    }

    val code = 404
    when(code) {
        in 200..299 -> println("Todo ha salido bien")
        in 400..499 -> println("Algo ha fallado")
        else -> println("Codigo desconocido")
    }

    val tallaZapato = 41
    val message = when(tallaZapato) {
        41,43 -> "Tenemos disponible"
        42,44 -> "Casi no nos quedad"
        45 -> "Lo siento no tenemos disponible"
        else -> "Estos zapatos solo vienen en tallas: 41, 42, 43, 44, 45"
    }
    println(message)
}

// CLICOS
fun exampleWhile() {
    var count = 10
    while (count > 0) {
        println("El valor de contador es $count")
        //count--
        count = count.dec()
    }

    do {
        println("Generando numero aleatorio ...")
        val numberAl = (0..100).random()
        println("El numero generado es $numberAl")
    } while (numberAl > 50)
}

fun exampleFor() {
    val listFruit = listOf("Manzana", "Pera", "Durazno")
    for (fruit in listFruit) {
        println("Hoy voy a comer mi fruta $fruit")
    }
    println()
    listFruit.forEach { fruit -> println("Esta fruta es $fruit") }

    val listNumber = listFruit.map { fruit -> fruit.length }
    println(listNumber)

    val listFiltered = listNumber.filter { n -> n > 5 }
    println(listFiltered)
}

//EXCEPCIONES
fun exampleTryCatch() {
    var name : String? = null
    try {
        //name!!.length
        throw NullPointerException("Referencia nulla")
    } catch (exception : NullPointerException) {
        println("Ha ocurrido un error")
    } finally {
        println("Finalizacion de ejemplo")
    }

    val firstValue = 10
    val secondValue = 0
    val result : Int = try { firstValue / secondValue} catch (exception: java.lang.Exception) { 0 }
    println(result)
}

fun exampleElvisOperator() {
    var name: String? = null
    var sizeName = name?.length ?: 0
    println(sizeName)
}

fun exampleList() {
    // Declarar listas inmutables
    val listaDeNombres = listOf("Juan","Enrique","Camila")
    println(listaDeNombres)

    // Declarar listas mutables
    val listaVacia = mutableListOf<String>()
    println("Lista vacia = $listaVacia")

    // Agregar elemento a una lista mutable
    listaVacia.add("Juan")

    // Obtener un valor de la lista
    val valorUsandoGet = listaVacia.get(0)
    println("Primer valor usando la función get $valorUsandoGet")

    val valorUsandoOperadorIndexado = listaVacia[0]
    println("Primer valor usando operador indexado $valorUsandoOperadorIndexado")

    val primerValor = listaVacia.first()

    println("Valor usando la función first $primerValor")

    // Eliminar elementos de la lista

    // Elimina el elemento en la posición 0
    listaVacia.removeAt(0)
    println("Lista vacia luego de eliminar el primer elemento $listaVacia")

    // Elimina el elemento cuando la condición se cumpla
    val listaDeApellidos = mutableListOf("Perez","Cruz","Rodriguez")
    listaDeApellidos.removeIf { apellido -> apellido.length > 5 }
    println("Lista de apellidos despues del filtro $listaDeApellidos ")

    // Arrays en Kotlin
    val myArray = arrayOf(1,2,3,4)
    println("Nuestro array $myArray")
    println("Array como lista ${myArray.toList()}")

}

fun exampleSortList() {
    val numerosDeLoteria = listOf(11,22,43,56,78,66)

    // Ordenar con Sort
    val numerosSorted = numerosDeLoteria.sorted()
    println(numerosDeLoteria)

    // Ordenar por orden descendiente
    val numerosDeLoteriaDescendiente = numerosDeLoteria.sortedDescending()
    println(numerosDeLoteriaDescendiente)

    // Ordenar por condición
    val ordenarPorMultiplos = numerosDeLoteria.sortedBy { numero -> numero < 50 }
    println(ordenarPorMultiplos)

    // Shuffled

    val numerosAleatorios = numerosDeLoteria.shuffled()
    println(numerosAleatorios)

    // Reversa

    val numerosEnReversa = numerosDeLoteria.reversed()
    println(numerosEnReversa)

    // Convertir lista de un tipo en listas de otro tipo

    val mensajesDeNumeros = numerosDeLoteria.map { numero -> "Tu numero de loteria es $numero" }
    println(mensajesDeNumeros)

    // Filtrar numeros

    val numerosFiltrados = numerosDeLoteria.filter { numero -> numero > 50 }
    println(numerosFiltrados)
}

fun exampleMaps() {
    // Maps Inmutables
    val edadDeSuperHeroes = mapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Capitan America" to 99
    )
    println(edadDeSuperHeroes)

    // Maps mutables
    val edadDeSuperHeroesMutable = mutableMapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Capitan America" to 99
    )
    println(edadDeSuperHeroesMutable)

    // Consultar un valor por su clave
    val edadIronman = edadDeSuperHeroesMutable["Ironman"]
    println("La edad de Ironman es $edadIronman")

    // Agregar elemento a un Map usando la función put
    edadDeSuperHeroesMutable.put("Wolverine", 45)
    println(edadDeSuperHeroesMutable)

    // Usando asignación
    edadDeSuperHeroesMutable["Storm"] = 30
    println(edadDeSuperHeroesMutable)

    // Eliminar elemento de nuestro Map
    edadDeSuperHeroesMutable.remove("Wolverine")

    // Para conocer todas las keys de nuestro map .keys
    println(edadDeSuperHeroesMutable.keys)

    // Todos los valores del map usamos .values
    println(edadDeSuperHeroesMutable.values)
}

fun exampleSets() {
    //Creando un set inmutable
    val vocalesRepetidas = setOf("a", "e", "i", "o", "u", "a", "e", "i", "o", "u")
    println(vocalesRepetidas) // Resultado: [a, e, i, o, u]

    //Creando set mutables
    val numerosFavoritos = mutableSetOf(1,2,3,4)
    numerosFavoritos.add(5)
    println(numerosFavoritos) // Resultado: [1, 2, 3, 4, 5]

    //Eliminado elementos de set
    numerosFavoritos.remove(3)
    println(numerosFavoritos) // Resultado: [1, 2, 4, 5]

    //Eliminar dependiendo de una condición
    numerosFavoritos.removeIf { numero -> numero.rem(2) != 0 }
    println(numerosFavoritos)
}

fun exampleFunctions() {
    val letterRandom = "En Platzi nunca paramos de aprender".randomCase()
    println(letterRandom)
}

// funcion de extension
private fun String.randomCase(): String {
    val numberRandom = 0..99
    val resultRandom = numberRandom.random()
    return if (resultRandom.rem(2) == 0) uppercase(Locale.getDefault()) else lowercase(Locale.getDefault())
}


fun exampleLambda() {
    // Como crear una lambda
    val myLambda : (String) -> Int = {
        it.length
    }

    val myLambda2 : (String) -> Int = { texto ->
        texto.length * 2
    }

    // Como invocar una lambda
    val resultLambda = myLambda("Hola Platzi")
    println(resultLambda)

    // Como usar una lambda como parámetro
    val listFromString = listOf("A","B","C")

    val resultLambdaWithOutVariable = listFromString.map { text ->
        text.length * 2
    }
    println(resultLambdaWithOutVariable)

    val resultLambda2= listFromString.map(myLambda2)
    println(resultLambda2)
}

fun exampleHighOrderFunctions() {
    // Pasar lambda como parámetro a una función de alto orden
    val largoDelValorInicial = superFuncion(valorInicial = "Hola!", block = {
            valorInicial -> valorInicial.length
    })
    println(largoDelValorInicial)

    val largoDelValorInicial2 = superFuncion(valorInicial = "Hola!") { valorInicial -> valorInicial.length }
    println(largoDelValorInicial2)

    // Como obtener una lambda de una función
    val obtenerLambda = funcionInception("Carlos")

    // Como obtener el valor de una lambda obtenida como resultado de otra función
    val valorDeLambda = obtenerLambda()
    println(valorDeLambda)

    // Como obtener el valor de una lambda declarada como variable

    val lambdaComoVariable : (String) -> String = { mensaje -> "El mensaje es $mensaje" }
    println(lambdaComoVariable)

    val lambdaComoVariable2 = { mensaje : String -> "El mensaje es $mensaje" }
    println(lambdaComoVariable2)

    val valorDeLambdaComoVariable = lambdaComoVariable("La función ha sido llamada con exito")
    println(valorDeLambdaComoVariable)
}

//se nombre como block para reconocimiento de una lambda
private fun superFuncion(valorInicial: String, block : (String) -> Int) : Int {
    return block(valorInicial)
}

// Como devolver una función

private fun funcionInception(nombre: String) : () -> String {
    return { "Hola desde la lambda $nombre" }
}


fun exampleLet() {
    var nombre: String? = null
    nombre?.let { valor ->
        println("El nombre no es nulo, es $valor")
    }
    nombre = "Giuseppe"
    nombre?.let { valor ->
        println("El nombre no es nulo, es $valor")
    }
}


fun exampleWith() {
    val colores = listOf("Azul", "Amarillo", "Rojo")

    // Tenemoes accedo directo al scope de colores con with, así ya no necesitamos escribir el nombre de la variable
    with(colores){
        println("Nuestros colores son $this")
        println("Esta lista tiene una cantidad de colores de $size")
    }
}

fun exampleRun() {
    val moviles = mutableListOf("Google Pixel 2XL", "Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3")
        .run {
            removeIf { movil -> movil.contains("Google") }
    }
    println(moviles)
}

fun exampleApply() {
    val moviles = mutableListOf("Google Pixel 2XL", "Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3")
        .apply { removeIf { movil -> movil.contains("Google") } }
    println(moviles)


    val colores: MutableList<String>? = null
    colores?.apply {
        println("Nuestro colores son $this")
        println("La cantidad de colores es $size")
    }
    println(colores)

    colores?.plus("Ammarillo")
    colores?.plus("Rojo")
    colores?.plus("Verde")
    println(colores)
}

fun exampleAlso() {
    val moviles = mutableListOf("Google Pixel 2XL", "Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3").also {
            lista -> println("El valor original de la lista es $lista")
    }.asReversed()
    println(moviles)
}


fun projectBall8() {
    // Declarar el mensaje de entrada del programa
    println("Hola soy tu bola 8 magica creada en Kotlin. ¿Cual de estas opciones deseas realizar? ")
    println("1. Realizar una pregunta.")
    println("2. Revisar todas las respuestas.")
    println("3. Salir")

    // Obtener el valor del usuario y convertirlo a un entero nullable
    //val valueInput = readLine()

    // Dependiendo del numero utilizamos el when para realizar una acción.
    when (readLine()){
        "1" -> realizarPregunta()
        "2" -> mostrarRespuestas()
        "3" -> salir()
        else -> mostrarError()
    }
}

//Mostramos un error por pantalla
private fun mostrarError() {
    println("Vaya parece que has elegido una opción no valida, intenta de nuevo.")
}

//Mostramos un mensaje de despedida por pantalla
private fun salir() {
    println("¡Hasta luego!")
}

// Preguntamos al usuario que deberiamos mostrarle y le mostramos una respuesta al azar
fun realizarPregunta() {
    println("¿Que preguntas deseas realizar?")
    readLine()
    println("Asi que esa es tu pregunta... La respuesta a eso es:")
    val respuestaGenerada = respuestas.keys.random()
    println(respuestaGenerada)
}

//Mostramos un menu para seleccionar una de las opciones al usuario
private fun mostrarRespuestas() {
    println("Selecciona una opción")
    println("1. Revisar todas las respuestas")
    println("2. Revisar solo las respuestas afirmativas")
    println("3. Revisar solo las respuestas dudodas")
    println("4. Revisar solo las respuestas negativas")

    val opcionIngresada = readLine()?.toInt()
    when(opcionIngresada){
        1 ->  mostrarRespuestasPorTipo()
        2 -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPONSE_AFFIRMATIVE)
        3 -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPONSE_QUESTIONABLE)
        4 -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPONSE_NEGATIVE)
        else -> println("Respuesta no valida, adios.")
    }

}

// Mostramos las respuestas dependiendo del tipo que se pase como parametro
private fun mostrarRespuestasPorTipo(tipoDeRespuesta : String = "TODOS") {
    when (tipoDeRespuesta){
        "TODOS" -> respuestas.keys.forEach { respuesta -> println(respuesta) }
        RESPONSE_AFFIRMATIVE -> respuestas.filterValues { values -> values == RESPONSE_AFFIRMATIVE }
            .also { respuestasPositivas -> println(respuestasPositivas.keys) }

        RESPONSE_NEGATIVE -> respuestas.filterValues { values -> values == RESPONSE_NEGATIVE }
            .also { respuestasNegativas -> println(respuestasNegativas.keys) }

        RESPONSE_QUESTIONABLE -> respuestas.filterValues { values -> values == RESPONSE_QUESTIONABLE }
            .also { respuestasDudosas -> println(respuestasDudosas.keys) }
    }
}
asdasdasdasdas
asdasdasdasdas
asdasdasdasdasdasdasd
