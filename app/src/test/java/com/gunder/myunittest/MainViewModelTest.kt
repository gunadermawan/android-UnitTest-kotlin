package com.gunder.myunittest

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito.*

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyLength = 10.0
    private val dummyHeight = 5.0
    private val dummyWidth = 3.0

    private val dummyVolume = 150.0
    private val dummyCircumFerence = 600.0
    private val dummySurfaceAre = 190.0

    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModel = MainViewModel(cuboidModel)
    }

    @Test
    fun testVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength, dummyHeight, dummyWidth)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun testMockVolume() {
        `when`(mainViewModel.getVolume()).thenReturn(dummyVolume)
        val volume = mainViewModel.getVolume()
        verify(cuboidModel).getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun testCircumFerence() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(CuboidModel())
        mainViewModel.save(dummyLength, dummyHeight, dummyWidth)
        val volume = mainViewModel.getCircumFerence()
        assertEquals(dummyCircumFerence, volume, 0.0001)
    }

    @Test
    fun testMockCircumFerence() {
        `when`(mainViewModel.getCircumFerence()).thenReturn(dummyCircumFerence)
        val circumReference = mainViewModel.getCircumFerence()
        verify(cuboidModel).getCircumFerence()
        assertEquals(dummyCircumFerence, circumReference, 0.0001)
    }

    @Test
    fun testSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength, dummyHeight, dummyWidth)
        val volume = mainViewModel.getSurfaceArea()
        assertEquals(dummySurfaceAre, volume, 0.0001)
    }

    @Test
    fun testMockSurfaceArea() {
        `when`(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceAre)
        val surfaceArea = mainViewModel.getSurfaceArea()
        verify(cuboidModel).getSurfaceArea()
        assertEquals(dummySurfaceAre, surfaceArea, 0.0001)
    }


    @Test
    fun getCircumFerence() {
    }

    @Test
    fun getSurfaceArea() {
    }

    @Test
    fun getVolume() {
    }

    @Test
    fun save() {
    }
}