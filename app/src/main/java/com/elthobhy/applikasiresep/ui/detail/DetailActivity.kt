package com.elthobhy.applikasiresep.ui.detail

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.elthobhy.applikasiresep.R
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.utils.Constants
import com.elthobhy.applikasiresep.core.utils.Status
import com.elthobhy.applikasiresep.databinding.ActivityDetailBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
import org.koin.android.ext.android.inject

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel by inject<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getFav()

        actionBar()
        showDetail()
    }

    private fun showDetail() {
        val intent1 = intent.getStringExtra(Constants.ID_MEAL)
        val intent2 = intent.getStringExtra(Constants.DATA_CATEGORY)
        val intent3 = intent.getStringExtra(Constants.ID_MEAL_AREA)
        Log.e("TAG", "showDetail: $intent2" )
        Log.e("TAG2", "showDetail: $intent1" )
        if (intent1 != null) {
            getData(intent1)
        }
        if(intent2 !=null){
            getData(intent2)
        }
        if(intent3 !=null) getData(intent3)
    }

    private fun getData(intent: String) {
        detailViewModel.getDetail(intent).observe(this) {
            when (it.status) {
                Status.LOADING -> {}
                Status.SUCCESS -> {
                    it.data?.get(0)?.let { it1 -> setActionBookmark(it1) }
                    binding.apply {
                        it.data?.get(0)?.apply {
                            Glide.with(this@DetailActivity)
                                .load(strMealThumb)
                                .into(ivDetail)
                            tvName.text = strMeal
                            tvAsal.text = getString(R.string.from, strArea)
                            tvCategory.text = getString(R.string.category, strCategory)
                            ingredient.text = getString(
                                R.string.ingredients,
                                strIngredient1,
                                strIngredient2,
                                strIngredient3,
                                strIngredient4,
                                strIngredient5,
                                strIngredient6,
                                strIngredient7,
                                strIngredient8,
                                strIngredient9,
                                strIngredient10,
                                strIngredient11,
                                strIngredient12,
                                strIngredient13,
                                strIngredient14,
                                strIngredient15,
                                strIngredient16,
                                strIngredient17,
                                strIngredient18,
                                strIngredient19,
                                strIngredient20,
                            )
                            measure.text = getString(
                                R.string.measure,
                                strMeasure1,
                                strMeasure2,
                                strMeasure3,
                                strMeasure4,
                                strMeasure5,
                                strMeasure6,
                                strMeasure7,
                                strMeasure8,
                                strMeasure9,
                                strMeasure10,
                                strMeasure11,
                                strMeasure12,
                                strMeasure13,
                                strMeasure14,
                                strMeasure15,
                                strMeasure16,
                                strMeasure17,
                                strMeasure18,
                                strMeasure19,
                                strMeasure20,
                            )
                            contentInstructions.text = strInstructions
                            youtube.addYouTubePlayerListener(object :
                                AbstractYouTubePlayerListener() {
                                override fun onReady(youTubePlayer: YouTubePlayer) {
                                    super.onReady(youTubePlayer)
                                    if (!strYoutube.equals("")) {
                                        val idVid = strYoutube?.split("=")
                                        youTubePlayer.loadOrCueVideo(
                                            lifecycle,
                                            idVid?.get(1).toString(),
                                            0F
                                        )
                                    } else {
                                        Log.e("link", "onReady: $strYoutube")
                                        Toast.makeText(
                                            this@DetailActivity,
                                            "Link youtube is empty",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }

                                }

                                override fun onError(
                                    youTubePlayer: YouTubePlayer,
                                    error: PlayerConstants.PlayerError
                                ) {
                                    super.onError(youTubePlayer, error)
                                    Log.e("Error yuyup", "onError: $error")
                                }
                            })
                        }

                    }

                    it.data?.get(0)?.let { it1 -> setFavoriteState(it1.isFavorite) }
                    Log.e("yuyup", "showDetail: ${it.data?.get(0)?.strYoutube}")
                }

                Status.ERROR -> {
                    Log.e("TAGi", "getData: ${it.message}" )
                }
            }

        }
    }

    private fun setActionBookmark(get: DomainDetail) {
        binding.fabFavorite.setOnClickListener {
            if (!get.isFavorite) {
                Toast.makeText(this, getString(R.string.added_to_bookmark), Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, getString(R.string.remove_from_bookmark), Toast.LENGTH_SHORT)
                    .show()
            }
            detailViewModel.setFav(get)
            Log.e("fav", "setActionBookmark: ${ get.isFavorite }")
        }
    }


    private fun setFavoriteState(favorite: Boolean) {
        if (favorite) {
            binding.fabFavorite.setImageResource(R.drawable.ic_baseline_bookmark_24)
        } else {
            binding.fabFavorite.setImageResource(R.drawable.ic_baseline_bookmark_border_24)
        }
    }

    private fun getFav(){
        detailViewModel.getFav().observe(this){

        }
    }

    private fun actionBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}