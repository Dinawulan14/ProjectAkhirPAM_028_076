package com.example.projectakhirpam

import androidx.lifecycle.ViewModel
import com.example.projectakhirpam.data.FormUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ContactViewModel : ViewModel(){
    private val _stateUI = MutableStateFlow(FormUIState())
    val stateUI: StateFlow<FormUIState> = _stateUI.asStateFlow()

    fun setContact(listData: MutableList<String>) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = listData[0],
                alamat = listData[1],
                telepon = listData[3],
                beratbarang = listData[4],
                statuspengiriman = listData[5],
                namakurir = listData[6]
            )
        }
    }
    fun resetForm(){
        _stateUI.value = FormUIState()
    }
}