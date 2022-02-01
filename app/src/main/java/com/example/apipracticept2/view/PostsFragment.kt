package com.example.apipracticept2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apipracticept2.databinding.FragmentPostBinding
import com.example.apipracticept2.model.network.ApiManager
import com.example.apipracticept2.model.repository.PostRepository
import com.example.apipracticept2.viewmodel.PostsViewModel

class PostsFragment: Fragment() {

    private var _binding: FragmentPostBinding? = null
    private val binding: FragmentPostBinding get() = _binding!!

    private val viewModel: PostsViewModel by activityViewModels {
        PostsViewModel.Factory(PostRepository(ApiManager()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding) {
            viewModel.posts.observe(viewLifecycleOwner) {users->
                postRv.apply {
                    adapter = users?.let { PostAdapter(it) }
                    layoutManager =
                        LinearLayoutManager(requireContext())
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}