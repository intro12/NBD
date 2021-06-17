import scala.annotation.tailrec

object Cw1 {
  val DaysList  = List("Poniedziałek","Wtorek","Środa","Czwartek","Piątek")
  val NumberList = List(1,3,4,5,6,0,1,0,6,0,10,7)
  val DoubleList = List(-10.00,-15.20,0,2.50,3.60,20,15,-4.00)

  def forFunction(daysList: List[String]): String = {
    var daysString: String = ""
    for (days <- daysList) {
      daysString = daysString + days + ","
    }
    return daysString.substring(0,daysString.length-1)
  }

  def forPFunction(daysList: List[String]): String = {
    var daysString: String = ""

    for (days <- daysList) {
      if (days.startsWith("P")){
        daysString = daysString + days + ","
      }
    }

    return daysString.substring(0,daysString.length-1)
  }

  def whileFunction(daysList: List[String]): String = {
    var daysString: String = ""
    var i = 0
    val daysListSize = daysList.size

    while(i < daysListSize){
      daysString = daysString + daysList(i) + ","
      i += 1
    }
    return daysString.substring(0,daysString.length-1)
  }

  def recursiveFunction(daysList: List[String]): String = {

    def recursiveFunctionAdd(daysList: List[String], i: Int): String = {
      if (i == daysList.size-1){
        daysList(i)
      }
      else{
        daysList(i)+ "," + recursiveFunctionAdd(daysList,i+1)
      }
    }
    recursiveFunctionAdd(daysList, 0)
  }

  def recursiveFunctionFromEnd(daysList: List[String]): String = {

    def recursiveFunctionFromEndAdd(daysList: List[String], i: Int): String = {
        if (i == daysList.size-1){
          daysList(i)
        }
        else{
          recursiveFunctionFromEndAdd(daysList,i+1) + "," + daysList(i)
        }
    }
    recursiveFunctionFromEndAdd(daysList, 0)
//    return recursiveFunctionAdd.substring(0,daysString.length-1)
  }

  def recursiveTailFunction(daysList: List[String]): String ={
    @tailrec
    def recursiveTailFunctionAdd(daysString: String,daysList: List[String]): String ={
      if (daysList.isEmpty) {
        daysString
      }
      else{
        recursiveTailFunctionAdd(daysString+","+daysList.head,daysList.tail)
      }
    }
    recursiveTailFunctionAdd(daysList.head,daysList.tail)
  }

  def foldlFunction(daysList: List[String]): String ={
    daysList.fold(""){
      (all,curr)=>{
        all+curr+","
      }
    }.dropRight(1)
  }

  def foldrFunction(daysList: List[String]): String={
    daysList.foldRight(""){
      (all,curr)=>{
        all+","+curr
      }
    }.dropRight(1)
  }

  def foldlOnlyPFunction(daysList: List[String]): String={
    daysList.fold(""){
      (all,curr)=>{
        if(curr.startsWith("P")){
          all+curr+","
        }
        else {
          all
        }

      }
    }.dropRight(1)
  }

  def printTuple(tt: (Int,String,Any))={
    println(tt._1)
    println(tt._2)
    println(tt._3)
  }

  def optionMap(x: Option[Double]) = x match {
    case Some(s) => s
    case None => "Brak tego w mapie"
  }

  def zeroEraser(numList : List[Int]): List[Int]={
    @tailrec
    def zeroEraserMinus(numList : List[Int], accList: List[Int]): List[Int]={
      if(numList.isEmpty){
        accList
      }
      else{
        if (numList.head == 0) {
          zeroEraserMinus(numList.tail,accList)
        }
        else{
          zeroEraserMinus(numList.tail,accList :+ numList.head)
        }
      }
    }
    zeroEraserMinus(numList,List())
  }

  def incrList(numList: List[Int]): List[Int] = {
    numList map (v => v+1)
  }

  def filterRangeList(numList: List[Double]): List[Double] ={
    val filteredNumList = numList filter(v => v >= -5 && v <= 12)

    filteredNumList map(v => v.abs)
  }

  def main(args: Array[String]): Unit = {
    println("Zadanie 1a: "+forFunction(DaysList))
    println("Zadanie 1b: "+forPFunction(DaysList))
    println("Zadanie 1c: "+whileFunction(DaysList))
    println("Zadanie 2a: "+recursiveFunction(DaysList))
    println("Zadanie 2b: "+recursiveFunctionFromEnd(DaysList))
    println("Zadanie 3: "+recursiveTailFunction(DaysList))
    println("Zadanie 4a: "+foldlFunction(DaysList))
    println("Zadanie 4b: "+foldrFunction(DaysList))
    println("Zadanie 4c: "+foldlOnlyPFunction(DaysList))

    val products = Map("Mąka"->3.00,"Cukier"->5.00,"Ziemniaki"->6.00,"Cebula"->3.50)
    val prodcutsPromo = products map {case (k,v) => (k,v*0.9)}
    println("Zadanie 5: "+prodcutsPromo)

    val tt = (4,"COś",DaysList)
    println("Zadanie 6:")
    printTuple(tt)

    println("Zadanie 7:")
    println(optionMap(products.get("Mąka")))
    println(optionMap(products.get("Mleko")))
    println("Zadanie 8: "+zeroEraser(NumberList))
    println("Zadanie 9: "+incrList(NumberList))
    println("Zadanie 10: "+filterRangeList(DoubleList))

  }

}
