package patrulhasaude

class Pessoa {

    static hasMany = [coletas: Coleta]
    String nome
    String cpf
    String telefone
    String matricula

    static constraints = {
        nome nullable: false
        telefone nullable: false
        cpf nullable: false, unique: true
        matricula nullable: false, unique: true
        //coletas display:false
    }

    String toString() {
        nome
    }
}
