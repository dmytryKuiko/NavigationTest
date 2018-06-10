package com.example.dimi.navigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_step_one.*

class StepOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_step_one, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val valueFromXml = arguments?.let {
            val safeArgs = StepOneFragmentArgs.fromBundle(it)
            safeArgs.someName
        }

        val valueFromBundle = arguments?.getInt("someIntManual")

        goToNextButton?.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_stepOneFragment_to_stepTwoFragment)
        }
        backButton.setOnClickListener {
            Navigation.findNavController(it).popBackStack(R.id.homeFragment, false)
        }
    }
}
