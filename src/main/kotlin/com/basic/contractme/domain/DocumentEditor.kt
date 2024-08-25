package com.basic.contractme.domain

interface DocumentEditor {
    fun generate(text: String): ByteArray?

    fun addHeader(document: Document, header: String) : ByteArray

    fun addFooter(document: Document, footer: String) : ByteArray
}