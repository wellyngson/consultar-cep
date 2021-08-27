package com.estudos.consultarcep.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.estudos.consultarcep.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.estudos.consultarcep.presentation.ui.DetailsContact as DetailsAddress
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.estudos.consultarcep.R
import com.estudos.consultarcep.data.model.Contact
import com.estudos.consultarcep.databinding.ActivityMainBinding
import com.estudos.consultarcep.presentation.adapter.ContactAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    private val adapter by lazy { ContactAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        setupAdapter()
        insertListeners()
        updateList()
    }

    private fun insertListeners() {
        binding.ftFloatingButton.setOnClickListener {
            val intent =
                Intent(this, ViewContact::class.java)

            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_down,
                R.anim.slide_out_left
            )

            startActivity(intent, options.toBundle())
        }
    }

    private fun setupAdapter() {
        binding.rvRecyclerView.adapter = adapter
        binding.rvRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.HORIZONTAL
            )
        )
        binding.rvRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun updateList() {
        viewModel.addressLiveData.observe(this, {
            adapter.submitList(it)
        })
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_down)
    }
}
