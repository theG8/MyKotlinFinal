package de.g8keeper.mykotlinfinal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_output.*

class Output : AppCompatActivity() {

    var tmpText = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        val value = intent.getStringExtra("value")

        ausgabe.text = "Die Ausgabe von Seite 1 ist: $value, fertig ist der Text"


    }


    fun clear(view: View) {
        tmpText = ausgabe.text.toString()
        ausgabe.text = ""
        val msb = Snackbar.make(const_layout_output, "Rückgängig machen", Snackbar.LENGTH_LONG)

        msb.setAction("UNDO", MyUndoListener())
        msb.show()

    }

    fun next(view : View){
        startActivity(Intent(this, ShowLists::class.java))
    }

    inner class MyUndoListener : View.OnClickListener {
        override fun onClick(v: View?) {
            ausgabe.text = tmpText
            Toast.makeText(this@Output, "Löschen wurde rückgängig gemacht",Toast.LENGTH_LONG).show()

        }


    }
}
