package com.example.alcoolougasolina

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("percentual",percentual)
        super.onSaveInstanceState(outState)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            percentual=savedInstanceState.getDouble("percentual")
        }
        Log.i("PDM24","No onCreate, $percentual")
        val btCalc: Button = findViewById(R.id.btCalcular)
        val textMsg:TextView= findViewById(R.id.textMsg)
        val alcPrice: EditText = findViewById(R.id.edAlcool)
        val gasPrice: EditText = findViewById(R.id.edGasolina)
        //btCalc.setBackgroundColor(Color.CYAN)
        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento
            val proportion = alcPrice.text.toString().toDouble()/gasPrice.text.toString().toDouble()
            if(proportion<percentual){
                textMsg.text="Abasteça com Álcool."
            } else {
                textMsg.text = "Abasteça com Gasolina."
            }
            Log.d("PDM24","No btCalcular, $percentual")
        })
    }

    fun onClickSwitch(v:View){
        val s : Switch = v as Switch
        if (s.isChecked){
            percentual = 0.75
        } else {
            percentual = 0.7
        }
    }
override fun onResume(){
    super.onResume()
    Log.d("PDM24","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.v("PDM24","No onStart")
}
override fun onPause(){
    super.onPause()
    Log.e("PDM24","No onPause")
}
override fun onStop(){
    super.onStop()
    Log.w("PDM24","No onStop")
}
override fun onDestroy(){
    super.onDestroy()
    Log.wtf("PDM24","No Destroy")
}
}