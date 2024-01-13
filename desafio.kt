/// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(
    val nome: String,
    var nivel: Nivel,
    var conteudos: MutableList<ConteudoEducacional>,
    var inscritos: MutableList<Usuario> = mutableListOf()
) {

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun exibirInscritos() {
        println("Inscritos na formação '$nome' ($nivel):")
        inscritos.forEachIndexed { index, usuario ->
            println("${index + 1}. ${usuario.nome}")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução a Kotlin")
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin")

    val formacaoKotlin = Formacao(
        "Formação Kotlin",
        Nivel.INTERMEDIARIO,
        mutableListOf(conteudo1, conteudo2)
    )

    val usuario1 = Usuario("João da Silva")
    val usuario2 = Usuario("Maria Souza")

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    formacaoKotlin.exibirInscritos()
}