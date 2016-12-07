package patrulhasaude

class Coleta {



    Date dataColeta
    String hipertensao
    String diabetes
    String examesPeriodicos
    String outrasDoencas /*Melhor ser uma Lista*/
    String tabagista
    Integer tempoTabagismo /*Em anos*/
    Integer cigarrosDia
    String usoBebidaAlcoolica
    String frequenciaConsumo /*Em uma semana*/
    String dosePorVez
    String classificacaoEtilismo /*Beseado numa escala - Regra de Negócio*/
    String percepcaoPeso
    String percepcaoEmocional
    String acaoEmocional
    String descricaoAcaoEmocional
    String climaAmbienteTrabalho
    String praticaAtividadeFisica
    String modalidadeAtividadeFisica
    String frequenciaAtividadeFisica
    String horasSono
    String qualidadeSono

    /*Escala de Sonolência de EPWORTH*/

    static belongsTo = [pessoa:Pessoa]


    /*Outras Estações*/
    static hasOne = [antropometria: Antropometria,medicinaTrafego: MedicinaTrafego,bioquimica: Bioquimica,atividadesFisicas: AtividadesFisicas,orientacoes: Orientacoes,
                     medicamentosUsoContinuo: MedicamentosUsoContinuo, epworth:SonolenciaEPWORTH]



    static constraints = {
        dataColeta nullable: false
        hipertensao nullable: false, inList: ["S","N"]
        diabetes nullable: false, inList: ["S","N"]
        examesPeriodicos nullable: false, inList: ["S","N"]
        outrasDoencas nullable: true
        tabagista nullable: false, inList: ["S","N"]
        tempoTabagismo nullable: false
        cigarrosDia nullable: false
        medicamentosUsoContinuoId nullable: true, unique: true
        usoBebidaAlcoolica nullable: false, inList: ["S","N"]
        frequenciaConsumo nullable: false
        dosePorVez nullable: false
        classificacaoEtilismo nullable: false, inList: ["Normal", "Alterado"]
        percepcaoPeso nullable: false, inList: ["Acima","Normal", "Abaixo"]
        percepcaoEmocional nullable: false, inList: ["Muito Estresse","Estresse","Normal","Tranquilo"]
        acaoEmocional nullable: false, inList: ["S","N"]
        descricaoAcaoEmocional nullable: true
        climaAmbienteTrabalho nullable: false, inList: ["Muito Tenso","Tenso", "Normal", "Tranquilo"]
        praticaAtividadeFisica nullable: false, inList: ["S","N"]
        modalidadeAtividadeFisica nullable: true
        frequenciaAtividadeFisica nullable: true
        horasSono nullable: false
        qualidadeSono nullable: false, inList: ["Ótimo","Bom","Razoável","Ruim"]
        atividadesFisicas unique: true, nullable: true
        antropometria unique: true, nullable: true
        bioquimica unique: true, nullable: true
        medicinaTrafego unique: true, nullable: true
        medicamentosUsoContinuo unique: true, nullable: true
        epworth unique: true, nullable: true
        orientacoes unique: true, nullable: true



    }

    @Override
    String toString() {
        if(pessoa) pessoa.nome
    }
}
