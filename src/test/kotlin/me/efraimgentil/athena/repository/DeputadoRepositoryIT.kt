package me.efraimgentil.athena.repository

import me.efraimgentil.athena.domain.Deputado
import me.efraimgentil.athena.domain.StatusDeputado
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDate

//
//@RunWith(SpringRunner::class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
//        , properties = ["spring.profiles.active=test"])

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
        , properties = ["spring.profiles.active=test"])
class DeputadoRepositoryIT {


    @Autowired
    lateinit var repository : DeputadoRepository

    @Test
    fun test() {
        var status = StatusDeputado(
                id = 1
                , data = "2019-01-01"
                , uri = "https://dadosabertos.camara.leg.br/api/v2/deputados/204554"
                , nome = "ABÍLIO SANTANA"
                , siglaPartido = "PL"
                , uriPartido = "https://dadosabertos.camara.leg.br/api/v2/partidos/37906"
                , siglaUf = "BA"
                , idLegislatura = 56
                , urlFoto = "https://www.camara.leg.br/internet/deputado/bandep/204554.jpg"
                , nomeEleitoral = "ABÍLIO SANTANA"
                , situacao = "Exercício"
                , condicaoEleitoral = "Titular"
                , descricaoStatus = null
                , gabinete = null
        )

        repository.save( Deputado(
            id = 1
            ,cpf = "99988844433"
            ,dataFalecimento = null
            ,dataNascimento = "1988-02-12"
            ,escolaridade =  "Superior Completo"
            ,municipioNascimento = "CE"
            ,nomeCivil = "Solteiro"
            ,sexo = "M"
            ,ufNascimento = "CE"
            ,ultimoStatus = status
            ,ultimosStatus = null
            ,uri = null
            ,urlWebsite = null
        ) )
    }

    @Test
    fun testeLoad(){
        val findById = repository.findById(1);
        println(findById)
    }
}