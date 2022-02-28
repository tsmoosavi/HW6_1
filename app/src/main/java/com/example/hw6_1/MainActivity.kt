package com.example.hw6_1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hw6_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
   lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.fullnamebox.visibility = View.GONE
        binding.fullnamebox





        binding.register.setOnClickListener{
            var infoCollection : SharedPreferences = getSharedPreferences("personalInformation",Context.MODE_PRIVATE)
            var editor = infoCollection.edit()
            editor.putString("fullName", binding.FullName.text.toString())
            editor.putString("userName", binding.UserName.text.toString())
            editor.putString("Email", binding.Email.text.toString())
            editor.putString("passWord", binding.Password.text.toString())
            editor.putString("passWord2", binding.ReTypePassword.text.toString())
            editor.putBoolean("fGender",binding.radioButton.isChecked)
            editor.putBoolean("mGender",binding.radioButton2.isChecked)
            editor.apply()
            var pass1 = infoCollection.getString("passWord","")
            var pass2 = infoCollection.getString("passWord2","")
            if (pass1 != pass2){
                binding.ReTypePassword.error = "گذرواژه ها یکسان نیستند. دوباره وارد کنید."
            }

        }
        binding.ShowInfo.setOnClickListener{
            var infoCollection : SharedPreferences = getSharedPreferences("personalInformation",Context.MODE_PRIVATE)
            var fullName =  infoCollection.getString("fullName","")
            var userName =infoCollection.getString("userName","")
            var email = infoCollection.getString("Email","")
            var passWord = infoCollection.getString("passWord","")
            binding.fullnamebox.text = fullName
            binding.usernamebox.text = userName
            binding.emailbox.text = email
            binding.passwordbox.text = passWord





        }


    }
}