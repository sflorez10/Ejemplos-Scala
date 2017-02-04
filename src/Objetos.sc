/*
* Declaracion de objetos.
* En Scala son singleton
* No reciben parametros
* */
object Declaracion{
  def main(){
    //Creacion de objeto
    val john = new Persona("John", "Doe", 1987)
    println(john.calcularEdad())
    println(john.nombreCompleto)
  }

  //Declaracion de clases
  class Persona (cNombre:String, cApellido: String, cAnio:Int){
    var nombre = cNombre
    var apellido = cApellido
    var anio = cAnio
    var nombreCompleto ={
      nombre + " " + apellido
    }

    def calcularEdad(): Int ={
      2017 - anio
    }
  }
}
//Instancia de objeto
Declaracion.main()

object Herencia{
  abstract class Animal(cPatas:Int, val sonido:String){

    protected var patas : Int = cPatas

    private def metodoPrivado(x:Int): Unit ={
      println("metodo privado " + x)
    }

    protected def metodoProtegido(x:Int):Unit={
      patas = 6
      println("patas protected " + patas)
    }

    def metodoPublico(x:Int):Unit={
      println("metodo publico " + x)
    }
  }

  class Perro(cPatas:Int, sonido:String, val cDomestico: Boolean)
    extends Animal(cPatas, sonido){

    val domestico = cDomestico

    override def metodoProtegido(x:Int){
      super.metodoProtegido(x)
      println("patas instancia " + patas)
    }

    override def toString() : String = {
      patas + " " + sonido + " " + domestico
    }
  }

  def main(){
    //Creacion de objeto
    val perro = new Perro(4, "roof", true)
    perro.metodoPublico(1)
    perro.metodoProtegido(1)
    println(perro)
    //perro.metodoPrivado(1) no es posible
  }
}

Herencia.main()


object Interfaces{
  //Trait concepto similar a interfaz. Puede ser parcialmente implementada
  trait Similaridad {
    def esSimilar(x: Any): Boolean //no implementado
    def noEsSimilar(x: Any): Boolean = !esSimilar(x) //implementado
  }

  class Rectangulo(cX:Int, cY:Int) extends Similaridad{
    val x = cX
    val y = cY
    def esSimilar(z: Any) =
      //Cast se hace con el metodo asInstanceOf[<Clase>]
      z.isInstanceOf[Rectangulo] && z.asInstanceOf[Rectangulo].x == x
  }
}

//Mezcla de implementaciones entre clases (Delta de implementaciones)
object Mixins{

  //Clase abstracta
  abstract class AbsIterator {
    type T
    def hasNext: Boolean
    def next: T
  }

  //Mixins deben ser creados como trait
  trait RichIterator extends AbsIterator {
    def foreach(f: T => Unit) { while (hasNext) f(next) }
  }

  class StringIterator(s: String) extends AbsIterator {
    type T = Char
    private var i = 0
    def hasNext = i < s.length()
    def next = { val ch = s charAt i; i += 1; ch }
  }

  object StringIteratorTest {
    def main(args: Array[String]) {
      //Iter hereda de StringIterator mixin con RichIterator
      class Iter extends StringIterator(args(0)) with RichIterator
      val iter = new Iter
      //Iter ahora hace uso de funcion presente en richiterator
      iter foreach println
    }
  }
}

/*
*Case Classes
* Son inmutables
* Comparacion por estructura y no referencia
*/
case class Triangulo(l1:Double, l2: Double, l3: Double)
val triangulo1 = Triangulo(2.0,3,4)//no se usa new
val triangulo2 = Triangulo(2.0,3,4)
val triangulo3 = Triangulo(1.0,3,4)
println(triangulo1 == triangulo2)
println(triangulo1 == triangulo3)

object Twice {
  def apply(x: Int): Int = x * 2
  def unapply(z: Int): Option[Int] = if (z%2 == 0) Some(z/2) else None
}
object TwiceTest {
  val x = Twice(21)
  x match { case Twice(n) => Console.println(n) } // prints 21
}
TwiceTest



