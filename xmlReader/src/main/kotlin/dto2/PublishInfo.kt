package dto2

import dto2.fonts.Emphasis
import dto2.fonts.StrikeThrough
import dto2.Epigraph
import dto2.TextAuthor
import dto2.Poem
import dto2.Subtitle
import dto2.P
import dto2.EmptyLine
import dto2.Stanza
import dto2.IdElement
import dto2.V
import dto2.Cite
import dto2.TitleInfo
import dto2.SrcTitleInfo
import dto2.DocumentInfo
import dto2.PublishInfo
import dto2.CustomInfo
import dto2.Xmlns
import dto2.Body
import org.w3c.dom.Document

class PublishInfo {
    var bookName: String? = null
        protected set
    var city: String? = null
        protected set
    var year: String? = null
        protected set
    var publisher: String? = null
        protected set
    var isbn: String? = null
        protected set
    var sequence: Sequence? = null
        protected set

    constructor() {}
    internal constructor(document: Document) {
        val description = document.getElementsByTagName("publish-info")
        for (item in 0 until description.length) {
            val map = description.item(item).childNodes
            for (index in 0 until map.length) {
                val node = map.item(index)
                when (node.nodeName) {
                    "book-name" -> bookName = node.textContent
                    "city" -> city = node.textContent
                    "year" -> year = node.textContent
                    "isbn" -> isbn = node.textContent
                    "publisher" -> publisher = node.textContent
                    "sequence" -> sequence = Sequence(node)
                }
            }
        }
    }
}