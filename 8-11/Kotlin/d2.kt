enum class colour
{
    Red,Green,Blue,Black,White,Orange,Yellow;
}
fun main()
{
    var c1 : colour
    c1 = colour.Red
    println("value of c1 : "+c1);

    c1=colour.White
    if(c1 == colour.White)
    {
        println("c1 contains White")
    }
    else
    {
        println("c1 contains Blue")
    }

    when(c1)
    {
        colour.Red -> println("color is Red")
        colour.Green -> println("color is Green")
        colour.Orange-> println("color is Orange")
        colour.Yellow-> println("color is Yellow")
        colour.Blue -> println("color is blue")
        colour.Black -> println("color is black")
        colour.White -> println("color is white")
    }
}
