package com.example.testproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.testproject1.databinding.ActivitySecondBinding
import com.example.testproject1.databinding.ActivityThirdAcitivityBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySecondBinding.inflate(layoutInflater)
        overridePendingTransition(R.anim.anim_none, R.anim.anim_none)
        setContentView(binding.root)
        binding.secondBtMy.setOnClickListener {
            val intent = Intent(this, ThirdAcitivity::class.java)
            intent.putExtra("pin1_img",binding.pinBtn1.isSelected)
            intent.putExtra("pin2_img",binding.pinBtn2.isSelected)
            startActivity(intent)
        }
        binding.pinBtn1.setOnClickListener() {
            if (binding.pinBtn1.isSelected) {
                binding.pinBtn1.setSelected(false)
            } else if (!binding.pinBtn1.isSelected) {
                binding.pinBtn1.setSelected(true)
            }
        }
        binding.pinBtn2.setOnClickListener() {
            if (binding.pinBtn2.isSelected) {
                binding.pinBtn2.setSelected(false)
            } else if (!binding.pinBtn2.isSelected) {
                binding.pinBtn2.setSelected(true)
            }
        }
        binding.pinBtn3.setOnClickListener() {
            if (binding.pinBtn3.isSelected) {
                binding.pinBtn3.setSelected(false)
            } else if (!binding.pinBtn3.isSelected) {
                binding.pinBtn3.setSelected(true)
            }
        }
        binding.pinBtn4.setOnClickListener() {
            if (binding.pinBtn4.isSelected) {
                binding.pinBtn4.setSelected(false)
            } else if (!binding.pinBtn4.isSelected) {
                binding.pinBtn4.setSelected(true)
            }
        }
//        binding = ActivitySecondBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        //setContentView(R.layout.activity_second)
//        val data = intent.getStringExtra("key")
//        binding.activitySecondTv.text=data
    }

    override fun onStart() {
        super.onStart()
        val sharedPreferences = getSharedPreferences("pin_state", MODE_PRIVATE)
        var state1 = sharedPreferences.getBoolean("pin1_selected", false)
        binding.pinBtn1.setSelected(state1)

        var state2 = sharedPreferences.getBoolean("pin2_selected", false)
        binding.pinBtn2.setSelected(state2)

        var state3 = sharedPreferences.getBoolean("pin3_selected", false)
        binding.pinBtn3.setSelected(state3)
        var state4 = sharedPreferences.getBoolean("pin4_selected", false)
        binding.pinBtn4.setSelected(state4)
    }

    override fun onStop() {
        super.onStop()
        val sharedPreferences = getSharedPreferences("pin_state", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        if (binding.pinBtn1.isSelected) {
            editor.putBoolean("pin1_selected", true)
        }
        else {
            editor.putBoolean("pin1_selected", false)
        }
        if (binding.pinBtn2.isSelected) {
            editor.putBoolean("pin2_selected", true)
        }
        else {
            editor.putBoolean("pin2_selected", false)
        }
        if (binding.pinBtn3.isSelected) {
            editor.putBoolean("pin3_selected", true)
        }
        else {
            editor.putBoolean("pin3_selected", false)
        }
        if (binding.pinBtn4.isSelected) {
            editor.putBoolean("pin4_selected", true)
        }
        else {
            editor.putBoolean("pin4_selected", false)
        }
        editor.commit() //pin_btn 눌림 정보 백업
    }
}