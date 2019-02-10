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
/*  max2 와 같은 expression 형태의 함수는 return type 을 생략할 수 있다
    이는 type inference 를 컴파일러가 해주기 때문이다
 */


fun printSum1(a: Int, b: Int): Unit {
    println("Sum of $a and $b is ${a + b}")
}
/*  함수가 의미있는 값을 반환하지 않을 때, return type 은 Unit 이다
    Java 에서의 void 와 비슷하지만 Unit 을 리턴하기는 한다는 점은 다르다
    Kotlin 은 모든 함수 구현이 반환값을 가지며
    return 을 명시적으로 써줄 수도 생략할 수도 있다
    반환이 없어보이는 코드의 경우에는 Unit 을 리턴한다
 */


fun printSum2(a: Int, b: Int) {
    println("Sum of $a and $b is ${a + b}")
}
/*  return type 인 Unit 은 생략이 가능하다
    또한 $a ${a + b} 와 같이 $ 를 이용하여 문자열 템플릿을 사용할 수 있다
    Java 의 "~~" + 변수 + "~~" 와 같은 방식보다 훨씬 간결하다
 */


fun main() {
    println(max1(1, 2))
    println(max2(4, 3))
    println(max3(5, 6))
    printSum1(10, 20)
    printSum2(1, 6)
}
