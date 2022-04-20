//package com.example.yydemo.mylist.ui.auth
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.lifecycle.Observer
//import com.example.yydemo.databinding.FragmentLoginBinding
//import com.example.yydemo.mylist.service.LoginAPI
//import com.example.yydemo.mylist.service.Resource
//import com.example.yydemo.mylist.repository.AuthRepository
//import com.example.yydemo.mylist.ui.base.BaseFragment
//
//
//class AuthFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
//            when(it){
//                is Resource.Success -> {
//                    Toast.makeText(requireContext(),it.toString(),Toast.LENGTH_LONG).show()
//
//                }
//                is Resource.Failure -> {
//                    Toast.makeText(requireContext(),"Login Failure",Toast.LENGTH_SHORT).show()
//                }
//            }
//        })
//        binding.buttonLogin.setOnClickListener{
//            val email = binding.editTextTextEmailAddress.text.toString().trim()
//            val password = binding.editTextTextPassword.text.toString().trim()
//            viewModel.login(email,password)
//        }
//    }
//
//    override fun getViewModel()= AuthViewModel::class.java
//
//    override fun getFragmentBinding(
//        inflater: LayoutInflater,
//        container: ViewGroup?
//    )= FragmentLoginBinding.inflate(inflater, container,false)
//
//    override fun getFragmentRepository()= AuthRepository(remoteDataSource.buildApi(LoginAPI::class.java))
//
//
//}
