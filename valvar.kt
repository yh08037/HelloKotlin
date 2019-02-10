fun main() {
    // val : value; immutable type
    val a: Int = 1  // 초기화와 동시에 값 할당
    val b = 2       // `Int` 타입이 추론됨
    val c: Int      // 초기화 시 값을 할당하지 않는다면
    c = 3           // 반드시 타입을 명시해야 한다

    /*  val 로 지정된 변수는 불변타입변수
        단 한번만 값을 할당할 수 있다, 즉 추후에 값을 변경할 수 없으며
        a += 1 과 같이 변경을 시도할 시 컴파일 에러가 난다
        Java 의 final 키워드와 같다
     */

    // var : variance; mutable type
    var x = 4       // `Int` 타입이 추론됨
    x += 1

    println("a : $a, b : $b, c : $c, x : $x")
}