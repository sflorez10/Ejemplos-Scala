//Declaracion de funciones anonimas
val suma = (x:Int, y: Int) => x+y
val resta = (x:Int, y: Int) => x-y

/*
* Funciones de orden mayor
* Uso de funciones anonimas como parametros
*/
def llamarFuncion(x:Int, y:Int, f:(Int,Int) => Int): Int ={
  f(x,y)
}

llamarFuncion(2,3,suma)
llamarFuncion(2,3,resta)

//Uso de type como alias
type valores = (Int, Int, Int, Int)
var invertir = (x1:Int, x2:Int, x3:Int, x4:Int) => (x4,x3,x2,x1)
def fun(f: => valores): valores ={
  f
}

println(fun(invertir(1,2,3,4)))

/*
* Funciones polimorficas
* Se parametriza la funcion
*/
def dup[T](x: T, n: Int): List[T] = {
  if (n == 0)
    Nil
  else
    x :: dup(x, n - 1)
}
//Imprime 3 4 veces
println(dup[Int](3, 4))

//imprime three 3 veces.
println(dup("three", 3))