package org.example.service

import org.example.model.Carro

interface CarroService {
    fun cadastrarCarro(carro: Carro)
    fun listarCarros(): List<Carro>
    fun deletarCarro(id: Int)
    fun atualizarCarro(id: Int, carroAtualizado: Carro): Boolean

}
