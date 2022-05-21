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
import org.w3c.dom.Node

//http://www.fictionbook.org/index.php/Элемент_binary
class Binary : IdElement {
    var contentType: String? = null
    protected var binary: String? = null

    constructor() {}
    internal constructor(node: Node) : super(node) {
        binary = node.textContent
        val map = node.attributes
        for (index in 0 until map.length) {
            val attr = map.item(index)
            when (attr.nodeName) {
                "content-type" -> contentType = attr.nodeValue
            }
        }
    }


    override var id: String?
        get() = super.id
        set(id) {
            super.id = id
        }

}