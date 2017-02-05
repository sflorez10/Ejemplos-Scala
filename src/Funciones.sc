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
type parPred = (Int,Int,Int,Int,Int) => Int
val gt : parPred = _+_+_+_+_
println(gt(1,1,1,1,1))

//Funciones parciales
type intBool = (Int,Int) => Boolean
def valores (f :Int=>Boolean, l:List[Int]):List[Int]={
  if(l.isEmpty){
    l
  }
  else if (f (l.head) ) {
    l.head :: valores (f, l.tail)
  }
  else {
    valores (f, l.tail)
  }
}
def mod(n: Int)(x: Int) = ((x % n) == 0)

//Se pasa 2 como parametro y la funcion valores evalua el parametro x
println(valores(mod(3), List(2,4,7)))

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

//Multiples argumentos
def capitalizeAll(args: String*) = {
  args.map { arg =>
    arg.capitalize
  }
}
println(capitalizeAll("carro", "casa"));

//composicion de funciones
def list(s:String):List[Char]={
  s.toList
}

def mayuscula(l:List[Char]):List[Char]={
  l map (_.toUpper)
}

var listMayuscula = mayuscula _ compose list _
listMayuscula("Casa")

var listMayuscula2 = list _ andThen mayuscula _
listMayuscula("Perro")
