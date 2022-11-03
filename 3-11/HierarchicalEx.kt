open class Bank
{
    fun bank()
    {
        println("banking")
    }
}
class Current :Bank()
{
    fun current()
    {
        println("current")
    }
}
class Save :Bank()
{
    fun save()
    {
        println("save")
    }
}
fun main()
{
    var c =Current()
    var s =Save()

    c.current()
    s.save()
    c.bank()
}