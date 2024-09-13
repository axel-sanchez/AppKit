package com.example.unfollowersinstagram.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.unfollowersinstagram.R
import com.example.unfollowersinstagram.databinding.FragmentHomeBinding
import com.example.unfollowersinstagram.helpers.Constants.USER

/**
 * @author Axel Sanchez
 */
class HomeFragment : Fragment() {
    private var fragmentHomeBinding: FragmentHomeBinding? = null
    private val binding get() = fragmentHomeBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentHomeBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etSearch.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if (binding.etSearch.text.isNullOrEmpty()) Toast.makeText(context, "Debe ingresar su búsqueda", Toast.LENGTH_SHORT).show()
            else {
                if (id == EditorInfo.IME_ACTION_SEARCH || id == EditorInfo.IME_NULL) {

                    val bundle = bundleOf(
                        USER to binding.etSearch.text.toString()
                    )
                    findNavController().navigate(R.id.action_homeFragment_to_dontFollowMeFragment, bundle)

                    return@OnEditorActionListener true
                }
            }
            false
        })
    }
}