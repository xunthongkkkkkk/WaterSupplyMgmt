package com.example.watersupplymgmt

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.watersupplymgmt.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private var etName: EditText? = null
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var etReenterPassword: EditText? = null
    private var tvStatus: TextView? = null
    private var btnRegister: Button? = null
    private var tvLogin: TextView? = null
    private val URL = "http://10.0.2.2/login/register.php"
    private var name: String? = null
    private var email: String? = null
    private var password: String? = null
    private var reenterPassword: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        etName = binding.etName
        etEmail = binding.etEmail
        etPassword = binding.etPassword
        etReenterPassword = binding.etReenterPassword
        tvStatus = binding.tvStatus
        btnRegister = binding.btnRegister
        tvLogin = binding.tvLogin
        reenterPassword = ""
        password = reenterPassword
        email = password
        name = email

        btnRegister!!.setOnClickListener{
            save()
        }

        tvLogin!!.setOnClickListener{
            login()
        }
    }

    private fun save() {
        name = etName!!.text.toString().trim { it <= ' ' }
        email = etEmail!!.text.toString().trim { it <= ' ' }
        password = etPassword!!.text.toString().trim { it <= ' ' }
        reenterPassword = etReenterPassword!!.text.toString().trim { it <= ' ' }
        if (password != reenterPassword) {
            Toast.makeText(this, "Password Mismatch", Toast.LENGTH_SHORT).show()
        } else if (name != "" && email != "" && password != "") {
            val stringRequest: StringRequest =
                object : StringRequest(Method.POST, URL, Response.Listener { response ->
                    if (response == "success") {
                        tvStatus!!.text = "Successfully registered."
                        btnRegister!!.isClickable = false
                    } else if (response == "failure") {
                        tvStatus!!.text = "Something went wrong!"
                    }
                }, Response.ErrorListener { error ->
                    Toast.makeText(
                        applicationContext,
                        error.toString().trim(),
                        Toast.LENGTH_SHORT
                    ).show()
                }) {
                    @Throws(AuthFailureError::class)
                    override fun getParams(): Map<String, String> {
                        val data: MutableMap<String, String> = HashMap()
                        data["name"] = name!!
                        data["email"] = email!!
                        data["password"] = password!!
                        return data
                    }
                }
            val requestQueue: RequestQueue = Volley.newRequestQueue(applicationContext)
            requestQueue.add(stringRequest)
        }
    }

    private fun login() {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
        finish()
    }
}