package com.sanmidev.themealdbcoroutines.features.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sanmidev.themealdbcoroutines.R
import com.sanmidev.themealdbcoroutines.data.model.category.CategoryModel
import com.sanmidev.themealdbcoroutines.databinding.FragmentCategoriesBinding
import com.sanmidev.themealdbcoroutines.features.meal.MealsFragmentArgs
import com.sanmidev.themealdbcoroutines.utils.NetworkState
import com.sanmidev.themealdbcoroutines.utils.dpToPx
import dagger.hilt.android.AndroidEntryPoint
import io.cabriole.decorator.ColumnProvider
import io.cabriole.decorator.GridMarginDecoration
import kotlinx.coroutines.flow.collect

private const val MARGIN_SIZE = 8

@AndroidEntryPoint
class CategoriesFragment : Fragment() {

    private val viewModel by viewModels<CategoriesViewModel>()


    private var _binding :  FragmentCategoriesBinding? = null
    private val binding : FragmentCategoriesBinding get() = _binding!!

    private var categoryAdapter: CategoryAdapter? = null

    private val navController by lazy { findNavController() }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        lifecycleScope.launchWhenStarted {
            viewModel.getCategoriesNetworkState.collect { uiState ->
                when(uiState){
                    is NetworkState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is NetworkState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        categoryAdapter!!.submitList(uiState.data)
                    }
                    is NetworkState.Error -> {
                        binding.progressBar.visibility = View.GONE
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        categoryAdapter = null
        _binding = null
        super.onDestroyView()
    }


    private fun setupRecyclerView() {
        categoryAdapter = CategoryAdapter { categoryModel: CategoryModel ->
            val directions = CategoriesFragmentDirections.actionCategoriesFragmentToMealsFragment(categoryModel.category)

            navController.navigate(directions)
        }

        binding.rvCategory.apply {
            val spanCount = context.resources.getInteger(R.integer.recycler_view_span_count)
            val margin = context.resources.dpToPx(MARGIN_SIZE)

            layoutManager = GridLayoutManager(requireContext(), spanCount)
            this.addItemDecoration(GridMarginDecoration(margin, object : ColumnProvider {
                override fun getNumberOfColumns(): Int = spanCount
            }, orientation = RecyclerView.VERTICAL))

            setHasFixedSize(true)
            adapter = categoryAdapter
        }
    }
}
