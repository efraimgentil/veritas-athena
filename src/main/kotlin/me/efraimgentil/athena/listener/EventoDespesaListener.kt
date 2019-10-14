package me.efraimgentil.athena.listener

import me.efraimgentil.athena.domain.EventoDespesaDTO
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service


@Service
@RabbitListener(queues = ["deputadoDespesaStore"], errorHandler = "defaultErrorHandler")
class EventoDespesaListener {



//    {
//        "ano": 2019,
//        "mes": 3,
//        "tipoDespesa": "MANUTENÇÃO DE ESCRITÓRIO DE APOIO À ATIVIDADE PARLAMENTAR",
//        "codDocumento": 6801547,
//        "tipoDocumento": "Nota Fiscal",
//        "codTipoDocumento": 0,
//        "dataDocumento": "2019-03-14",
//        "numDocumento": "355732875",
//        "valorDocumento": 154.95,
//        "urlDocumento": "",
//        "nomeFornecedor": "COMPANHIA DE ELETRICIDADE DO ESTADO DA BAHIA",
//        "cnpjCpfFornecedor": "15139629000194",
//        "valorLiquido": 154.95,
//        "valorGlosa": 0,
//        "numRessarcimento": "",
//        "codLote": 1582602,
//        "parcela": 0
//    }

    @RabbitHandler
    fun handle(despesa: EventoDespesaDTO){

        println("Handle and do something with" + despesa)

        throw RuntimeException("something went wrong? will it retry?")

    }
}