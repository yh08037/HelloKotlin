# Hello, Kotlin!


<details><summary> HelloWorld.kt </summary>
<p>
<hr>

## HelloWorld.kt

```kt
fun main(args: Array<String>) {
    println("Hello, World!")
}
```
### args: Array<String>

- 함수 인자를 표기할 때 "변수명: 타입" 순서로 쓴다

- 제네릭은 자바와 동일하다

- Kotlin 1.3 부터 main 함수의 args 는 필수요소가 아니다

### println()

- Java의 ```System.out.println()``` 을 간단하게 사용할 수 있다

- 이는 표준 자바 라이브러리 함수를 간소화해주는 wrapper 가 제공되기 때문이다

- 세미콜론(;)은 특수한 경우 외에는 선택사항이다


<hr>
</p></details>


<details><summary> Function.kt </summary>
<p>
<hr>


## Function.kt

```kt
fun max1(a: Int, b: Int): Int {
    return if (a > b) a else b
}
```

Java 에서는 if 문이 statement 이므로 ```return a > b ? a : b;```
와 같이 3항연산자를 사용해서 했어야 했지만


Kotlin 에서는 반복문을 제외하고는 모두 expression 이므로
```return if (a > b) a else b``` 와 같은 표현이 가능하다

- expression : 값을 반환하는 형태이다

- statement : 아무런 값을 만들어 내지 않는다


따라서 아래의 max2 와 같은 표현도 가능하다

```kt
fun max2(a: Int, b: Int): Int = if (a > b) a else 
```



이러한 형태의 함수를 expression 형태의 함수라고 한다

위의 max1 의 형태는 block 형태의 함수라고 한다

IntelliJ 는 함수 body 의 형태를 서로 변환하는 기능을 제공한다





```kt
fun max3(a: Int, b: Int) = if (a > b) a else b
```



max2 와 같은 expression 형태의 함수는 return type 을 생략할 수 있다

이는 type inference 를 컴파일러가 해주기 때문이다





```kt
fun printSum1(a: Int, b: Int): Unit {
    println("Sum of $a and $b is ${a + b}")
}


```


함수가 의미있는 값을 반환하지 않을 때, return type 은 Unit 이다

Java 에서의 void 와 비슷하지만 Unit 을 리턴하기는 한다는 점은 다르다

Kotlin 은 모든 함수 구현이 반환값을 가지며
return 을 명시적으로 써줄 수도 생략할 수도 있다

반환이 없어보이는 코드의 경우에는 Unit 을 리턴한다





```kt
fun printSum2(a: Int, b: Int) {
    println("Sum of $a and $b is ${a + b}")
}
```



return type 인 Unit 은 생략이 가능하다

또한 ```$a ${a + b}``` 와 같이 $ 를 이용하여 문자열 템플릿을 사용할 수 있다

Java 의 ```"..." + 변수 + "..."``` 와 같은 방식보다 훨씬 간결하다




```kt
fun main() {
    println(max1(1, 2))
    println(max2(4, 3))
    println(max3(5, 6))
    printSum1(10, 20)
    printSum2(1, 6)
}
```


<hr>
</p></details>


<details><summary> valvar.kt </summary>
<p>
<hr>

## valvar.kt

```kt
fun main() {
    // val : value; immutable type
    val a: Int = 1  // 초기화와 동시에 값 할당
    val b = 2       // `Int` 타입이 추론됨
    val c: Int      // 초기화 시 값을 할당하지 않는다면
    c = 3           // 반드시 타입을 명시해야 한다

    // var : variance; mutable type
    var x = 4       // `Int` 타입이 추론됨
    x += 1

    println("a : $a, b : $b, c : $c, x : $x")
}
```
val 로 지정된 변수는 불변타입변수로, 단 한번만 값을 할당할 수 있다

즉 추후에 값을 변경할 수 없으며 ```a += 1``` 과 같이 변경을 시도할 시 컴파일 에러가 난다
        
Java 의 final 키워드와 같다
  
<hr>
</p></details>


<details><summary> StringTemplate.kt </summary>
<p>
<hr>

## StringTemplate.kt

```kt
fun main() {
    var a = 1

    val s1 = "a is $a"

    a = 2

    val s2 = "${s1.replace("is", "was")}, but now is $a"

    println(s1)
    println(s2)
}
```

단순히 변수가 아니라 추가적인 기능이 호출된다면 위와 같이 ${...} block 으로 사용해야 한다

<hr>
</p></details>

<details><summary> ClassAndProperty.kt </summary>
<p>
<hr>

## ClassAndProperty.kt

```kt
class Person (
    val name: String,       // val -> getter 생성
    var isMarried: Boolean  // var -> getter, setter 생성
)
```
Java 에서는 캡슐화를 위해 멤버변수를 private 선언하고 get, set 메소드를 통해 접근하였지만

Kotlin 은 get, set 메소드가 묵시적으로 생성되고, 실제로 사용할 때는 직접 접근하듯이 사용하면 된다

또한 Java 문법과 비교했을 때, 멤버변수 선언과 이를 초기화해주기 위한 생성자를 따로 정의하는데에 비해

Kotlin 에서는 class ClassName(name: type , ... ) { ... } 와 같은 형태로 정의하여 그대로 생성자로 사용한다

