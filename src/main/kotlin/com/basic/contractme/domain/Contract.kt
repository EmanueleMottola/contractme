package com.basic.contractme.domain

data class Contract(
    val contractId: ContractId,
    val providerId: CompanyId,
    val consumerId: CompanyId,
    val documents: List<Document>
)
