package de.g8keeper.mykotlinfinal

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_functions_and_more.*

class FunctionsAndMore : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_functions_and_more)
        var j = 3
        j.upper(3)


        textView5.append(j.toString() + " " + j.upper(3) + "\n")
        textView5.append(j.toString() + " " + (j upper 3) + "\n")

        val str1: NullSafety.Node = NullSafety.Node("Seb", "Kugler")
        val str2: NullSafety.Node = NullSafety.Node("Seb", "Kugler")
        val str3: NullSafety.Node = str2

        val node1: NullSafety.AllOfNode = NullSafety.Node2("Seb", "Kugler")

        if(node1 is NullSafety.Node2)
            textView5.append("node1 ist ein NodeChild")

        // inhaltlicher vergleich (equals)
        textView5.append("" + (str1 == str2) + " " + (str3 == str2) + "\n")
        // object-vergleich
        textView5.append("" + (str1 === str2) + " " + (str3 === str2))


    }

    infix fun Int.upper(i: Int): Int {
        return this * i
    }


}