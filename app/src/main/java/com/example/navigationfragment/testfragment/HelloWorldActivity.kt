package com.example.navigationfragment.testfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationfragment.R
import com.example.navigationfragment.databinding.ActivityHelloWorldBinding

class HelloWorldActivity:AppCompatActivity() {
    private lateinit var binding: ActivityHelloWorldBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloWorldBinding.inflate(layoutInflater).also { setContentView(it.root) }

        setSupportActionBar(binding.toolbar)

        if (savedInstanceState == null){
            val fragment = CounterFragment.newInstance(
                counterValue = 1,
                quote = getQuote()
            )
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit()
        }

    }

    fun getScreenCount(): Int{
        return supportFragmentManager.backStackEntryCount + 1
    }

    fun getQuote():String{
        return "Quote"
    }
}