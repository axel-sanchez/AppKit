package com.example.unfollowersinstagram.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unfollowersinstagram.core.MyApplication
import com.example.unfollowersinstagram.databinding.FragmentDontFollowMeBinding
import com.example.unfollowersinstagram.domain.usecase.GetUsersDontFollowMeUseCase
import com.example.unfollowersinstagram.helpers.hide
import com.example.unfollowersinstagram.helpers.show
import com.example.unfollowersinstagram.presentation.viewmodel.DontFollowMeViewModel
import javax.inject.Inject

class DontFollowMeFragment : Fragment() {

    @Inject
    lateinit var getUsersDontFollowMeUseCase: GetUsersDontFollowMeUseCase

    private lateinit var userName: String

    private var fragmentDontFollowMeBinding: FragmentDontFollowMeBinding? = null
    private val binding get() = fragmentDontFollowMeBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentDontFollowMeBinding = FragmentDontFollowMeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as MyApplication).component.inject(this)
    }

    private val viewModel: DontFollowMeViewModel by viewModels(
        factoryProducer = { DontFollowMeViewModel.DontFollowMeViewModelFactory(getUsersDontFollowMeUseCase) }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userName = arguments?.getString(USER)?:""

        viewModel.getProduct(query)

        viewModel.getProductLiveData().observe(viewLifecycleOwner) { response ->
            updateView(response)
        }
    }

    private fun updateView(dataProducts: DataProducts) {
        with(binding) {

            dataProducts.products?.let { products ->
                if (products.isEmpty()) {
                    rvProducts.hide()
                    tvErrorText.text = ApiError.EMPTY_PRODUCTS.error
                    cvEmptyState.show()
                } else {
                    rvProducts.show()
                    setAdapter(products)
                }
            }?: kotlin.run {
                tvErrorText.text = dataProducts.apiError?.error
                cvEmptyState.show()
                rvProducts.hide()
            }
            cpiLoading.hide()
        }
    }

    private fun setAdapter(products: List<Product?>) {
        val productsAdapter = ProductAdapter(products, itemClick)
        with(binding.rvProducts) {
            layoutManager = LinearLayoutManager(context)
            adapter = productsAdapter
        }
    }

    private val itemClick = { product: Product?, imageView: ImageView ->
        product?.let {
            val bundle = bundleOf(ID_PRODUCT to it.id)
            val extras = FragmentNavigatorExtras(
                imageView to ID_IMAGE_VIEW
            )
            findNavController().navigate(R.id.action_searchFragment_to_detailsFragment, bundle, null, extras)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentDontFollowMeBinding = null
    }
}