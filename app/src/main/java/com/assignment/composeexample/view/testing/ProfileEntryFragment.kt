//package com.assignment.composeexample.view.testing
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.compose.ui.platform.ComposeView
//import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.findNavController
//import com.assignment.composeexample.MainActivity
//
//
//class ProfileEntryFragment : Fragment() {
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return ComposeView(requireContext()).apply {
//            setContent {
//                FirstScreen(
//                    navController = findNavController(),
//                    viewModel = (activity as MainActivity).sharedViewModel
//                )
//            }
//        }
//    }
//}