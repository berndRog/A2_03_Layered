package de.rogallab.mobile.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import de.rogallab.mobile.R
import de.rogallab.mobile.databinding.ActivityMainBinding
import de.rogallab.mobile.utilities.logDebug

@AndroidEntryPoint
class MainActivity : BaseActivity(TAG) {

   // Data Binding
   private lateinit var _binding: ActivityMainBinding
   private val _viewModel: MainViewModel by viewModels()

   // Activity is first created
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      // Data Binding
      _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
      _binding.viewModel = _viewModel
      _binding.lifecycleOwner = this

      // button event handler
      _binding.mainBtSend.setOnClickListener {
         Log.i(TAG,"main_bt_send.OnClick()")
         logDebug(TAG, "Name: ${_viewModel.name} Email:${_viewModel.email}")
         // save input into database
         _viewModel.addUser();
      }
   }
   companion object {
                            // 12345678901234567890123
      private const val TAG = "ok>MainActivity       ."
      private const val BUNDLE = "BundleMainActivity"
      const val isDebug = true
   }
}