package com.gunder.myunittest

class MainViewModel(private val cuboidModel: CuboidModel) {
    fun getCircumFerence() = cuboidModel.getCircumFerence()

    fun getSurfaceArea() = cuboidModel.getSurfaceArea()

    fun  getVolume() = cuboidModel.getVolume()

    fun  save(w: Double, l:Double, h: Double){
        cuboidModel.save(w,l,h)
    }
}