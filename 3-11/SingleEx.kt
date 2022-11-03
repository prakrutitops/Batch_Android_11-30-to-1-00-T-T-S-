open class A
{
    fun a1()
    {
        println("A is accessed")
    }
}
open class B : A()
{
    fun b1()
    {
        println("B is accessed")
    }
}
class C :B()
{
    fun c1()
    {
        println("C is accessed")
    }
}
fun main()
{
    var c = C()
    c.a1()
    c.b1()
    c.c1()
}