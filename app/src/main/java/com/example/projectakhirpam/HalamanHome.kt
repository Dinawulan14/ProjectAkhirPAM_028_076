package com.example.projectakhirpam

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectakhirpam.ui.theme.ProjectAkhirPAMTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanHome(
    onNextButtonClicked: () -> Unit
) {
    val image = painterResource(id = R.drawable.kurir)
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedCard(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            border = BorderStroke(1.dp, Color.Black), modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(vertical = 50.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 16.dp)
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ) {
            var emailTxt by rememberSaveable {
                mutableStateOf("")
            }
            var passwordTxt by rememberSaveable {
                mutableStateOf("")
            }
            var ListDataTxt: MutableList<String> = mutableListOf(emailTxt, passwordTxt)

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize(1f)
            ) {
                OutlinedTextField(value = emailTxt, onValueChange = {
                    emailTxt = it
                }, label = {
                    Text(text = "Email")
                })
                OutlinedTextField(value = passwordTxt, onValueChange = {
                    passwordTxt = it
                }, label = {
                    Text(text = "Password")
                })
                Button(
                    onClick = onNextButtonClicked
                ) {
                    Text(stringResource(R.string.btn_next))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHalamanHome() {
    ProjectAkhirPAMTheme {
        HalamanHome(onNextButtonClicked = {})
    }
}