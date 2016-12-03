package patrulhasaude

import grails.converters.JSON



class HelloController {

    def index() {

        Hello h = new Hello()
        Hello h1 = new Hello()

        h.setId(0)
        h.setName("Ivanildo")
        h.setCompany("PRF")
        h.setEmail("ivanildo.jr@gmail.com")
        h1.setId(1)
        h1.setName("Susiane")
        h1.setCompany("INEP")
        h1.setEmail("susiane.m@gmail.com")
        def tabela = [h,h1] as JSON

        render(view:"index",model:[gridData:tabela])//[gridData: tabela]
    }

    def teste(){
        def parametro = "ivanildo"
        render(view:"teste",model:[gridData:parametro])
    }
}
