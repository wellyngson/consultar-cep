package com.estudos.consultarcep.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.estudos.consultarcep.R
import com.estudos.consultarcep.core.Constants
import com.estudos.consultarcep.databinding.ActivityViewContactBinding
import com.estudos.consultarcep.presentation.adapter.ContactAdapter
import com.estudos.consultarcep.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ViewContact : AppCompatActivity() {

    private lateinit var binding: ActivityViewContactBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        insertListeners()
    }

    private fun insertListeners() {
        binding.btSearchPostCode.setOnClickListener {
            val cepUser = binding.etInputPostCode.text.toString()
            if (cepUser == null || cepUser == "") {
                showToast(Constants.ERROR, "Insira um CEP correto")
            } else {
                viewModel.init(cepUser)
                showToast(Constants.SUCCESS, "CEP consultado com sucesso")
                changeScreen()
            }
        }
    }

    private fun changeScreen() {
        viewModel.addressLiveData.observe(this) {
            val intent = Intent(this, DetailsContact::class.java).apply {
                putExtra("contact", it)
            }

            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_down,
                R.anim.slide_out_left
            )

            startActivity(intent, options.toBundle())
        }
    }

    private fun showToast(type: Int, message: String) {
        val toast = Toast(this)
        val layout =
            layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.containerToast))

        when (type) {
            Constants.SUCCESS -> layout.background = getDrawable(R.drawable.toast_sucess)
            Constants.WARNING -> layout.background = getDrawable(R.drawable.toast_warning)
            Constants.ERROR -> layout.background = getDrawable(R.drawable.toast_error)
            else -> throw IllegalStateException("Erro de tipo $message")
        }

        layout.findViewById<TextView>(R.id.tvToastMessage).text = message

        toast.apply {
            duration = Toast.LENGTH_LONG
            view = layout
            show()
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_down)
    }
}