package com.ronney.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var diceImage1: ImageView // instania automatica
    lateinit var diceImage2: ImageView

    var randomInt1: Int = 1
    var randomInt2: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countDownButton: Button = findViewById(R.id.count_button)
        countDownButton.setOnClickListener { countDice() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { resetDice() }
    }

    private fun resetDice() {
        randomInt1 = 1
        randomInt2 = randomInt1

        defineImage1()
        defineImage2()
    }

    private fun countDice() {
        randomInt1++
        randomInt2++

        defineImage1()
        defineImage2()
    }

    private fun rollDice() {
        randomInt1 = defineRandom1()
        defineImage1()

        randomInt2 = defineRandom2()
        defineImage2()

    }

    private fun defineRandom1(): Int {
        return (1..6).random()
    }

    private fun defineRandom2(): Int {
        return (1..6).random()
    }

    private fun defineImage1() {
        val drawableResource = when (randomInt1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage1.setImageResource(drawableResource)
    }

    private fun defineImage2() {
        val drawableResource = when (randomInt2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource)
    }

}