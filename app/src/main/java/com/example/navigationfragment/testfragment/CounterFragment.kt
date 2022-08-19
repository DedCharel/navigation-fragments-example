package com.example.navigationfragment.testfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationfragment.R
import com.example.navigationfragment.databinding.FragmentCounterBinding

class CounterFragment:Fragment() {

    private lateinit var binding: FragmentCounterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        binding = FragmentCounterBinding.inflate(inflater,container, false)

        binding.counterTextView.text = getString(R.string.screen_label, getCounterValue())
        binding.quoteTextView.text = getQuote()

        binding.launchNextButton.setOnClickListener { launchNext() }
        binding.goBackButton.setOnClickListener { goBack() }

        return binding.root
    }

    private fun goBack() {
        requireActivity().onBackPressed()
    }

    private fun launchNext() {
        val fragment = CounterFragment.newInstance(
            counterValue = (requireActivity() as HelloWorldActivity).getScreenCount() + 1,
            quote = (requireActivity() as HelloWorldActivity).getQuote()
        )
        parentFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, fragment)
            .commit()

    }

    //Получаем аргументы
    private fun getQuote(): String = requireArguments().getString(ARG_QUOTE)!!
    private fun getCounterValue():Int = requireArguments().getInt(ARG_COUNTER_VALUE)


    companion object{
        private val ARG_COUNTER_VALUE = "ARG_COUNTER_VALUE"
        private val ARG_QUOTE = "ARG_QUOTE"

        fun newInstance(counterValue: Int, quote:String):CounterFragment{
            val args = Bundle().apply {
                //Кладем аргументы
                putInt(ARG_COUNTER_VALUE,counterValue)
                putString(ARG_QUOTE, quote)
            }
            val fragment = CounterFragment()
            fragment.arguments = args
            return  fragment
        }
    }
}