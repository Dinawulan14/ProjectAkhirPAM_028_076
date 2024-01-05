package com.example.projectakhirpam

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun HalamanDetail (
    formUIState: FormUIState,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Nama")
        Text(text = formUIState.nama)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "alamat")
        Text(text = formUIState.alamat)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "telepon")
        Text(text = formUIState.telepon)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "beratbarang")
        Text(text = formUIState.beratbarang)
        Divider()
        Text(text = "Status Pengiriman")
        Text(text = formUIState.statuspengiriman)
        Divider()
        Text(text = "nama kurir")
        Text(text = formUIState.namakurir)

        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.padding_small)
            )
        ) {

            Row(
                modifier = Modifier
                    .weight(1f, false)
                    .padding(dimensionResource(R.dimen.padding_medium))
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
                ) {
                }
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicked
                ) {
                    Text(stringResource(R.string.btn_back))
                }
            }
        }
    }
}
