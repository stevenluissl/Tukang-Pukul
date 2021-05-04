package com.example.foodtower.Fragment

import com.example.foodtower.interfaceSubs
import com.example.foodtower.presenterSubs
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HargaTagihan {

    private var view: interfaceSubs = mock(interfaceSubs::class.java)
    private var presenter = presenterSubs(view)

    @Test
    fun hitungharga() {
        //menguji data nama Udin dan Harga
        var harga = presenter.hargaa("Udin","Price : IDR 1.500.000 / Month")
        //mengecek apakah data tersebut sudah benar
        assertEquals("testing","Price : IDR 1.500.000 / Month",harga)
    }
}