enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val matricula: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            println("Usuário já está matriculado nesta formação.")
        } else {
            inscritos.add(usuario)
            println("Usuário matriculado com sucesso.")
        }
    }
}

fun main() {
    val inscritos = listOf(Usuario(1), Usuario(2), Usuario(3), Usuario(4), Usuario(5))
    val formacao = Formacao("Programação em Kotlin", listOf(
        ConteudoEducacional("Introdução ao Kotlin", 120),
        ConteudoEducacional("Estruturas de Controle de Fluxo", 90),
        ConteudoEducacional("Classes e Objetos", 150),
        ConteudoEducacional("Collections Framework", 120),
        ConteudoEducacional("Programação Funcional", 180),
        ConteudoEducacional("Coroutines", 90)
    ))
    
    // Cenário 1: Matrícula de usuário existente
    val usuarioExistente = inscritos[2]
    formacao.matricular(usuarioExistente)
    
    // Cenário 2: Matrícula de usuário novo
    val usuarioNovo = Usuario(6)
    formacao.matricular(usuarioNovo)
    
    // Cenário 3: Tentativa de matrícula de usuário já matriculado
    formacao.matricular(usuarioNovo)
}