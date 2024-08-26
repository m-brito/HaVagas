class Formulario(
    val nome: String,
    val email: String,
    val desejaAtualizacoes: Boolean,
    val tipoTelefone: String,
    val telefone: String,
    val telefoneCelular: String,
    val sexo: String,
    val dataNascimento: String,
    val formacao: String,
    val anoFormatura: String,
    val anoConclusao: String,
    val instituicao: String,
    val tituloMonografia: String,
    val orientador: String,
    val vagasInteresse: String
) {
    override fun toString(): String {
        return """
            Nome: $nome
            Email: $email
            Deseja receber atualizações: $desejaAtualizacoes
            Tipo de telefone: $tipoTelefone
            Telefone: $telefone
            Telefone celular: $telefoneCelular
            Sexo: $sexo
            Data de nascimento: $dataNascimento
            Formação: $formacao
            Ano de formatura: $anoFormatura
            Ano de conclusão: $anoConclusao
            Instituição: $instituicao
            Título da monografia: $tituloMonografia
            Orientador: $orientador
            Vagas de interesse: $vagasInteresse
        """.trimIndent()
    }
}