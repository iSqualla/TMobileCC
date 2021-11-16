package com.example.tmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.example.tmobile.ui.compose.PageCompose
import com.example.tmobile.ui.theme.TMobileTheme
import com.example.tmobile.ui.viewmodel.PageViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val pageViewModel: PageViewModel by viewModel()
    private val composer = PageCompose()

    @ExperimentalUnitApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel.pages.observe(this, {
            setContent {
                TMobileTheme {
                    composer.ListCards(it)
                }
            }
        })
    }
}
