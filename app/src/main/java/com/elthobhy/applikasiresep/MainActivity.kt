package com.elthobhy.applikasiresep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elthobhy.applikasiresep.area.AreaActivity
import com.elthobhy.applikasiresep.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goToArea()
    }

    private fun goToArea() {
        binding.root.setOnClickListener {
            startActivity(Intent(this,AreaActivity::class.java))
        }
    }
}