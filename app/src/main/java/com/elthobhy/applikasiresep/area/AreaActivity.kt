package com.elthobhy.applikasiresep.area

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.elthobhy.applikasiresep.R
import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.utils.Status
import com.elthobhy.applikasiresep.databinding.ActivityAreaBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class AreaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAreaBinding
    private val areaViewModel by inject<AreaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAreaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()

    }

    private fun getData() {
        areaViewModel.getArea().observe(this){
            if(it.data?.isNotEmpty()==true){
                when(it.status){
                    Status.LOADING -> {

                    }
                    Status.SUCCESS -> {
                        binding.tv.text = it.data.toString()
                        Log.e("tes", "getData: ${it.data.toString()}" )
                    }
                    Status.ERROR -> {

                    }
                }
            }
            else Log.e("error ka", "getData: ${it.message}" )
        }
    }
}