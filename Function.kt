fun max1(a: Int, b: Int): Int {
    return if (a > b) a else b
}
/*  Java 에서는 if 문이 statement 이므로
    return a > b ? a : b;
    와 같이 3항연산자를 사용해서 했어야 했지만

    Kotlin 에서는 반복문을 제외하고는 모두 expression 이므로
    return if (a > b) a else b
    와 같은 표현이 가능하다
    따라서 아래의 max2 와 같은 표현도 가능하다

    expression : 값을 반환하는 형태이다
    statement : 아무런 값을 만들어 내지 않는다
 */

fun max2(a: Int, b: Int): Int = if (a > b) a else b
/*  이러한 형태의 함수를 expression 형태의 함수라고 한다
    위의 max1 의 형태는 block 형태의 함수라고 한다
    IntelliJ 는 함수 body 의 형태를 서로 변환하는 기능을 제공한다
 */


fun max3(a: Int, b: Int) = if (a > b) a else b
/*  max2 와 같은 expression 형태의 함수는 return type을 생략할 수 있다
    이는 type inference 를 컴파일러가 해주기 때문이다
 */

fun main() {
    println(max1(1, 2))
    println(max2(4, 3))
    println(max3(5, 6))
}