package com.example.projectakhirpam.navigasi

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectakhirpam.ContactViewModel
import com.example.projectakhirpam.HalamanDetail
import com.example.projectakhirpam.HalamanForm
import com.example.projectakhirpam.HalamanHome
import com.example.projectakhirpam.R

enum class PengelolaHalaman {
    Home,
    Formulir,

    Summary
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KurirAppBar(
    bisaNavigasiBack: Boolean,
    navigasiUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(title = { Text(stringResource(id = R.string.app_name)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (bisaNavigasiBack) {
                IconButton(onClick = navigasiUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.btn_back)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KurirApp(
    viewModel: ContactViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    Scaffold(
        topBar = {
            KurirAppBar(
                bisaNavigasiBack = false,
                navigasiUp = { /*TODO: implement back navigation*/
                }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PengelolaHalaman.Home.name) {
                HalamanHome(
                    onNextButtonClicked = {
                        navController.navigate(PengelolaHalaman.Formulir.name)
                    })
            }
            composable(route = PengelolaHalaman.Formulir.name) {
                val context = LocalContext.current
                HalamanForm(
                    onSubmitButtonClick = {
                        navController.navigate(PengelolaHalaman.Summary.name) },
                )
            }
            composable(route = PengelolaHalaman.Summary.name) {
                HalamanDetail(
                    formUIState = uiState,
                    onCancelButtonClicked = { cancelOrderAndNavigateToForm(
                        viewModel,
                        navController
                    )
                    }
                )
            }
        }
    }
}

fun cancelOrderAndNavigateToForm(
    viewModel: ContactViewModel,
    navController: NavHostController
) {
    navController.popBackStack(PengelolaHalaman.Home.name, inclusive = false)
}
