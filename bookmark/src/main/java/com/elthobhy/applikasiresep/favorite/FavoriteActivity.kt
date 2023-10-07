package com.elthobhy.applikasiresep.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.databinding.ActivityFavoriteBinding
import com.elthobhy.applikasiresep.di.favoriteModule
import com.elthobhy.applikasiresep.ui.home.AdapterMain
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var adapterList: AdapterFav

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFavoriteBinding.inflate(layoutInflater)
        adapterList= AdapterFav()
        setContentView(binding.root)
        loadKoinModules(favoriteModule)
        showRv()
        setList()
    }

    private fun setList() {
        favoriteViewModel.getFav().observe(this){
            adapterList.submitList(it)
        }
    }

    private fun showRv() {
        binding.rvFav.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = adapterList
        }
        adapterList.setOnClickCallback(object : AdapterFav.OnItemClickCallback {
            override fun onClicked(data: DomainDetail) {
                TODO("Not yet implemented")
            }
        })
    }
}