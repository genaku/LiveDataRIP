package com.genaku.livedataripsample

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.genaku.livedatarip.observe
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeViewModel()
        initUI()
    }

    private fun initUI() {
        button_plus.setOnClickListener(::incrementCounter)
        button_minus.setOnClickListener(::decrementCounter)
    }

    private fun incrementCounter(view: View) {
        viewModel.incrementCount()
        viewModel.mess()
    }

    private fun decrementCounter(view: View) {
        viewModel.decrementCount()
    }

    private fun observeViewModel() {
        viewModel.run {
            observe(eventFlow) {
                Log.d(TAG, "action: $it")
                Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
            }
            observe(counterStateFlow) {
                Log.d(TAG, "collect value: $it")
                textview_count.text = "$it"
            }
        }
    }
}
