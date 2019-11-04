package me.efraimgentil.athena.repository

import me.efraimgentil.athena.domain.Congressman
import me.efraimgentil.athena.domain.CongressmanStatus
import me.efraimgentil.athena.domain.ExpenseByYearMonthQuotaDoc
import me.efraimgentil.athena.domain.dto.ExpenseDTO
import me.efraimgentil.athena.domain.type.CongressmanStatusType
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.cassandra.core.mapping.BasicMapId
import org.springframework.test.context.junit4.SpringRunner
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
        , properties = ["spring.profiles.active=test"])
class ExpenseByYearMonthQuotaDocRepositoryIT {

    @Autowired
    lateinit var repository: ExpenseByYearMonthQuotaDocRepository

    @Test
    fun test() {
        println( Instant.parse("2019-02-01T11:45" + ":00-03:00") )


        val expenseDTO = ExpenseDTO(
                congressmanName = "PAULO FOLETTO"
                , identityDocument = "47909463715"
                , congressmanId = 160517
                , numberParliamentarian = "280"
                , politicalPartyState = "ES"
                , legislature = 2015
                , politicalPartyAcronym = "PSB"
                , legislatureCode = 55
                , subQuotaNumber = 1
                , description = "MANUTENÇÃO DE ESCRITÓRIO DE APOIO À ATIVIDADE PARLAMENTAR"
                , subQuotaSpecNumber = 0
                , specificationDescription = ""
                , supplier = "Maria da Penha Rondini"
                , supplierIdentityDocument = "113.785.306/91  -  "
                , number = "S/N"
                , documentType = "1"
                , issuanceDate = "2019-01-31T00:00:00"
                , documentValue = "2749.11"
                , glossValue = "0"
                , netValue = "2749.11"
                , month = 1
                , year = 2019
                , parcel = 0
                , passenger = ""
                , destination = ""
                , allotment = "1558008"
                , repayment = ""
                , refund = ""
                , numberCongressmanId = 2317
                , documentId = 6744975
        )

        repository.save(ExpenseByYearMonthQuotaDoc.from(expenseDTO))

        println( repository.findAll() )
//        val findById = repository.findById(BasicMapId.id("id", 1))
//        print(findById);

//        for( i in 1..1000 ){
//            congressmanStatusRepository.save(CongressmanStatus(
//                      congressmanId = Random().nextInt(5)
//                    , datetime = Instant.now().minus( Random().nextInt(100).toLong() , ChronoUnit.DAYS )
//                    , legislatureId = 1
//                    , status = "MEEEEH"
//                    , politicalPartyAcronym = "PT"
//            ))
//        }

//
//        repository.save( Congressman(
//            id = 1
//            ,identityDocument = "99988844433"
//            ,dateOfDeath = null
//            ,dateOfBirth = "1988-02-12"
//            ,education =  "Superior Completo"
//            ,municipalityOfBirth = "CE"
//            ,civilName = "Solteiro"
//            ,sex = "M"
//            ,stateOfBirth = "CE"
//            ,lastStatus = status
//            ,lastStatuses = null
//            ,uri = null
//            ,websiteUrl = null
//        ) )
    }
}