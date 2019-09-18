package com.example.tcapp

import android.Manifest
import android.annotation.TargetApi
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.hardware.fingerprint.FingerprintManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.hardware.fingerprint.FingerprintManagerCompat
import androidx.fragment.app.Fragment
import java.lang.ClassCastException
import java.util.concurrent.Executors


// 1
class LoginFragment: Fragment() {
    private lateinit var btnListener: FragmentChangeListener
    private lateinit var tvstatus: TextView


    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is FragmentChangeListener) {
            btnListener = context
        } else {
            throw ClassCastException("$context must implement FragmentChangeListener")
        }
    }

    @TargetApi(Build.VERSION_CODES.P)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.login_fragment, container,false)
        val goToContactList = rootView.findViewById(R.id.goToContactList) as Button

        tvstatus = rootView.findViewById(R.id.tv1)
        val fragmentActivity = this.activity!!
        //checks if permission are enabled and biometric functionality is activated (below)
        if(this.activity?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.USE_BIOMETRIC)
            } != PackageManager.PERMISSION_GRANTED){
            tvstatus.text = "no good"

        } else {

            val fmc = FingerprintManagerCompat.from(fragmentActivity)

            if (!fmc.isHardwareDetected) {
                tvstatus.text = "There is no fingerprint sensor hardware found."
            } else if (!fmc.hasEnrolledFingerprints()){
                tvstatus.text = "There is no fingerprint currently enrolled."
            } else {
                tvstatus.text = "Finger authentication is ready for testing"

               /* //set up the authentication dialog
                val executor = Executors.newSingleThreadExecutor()

                //Authenticate with callback functions

                val biometricPrompt = BiometricPrompt.authenticate(fragmentActivity, executor,
                    object : BiometricPrompt.AuthenticationCallback() {})

                // configuring the prompt
                val cancelString = fragmentActivity.getString(android.R.string.cancel)
                val promptInfo = BiometricPrompt.PromptInfo.Builder()
                    .setTitle("Prompt Title") // required
                    .setSubtitle("Prompt Subtitle")
                    .setDescription("Prompt Description: lorem ipsum")
                    .setNegativeButtonText(cancelString) // required
                    .build()*/
            }
        }

       goToContactList.setOnClickListener{
            showOtherFragment()
        }
        return rootView
    }

    private fun showOtherFragment() {
        val fr = ContactListFragment.newInstance()
        val fc = btnListener
        fc.replaceFragment(fr)
    }
}




