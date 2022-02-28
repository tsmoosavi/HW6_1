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
        initViews()
        binding.ShowInfo.setOnClickListener{
            initViews()
        }





        binding.register.setOnClickListener{

            var infoCollection : SharedPreferences = getSharedPreferences("personalInformation",Context.MODE_PRIVATE)
            var editor = infoCollection.edit()
            var pass1 = binding.Password.text.toString()
            var pass2 = binding.ReTypePassword.text.toString()
            if (binding.FullName.text.isBlank()|| binding.UserName.text.isBlank()|| binding.Email.text.isBlank()||binding.Password.text.isBlank()||binding.ReTypePassword.text.isBlank()){
                binding.FullName.error=" همه فیلد ها را پر کنید."
            }else {
                if (pass1 != pass2){
                    binding.ReTypePassword.error = "گذرواژه ها یکسان نیستند. دوباره وارد کنید."
                }else{
                    editor.putString("fullName", binding.FullName.text.toString())
                    editor.putString("userName", binding.UserName.text.toString())
                    editor.putString("Email", binding.Email.text.toString())
                    editor.putString("passWord", binding.Password.text.toString())
                    editor.putString("passWord2", binding.ReTypePassword.text.toString())
                    editor.putBoolean("fGender",binding.radioButton.isChecked)
                    editor.putBoolean("mGender",binding.radioButton2.isChecked)
                    editor.apply()
                }
            }



        }
        binding.ShowInfo.setOnClickListener{
            var infoCollection : SharedPreferences = getSharedPreferences("personalInformation",Context.MODE_PRIVATE)
            var fullName =  infoCollection.getString("fullName","")
            var userName =infoCollection.getString("userName","")
            var email = infoCollection.getString("Email","")
            var passWord = infoCollection.getString("passWord","")
            if (infoCollection.getBoolean("mGender",false)){
                binding.genderbox.text = "male"
            }else if (infoCollection.getBoolean("fGender",false)){
                binding.genderbox.text = "female"
            }else
                binding.genderbox.text = ""
            showInfoBox()
            binding.fullnamebox.text = fullName
            binding.usernamebox.text = userName
            binding.emailbox.text = email
            binding.passwordbox.text = passWord





        }


    }

    private fun showInfoBox() {
        binding.fullnamebox.visibility = View.VISIBLE
        binding.usernamebox.visibility = View.VISIBLE
        binding.emailbox.visibility = View.VISIBLE
        binding.passwordbox.visibility = View.VISIBLE
        binding.genderbox.visibility = View.VISIBLE
        binding.hidebox.visibility = View.VISIBLE

    }

    private fun initViews() {
        binding.fullnamebox.visibility = View.GONE
        binding.usernamebox.visibility = View.GONE
        binding.emailbox.visibility = View.GONE
        binding.passwordbox.visibility = View.GONE
        binding.genderbox.visibility = View.GONE
        binding.hidebox.visibility = View.GONE
    }
}