interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

/*
    Smart cast : 객체의 타입 확인과 동시에 형변환(casting) 을 해주는 기능
 */

fun eval1(e: Expr): Int {
    if (e is Num) { // Smart cast to Num
//      val n = e as Num    // e 는 이미 Smart cast 되어 Num 타입이다
//      return n.value
        return e.value
    }
    if (e is Sum) { // Smart cast to Sum
        return eval1(e.right) + eval1(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun eval2(e: Expr): Int =
    when (e) {
        is Num -> e.value                           // Smart cast to Num
        is Sum -> eval2(e.right) + eval2(e.left)    // Smart cast to Sum
        else -> throw IllegalArgumentException("Unknown expression")
    }
/*
    위의 eval1 함수의 if 문 부분을 when 을 이용해서 간소화 시킬 수 있다
 */

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum : $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown ecpression")
    }

/*
    when 문에서 -> 뒤의 값을 block 을 사용해서 표현할 수도 있다
    이때 block 의 마지막 문장이 block 전체의 결과값이 된다
 */

fun main() {
    println(eval1(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(eval2(Sum(Num(346), Num(765))))
    println(evalWithLogging(Sum(Num(876), Num(315))))
}