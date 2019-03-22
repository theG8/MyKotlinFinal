package de.g8keeper.mykotlinfinal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_show_lists.*
import java.util.*

class ShowLists : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_lists)


        textView.text = ""

        val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val numbers2 = arrayOf<Int>(1, 2, 3, 4, 5)
        val numbers3 = IntArray(10) { i -> -1 }
        val numbers4 = IntArray(10, { i -> i * 10 })

        val values = arrayOf(1, 2, 3, 4, 5, "Hallo") // entspricht arrayOf<Any>

        val twoDimArray = Array(10, { i -> IntArray(10, { i -> i + 1 }) })
        val twoDimArray2 = Array(10, { IntArray(10, { it + 1 }) })


        for (array in twoDimArray) {
            for ((index, value) in array.withIndex()) {
                textView.append("($index): $value, ")
            }
            textView.append("\n")
        }

        val zahl1 = 123
        val zahl2 = 234

        var max = if (zahl1 > zahl2) zahl1 else zahl2
        max = maxValue1(zahl1, zahl2)

        button2.setOnClickListener {

            startActivity(Intent(this@ShowLists, NullSafety::class.java))

        }

        for(i in numbers2.size -1 downTo 0 step 2)
            textView.append(" :  $i \n")

//        Arrays.stream(twoDimArray)

        checkValue(1)
        checkValue("Hallo")
    }

    fun maxValue1(valA: Int, valB: Int) = if (valA > valB) valA else valB

    fun maxValue2(valA: Int, valB: Int): Int {
        if (valA > valB) {
            return valA
        } else {
            return valB
        }
    }

    fun maxValue3(valA: Int, valB: Int): Int {
        return if (valA > valB) {
            valA
        } else {
            valB
        }
    }


    fun checkValue(zahl: Any) {
        when (zahl) {
            0 -> textView.append("Wert 0\n")

            in 1..17 -> textView.append("Jünger als 18\n")

            18,19,20 -> textView.append("der Wert ist 18, 19 oder 20\n")

            "Hallo" -> textView.append("Hallo\n")


            else-> textView.append("Ungültig\n")


        }
    }

}
