package com.example.testproject1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testproject1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    // 액티비티에서 사용할 레이아웃의 뷰 바인딩 클래스
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // 뷰 바인딩 클래스의 인스턴스를 생성
        binding = ActivityMainBinding.inflate(layoutInflater)
        // 생성된 뷰를 액티비티에 표시
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        binding.activityMainBtn.setOnClickListener {
            val sharedPreferences= getSharedPreferences("info",MODE_PRIVATE)
            //내가 정해놓은 정보
            val value1 ="yosan2222@naver.com"
            val value2 = "yosu1336"
            //입력된 정보
            val inserted1 = binding.activityMainId.getText()
            val inserted2 = binding.activityMainPw.getText()
            if(value1!!.contentEquals(inserted1.toString()) || value2!!.contentEquals(inserted2.toString())){
                val intent= Intent(this, SecondActivity::class.java)
//            intent.putExtra("key",data)
                startActivity(intent)
                Toast.makeText(this,"로그인 성공", Toast.LENGTH_SHORT).show()
                //정보가 일치하면 성공하고 화면 전환
            }
            else{
                Toast.makeText(this,"잘못된 ID 또는 PW", Toast.LENGTH_SHORT).show()
            }
        }

    // 메인 엑티비티의 edittext에 값을 입력한 후
        //버튼을 클릭하면 입력한 값을 인텐트에 담아서
        //SecondActivity로 화면 전환을 해주고
        //SecondActivity에 있는 textView에 받아온 값을 세팅해준다.
    }
    override fun onStart() {
        super.onStart()
    }
    override fun onResume() {
        super.onResume()
        val sharedPreferences= getSharedPreferences("info",MODE_PRIVATE)
        val value1 = sharedPreferences.getString("email_preferenced","")
        val value2 = sharedPreferences.getString("pw_preferenced","")
        var info_st= sharedPreferences.getBoolean("info_store",false)
        binding.mainCheckbox.setChecked(info_st)
        binding.activityMainId.setText(value1)
        binding.activityMainPw.setText(value2)

    }
    override fun onPause() {
        super.onPause()
        val email=binding.activityMainId.text.toString()
        val pw=binding.activityMainPw.text.toString()
        val sharedPreferences= getSharedPreferences("info",MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        if(binding.mainCheckbox.isChecked) {
            editor.putBoolean("info_store",true)
            editor.putString("email_preferenced", email)
            editor.putString("pw_preferenced", pw)
            editor.commit() //email, pw정보 백업
            Toast.makeText(this, "onPause - 로그인 정보가 저장되었습니다.", Toast.LENGTH_SHORT).show()
        }
        else{
            editor.putBoolean("info_store",false)
            editor.putString("email_preferenced", "")
            editor.putString("pw_preferenced", "")
            editor.commit() //email, pw정보 백업

        }
    }
    override fun onStop() {
        super.onStop()
    }
    override fun onRestart() {
        super.onRestart()
    }
    override fun onDestroy() {
        super.onDestroy()
    }


}