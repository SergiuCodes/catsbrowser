package com.example.catsbrowser.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.catsbrowser.R
import com.example.catsbrowser.databinding.FragmentBreedListBinding
import com.example.catsbrowser.domain.model.BreedViewModel

class BreedListFragment : Fragment() {

    private lateinit var mBinding: FragmentBreedListBinding
    private lateinit var mViewModel: BreedViewModel
    private lateinit var thisContext: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        thisContext = container!!.context
        mViewModel = ViewModelProvider(this).get(BreedViewModel::class.java)
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_breed_list, container, false)

        with(mBinding) {
            lifecycleOwner = this@BreedListFragment
            viewModel = mViewModel
            executePendingBindings()
        }
        mViewModel.getBreeds()
        return mBinding.root
    }
}