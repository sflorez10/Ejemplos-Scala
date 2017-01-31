//Expresiones retornan un valor
val h = {
  val j1 = 1
  val j2 = 2
  j1 + j2
}

//If-else
val exist = {
  val j1 = 2
  val j2 = 4
  //No se utiliza return
  if(j1 > j2){
    true
  }
  else{
    false
  }
}

//Cuando no retorna un valor toma el valor de Unit
val pr = println(105)

//while, for cuentan como expresiones en Scala retornan Unit
var i = 2
while (i>0){
  println(i)
  i = i-1
}

for(j <- 0 to 2){
  println(j)
}

for(j <- 2 to 0){
  println(j)
}

//Declaracion de metodos
def metodo (i : Int): Int ={
  i+1
}
var ans = metodo(1)