package patrulhasaude

import grails.transaction.Transactional

@Transactional
class ColetaService {

    /*Responsável por avaliar se o consumo de alcool é normal ou alterado*/
    Coleta consumoAlcool(Coleta coleta, String sexo){
        if(sexo.equalsIgnoreCase("M")){
            if(coleta?.frequenciaConsumo.toInteger() <= 15 && coleta?.dosePorVez.toInteger() <= 3){
                coleta.classificacaoEtilismo = "Normal"
                return coleta
            }else {
                coleta.classificacaoEtilismo = "Alterado"
                return coleta
            }
        }else{
            if(coleta?.frequenciaConsumo.toInteger() <= 10 && coleta?.dosePorVez.toInteger() <= 2){
                coleta.classificacaoEtilismo = "Normal"
                return coleta
            }else {
                coleta.classificacaoEtilismo = "Alterado"
                return coleta
            }
        }

    }

}
