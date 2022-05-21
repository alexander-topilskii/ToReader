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

//http://www.fictionbook.org/index.php/Элемент_cite
class Cite : Element {
    var id: String? = null
    var lang: String? = null
    private var elements: ArrayList<Element>? = null
    private var textAuthor: ArrayList<TextAuthor?>? = null

    constructor() {}
    internal constructor(node: Node) {
        val attrs = node.attributes
        for (index in 0 until attrs.length) {
            val attr = attrs.item(index)
            if (attr.nodeName == "id") {
                id = attr.nodeValue
            }
            if (attr.nodeName == "xml:lang") {
                lang = attr.nodeValue
            }
        }
        val nodeList = node.childNodes
        for (i in 0 until nodeList.length) {
            val paragraph = nodeList.item(i)
            when (paragraph.nodeName) {
                "text-author" -> {
                    if (textAuthor == null) textAuthor = ArrayList()
                    textAuthor!!.add(TextAuthor(paragraph))
                }
                "poem" -> {
                    if (elements == null) elements = ArrayList()
                    elements!!.add(Poem(paragraph))
                }
                "subtitle" -> {
                    if (elements == null) elements = ArrayList()
                    elements!!.add(Subtitle(paragraph))
                }
                "p" -> {
                    if (elements == null) elements = ArrayList()
                    elements!!.add(P(paragraph))
                }
                "empty-line" -> {
                    if (elements == null) elements = ArrayList()
                    elements!!.add(EmptyLine())
                }
            }
        }
    }

    fun getTextAuthor(): ArrayList<TextAuthor?>? {
        return if (textAuthor == null) ArrayList() else textAuthor
    }

    fun setTextAuthor(textAuthor: ArrayList<TextAuthor?>?) {
        this.textAuthor = textAuthor
    }

    fun getElements(): ArrayList<Element>? {
        return if (elements == null) ArrayList() else elements
    }

    fun setElements(elements: ArrayList<Element>?) {
        this.elements = elements
    }

    override var text: String?
        get() {
            val list = ArrayList(getElements())
            if (textAuthor != null) list.addAll(textAuthor!!)
            return Element.Companion.getText(list, "\n")
        }
        set(text) {
            super.text = text
        }
}