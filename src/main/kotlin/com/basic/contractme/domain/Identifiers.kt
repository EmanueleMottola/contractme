package com.basic.contractme.domain

import java.util.UUID

abstract class Identifier(open val id: UUID)

class DocumentId(override val id: UUID) : Identifier(id)

class ContractId(override val id: UUID) : Identifier(id)

class CompanyId(override val id: UUID) : Identifier(id)