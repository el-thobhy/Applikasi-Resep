package com.elthobhy.applikasiresep.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.elthobhy.applikasiresep.R
import com.elthobhy.applikasiresep.core.utils.Constants
import com.elthobhy.applikasiresep.databinding.ActivityCustomSplashBinding
import com.elthobhy.applikasiresep.ui.home.MainActivity

@SuppressLint("CustomSplashScreen")
class CustomSplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityCustomSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goToMain()
    }

    private fun goToMain() {
        Handler(Looper.getMainLooper())
            .postDelayed({
                startActivity(Intent(this,MainActivity::class.java))
                finishAffinity()
            }, Constants.DELAY)
    }
}