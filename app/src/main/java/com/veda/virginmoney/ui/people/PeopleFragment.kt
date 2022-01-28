package com.veda.virginmoney.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.veda.virginmoney.data.model.People
import com.veda.virginmoney.databinding.FragmentPeopleBinding
import com.veda.virginmoney.data.service.Resource
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    private val _peopleViewModel: PeopleViewModel by viewModels()
    private lateinit var _binding: FragmentPeopleBinding
    private lateinit var _adapter: PeopleListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        _peopleViewModel.people.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    _binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) {
                        setPeopleListAdapter(ArrayList(it.data))
                    }
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    _binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun setPeopleListAdapter(dataSet: ArrayList<People>) {
        _adapter = PeopleListAdapter(dataSet)
        _binding.peopleRecyclerId.layoutManager = LinearLayoutManager(requireContext())
        _binding.peopleRecyclerId.adapter = _adapter
    }
}