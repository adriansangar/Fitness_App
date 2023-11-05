package com.example.fitness_app

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.fitness_app.databinding.ActivityMainBinding

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