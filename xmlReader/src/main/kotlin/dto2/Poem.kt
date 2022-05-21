package dto2

import org.w3c.dom.Node

class Poem : Element {
    var title: Title? = null
        protected set
    var epigraphs: ArrayList<Epigraph>? = null
        protected set
    protected var stanza = ArrayList<Stanza>()
    var textAuthor: String? = null
        protected set
    var date: String? = null
        protected set

    constructor() {}
    internal constructor(node: Node) {
        val nodeList = node.childNodes
        for (i in 0 until nodeList.length) {
            val paragraph = nodeList.item(i)
            when (paragraph.nodeName) {
                "text-author" -> textAuthor = paragraph.textContent
                "title" -> title = Title(paragraph)
                "epigraph" -> {
                    if (epigraphs == null) epigraphs = ArrayList()
                    epigraphs!!.add(Epigraph(paragraph))
                }
                "date" -> date = paragraph.textContent
                "stanza" -> stanza.add(Stanza(paragraph))
            }
        }
    }

    override var text: String?
        get() {
            val list = ArrayList<Element?>()
            if (title != null) list.addAll(title!!.paragraphs)
            for (stanza1 in stanza) {
                if (stanza1.getTitle() != null) {
                    for (title1 in stanza1.getTitle()!!) {
                        if (title1 != null) list.addAll(title1.paragraphs)
                    }
                }
                list.addAll(stanza1.getStanza())
            }
            return Element.Companion.getText(list, "\n")
        }
        set(text) {
            super.text = text
        }
}