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

    var patas = cPatas

    private def metodoPrivado(x:Int): Unit ={
      println("metodo privado " + x)
    }

    protected def metodoProtegido(x:Int):Unit={
      patas = 6
    }

    def metodoPublico(x:Int):Unit={
      println("metodo publico " + x)
    }
  }

  class Perro(patas:Int, sonido:String, val cDomestico: Boolean)
    extends Animal(patas, sonido){

    val domestico = cDomestico

    override def metodoProtegido(x:Int){
      super.metodoProtegido(x)
      println("patas " + patas)
      //patas = 5 //patas es inmutable en Animal
      println("patitas " + patas)
    }
  }

  def main(){
    //Creacion de objeto
    val perro = new Perro(4, "roof", true)
    perro.metodoPublico(1)
    perro.metodoProtegido(1)
    //perro.metodoPrivado(1) no es posible
  }
}

Herencia.main()



