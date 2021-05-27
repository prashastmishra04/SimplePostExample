package com.example.post

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.HTTP


class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var email: EditText
    lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button = findViewById(R.id.login)
        email = findViewById(R.id.username)
        password = findViewById(R.id.password)

        button.setOnClickListener {
            getRegister()
        }


    }

    fun getRegister() {

        ApiClient().getApiClient()!!.create(ApiInterface::class.java).also {
            it.registerUser(Register(email = email.editableText.toString(), password = password.editableText.toString())).enqueue(
                object : retrofit2.Callback<RegisterResult> {
                    override fun onResponse(
                        call: Call<RegisterResult>,
                        response: Response<RegisterResult>
                    ) {
                        if (response.isSuccessful) {
                            Log.i("login", "sucesss")
                            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
                            intent.putExtra("TOKEN", response.body()?.token)
                            intent.putExtra("CreatedAt", response.body()?.createdAt)

                            startActivity(intent)
                        } else {
                            Log.i("login", "unsucesss")
                        }

                    }

                    override fun onFailure(call: Call<RegisterResult>, t: Throwable) {
                        Log.i("hryy", "fail")
                    }


                }
            )
        }
    }


}
