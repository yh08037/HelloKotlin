class Person (
    val name: String,       // val -> getter 생성
    var isMarried: Boolean  // var -> getter, setter 생성
)
/*  Java 에서는 캡슐화를 위해 멤버변수를 private 선언하고 get, set 메소드를 통해 접근하였지만
    Kotlin 은 get, set 메소드가 묵시적으로 생성되고, 실제로 사용할 때는 직접 접근하듯이 사용하면 된다
    또한 Java 문법과 비교했을 때, 멤버변수 선언과 이를 초기화해주기 위한 생성자를 따로 정의하는데에 비해
    Kotlin 에서는 class ClassName(name: type , ... ) { ... } 와 같은 형태로 정의하여 그대로 생성자로 사용한다
    또한 객체를 생성하는데에 있어서 new 키워드를 사용하지 않는다
 */

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}
/*  getter 와 setter 가 묵시적으로 자동 생성되지만 특정 구현부를 넣고 싶은 경우도 있다
    이런 경우 위의 isSquare 와 같이 get() set() 메소드를 직접 구현할 수도 있다
 */

enum class Language(val greeting: String) {
    EN("Hello"), ES("Hola"), FR("Bonjour")
}

class Person2(val name: String, val lang: Language = Language.EN) {
    fun greet() = println("${lang.greeting}, $name!")
}
/*  Kotlin 에서는 인자들의 기본값을 설정해줄 수 있다
    기본값이 설정되어있는 인자는 인스턴스를 생성할 때 생략할 수 있다
 */

fun main() {
    val person = Person("Bob", true)
    println("Hello, ${person.name}!")    // 실제로는 getter 가 호출된다
    println(person.isMarried)           // 실제로는 getter 가 호출된다
    /*
    자바에서 Person 클래스를 사용한다면

    Person person = new Person("Bob", true);
    System.out.println("Hello, " + person.getName() + "!");
    System.out.println(person.isMarried());

    와 같이 사용할 수 있을 것이다
    변수이름이 name 이므로 컴파일될 때 getName(), setName() 과 같이 이름이 지어진다
    물론 Person 클래스 정의에서 name 이 val 로 선언되었으므로 getter 만 생성된다
    한편 변수이름이 isMarried 와 같이 isXXXX 의 형태인 경우
    getter 는 isMarried(), setter 는 setMarried() 와 같이 이름이 지어진다
     */

    val rectangle = Rectangle(41, 43)
    println(if (rectangle.isSquare) "Square" else "Not square")
/*  expression 형태릐 if 문을 통해 isSquare 의 값에 따라 다른 문자열이 출력되도록 해보았다
    Kotlin 문법의 매력적이면서도 멋진 특성이라고 생각한다
 */

    val kim = Person2("Dohun Kim")
    val yoon = Person2("Greathoney", Language.FR)

    kim.greet()
    yoon.greet()
}