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

class Stanza internal constructor(node: Node) {
    private var title: ArrayList<Title>? = null
    private var stanza: ArrayList<Element>? = null

    init {
        val nodeList = node.childNodes
        for (i in 0 until nodeList.length) {
            val paragraph = nodeList.item(i)
            when (paragraph.nodeName) {
                "title" -> {
                    if (title == null) title = ArrayList()
                    title!!.add(Title(paragraph))
                }
                "subtitle" -> {
                    if (stanza == null) stanza = ArrayList()
                    stanza!!.add(Subtitle(paragraph))
                }
                "v" -> {
                    if (stanza == null) stanza = ArrayList()
                    stanza!!.add(V(paragraph))
                }
            }
        }
    }

    fun getTitle(): ArrayList<Title>? {
        return if (title == null) ArrayList() else title
    }

    fun setTitle(title: ArrayList<Title>?) {
        this.title = title
    }

    fun getStanza(): ArrayList<Element> {
        return if (stanza == null) ArrayList() else stanza!!
    }

    fun setStanza(stanza: ArrayList<Element>?) {
        this.stanza = stanza
    }
}