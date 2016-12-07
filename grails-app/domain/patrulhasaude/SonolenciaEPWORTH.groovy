package patrulhasaude

class SonolenciaEPWORTH {
    Integer sentadoOuLendo
    Integer assistindoTV
    Integer sentadoLugarPublico
    Integer passageiroAposUmaHoraCaminhada
    Integer sentadoCalmoAposAlmocoSemAlcool
    Integer deitadoDescansoATarde
    Integer sentadoConvesando
    Integer noCarroParadoTransito
    Integer total
    static belongsTo = [coleta:Coleta]
    static constraints = {
        sentadoOuLendo nullable: false
        assistindoTV nullable: false
        sentadoLugarPublico nullable: false
        passageiroAposUmaHoraCaminhada nullable: false
        sentadoCalmoAposAlmocoSemAlcool nullable: false
        deitadoDescansoATarde nullable: false
        sentadoConvesando nullable: false
        noCarroParadoTransito nullable: false
        total nullable: false

    }
}
