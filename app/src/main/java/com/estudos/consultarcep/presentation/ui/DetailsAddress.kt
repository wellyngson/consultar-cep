package com.estudos.consultarcep.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.estudos.consultarcep.R
import com.estudos.consultarcep.data.model.Cep
import com.estudos.consultarcep.databinding.ActivityDetailsAddressBinding

class DetailsAddress : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsAddressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val address = intent.getSerializableExtra("address") as Cep

        binding.tvRoad.text = "${address.logradouro}"
        binding.tvDistrict.text = "${address.bairro}"
        binding.tvCityAndState.text = "${address.localidade} - ${address.uf}"
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_down)
    }
}