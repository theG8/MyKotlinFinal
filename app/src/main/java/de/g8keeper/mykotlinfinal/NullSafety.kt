package de.g8keeper.mykotlinfinal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_nullsavety.*
import java.io.Closeable
import java.io.Serializable
import java.lang.IllegalArgumentException

class NullSafety : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nullsavety)


        var a: String = "abc"
        // geht nicht:
        // a = null

        //geht
        var b: String? = "abc"

//        b = null

        val l = a.length
        var length: Int? = if (b != null) b.length else -1

        length = b?.length

        length?.compareTo(2)


        val listWithNulls: List<String?> = listOf("Hallo ", null, "Welt")

        val stringList : List<String> = listWithNulls.filterNotNull()


        for (item in listWithNulls) {
            item?.let {
                textView2.append("$it mit länge ${it.length}\n")
            }
        }


        for (itm in stringList) {
            textView2.append("?itm mit länge $(itm.lenth)")
        }


        b = foo(Node("A","Sebastian"))
        val c : Int = b?.length ?: -1
        textView2.append("\n\n $b")

        var str = "123444"
        val int: Int? = str.toInt()


        val runner = Runnable {
            Log.d("A","Thread läuft")
        }
        Thread(runner).start()
    }

    fun foo(node: Node): String? {
        val parent = node.parent ?: return null
        val name = node.name ?: throw IllegalArgumentException()
        return name
    }

    //open muss vor class stehen, damit von der klasse geerbt werden kann
    open class Node(val parent: String?, val name: String?){
        constructor():this(null,null)

    }

    class NodeChild(parent:String?,name:String?) : Node(parent, name), Serializable, Closeable {
        override fun close() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}