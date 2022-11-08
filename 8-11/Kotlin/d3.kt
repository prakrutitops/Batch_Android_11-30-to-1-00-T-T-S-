class Sender
{
    fun send(msg:String)
    {

        print("Sending $msg")

            Thread.sleep(2000)

        print("$msg Sent")

    }

}

class ThreadSend(var sender: Sender,var msg:String) :Thread() {

    override fun run()
    {
        synchronized(sender)
        {
            sender.send(msg)
        }
    }

}

fun main()
{
    var sender = Sender()

    var t1 =ThreadSend(sender,"Hii")
    var t2 =ThreadSend(sender,"Byee")

    t1.start()
    t2.start()

}