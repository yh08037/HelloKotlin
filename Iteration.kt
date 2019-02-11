fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun isLetter(c: Char) = c in 'a'..'c' || c in 'A'..'Z'

fun isNotDigit(c: Char) = c !in '0'..'9'

fun main() {
    for (i in 1..20) {  // 끝값(20) 포함
        print(fizzBuzz(i))
    }
    println()

    for (i in 1 until 20) { // 끝값(20) 포함하지 않음
        print(fizzBuzz(i))
    }
    println()

    for (i in 20 downTo 1 step 2) { // 끝값(1) 포함
        print(fizzBuzz(i))
    }
    println()

    for (c in 'A'..'F') {
        print("$c ")
    }
    println()

    val array = arrayOf("for", "each", "with", "indices")

    for (i in array.indices) {
        println(array[i])
    }

    for ((index, value) in array.withIndex()) {
        println("array[$index] : $value")
    }

    println(isLetter('q'))
    println(isNotDigit('x'))
}