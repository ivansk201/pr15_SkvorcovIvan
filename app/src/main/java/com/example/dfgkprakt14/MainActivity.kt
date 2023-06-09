package com.example.dfgkprakt14
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var prevButton: ImageButton
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))
    private var currentIndex = 0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton =findViewById(R.id.next_button)
        prevButton =findViewById(R.id.prev_button)
        questionTextView=findViewById(R.id.question_text_view)

        val questionTextResId=questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)

        trueButton.setOnClickListener { view: View ->

        Toast.LENGTH_SHORT
            checkAnswer(true)

        }

       falseButton.setOnClickListener { view: View ->
           Toast.LENGTH_SHORT

           checkAnswer(false)
       }

        nextButton.setOnClickListener{currentIndex=(currentIndex+1)%questionBank.size
        updateQuestion()
        }
        updateQuestion()


    prevButton.setOnClickListener{currentIndex=(currentIndex-1)%questionBank.size
        updateQuestion()
    }
    updateQuestion()
}





    private fun updateQuestion() {
        val questionTextResId=questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer:Boolean)
    {
        val correctAnswer=questionBank[currentIndex].answer
        var messageResId = if (userAnswer == correctAnswer)
        {
            R.string.correct_toast

        }
        else
        {
            R.string.icorect_toast

        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show()
    }

}