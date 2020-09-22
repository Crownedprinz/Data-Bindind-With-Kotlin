package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    var myName: MyName= MyName("Crownedprinz")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //This is to implement data binding. This increases performance to prevent all Views been looked for at Runtime
        //But checkout for all Views at Compiled Time
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.myName = myName;
       // findViewById<Button>(R.id.done_button).setOnClickListener{(addNickName(it))}
        binding.doneButton.setOnClickListener{
            addNickName(it)
        }
    }

    private fun addNickName(view: View){
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nickNameTextView = findViewById<TextView>(R.id.nickname_text)
//
//
//        nickNameTextView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility= View.GONE
//        nickNameTextView.visibility=View.VISIBLE


        //Refactor with data binding
        binding.apply {
            //nicknameText.text =  binding.nicknameEdit.text
            myName?.nickName = nicknameEdit.text.toString()
            //Invalidate all binding expressions so that they recreated with the correct data
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility= View.GONE
            nicknameText.visibility=View.VISIBLE

        }

        //Hide The Keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}