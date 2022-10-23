package com.api.piclerick

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.api.piclerick.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    private val viewModel: SharedViewModel by lazy {
        ViewModelProvider(this)[SharedViewModel::class.java]
    }
    private val mainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        supportActionBar?.hide()

        viewModel.refreshCharacter(1)
        viewModel.characterByIdLiveData.observe(this){ response ->
            if (response == null){
               Snackbar.make(mainBinding.root, "Couldn't Fetch Data!!",1000)
            }
            mainBinding.nameText.text = response?.name
            mainBinding.statusText.text = response?.status
            when (response?.status) {
                "Alive" -> {
                    mainBinding.statusColor.setImageResource(R.drawable.status_alive_background)
                }
                "Dead" -> {
                    mainBinding.statusColor.setImageResource(R.drawable.status_dead_background)
                }
                "unknown" -> {
                    mainBinding.statusColor.setImageResource(R.drawable.status_unkown_background)
                }
            }
            mainBinding.speciesText.text = response?.species
            mainBinding.originText.text = response?.origin?.name
            mainBinding.lastKnownLocationText.text = response?.location?.name
            mainBinding.genderText.text = response?.gender
            Picasso.get().load(response?.image).into(mainBinding.characterImage)
        }

    }
}