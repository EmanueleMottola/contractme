package com.basic.contractme.infrastructure.editor

import com.basic.contractme.domain.Document
import com.basic.contractme.domain.DocumentEditor
import com.lowagie.text.Element
import com.lowagie.text.Font
import com.lowagie.text.Paragraph
import com.lowagie.text.Phrase
import com.lowagie.text.pdf.*
import com.lowagie.text.Document as DocumentPDF
import java.io.ByteArrayOutputStream

class DocumentEditorImpl : DocumentEditor {

    override fun generate(text: String): ByteArray? {
        try {
            val document = DocumentPDF()
            val byteArrayOutputStream = ByteArrayOutputStream()
            PdfWriter.getInstance(document, byteArrayOutputStream)

            document.open()
            document.add(Paragraph(text))
            document.close()

            return byteArrayOutputStream.toByteArray()
        } catch (ex: Throwable) {
            println(ex)
            return null
        }
    }

    override fun addHeader(document: Document, header: String): ByteArray {
        val reader = PdfReader(document.payload)
        val outputStream = ByteArrayOutputStream()
        val stamper = PdfStamper(reader, outputStream)

        val totalPages = reader.numberOfPages
        val font = Font(Font.HELVETICA, 8f)

        for (i in 1..totalPages) {
            val canvas: PdfContentByte = stamper.getOverContent(i)
            val pageSize = canvas.pdfDocument.pageSize

            ColumnText.showTextAligned(
                canvas,
                Element.ALIGN_CENTER,
                Phrase(header, font),
                (pageSize.left + pageSize.right) / 2,
                pageSize.top - 20,
                0f
            )
        }

        stamper.close()
        reader.close()

        return outputStream.toByteArray()
    }

    override fun addFooter(document: Document, footer: String): ByteArray {
        val reader = PdfReader(document.payload)
        val outputStream = ByteArrayOutputStream()
        val stamper = PdfStamper(reader, outputStream)

        val totalPages = reader.numberOfPages
        val font = Font(Font.HELVETICA, 8f)

        for (i in 1..totalPages) {
            val canvas: PdfContentByte = stamper.getOverContent(i)
            val phrase = Phrase(footer, font)

            ColumnText.showTextAligned(
                canvas,
                Element.ALIGN_CENTER,
                phrase,
                (canvas.pdfDocument.pageSize.left + canvas.pdfDocument.pageSize.right) / 2,
                canvas.pdfDocument.pageSize.bottom + 20,
                0f
            )
        }

        stamper.close()
        reader.close()

        return outputStream.toByteArray()
    }
}