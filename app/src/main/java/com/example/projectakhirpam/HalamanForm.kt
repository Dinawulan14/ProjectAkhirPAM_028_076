package com.example.projectakhirpam

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitButtonClick: (MutableList<String>) -> Unit,
) {
    var namaTxt by rememberSaveable {
        mutableStateOf("")
    }
    var alamatTxt by rememberSaveable {
        mutableStateOf("")
    }
    var teleponTxt by rememberSaveable {
        mutableStateOf("")
    }
    var beratbarangTxt by rememberSaveable {
        mutableStateOf("")
    }
    var statuspengirimanTxt by rememberSaveable {
        mutableStateOf("")
    }
    var namakurirTxt by rememberSaveable {
        mutableStateOf("")
    }
    var ListDataTxt: MutableList<String> = mutableListOf(
        namaTxt,
        alamatTxt,
        teleponTxt,
        beratbarangTxt,
        statuspengirimanTxt,
        namakurirTxt
    )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        OutlinedTextField(value = namaTxt, onValueChange = {
            namaTxt = it
        }, label = {
            Text(text = "Nama Customer")
        })
        OutlinedTextField(value = alamatTxt, onValueChange = {
            alamatTxt = it
        }, label = {
            Text(text = "Alamat Customer")
        })
        OutlinedTextField(value = teleponTxt, onValueChange = {
            teleponTxt = it
        }, label = {
            Text(text = "No hp Customer")
        })
        OutlinedTextField(value = beratbarangTxt, onValueChange = {
            beratbarangTxt = it
        }, label = {
            Text(text = "Berat Barang")
        })
        OutlinedTextField(value = statuspengirimanTxt, onValueChange = {
            statuspengirimanTxt = it
        }, label = {
            Text(text = "Status Pengiriman")
        })
        OutlinedTextField(value = namakurirTxt, onValueChange = {
            namakurirTxt = it
        }, label = {
            Text(text = "Nama Kurir")
        })
    }
    Spacer(modifier = Modifier.padding(16.dp))
    Button(onClick = { onSubmitButtonClick(ListDataTxt) }) {
        Text(text = stringResource(id = R.string.btn_submit))
    }
}