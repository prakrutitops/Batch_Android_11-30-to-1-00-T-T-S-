interface Print
{
    fun print()
}
interface Show
{
    fun show()
}
class Data :Print,Show
{
    override fun print()
    {
        println("Printing")
    }

    override fun show()
    {
        println("Showing")
    }

}
fun main()
{
    var d = Data()
    d.print()
    d.show()
}