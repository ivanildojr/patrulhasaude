package patrulhasaude

class Antropometria {
    Double peso
    Double altura
    Double imc
    Double cincunferenciaAbdominal
    Double circunferenciaCervical
    String classificacaoIMC
    static belongsTo = [coleta:Coleta]
    static constraints = {
        peso nullable: false
        altura nullable: false
        imc nullable: false
        cincunferenciaAbdominal nullable: false
        circunferenciaCervical nullable: false
        classificacaoIMC nullable: false, inList: ["AB", "N", "SP", "OI", "OII", "OIII"]
        coleta unique: true, nullable: false
    }

    @Override
    String toString() {
        if(coleta) coleta.pessoa.nome
    }
}
