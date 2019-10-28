package me.efraimgentil.athena.service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import me.efraimgentil.athena.domain.*
import me.efraimgentil.athena.domain.type.OfficeType
import me.efraimgentil.athena.domain.type.CongressmanStatusType
import me.efraimgentil.athena.repository.CongressmanRepository
import me.efraimgentil.athena.repository.CongressmanStatusRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.cassandra.core.mapping.BasicMapId
import org.springframework.test.context.junit4.SpringRunner
import java.time.Instant
import java.time.LocalDate
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
        , properties = ["spring.profiles.active=test"])
class CongressmanStorageServiceIT {

    @Autowired
    lateinit var service : CongressmanStorageService
    @Autowired
    lateinit var congressmanRepository : CongressmanRepository
    @Autowired
    lateinit var congressmanStatusRepository : CongressmanStatusRepository

    @Before
    fun init() {
        service = CongressmanStorageService(congressmanRepository, congressmanStatusRepository)
    }

    val input = DeputadoDTO(
            id = 1
            , cpf = "99988844433"
            , uri = "http://uri"
            , urlWebsite = "http://website"
            , ufNascimento =  "CE"
            , municipioNascimento = "CE"
            , sexo =  "M"
            , redeSocial = listOf("facebook")
            , nomeCivil = "Solteiro"
            , escolaridade = "Superior Completo"
            , dataNascimento = LocalDate.of(1988, 2 , 12)
            , dataFalecimento = LocalDate.of(2019, 2 , 12)
            , ultimoStatus = UltimoStatusDTO(
                id = 1
                ,data = "2019-01-01T11:45"
                ,uri = "https://dadosabertos.camara.leg.br/api/v2/deputados/0"
                ,uriPartido = "https://dadosabertos.camara.leg.br/api/v2/partidos/0"
                ,urlFoto = "https://www.camara.leg.br/internet/deputado/bandep/0.jpg"
                ,siglaPartido = "PL"
                ,siglaUf = "BA"
                ,idLegislatura = 56
                ,condicaoEleitoral = "Titular"
                ,situacao = "Exercício"
                ,nome = "Some Test"
                ,nomeEleitoral = "Some Test"
                ,descricaoStatus = "Descricao"
                ,gabinete = GabineteDTO(
                      andar = "1"
                    , nome = "nome"
                    , email = "email"
                    , predio = "predio"
                    , sala = "sala 1"
                    , telefone = "telefone"
                )
            )
        )

    @Ignore //TODO configure IT test to use new docker container
    @Test
    fun shouldNotSaveMultipleRowsForTheSameCongressmanStatus(){
        val congressmanId = input.id
        val statusDatetime = Instant.parse(input.ultimoStatus!!.data + ":00-03:00")
        service.addStatusIfNeeded(input)
        var numOfRows = congressmanStatusRepository.countByCongressmanIdAndDatetime(congressmanId, statusDatetime)
        assertThat(numOfRows).isEqualTo(1L)

        service.addStatusIfNeeded(input)
        numOfRows = congressmanStatusRepository.countByCongressmanIdAndDatetime(congressmanId, statusDatetime)
        assertThat(numOfRows).isEqualTo(1L)
    }
}