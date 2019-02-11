enum class Color1 {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(63, 0, 255), VIOLET(238, 130, 238);

    fun rgb() = ((r * 256 + g) * 256 + b).toString(16)
}
/*
    enum 내부에 값과 함수까지 정의하였다
    코틀린에서는 ; 를 사용하지 않지만 enum 의 마지막에는 꼭 사용해야한다
 */

fun getAlphabet(color: Color) = when (color) {
    Color.RED -> "ABC"
    Color.ORANGE -> "DEF"
    Color.YELLOW -> "GHI"
    Color.GREEN -> "JKL"
    Color.BLUE -> "MNO"
    Color.INDIGO -> "PQR"
    Color.VIOLET -> "STU"
}

fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
    setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
    else -> throw Exception("Dirty color")
}

/*
    when 은 Java 에서의 switch 와 비슷하면서 좀더 편하게 사용할 수 있다
    switch 는 매 case 마다 break 를 해주어야 했던 것에 비해 when 은 break 가 필요없다
    이를 통해 break 를 빼먹어서 발생하는 오류를 막을 수 있다
    또한 Kotlin 에서 when 은 인수로써 object 를 받는 것이 가능하다
 */

fun mixOptimized(c1: Color, c2: Color) = when {
    (c1 == Color.RED && c2 == Color.YELLOW) || (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
    (c1 == Color.YELLOW && c2 == Color.BLUE) || (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
    (c1 == Color.BLUE && c2 == Color.VIOLET) || (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
    else -> throw Exception("Dirty color")
}

/*
    when 은 인자값 없이도 사용할 수 있다
    단 이때 조건부분은 반드시 Boolean 을 반환하는 expression 이어야한다
    위의 mix() 함수는 매 케이스 마다 set 객체를 생성하기 때문에 비효율적이므로
    mixOptimized() 는 객체 생성을 줄이고 논리식으로 대체하여 개선을 할 수 있다
 */

fun main() {
    println((Color.INDIGO.rgb()))
    println(getAlphabet(Color.INDIGO))
    println(getWarmth(Color.INDIGO))
    println(mix(Color.BLUE, Color.YELLOW))
    println(mixOptimized(Color.YELLOW, Color.RED))
}