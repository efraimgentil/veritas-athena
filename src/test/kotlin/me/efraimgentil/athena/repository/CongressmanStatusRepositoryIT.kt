package me.efraimgentil.athena.repository

import me.efraimgentil.athena.domain.Congressman
import me.efraimgentil.athena.domain.CongressmanStatus
import me.efraimgentil.athena.domain.type.CongressmanStatusType
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
        , properties = ["spring.profiles.active=test"])
class CongressmanStatusRepositoryIT {


    @Autowired
    lateinit var congressmanStatusRepository: CongressmanStatusRepository

    @Test
    fun test() {

        for( i in 1..1000 ){
            congressmanStatusRepository.save(CongressmanStatus(
                      congressmanId = Random().nextInt(5)
                    , datetime = Instant.now().minus( Random().nextInt(100).toLong() , ChronoUnit.DAYS )
                    , legislatureId = 1
                    , status = "MEEEEH"
                    , politicalPartyAcronym = "PT"
            ))
        }

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

    @Test
    fun testeLoad(){
//        val findById = repository.findById(1);
//        println(findById)
    }
}