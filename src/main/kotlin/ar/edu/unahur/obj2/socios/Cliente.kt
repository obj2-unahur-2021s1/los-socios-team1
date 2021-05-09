package ar.edu.unahur.obj2.socios

import kotlin.math.max

class Cliente(var estadoDeAnimo: EstadoDeAnimo,var barrio: Barrio, var plataEnBolsillo: Int) {

    fun cuantaPropinaDejariaSoloEstadoDeAnimo(valorDelPedido: Int): Int {
        if(estadoDeAnimo == Indiferente) {
            return this.plataEnBolsillo
        }
        else {
            return estadoDeAnimo.propina(valorDelPedido)
        }
    }

    fun cuantaPropinaDejariaConBarrio(valorDelPedido: Int) :Int {
        if(barrio==LasLauchas) {
            return this.cuantaPropinaDejariaSoloEstadoDeAnimo(valorDelPedido) / barrio.propinaExtra()
        }
        else if(barrio==BarrioVerde) {
            return max(this.cuantaPropinaDejariaSoloEstadoDeAnimo(valorDelPedido), barrio.propinaExtra())
        }
        else {
            return this.cuantaPropinaDejariaSoloEstadoDeAnimo(valorDelPedido) + barrio.propinaExtra()
        }
    }
}


abstract class EstadoDeAnimo {
    abstract fun propina(valorDelPedido: Int): Int
}

object Enojado: EstadoDeAnimo() {
    override fun propina(valorDelPedido: Int) = 0
}

object Feliz: EstadoDeAnimo() {
    override fun propina(valorDelPedido: Int) = valorDelPedido * 25 / 100
}

object Indiferente: EstadoDeAnimo() {
    override fun propina(valorDelPedido: Int) = 0
}
object Resfriado: EstadoDeAnimo() {
    override fun propina(valorDelPedido: Int) = valorDelPedido
}

abstract class Barrio{
    abstract fun propinaExtra(): Int
}

object LasRosas: Barrio() {
    override fun propinaExtra() = + 50
}

object LasLauchas: Barrio() {
    override fun propinaExtra() = 2
}

object BarrioVerde: Barrio() {
    override fun propinaExtra() = 200
}

object LasTorres: Barrio() {
    override fun propinaExtra() = 0
}
