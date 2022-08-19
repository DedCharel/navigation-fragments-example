package com.example.navigationfragment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationfragment.R
import com.example.navigationfragment.contract.HasCustomTitle
import com.example.navigationfragment.contract.navigator
import com.example.navigationfragment.databinding.FragmentAboutBinding
import com.example.navigationfragment.BuildConfig

class AboutFragment: Fragment(),HasCustomTitle{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentAboutBinding.inflate(inflater, container, false).apply {
        versionNameTextView.text = BuildConfig.VERSION_NAME
        versionCodeTextView.text = BuildConfig.VERSION_CODE.toString()
        okButton.setOnClickListener { onOkPressed() }
    }.root

    private fun onOkPressed() {
        navigator().goBack()
    }

    override fun getTitleRes(): Int = R.string.about
}