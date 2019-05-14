package dev.randallgreene.basketballstats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import dev.randallgreene.basketballstats.R
import dev.randallgreene.basketballstats.viewmodels.PlayerStatsViewModel

class PlayerStatsHostFragment : Fragment() {

    companion object {
        fun newInstance() = PlayerStatsHostFragment()
    }

    private lateinit var viewModel: PlayerStatsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.player_stats_host_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PlayerStatsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
