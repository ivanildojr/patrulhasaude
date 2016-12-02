package patrulhasaude

class Coleta {



    Date dataColeta
    Double circunferenciaAbd
    static belongsTo = [pessoa:Pessoa]

    static constraints = {
        dataColeta nullable: false
        circunferenciaAbd nullable: false
    }

//    @Override
//    String toString() {
//        pessoa.nome
//    }
}
