class MyFirstClass
{
    fun hasPassed(marks : Int) : Boolean
    {
        return marks > 40
    }
}
fun MyFirstClass.isscholar(marks: Int) :Boolean
{
    return marks>95
}
fun main()
{
    var m = MyFirstClass()
    println("Passed status :    "+m.hasPassed(45))
    println("Scholarship status : "+m.isscholar(96))
}