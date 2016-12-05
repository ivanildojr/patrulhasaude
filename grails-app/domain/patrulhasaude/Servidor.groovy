package patrulhasaude

class Servidor {

    static belongsTo = [pessoa: Pessoa]
    String situacaoFuncional
    String lotacao
    String matricula


    static constraints = {
        situacaoFuncional nullable: false
        lotacao nullable: false
        matricula nullable: false
    }
}
