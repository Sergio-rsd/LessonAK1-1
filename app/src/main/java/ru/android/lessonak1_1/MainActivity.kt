package ru.android.lessonak1_1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonCreateOne: Button
    private lateinit var buttonCreateTwo: Button
    private lateinit var buttonObjectCopy: Button
    private lateinit var buttonLoops: Button
    private lateinit var textInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCreateOne = findViewById(R.id.create_first)
        buttonCreateTwo = findViewById(R.id.create_second)
        buttonObjectCopy = findViewById(R.id.create_object)
        buttonLoops = findViewById(R.id.loops)

        textInfo = findViewById(R.id.info_text)

        val noteOne = Note("Create note", 12)

        buttonCreateOne.setOnClickListener {

            textInfo.text = noteOne.name
        }
        buttonCreateTwo.setOnClickListener {
            textInfo.text = noteOne.age.toString()
        }

        buttonObjectCopy.setOnClickListener {

            val noteTwo = noteOne.copy(name = "Change note", age = 23)

            val sumText: String = noteTwo.name + " " + noteTwo.age.toString()
            textInfo.text = sumText

        }
        buttonLoops.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val notes = Repo.getNoteList()

        Repo.noteList.add(Note(name = "First note", 2))
        Repo.noteList.add(Note(name = "Second note", 16))
        Repo.noteList.add(Note(name = "Last note", 33))

        val simpleNoteAge = 16

        for (singleNote in notes) {
            println(singleNote.name + " : " + singleNote.age)
        }

        for (i in 1..5) {
            print("Hello Kotlin!")
            println()
        }

        for (i in 10 downTo 1 step 2) {
            print("Hello Kotlin! And World!")
            println()
        }
        for (i in 0 until notes.size) {
            if (notes[i].age == simpleNoteAge) {
                notes[i].name = "Hello Kotlin!"
                println(notes[i])
                return
            }
        }
    }

    object Repo {
        val noteList = arrayListOf<Note>()
        fun getNoteList(): List<Note> {
            return noteList
        }
    }
}








