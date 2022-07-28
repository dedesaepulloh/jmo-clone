package com.dedesaepulloh.assesment.presentation

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dedesaepulloh.assesment.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private var activityLoginBinding: ActivityLoginBinding? = null
    private val binding get() = activityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setupListener()
    }

    private fun setupListener() {
        binding?.apply {
            btnLogin.setOnClickListener {
                when {
                    TextUtils.isEmpty(edtEmail.text) -> {
                        edtEmail.error = "Data harus diisi"
                    }
                    TextUtils.isEmpty(edtPasswd.text) -> {
                        edtPasswd.error = "Data harus diisi"
                    }
                    edtEmail.text.isNotEmpty() && edtPasswd.text.isNotEmpty() -> {
                        btnLogin.isEnabled = true
                        if (edtEmail.text.toString() == "admin@mail.com" && edtPasswd.text.toString() == "123456") {
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Akun tidak ditemukan pastikan email dan password anda benar",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }

        }
    }
}