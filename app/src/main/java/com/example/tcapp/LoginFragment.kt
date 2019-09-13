package com.example.tcapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.login_fragment.*
import java.lang.ClassCastException


// 1
class LoginFragment: Fragment() {
    private lateinit var listener: OnLogin

    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is OnLogin) {
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement OnLogin.")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.login_fragment, container,false)
        val goToContactList = rootView.findViewById(R.id.goToContactList) as Button

        goToContactList.setOnClickListener{
            listener.onLogin()
        }
        return rootView
    }


    interface OnLogin {
        fun onLogin()
    }

}



