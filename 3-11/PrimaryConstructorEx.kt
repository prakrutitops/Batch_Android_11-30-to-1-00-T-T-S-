class PrimaryConstructorEx(val firstName: String, var age: Int)
{
    fun dispaly()
    {
        println("Your name is $firstName")
        println("Your age is $age")
    }
}
fun main()
{
    var p =PrimaryConstructorEx("Heet",20)
    p.dispaly()

}