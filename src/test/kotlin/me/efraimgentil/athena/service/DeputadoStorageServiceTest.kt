package me.efraimgentil.athena.service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import me.efraimgentil.athena.domain.*
import me.efraimgentil.athena.repository.DeputadoRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner
import java.time.LocalDate
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class DeputadoStorageServiceTest {

    lateinit var service : DeputadoStorageService
    lateinit var repository : DeputadoRepository

    @Before
    fun init() {
        repository = mockk();
        service = DeputadoStorageService(repository)
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
                ,data = "2019-01-01"
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
    val expectedDeputado = Deputado(
            id = 1
            ,cpf = "99988844433"
            ,dataFalecimento = "2019-02-12"
            ,dataNascimento = "1988-02-12"
            ,escolaridade =  "Superior Completo"
            ,municipioNascimento = "CE"
            ,nomeCivil = "Solteiro"
            ,sexo = "M"
            ,ufNascimento = "CE"
            ,ultimosStatus = null
            ,uri = "http://uri"
            ,urlWebsite = "http://website"
            ,ultimoStatus = StatusDeputado(
                id = 1
                , data = "2019-01-01"
                , uri = "https://dadosabertos.camara.leg.br/api/v2/deputados/0"
                , nome = "Some Test"
                , siglaPartido = "PL"
                , uriPartido = "https://dadosabertos.camara.leg.br/api/v2/partidos/0"
                , siglaUf = "BA"
                , idLegislatura = 56
                , urlFoto = "https://www.camara.leg.br/internet/deputado/bandep/0.jpg"
                , nomeEleitoral = "Some Test"
                , situacao = "Exercício"
                , condicaoEleitoral = "Titular"
                , descricaoStatus = "Descricao"
                , gabinete = Gabinete(
                    andar = "1"
                    , nome = "nome"
                    , email = "email"
                    , predio = "predio"
                    , sala = "sala 1"
                    , telefone = "telefone"
                 )
            )
        )
    val existingDeputado = Deputado(
            id = 1
            ,cpf = "99988844433"
            ,dataFalecimento = ""
            ,dataNascimento = "1988-02-12"
            ,escolaridade =  "Superior Completo"
            ,municipioNascimento = "CE"
            ,nomeCivil = "Solteiro"
            ,sexo = "M"
            ,ufNascimento = "CE"
            ,ultimosStatus = null
            ,uri = "http://uri"
            ,urlWebsite = "http://website"
            ,ultimoStatus = StatusDeputado(
                id = 2
                , data = "2018-01-01"
                , uri = "https://dadosabertos.camara.leg.br/api/v2/deputados/0"
                , nome = "Some Test"
                , siglaPartido = "PL"
                , uriPartido = "https://dadosabertos.camara.leg.br/api/v2/partidos/0"
                , siglaUf = "BA"
                , idLegislatura = 56
                , urlFoto = "https://www.camara.leg.br/internet/deputado/bandep/0.jpg"
                , nomeEleitoral = "Some Test"
                , situacao = "Exercício"
                , condicaoEleitoral = "Titular"
                , descricaoStatus = "Old"
                , gabinete = Gabinete(
                    andar = "2"
                    , nome = "nome"
                    , email = "email"
                    , predio = "predio"
                    , sala = "sala 1"
                    , telefone = "telefone"
                )
            )
        )
    val expectedUpdate = Deputado(
            id = 1
            ,cpf = "99988844433"
            ,dataFalecimento = "2019-02-12"
            ,dataNascimento = "1988-02-12"
            ,escolaridade =  "Superior Completo"
            ,municipioNascimento = "CE"
            ,nomeCivil = "Solteiro"
            ,sexo = "M"
            ,ufNascimento = "CE"
            ,uri = "http://uri"
            ,urlWebsite = "http://website"
            ,ultimoStatus = StatusDeputado(
                id = 1
                , data = "2019-01-01"
                , uri = "https://dadosabertos.camara.leg.br/api/v2/deputados/0"
                , nome = "Some Test"
                , siglaPartido = "PL"
                , uriPartido = "https://dadosabertos.camara.leg.br/api/v2/partidos/0"
                , siglaUf = "BA"
                , idLegislatura = 56
                , urlFoto = "https://www.camara.leg.br/internet/deputado/bandep/0.jpg"
                , nomeEleitoral = "Some Test"
                , situacao = "Exercício"
                , condicaoEleitoral = "Titular"
                , descricaoStatus = "Descricao"
                , gabinete = Gabinete(
                    andar = "1"
                    , nome = "nome"
                    , email = "email"
                    , predio = "predio"
                    , sala = "sala 1"
                    , telefone = "telefone"
                )
            )
            ,ultimosStatus = listOf(StatusDeputado(
                    id = 2
                    , data = "2018-01-01"
                    , uri = "https://dadosabertos.camara.leg.br/api/v2/deputados/0"
                    , nome = "Some Test"
                    , siglaPartido = "PL"
                    , uriPartido = "https://dadosabertos.camara.leg.br/api/v2/partidos/0"
                    , siglaUf = "BA"
                    , idLegislatura = 56
                    , urlFoto = "https://www.camara.leg.br/internet/deputado/bandep/0.jpg"
                    , nomeEleitoral = "Some Test"
                    , situacao = "Exercício"
                    , condicaoEleitoral = "Titular"
                    , descricaoStatus = "Old"
                    , gabinete = Gabinete(
                        andar = "2"
                        , nome = "nome"
                        , email = "email"
                        , predio = "predio"
                        , sala = "sala 1"
                        , telefone = "telefone"
                    )
            ))
    )

    @Test
    fun shouldSaveANewDeputado(){
        every { repository.findById(1) } returns Optional.empty()
        every { repository.save(ofType(Deputado::class)) } returns expectedDeputado

        service.store(input)

        verify { repository.save(expectedDeputado) }
    }

    @Test
    fun shouldSaveAExistingDeputado(){
        every { repository.findById(1) } returns Optional.of(existingDeputado)
        every { repository.save(ofType(Deputado::class)) } returns expectedUpdate

        service.store(input)

        verify { repository.save(expectedUpdate) }
    }
}