package com.estudos.consultarcep.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.estudos.consultarcep.databinding.ActivityMainBinding
import com.estudos.consultarcep.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.estudos.consultarcep.presentation.ui.DetailsAddress as DetailsAddress
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import com.estudos.consultarcep.R
import com.estudos.consultarcep.core.Constants.ERROR
import com.estudos.consultarcep.core.Constants.SUCCESS
import com.estudos.consultarcep.core.Constants.WARNING

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListeners()
    }

    private fun insertListeners() {
        binding.btSearchPostCode.setOnClickListener {
            val cepUser = binding.etInputPostCode.text.toString()
            if (cepUser == null || cepUser == "") {
                showToast(ERROR, "Insira um CEP correto")
            } else {
                viewModel.init(cepUser)
                showToast(SUCCESS, "CEP consultado com sucesso")
                changeScreen()
            }
        }
    }

    private fun changeScreen() {
        viewModel.cepLiveData.observe(this) {
            val intent = Intent(this, DetailsAddress::class.java).apply {
                putExtra("address", it)
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
            SUCCESS -> layout.background = getDrawable(R.drawable.toast_sucess)
            WARNING -> layout.background = getDrawable(R.drawable.toast_warning)
            ERROR -> layout.background = getDrawable(R.drawable.toast_error)
            else -> throw IllegalStateException("Erro de tipo $message")
        }

        layout.findViewById<TextView>(R.id.tvToastMessage).text = message

        toast.apply {
            duration = Toast.LENGTH_LONG
            view = layout
            show()
        }
    }
}