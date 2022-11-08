data class User (var name : String, var id : Int)
{

}

fun main()
{
    var u1 = User("Heet",101)
    var u2 = User("Heet",102)
    var u3 =u1.copy()

    if(u1==u2)
    {
        print("same")
    }
    else
    {
        print("Diffrent")
    }
    print(u3)
}