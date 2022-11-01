import java.lang.Integer.parseInt

fun main()
{

    var a = IntArray(5)

    for(i in 0..4)
    {
        println("Enter Number")
        var a2= readLine()

        a[i] = parseInt(a2)

    }

    for(i in 0..4)
    {
        println("Your Numbers are: ")
        println(a[i])
    }

}