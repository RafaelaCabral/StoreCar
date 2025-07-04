package org.example.service.impl


import org.example.model.Carro
import org.example.repository.CarroRepository
import org.example.service.CarroService

class CarroServiceImpl : CarroService {

    private val repository = CarroRepository()

    override fun cadastrarCarro(carro: Carro) {
        if (carro.modelo.isBlank() && carro.marca.isBlank() && carro.valor <= 0.0) {
            println("Campos obrigatórios vazios ou inválidos (modelo, marca e valor)")
            return
        }
        repository.inserirCarro(carro)
    }

    override fun listarCarros(): List<Carro> {
        return repository.listarCarros()
    }

    override fun deletarCarro(id: Int) {
        if (id <= 0) {
            println("ID inválido para deletar: $id")
            return
        }
        repository.deletarCarro(id)
    }

    override fun atualizarCarro(id: Int, carroAtualizado: Carro): Boolean {
        if (id <= 0) {
            println("ID inválido para atualizar: $id")
            return false
        }

        if (carroAtualizado.modelo.isBlank() || carroAtualizado.marca.isBlank() || carroAtualizado.valor <= 0.0) {
            println("Campos obrigatórios vazios ou inválidos (modelo, marca e valor)")
            return false
        }

        val atualizado = repository.atualizarCarro(id, carroAtualizado)

        if (atualizado) {
            println("Carro com ID $id atualizado com sucesso.")
        } else {
            println("Falha ao atualizar o carro com ID $id. Verifique se ele existe.")
        }

        return atualizado
    }


}
