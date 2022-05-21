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
import java.util.ArrayList

//http://www.fictionbook.org/index.php/Элемент_body
class Body {
    var lang: String? = null
    var name: String? = null
    var title: Title? = null
    var image: Image? = null
    var sections = ArrayList<Section>()
    var epigraphs: ArrayList<Epigraph>? = null

    constructor() {}
    internal constructor(body: Node) {
        val attrs = body.attributes
        for (index in 0 until attrs.length) {
            val attr = attrs.item(index)
            if (attr.nodeName == "name") {
                name = attr.nodeValue
            }
            if (attr.nodeName == "xml:lang") {
                lang = attr.nodeValue
            }
        }
        val map = body.childNodes
        for (index in 0 until map.length) {
            val node = map.item(index)
            when (node.nodeName) {
                "section" -> sections.add(Section(node))
                "title" -> title = Title(node)
                "name" -> name = node.textContent
                "image" -> image = Image(node)
                "epigraph" -> {
                    if (epigraphs == null) epigraphs = ArrayList()
                    epigraphs!!.add(Epigraph(node))
                }
            }
        }
    }
}