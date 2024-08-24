package com.basic.contractme.domain

import java.time.LocalDateTime

data class Document(
    val id: DocumentId,
    val contractId: ContractId,
    val status: DocumentStatus,
    val payload: ByteArray,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)