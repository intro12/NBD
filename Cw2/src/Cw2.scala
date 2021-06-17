object Cw2 {

  def checkDays(day: String) = day match {
    case "Poniedziałek" => "Praca"
    case "Wtorek" => "Praca"
    case "Sroda" => "Praca"
    case "Czwartek" => "Praca"
    case "Piątek" => "Praca"
    case "Sobota" => "Weekend"
    case "Niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia"
  }

  class KontoBankowe(poczatkowyStan: Double){
    private var _stanKonta: Double = poczatkowyStan

    def this(){
      this(0)
    }

    def stanKonta: Double = _stanKonta

    def wplata(kwota: Double): Unit ={
      _stanKonta += kwota
    }

    def wyplata(kwota: Double): Unit ={
      _stanKonta -= kwota
    }
  }

  case class Osoba3(imie: String,nazwisko: String){
  }

  def przywitanie(osoba: Osoba3) = osoba match{
    case Osoba3("Aleksander","Kowalski") => "No siemka Olek"
    case Osoba3("Jan","Kuliński") => "Uszanowanie Janek"
    case Osoba3("Rafał","Karpiesiuk") => "Witam Rafał"
    case _ => "Witam"
  }

  def multiplication(x: Int)={
    x*3
  }

  def multiplication3(x: Int, fun: (Int)=>Int):Int = {
    fun(fun(fun(x)))
  }

  abstract class Osoba5(val imie: String, val nazwiwsko: String){
    val podatek: Double
  }

  trait Pracownik extends Osoba5{
    val pensja: Double = 2000.00
    override val podatek: Double = 0.2 * pensja
  }

  trait Student extends Osoba5{
    override val podatek: Double = 0.0
  }

  trait Nauczyciel extends Pracownik{
    override val podatek: Double = 0.1 * pensja
  }

  def main(args: Array[String]): Unit = {

    println("Zadanie 1:")
    println(checkDays("Wtorek"))
    println(checkDays("Sobota"))
    println(checkDays("Poniedzielnik"))

    println("Zadanie 2:")
    var konto = new KontoBankowe()
    println(konto.stanKonta)
    konto.wplata(10)
    println(konto.stanKonta)
    konto.wyplata(5)
    println(konto.stanKonta)

    var konto1 = new KontoBankowe(10)
    println(konto1.stanKonta)
    konto1.wplata(10)
    println(konto1.stanKonta)
    konto1.wyplata(5)
    println(konto1.stanKonta)

    println("Zadanie 3:")
    var osoba1 = new Osoba3("Aleksander","Kowalski")
    var osoba2 = new Osoba3("Jan","Kuliński")
    var osoba3 = new Osoba3("Rafał","Karpiesiuk")
    var osoba4 = new Osoba3("Asia","Szczech")

    println(przywitanie(osoba1))
    println(przywitanie(osoba2))
    println(przywitanie(osoba3))
    println(przywitanie(osoba4))

    println("Zadanie 4: " + multiplication3(3,multiplication))
    println("Zadanie 5:")
    val s = new Osoba5("Student","Student") with Student
    println("podatek Studenta: "+s.podatek)
    val n = new Osoba5("Nauczyciel","Nauczyciel") with Nauczyciel
    println("podatek Nauczyciela: "+n.podatek)
    val p = new Osoba5("Pracownik","Pracownik") with Pracownik
    println("podatek Pracownika: "+p.podatek)
    val sp = new Osoba5("Student-Pracownik","Student-Pracownik") with Student with Pracownik
    println("podatek Student-Pracownik: "+sp.podatek)
    val ps = new Osoba5("Pracownik-Student","Pracownik-Student") with Pracownik with Student
    println("podatek Pracownik-Student: "+ps.podatek)

  }

}
