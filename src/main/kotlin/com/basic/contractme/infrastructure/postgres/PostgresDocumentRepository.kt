package com.basic.contractme.infrastructure.postgres

import com.basic.contractme.domain.ContractId
import com.basic.contractme.domain.Document
import com.basic.contractme.domain.DocumentRepository
import com.basic.contractme.domain.DocumentStatus
import org.jooq.DSLContext
import org.jooq.Table
import java.time.LocalDateTime

class PostgresDocumentRepository(
    private val dslContext: DSLContext
) : DocumentRepository {
    override fun save(
        contractId: ContractId,
        status: DocumentStatus,
        payload: ByteArray,
        createdAt: LocalDateTime,
        updatedAt: LocalDateTime
    ): Document {
        //TODO
    }
}