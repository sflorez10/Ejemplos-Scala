//Arreglos mutables
var arreglo = Array[Int](1,2,3,4,5)
//var arreglo = Array(1,2,3,4,5)
println(arreglo(2))

var arreglo2 = Array(1,"hola", 2.0, 'a')
println(arreglo2(3))

//Listas son inmutables
var lista = List(1,2,3,4,5)
List.fill(10)(0)
lista(0) == lista.head

//append 1 elemento antes de la lista
0 :: lista
//
List(-1,0) :: lista //se debe tener 1 elemento
0 +: lista

//Sets no mantienen orden
var set = Set(1,2,3,4,5,6)

//Tuplas
//Declaracion
val tuple = Pair(40, 60)
val tuple2 = 50 -> 60

//Maps
val map = Map("uno" -> 1)
val get1 = map("uno")
//map.get retorna valor opcional
val get2 = map.get("uno")
println(get2.getOrElse(0))

//Operadores de colecciones
//map retorna nueva coleccion
lista.map(i => i*2)

val m3 = (i:Int) => i*3
lista.map(m3)

lista map m3

//foreach retorna Unit
lista foreach m3
println(lista)

//filter aplica predicados y filtra la coleccion
lista filter (_%2 == 0)

//zip junta dos listas valor a valor l(a) + l(b) = L(a,b)
//El resultado tiene longitud de la coleccion de menor tamaño
val listaZip = lista.zip(set)

//Partition crea conjuntos de valores que cumplen y no cumplen un predicado
lista partition (_%2 == 0)

//Flatten junta listas
List(List(1,2,3), List(9,8,7)).flatten
List(1,2,3) ::: List(9,8,7)

//find Enconstrar el primer elemento que cumpla con el predicado
var found : Int = (lista find (_==5)).getOrElse(0)

//drop elimina la cantidad dada de elementos
lista drop 2

//drop while elimina los elementos hasta que se deje de cumplir un predicado
lista dropWhile (_<4)

//foldLeft acumula según una funcion de izquierda a derecha
lista.foldLeft(0){(acc:Int, i:Int)=> acc + i}

//flatMap = flat + map
List(List(1,2,3), List(9,8,7)).flatMap(x => x.map(x=>x*2))




