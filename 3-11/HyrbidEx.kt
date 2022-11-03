open class P
{
    fun p()
    {
        println("P is called")
    }
}
open class Q :P()
{
    fun q()
    {
        println("Q is called")
    }
}
interface R
{
    fun r()
    {
        println("r is called")
    }
}
class S :Q(),R
{
    fun s()
    {
        println("S is called")
    }
}
fun main()
{
    var s1 = S()
    s1.p()
    s1.q()
    s1.r()
    s1.s()
}