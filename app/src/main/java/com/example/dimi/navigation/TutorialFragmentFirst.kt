package com.example.dimi.navigation


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_tutorial_fragment_first.*

class TutorialFragmentFirst : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_tutorial_fragment_first, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button?.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_tutorialFragmentFirst_to_tutorialFragmentSecond)
        )
        backButton?.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }
}
