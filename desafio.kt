// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val idade: Int, val email: String) {
    override fun toString(): String {
        return "Nome: $nome, Idade: $idade, Email: $email"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if(usuario.nome.isNotBlank()){
            inscritos.add(usuario)
            println("cadastrado com sucesso")
        }else {
            throw IllegalArgumentException("$usuario")
        }
    }

    fun matriculaEmLote(usuarios: List<Usuario>) {
        for(usuario in usuarios){
            try {
                matricular(usuario)
            }catch (e: Exception) {
                println("Ocorreu um erro ao cadastrar o aluno: ${e.message}")
            }
        }
        println("Todos os alunos foram cadastrados")
    }

    fun exibirTodosAlunos(){
        inscritos.forEach{ println(it)}
    }

    override fun toString(): String {
        return "Nome: $nome"
    }
}

fun main() {

    val conteudos =  listOf(
        ConteudoEducacional("Logica", nivel = Nivel.BASICO),
        ConteudoEducacional("sintaxe", nivel = Nivel.INTERMEDIARIO),
        ConteudoEducacional("promises", nivel = Nivel.AVANCADO))

    println("Criado o conteudo $conteudos")

    val formacao = Formacao("TypeScript", conteudos)

    println("Criado o formacao $formacao")

    val joao = Usuario("joao", 16, "joao@teste.com")

    println("Criado o usuario e cadastrando: $joao")

    formacao.matricular(joao)

    println("Criando uma lista de usuários para cadastro em lote")

    val alunos = listOf(
        Usuario("julia", 59, "julia@teste.com"),
        Usuario("", 18, "vazio@teste.com"),
        Usuario("leslie", 25, "leslie@teste.com")
    )

    formacao.matriculaEmLote(alunos);

    formacao.exibirTodosAlunos();
}
