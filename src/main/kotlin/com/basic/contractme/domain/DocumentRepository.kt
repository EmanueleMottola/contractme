package com.basic.contractme.domain

import java.time.LocalDateTime

interface DocumentRepository {
    fun save(
        contractId: ContractId,
        status: DocumentStatus,
        payload: ByteArray,
        createdAt: LocalDateTime,
        updatedAt: LocalDateTime
    ) : Document
}