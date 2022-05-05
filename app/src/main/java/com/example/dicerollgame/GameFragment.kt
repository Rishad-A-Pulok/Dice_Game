package com.example.dicerollgame

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dicerollgame.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    var dice1 = 0
    var dice2 = 0
    var point = 0
    var score = 0
    var isFirstRoll = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        binding.restartBtn.visibility =View.INVISIBLE
        binding.diceRollBtn.setOnClickListener {
            binding.startMsgTV.visibility = View.INVISIBLE
            rollDice()
        }
        return binding.root
    }

    private fun rollDice() {
        generateDiceNum()
        getResult()
    }

    private fun getResult() {
        if(isFirstRoll){
            if(score == 7 || score == 11){
                winGame()
            }
            else if(score == 2 || score == 3 || score == 12){
                looseGame()
            }
            else{
                point = score
                binding.pointTV.setText("Point: ${point.toString()}")
                binding.pointTV.setTextColor(Color.BLUE)
                binding.diceRollBtn.text = "Roll Again"
            }
            isFirstRoll = false
        }
        else if(!isFirstRoll){
            if(score == 7){
                looseGame()
            }
            else if(score == point){
                winGame()
            }
        }
    }

    private fun looseGame() {
        binding.resultTV.text = "Sorry! YOU LOOSE."
        binding.resultTV.setBackgroundColor(Color.RED)
        binding.resultTV.setTextColor(Color.WHITE)
        binding.diceRollBtn.visibility = View.INVISIBLE
        binding.restartBtn.visibility = View.VISIBLE
        binding.restartBtn.setOnClickListener {
            findNavController().navigate(R.id.action_gameFragment_to_homeFragment2)
        }
    }

    private fun winGame() {
        binding.resultTV.text = "Congratulations! YOU WON."
        binding.resultTV.setBackgroundColor(Color.GREEN)
        binding.resultTV.setTextColor(Color.WHITE)
        binding.diceRollBtn.visibility = View.INVISIBLE
        binding.restartBtn.visibility = View.VISIBLE
        binding.restartBtn.setOnClickListener {
            findNavController().navigate(R.id.action_gameFragment_to_homeFragment2)
        }
    }

    private fun generateDiceNum() {
        dice1 = (1..6).random()
        dice2 = (1..6).random()
        score = dice1 + dice2
        binding.dice1TV.setText(dice1.toString())
        binding.dice2TV.setText(dice2.toString())
        binding.scoreTV.setText("Score: ${score.toString()}")
        binding.scoreTV.setTextColor(Color.BLACK)
    }
}