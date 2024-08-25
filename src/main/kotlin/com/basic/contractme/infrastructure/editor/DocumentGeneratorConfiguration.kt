package com.basic.contractme.infrastructure.editor

import com.basic.contractme.domain.DocumentEditor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DocumentGeneratorConfiguration {

    @Bean
    fun documentGenerator() : DocumentEditor {
        return DocumentEditorImpl()
    }
}