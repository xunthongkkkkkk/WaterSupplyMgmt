package com.example.watersupplymgmt

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.watersupplymgmt.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var email: String? = null
    private var password: String? = null
    private val URL = "http://10.0.2.2/login/login.php"
    private var btnLogin: Button? = null
    private var tvRegister: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        password = ""
        email = password
        etEmail = binding.etEmail
        etPassword = binding.etPassword
        btnLogin = binding.btnLogin
        tvRegister = binding.tvRegister

        btnLogin!!.setOnClickListener{
            login()
        }

        tvRegister!!.setOnClickListener{
            register()
        }
    }

    private fun login() {
        email = etEmail!!.text.toString().trim { it <= ' ' }
        password = etPassword!!.text.toString().trim { it <= ' ' }
        if (email != "" && password != "") {
            val stringRequest: StringRequest =
                object : StringRequest(Request.Method.POST, URL, Response.Listener<String> { response ->
                    Log.d("res", response)
                    if (response == "success") {
                        val intent = Intent(this, Home::class.java)
                        startActivity(intent)
                        finish()
                    } else if (response == "failure") {
                        Toast.makeText(
                            this,
                            "Invalid Login Id/Password",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }, Response.ErrorListener { error ->
                    Toast.makeText(
                        this@Login,
                        error.toString().trim(),
                        Toast.LENGTH_SHORT
                    ).show()
                }) {
                    @Throws(AuthFailureError::class)
                    override fun getParams(): Map<String, String> {
                        val data: MutableMap<String, String> = HashMap()
                        data["email"] = email!!
                        data["password"] = password!!
                        return data
                    }
                }
            val requestQueue: RequestQueue = Volley.newRequestQueue(applicationContext)
            requestQueue.add(stringRequest)
        } else {
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun register() {
        val intent = Intent(this, Register::class.java)
        startActivity(intent)
        finish()
    }
}