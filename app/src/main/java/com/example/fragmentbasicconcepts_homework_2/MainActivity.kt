package com.example.fragmentbasicconcepts_homework_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentbasicconcepts_homework_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var blankFragment: BlankFragment ?=null
    private lateinit var blankFragment2:BlankFragment2
    private val manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        blankFragment2=BlankFragment2()


        binding.apply {
            add.setOnClickListener {
                if (blankFragment == null) {
                    blankFragment = BlankFragment()
                    manager.beginTransaction().add(R.id.my_continer, blankFragment!!).addToBackStack(blankFragment.toString()).commit()
                }
            }

            remove.setOnClickListener {
                if (blankFragment != null) {
                    manager.beginTransaction().remove(blankFragment!!).commit()
                    blankFragment=null
                }
            }
            replace.setOnClickListener{

                manager.beginTransaction().replace(R.id.my_continer, blankFragment2).commit()
            }
            hide.setOnClickListener{
                manager.beginTransaction().hide(blankFragment!!).commit()
            }
            show.setOnClickListener{
                manager.beginTransaction().show(blankFragment!!).commit()

            }
        }
    }
}