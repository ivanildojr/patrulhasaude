package patrulhasaude

class Servidor {

    Pessoa pessoa
    String situacaoFuncional
    String lotacao
    String matricula


    static constraints = {
        situacaoFuncional nullable: false, inList: ["Policial","Administrativo", "Terceirizado", "Outros"]
        lotacao nullable: false
        pessoa unique: true, nullable: false

    }

    @Override
    String toString() {
        if(pessoa) pessoa.nome
    }
}
