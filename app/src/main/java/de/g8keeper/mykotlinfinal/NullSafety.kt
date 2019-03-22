package de.g8keeper.mykotlinfinal

import android.content.Intent
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
            textView2.append("?itm mit länge $(itm.lenth)\n")
        }


        b = foo(Node("A","Sebastian"))
        val c : Int = b?.length ?: -1
        textView2.append("\n\n $b\n")

        var str = "123444"
        val int: Int? = str.toInt()


        val runner = Runnable {
            Log.d("A","Thread läuft")
            textView2.append("Thread läuft\n")
        }
        Thread(runner).start()



        val a_num = 10
        val b_num = 4

        var arithmetics : IntArithmetics = IntArithmetics.PLUS

        textView2.append("$arithmetics($a_num, $b_num) = ${arithmetics.applyAsInt(a_num, b_num)}\n")

        arithmetics = IntArithmetics.MINUS

        textView2.append("$arithmetics($a_num, $b_num) = ${arithmetics.applyAsInt(a_num, b_num)}\n")

        arithmetics = IntArithmetics.MAL

        textView2.append("$arithmetics($a_num, $b_num) = ${arithmetics.applyAsInt(a_num, b_num)}\n")

        arithmetics = IntArithmetics.GETEILT

        textView2.append("$arithmetics($a_num, $b_num) = ${arithmetics.applyAsInt(a_num, b_num)}\n")



        button4.setOnClickListener {  startActivity(Intent(this,FunctionsAndMore::class.java)) }

    }

    fun foo(node: Node): String? {
        val parent = node.parent ?: return null
        val name = node.name ?: throw IllegalArgumentException()
        return name
    }

    //open muss vor class stehen, damit von der klasse geerbt werden kann
//    open class Node(val parent: String?, val name: String?){
//        constructor():this(null,null)
//
//    }
    data class Node(val parent: String?, val name: String?) : AllOfNode {
        constructor():this(null,null)

    }

    data class Node2(val parent: String?, val name: String?, val ort: String? = null) : AllOfNode {
        constructor():this(null,null)
        fun fromNode(node: Node): Node2 = Node2(node.parent, node.name)

    }

    interface AllOfNode


    class NodeChild(parent:String?,name:String?) : Serializable, Closeable {
        override fun close() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}