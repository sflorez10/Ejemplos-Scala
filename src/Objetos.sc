//Declaracion de objetos. En Scala son singleton
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
//Creacion de objeto
Declaracion.main()

