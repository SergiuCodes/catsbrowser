package com.example.catsbrowser.ui.breeds

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.catsbrowser.R
import com.example.catsbrowser.databinding.DetailsFragmentDialogBinding
import com.example.catsbrowser.domain.model.BreedViewModel

class DetailsFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .create()


    companion object {
        const val TAG = "DetailsDialogFragment"
    }
}