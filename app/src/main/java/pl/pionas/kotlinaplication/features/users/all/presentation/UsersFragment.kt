package pl.pionas.kotlinaplication.features.users.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_user.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.BR
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.databinding.FragmentUserBinding

class UsersFragment : BaseFragment<UsersViewModel, FragmentUserBinding>(
    BR.viewModel,
    R.layout.fragment_user
) {

    override val viewModel: UsersViewModel by viewModel()

    private val linearLayoutManager: LinearLayoutManager by inject()
    private val divider: DividerItemDecoration by inject()
    private val userAdapter: UsersAdapter by inject()

    override fun initViews(binding: FragmentUserBinding) {
        super.initViews(binding)
        initRecycler()
    }

    private fun initRecycler() {
        with(recyclerView) {
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = userAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        with(recyclerView) {
            layoutManager = null
            adapter = null
        }
    }

}
