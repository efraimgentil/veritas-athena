package me.efraimgentil.athena.config

object RabbitMQConstants {
    const val NO_ROUTING = ""
    const val EXPENSE_TOPIC = "expense"
    const val EXPENSE_STORE_QUEUE = "expenseStore"
    const val EXPENSE_STORE_BY_YEAR_MONTH_QUOTA_DOC = "expenseStoreByYearMonthQuotaDoc"

    const val CONGRESSMAN_TOPIC = "congressman"
    const val CONGRESSMAN_STORE_QUEUE = "congressmanStore"
    const val CONGRESSMAN_STATUS_STORE_QUEUE = "congressmanStatusStore"
}