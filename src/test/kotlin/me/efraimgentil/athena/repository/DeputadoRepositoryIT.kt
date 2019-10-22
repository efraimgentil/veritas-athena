package me.efraimgentil.athena.repository

import me.efraimgentil.athena.domain.Congressman
import me.efraimgentil.athena.domain.type.CongressmanStatusType
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

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
        var status = CongressmanStatusType(
                id = 1
                , date = "2019-01-01"
                , uri = "https://dadosabertos.camara.leg.br/api/v2/deputados/204554"
                , name = "ABÍLIO SANTANA"
                , politicalPartyAcronym = "PL"
                , politicalPartyUri = "https://dadosabertos.camara.leg.br/api/v2/partidos/37906"
                , politicalPartyState = "BA"
                , legislatureId = 56
                , photoUrl = "https://www.camara.leg.br/internet/deputado/bandep/204554.jpg"
                , electoralName = "ABÍLIO SANTANA"
                , status = "Exercício"
                , electoralCondition = "Titular"
                , statusDescription = null
                , office = null
        )

        repository.save( Congressman(
            id = 1
            ,identityDocument = "99988844433"
            ,dateOfDeath = null
            ,dateOfBirth = "1988-02-12"
            ,education =  "Superior Completo"
            ,municipalityOfBirth = "CE"
            ,civilName = "Solteiro"
            ,sex = "M"
            ,stateOfBirth = "CE"
            ,lastStatus = status
            ,lastStatuses = null
            ,uri = null
            ,websiteUrl = null
        ) )
    }

    @Test
    fun testeLoad(){
        val findById = repository.findById(1);
        println(findById)
    }
}