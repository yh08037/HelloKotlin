fun main() {
    var a = 1

    val s1 = "a is $a"

    a = 2

    val s2 = "${s1.replace("is", "was")}, but now is $a"
    /*  단순히 변수가 아니라 추가적인 기능이 호출된다면
        위와 같이 ${...} block 으로 사용해야 한다
     */

    println(s1)
    println(s2)
}