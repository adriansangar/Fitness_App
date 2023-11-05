package com.example.fitness_app

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


// Enum con las opciones
enum class opciones {
    PIEDRA,
    PAPEL,
    TIJERAS,
    LAGARTO,
    SPOCK
}

// Resultados
val resultados = arrayOf(
    arrayOf(opciones.TIJERAS, opciones.PAPEL),
    arrayOf(opciones.TIJERAS, opciones.LAGARTO),
    arrayOf(opciones.PAPEL, opciones.PIEDRA),
    arrayOf(opciones.PAPEL, opciones.SPOCK),
    arrayOf(opciones.PIEDRA, opciones.TIJERAS),
    arrayOf(opciones.PIEDRA, opciones.LAGARTO),
    arrayOf(opciones.LAGARTO, opciones.PAPEL),
    arrayOf(opciones.LAGARTO, opciones.SPOCK),
    arrayOf(opciones.SPOCK, opciones.TIJERAS),
    arrayOf(opciones.SPOCK, opciones.PIEDRA)
)

fun play( p1: opciones, p2:opciones){
    println("Player 1 plays with $p1, Player 2 with $p2")
    if(p1 == p2){
        println("Tie")
    } else {
        var p1Wins = false
        for (i in 0 until resultados.size){
            if (p1 == resultados[i][0] && p2 == resultados[i][1]){
                p1Wins = true
            }
        }

        // Print results
        if (p1Wins) {
            println("Player 1 wins!!")
        } else {
            println("Player 2 wins!!")
        }
    }
}

fun main( args: Array<String>) {
    println("Reto semanal 6: Piedra, papel, tijeras, lagarto, spock")

    // Tie
    var p1Option = opciones.PAPEL
    var p2Option = opciones.PAPEL

    play(p1Option, p2Option)

    // P1 wins
    p1Option = opciones.TIJERAS

    play(p1Option, p2Option)

    // P2 wins
    p2Option = opciones.SPOCK

    play(p1Option, p2Option)
}


class MainActivityKt : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rs6)

        val boton_fight : Button = findViewById(R.id.Fight)
        val P1Spinner : Spinner = findViewById(R.id.P1Option)
        val P2Spinner : Spinner = findViewById(R.id.P2Option)

        ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones.values()).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            P1Spinner.adapter = adapter
            P2Spinner.adapter = adapter
        }

        boton_fight.setOnClickListener{
            // Get the selected item of the player 1 spinner.
            val P1Option = P1Spinner.selectedItem.toString()
            val P2Option = P2Spinner.selectedItem.toString()

            // Validate the user input.
            if (P1Option.isEmpty() || P2Option.isEmpty()) {
                // Show an error message to the user.
                Toast.makeText(this, "Please select an option for both players.", Toast.LENGTH_SHORT).show()
            }

            // Print the selected item to the console.
            println("Player 1 option: $P1Option")
            println("Player 2 option: $P2Option")
            play(opciones.valueOf(P1Option.uppercase()), opciones.valueOf(P2Option.uppercase()))
        }
    }
}