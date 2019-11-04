package me.efraimgentil.athena.listener

import me.efraimgentil.athena.config.RabbitMQConstants
import me.efraimgentil.athena.domain.ExpenseByYearMonthQuotaDoc
import me.efraimgentil.athena.domain.dto.ExpenseDTO
import me.efraimgentil.athena.repository.ExpenseByYearMonthQuotaDocRepository
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.data.cassandra.core.mapping.BasicMapId
import org.springframework.stereotype.Service

@Service
class ExpenseListener (val expenseByYearMonthQuotaDocRepository: ExpenseByYearMonthQuotaDocRepository){

    @RabbitListener(queues = [RabbitMQConstants.EXPENSE_STORE_QUEUE], errorHandler = "defaultErrorHandler")
    fun handle(expense : ExpenseDTO){
        println("Handle and do something with" + expense)

        throw RuntimeException("something went wrong? will it retry?")
    }

    @RabbitListener(queues = [RabbitMQConstants.EXPENSE_STORE_BY_YEAR_MONTH_QUOTA_DOC], errorHandler = "defaultErrorHandler")
    fun handleStoreByYearMonthQuotaDoc(expense : ExpenseDTO){
        val mapId = BasicMapId.id("congressmanId", expense.congressmanId!!.toInt())
                .with("year", expense.year!!)
                .with("month", expense.month!!)
                .with("quota", expense.subQuotaNumber!!)
                .with("documentId", expense.documentId!!)

        if(expenseByYearMonthQuotaDocRepository.findById(mapId).isPresent){
            // do nothing
            // TODO maybe log something ?!
        }else{
            expenseByYearMonthQuotaDocRepository.save(ExpenseByYearMonthQuotaDoc.from(expense))
        }
    }
}