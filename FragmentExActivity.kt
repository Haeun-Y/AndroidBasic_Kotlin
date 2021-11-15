package com.example.fragmentex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.fragmentex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMenu1.setOnClickListener{ btnselected(binding.btnMenu1)
        }
        binding.btnMenu2.setOnClickListener{ btnselected(binding.btnMenu2)
        }
    }//onCreate 함수 끝
    
    fun btnselected(btn_selected: Button)
    {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = if(btn_selected == binding.btnMenu1) LetterListFragment() else WordListFragment()
        transaction.replace(R.id.frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}//MainActivity 클래스 끝

