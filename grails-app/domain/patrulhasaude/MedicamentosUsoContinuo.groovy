package patrulhasaude

class MedicamentosUsoContinuo {
    String nome
    String dosagem
    String posologia
    static belongsTo = [coleta:Coleta]
    static constraints = {
        nome nullable: false
        dosagem nullable: false
        posologia nullable: false
    }
}
