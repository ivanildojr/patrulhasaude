package patrulhasaude

class Pessoa {

    static hasMany = [coletas: Coleta]
    static hasOne = [servidor: Servidor]
    String nome
    String cpf
    String telefone
    String sexo
    Date dataNascimento
    String cnhTipo


    static constraints = {
        nome nullable: false
        telefone nullable: false
        cpf nullable: false, unique: true
        sexo nullable: false, inList: ["M", "F", "N"]
        dataNascimento nullable: false

        //coletas display:false
        //servidor display:false
    }

    String toString() {
        nome
    }
}