또한 객체를 생성하는데에 있어서 new 키워드를 사용하지 않는다

```kt
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}
```

getter 와 setter 가 묵시적으로 자동 생성되지만 특정 구현부를 넣고 싶은 경우도 있다

이런 경우 위의 isSquare 와 같이 get() set() 메소드를 직접 구현할 수도 있다


```kt
enum class Language(val greeting: String) {
    EN("Hello"), ES("Hola"), FR("Bonjour")
}

class Person2(val name: String, val lang: Language = Language.EN) {
    fun greet() = println("${lang.greeting}, $name!")
}
```

Kotlin 에서는 인자들의 기본값을 설정해줄 수 있다

기본값이 설정되어있는 인자는 인스턴스를 생성할 때 생략할 수 있다


```kt
fun main() {
    val person = Person("Bob", true)
    println("Hello, ${person.name}!")    // 실제로는 getter 가 호출된다
    println(person.isMarried)           // 실제로는 getter 가 호출된다

    val rectangle = Rectangle(41, 43)
    println(if (rectangle.isSquare) "Square" else "Not square")

    val kim = Person2("Dohun Kim")
    val yoon = Person2("Greathoney", Language.FR)

    kim.greet()
    yoon.greet()
}
```

자바에서 Person 클래스를 사용한다면
```java
public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person("Bob", true);
        System.out.println("Hello, " + person.getName() + "!");
        System.out.println(person.isMarried());
    }
}
```
와 같이 사용할 수 있을 것이다
   
변수이름이 name 이므로 컴파일될 때 getName(), setName() 과 같이 이름이 지어진다

물론 Person 클래스 정의에서 name 이 val 로 선언되었으므로 getter 만 생성된다

한편 변수이름이 isMarried 와 같이 isXXXX 의 형태인 경우

getter 는 isMarried(), setter 는 setMarried() 와 같이 이름이 지어진다

```kt
println(if (rectangle.isSquare) "Square" else "Not square")
```

expression 형태 if 문을 통해 isSquare 의 값에 따라 다른 문자열이 출력되도록 해보았다

Kotlin 문법의 매력적이면서도 멋진 특성이라고 생각한다
 

<hr>
</p></details>

<details><summary> EnumAndWhen.kt </summary>
<p>
<hr>

## EnumAndWhen.kt
    
```kt
enum class Color1 {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(63, 0, 255), VIOLET(238, 130, 238);

    fun rgb() = ((r * 256 + g) * 256 + b).toString(16)
}
```

enum 내부에 값과 함수까지 정의하였다

코틀린에서는 ; 를 사용하지 않지만 enum 의 마지막에는 꼭 사용해야한다

```kt
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
```

when 은 Java 에서의 switch 와 비슷하면서 좀더 편하게 사용할 수 있다

switch 는 매 case 마다 break 를 해주어야 했던 것에 비해 when 은 break 가 필요없다

이를 통해 break 를 빼먹어서 발생하는 오류를 막을 수 있다

또한 Kotlin 에서 when 은 인수로써 object 를 받는 것이 가능하다

```kt
fun mixOptimized(c1: Color, c2: Color) = when {
    (c1 == Color.RED && c2 == Color.YELLOW) || (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
    (c1 == Color.YELLOW && c2 == Color.BLUE) || (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
    (c1 == Color.BLUE && c2 == Color.VIOLET) || (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
    else -> throw Exception("Dirty color")
}
```

위의 함수와 같이 when 은 인자값 없이도 사용할 수 있다

단 이때 조건부분은 반드시 Boolean 을 반환하는 expression 이어야한다

위의 mix() 함수는 매 케이스 마다 set 객체를 생성하기 때문에 비효율적이므로

mixOptimized() 와 같이 객체 생성을 줄이고 논리식으로 대체하여 개선을 할 수 있다

```kt
fun main() {
    println((Color.INDIGO.rgb()))
    println(getAlphabet(Color.INDIGO))
    println(getWarmth(Color.INDIGO))
    println(mix(Color.BLUE, Color.YELLOW))
    println(mixOptimized(Color.YELLOW, Color.RED))
}
```

<hr>
</p></details>


<details><summary> WhenAndSmartCast.kt </summary>
<p>
<hr>

## WhenAndSmartCast.kt

```kt
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

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
```
 
Smart cast : 객체의 타입 확인과 동시에 형변환(casting) 을 해주는 기능

위의 eval1 함수의 if 문 부분을 when 을 이용해서 간소화 시킬 수 있다

```kt
fun eval2(e: Expr): Int =
    when (e) {
        is Num -> e.value                           // Smart cast to Num
        is Sum -> eval2(e.right) + eval2(e.left)    // Smart cast to Sum
        else -> throw IllegalArgumentException("Unknown expression")
    }
```

아래와 같이 when 문에서 -> 뒤의 값을 block 을 사용해서 표현할 수도 있다
    
이때 block 의 마지막 문장이 block 전체의 결과값이 된다

```kt
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
```

```kt
fun main() {
    println(eval1(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(eval2(Sum(Num(346), Num(765))))
    println(evalWithLogging(Sum(Num(876), Num(315))))
}
```

<hr>
</p></details>

<details><summary> Iteration.kt </summary>
<p>
<hr>

## Iteration.kt

```kt
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
```

<hr>
</p></details>
