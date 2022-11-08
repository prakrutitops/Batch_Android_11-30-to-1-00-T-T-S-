fun main()
{
    var data = mutableMapOf<String,Int>("A" to 1,"B" to 2)

    for(key in data.keys)
    {
        println("Element at key : $key =${data[key]}") // myMap.get(key)

    }
}