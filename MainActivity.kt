package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
//import android.widget.TextView
//import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//시작 레이아웃 설정

        val rollButton : Button = findViewById(R.id.button)

        //do a dice roll when the app starts
        rollDice()

        rollButton.setOnClickListener { rollDice() }

    }

    /*roll the dice and update the screen with the result*/
    private fun rollDice(){

        val dice = Dice(6)//create new dice object with 6 sides
        val diceRoll = dice.roll()//roll the dice

        val diceImage: ImageView = findViewById(R.id.imageView)//find the imageview in the layout

        //determine which drawable resource ID to use based on the dice roll
        val drawableResource = when(diceRoll)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5

            else -> R.drawable.dice_6
        }

        //update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        //update the content description
        diceImage.contentDescription = diceRoll.toString()


    }
}
class Dice(private val numSides : Int)
{
    fun roll() : Int
    {
        return (1..numSides).random()

    }
}