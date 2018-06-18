package com.example.dimi.navigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_step_two.*

class StepTwoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_step_two, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val valueFromDeepLink = arguments?.getString("someArgFromWidget")

        goToFirstButton.setOnClickListener {
            val options = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()
            Navigation.findNavController(it)
                .navigate(R.id.action_stepTwoFragment_to_homeFragment, null, options)
        }
        backButton?.setOnClickListener {
            Navigation.findNavController(it).popBackStack(R.id.homeFragment, false)
        }
    }
}
