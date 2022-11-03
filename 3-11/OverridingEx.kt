open class Bank12
{
    open fun rate():Int
    {
       return 0
    }
}
class Sbi :Bank12()
{
    override fun rate():Int
    {
        return 7
    }
}
class Icici :Bank12()
{
    override fun rate():Int
    {
        return 8
    }
}
class Axis :Bank12()
{
    override fun rate():Int
    {
        return 9
    }
}


fun main()
{

    var b1 =Sbi()
    println(b1.rate())

    var b2 =Icici()
    println(b2.rate())

    var b3 =Axis()
    println(b3.rate())

}