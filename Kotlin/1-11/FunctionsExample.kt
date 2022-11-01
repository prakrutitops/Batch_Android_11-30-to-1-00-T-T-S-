//with para with return type
fun add( a:Int, b:Int) :Int
{
    return  a+b
}
//without para with return type
fun add2() :Int
{
    var a=5
    var b=6

    var c=a+b
    return  c
}
//with para without return type
fun add3(a:Int,b:Int)
{
    var c=a+b
    println(c)
}

//without para without return type
fun add4()
{
    var a=5
    var b=6

    var c=a+b

    println(c)
}
fun main()
{
    println(add(5,6))
    println(add2())
    add3(5,6)
    add4()
}