package com.basic.contractme.usecase

import com.basic.contractme.domain.*
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class CreateDocumentUsecase(
    private val documentEditor: DocumentEditor,
    private val repository: DocumentRepository
) {
    fun invoke(command: CreateDocumentCommand): CreateDocumentResponse {
        val payload = documentEditor.generate(command.text)

        val document = payload?.let {
            repository.save(
                command.contractId,
                command.status,
                payload,
                command.createdAt,
                command.updatedAt
            )
        } ?: throw RuntimeException("Error generating the file.")

        return CreateDocumentResponse(document.id)
    }
}

class CreateDocumentCommand(
    val contractId: ContractId,
    val status: DocumentStatus,
    val text: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)

class CreateDocumentResponse(val documentId: DocumentId)