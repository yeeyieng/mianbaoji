package com.example.yydemo.mylist.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.yydemo.R
import com.example.yydemo.mylist.repository.AuthRepository
import com.example.yydemo.mylist.service.LoginAPI


class AuthFragment1 : Fragment() {

    val viewModel:AuthViewModel = AuthViewModel(AuthRepository(LoginAPI))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val LoginAPI = LoginAPI()

        val email:TextView = view.findViewById<TextView>(R.id.email)
        val btnLogin:Button = view.findViewById(R.id.buttonLogin)
        val btnReset = view.findViewById<Button>(R.id.buttonReset)
        btnLogin.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {

            }
        })

        btnReset.setOnClickListener{
        }
    }

}
