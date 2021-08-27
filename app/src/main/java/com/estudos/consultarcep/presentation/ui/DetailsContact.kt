package com.estudos.consultarcep.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.estudos.consultarcep.R
import com.estudos.consultarcep.data.model.Contact
import com.estudos.consultarcep.databinding.ActivityDetailsAddressBinding

class DetailsContact : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsAddressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contact = intent.getParcelableExtra<Contact>("contact")
        binding.tvName.text = contact?.name
        binding.tvRoad.text = contact?.address?.road
        binding.tvDistrict.text = contact?.address?.district
        binding.tvCityAndState.text = "${contact?.address?.city} - ${contact?.address?.state}"
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_down)
    }
}