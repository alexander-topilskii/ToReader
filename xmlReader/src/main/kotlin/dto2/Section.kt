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
import java.lang.StringBuilder
import java.util.ArrayList

class Section : IdElement {
    var image: Image? = null
    var annotation: Annotation? = null
    private var epigraphs: ArrayList<Epigraph>? = null
    private var sections: ArrayList<Section>? = null
    private var elements: ArrayList<Element>? = null
    private var title: Title? = null

    constructor() {}
    internal constructor(root: Node) : super(root) {
        val body = root.childNodes
        for (item in 0 until body.length) {
            val node = body.item(item)
            when (node.nodeName) {
                "title" -> title = Title(node)
                "elements" -> annotation = Annotation(node)
                "image" -> {
                    if (elements == null) elements = ArrayList()
                    elements!!.add(P(Image(node)))
                }
                "epigraph" -> {
                    if (epigraphs == null) epigraphs = ArrayList()
                    epigraphs!!.add(Epigraph(node))
                }
                "section" -> {
                    if (sections == null) sections = ArrayList()
                    sections!!.add(Section(node))
                }
                "poem" -> {
                    if (elements == null) elements = ArrayList()
                    elements!!.add(Poem(node))
                }
                "subtitle" -> {
                    if (elements == null) elements = ArrayList()
                    elements!!.add(Subtitle(node))
                }
                "p" -> {
                    if (elements == null) elements = ArrayList()
                    elements!!.add(P(node))
                }
                "empty-line" -> {
                    if (elements == null) elements = ArrayList()
                    elements!!.add(EmptyLine())
                }
                "cite" -> {
                    if (elements == null) elements = ArrayList()
                    elements!!.add(Cite(node))
                }
            }
        }
    }

    fun getTitle(): Title {
        return title!!
    }

    fun getSections(): ArrayList<Section> {
        return if (sections == null) ArrayList() else sections!!
    }

    fun getElements(): ArrayList<Element> {
        return if (elements == null) ArrayList() else elements!!
    }

    fun getEpigraphs(): ArrayList<Epigraph> {
        return if (epigraphs == null) ArrayList() else epigraphs!!
    }

    fun getTitleString(innerDivider: String, outerDivider: String): String {
        if (title == null) return ""
        val builder = StringBuilder()
        val list = ArrayList<Element?>(title!!.paragraphs)
        builder.append(Element.Companion.getText(list, innerDivider)).append(outerDivider)
        return builder.substring(0, builder.length - outerDivider.length)
    }

    fun setElements(elements: ArrayList<Element>?) {
        this.elements = elements
    }

    fun setSections(sections: ArrayList<Section>?) {
        this.sections = sections
    }

    fun setEpigraphs(epigraphs: ArrayList<Epigraph>?) {
        this.epigraphs = epigraphs
    }

    fun setTitle(title: Title?) {
        this.title = title
    }

    override fun toString(): String {
        var data = getTitleString(". ", "\n")
        if (!getElements().isEmpty()) {
            data += " p: " + elements!!.size
        }
        if (!getSections().isEmpty()) {
            data += " section: " + sections!!.size
        }
        return data.trim { it <= ' ' }
    }
}