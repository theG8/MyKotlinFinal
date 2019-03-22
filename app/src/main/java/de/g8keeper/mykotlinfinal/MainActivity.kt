package de.g8keeper.mykotlinfinal

import android.content.Intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv.setText("Hallo Kotlin")

        val p = Person("Sebastian", "Kugler", "Hauptstr.", 49,"Seligenstadt", "63500", 37)

        tv.append("\n" + p.nName)

        val p2  = PersonK("Sebastian", "Kugler", "Hauptstr.", 49,"Seligenstadt", "63500", 37, true)

        val p3 = p2.copy()

        p2.strasse = "test"

        tv.append("\n" + p2.strasse)
        tv.append("\n" + JavaActivity().doit())


    }

    fun send(view : View){
        val intent = Intent(this,Output::class.java)
        intent.putExtra("value", tv.text.toString())

        test()

        startActivity(intent)

    }
}

// geht auch außerhalb von Klassen! ->
fun test(){
    print("Hallo")
}