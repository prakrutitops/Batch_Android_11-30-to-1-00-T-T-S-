class MyConstructorEx(var name:String,var surname:String)
{

    fun mydetail()
    {
        println("my name is $name , my surname is $surname")
    }
}
fun main()
{
    var c =MyConstructorEx("Heet","Nanda")
    c.mydetail()

}