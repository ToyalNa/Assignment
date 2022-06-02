package com.example.radiogroup_switch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img=findViewById<ImageView>(R.id.idImg)
        val showSwitch = findViewById<Switch>(R.id.idSwitch)
        showSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            img.isVisible=isChecked
        }
    }
    fun chooseTurtle(view: View){
        val img=findViewById<ImageView>(R.id.idImg)
        val desc=findViewById<TextView>(R.id.idName)
        when(view.id){
            R.id.idDon ->{
                desc.text="You have chosen Don"
                img.setImageResource(R.drawable.don)
            }
            R.id.idRaph ->{
                desc.text="You have chosen Raph"
                img.setImageResource(R.drawable.raph)
            }
            R.id.idLeo ->{
                desc.text="You have chosen Mike"
                img.setImageResource(R.drawable.leo)
            }
            R.id.idMike ->{
                desc.text="You have chosen Leo"
                img.setImageResource(R.drawable.mike)
            }
        }
    }
}