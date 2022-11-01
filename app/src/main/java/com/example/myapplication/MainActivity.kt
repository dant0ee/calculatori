package com.example.myapplication

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var text1:TextView
    private var operation =" "
    private var operand = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text1=findViewById(R.id.textview)
    }
    fun onclicl(clickedview: View){
        if (clickedview is TextView){
            var number=clickedview.text.toString()
            var text =text1.text.toString()

            if (text =="0"){
                text=" "
            }
            text1.text=text + number
        }
    }
    fun operationClicl(clickedview: View){
        if (clickedview is TextView){
            operation=clickedview.text.toString()

            operand=text1.text.toString().toDouble()
            text1.text="0"
        }
    }
    fun equalsClicl(clickedview: View){

        var operand1= text1.text.toString().toDouble()
        if (operation==" "){
            text1.text=text1.text.toString()
        }else
            when(operation){

                "+" -> text1.text=(operand + operand1).toString()
                "-" -> text1.text=(operand - operand1).toString()
                "*" -> text1.text=(operand * operand1).toString()
                "/" -> text1.text=(operand / operand1).toString()

            }
            operation =" "
            operand1
            var newnumber=text1.text.toString()
            if (newnumber.substring(newnumber.length-2,newnumber.length)==".0"){
                text1.text=newnumber.substring(0, newnumber.length-2)
            }
    }
    fun cleartext(view: View){
        text1.text= "0"
        operand=0.0
    }
    fun delete(view: View){
        var newoperand =operand.toString().substring(0,operand.toString().length-2)
        var txt= text1.text.toString()
        if (txt.length==1 && operand==0.0){
            text1.text=newoperand
            operand=0.0

        }else{
            text1.text=txt.substring(0, txt.length-1)
        }
    }
    fun dotclicl(view: View){
        var dota2= false
        var txt =text1.text.toString()
        for (i in 0 until txt.length){
            if (txt[i]=='.'){
                dota2 = true
            }
        }
        if (dota2== false){
            text1.text=txt +'.'
        }
    }
}
