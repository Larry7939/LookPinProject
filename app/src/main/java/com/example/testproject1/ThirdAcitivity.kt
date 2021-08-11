package com.example.testproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.testproject1.databinding.ActivitySecondBinding
import com.example.testproject1.databinding.ActivityThirdAcitivityBinding

class ThirdAcitivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdAcitivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.anim_none,R.anim.anim_none)
        binding= ActivityThirdAcitivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.thirdBtHome.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        var state1 = intent.getBooleanExtra("pin1_img",false)
        if(state1){
            binding.pined1.setImageResource(R.drawable.pined1)
        }
        else{
            binding.pined1.visibility= View.GONE
        }
        var state2 = intent.getBooleanExtra("pin2_img",false)
        if(state2){
            binding.pined2.setImageResource(R.drawable.pined2)
        }
        else{
            binding.pined2.visibility= View.GONE
        }
    }
    override fun onStart() {
        super.onStart()
    }
    override fun onStop() {
        super.onStop()
    }
}