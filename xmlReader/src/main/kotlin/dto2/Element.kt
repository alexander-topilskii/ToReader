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

open class Element {
    open var text: String?
        protected set

    constructor() {
        text = null
    }

    constructor(p: Node) {
        text = p.textContent
    }

    constructor(p: String?) {
        text = p
    }

    companion object {
        fun getText(list: ArrayList<Element?>, divider: String): String {
            val text = StringBuilder()
            for (p in list) {
                text.append(p!!.text).append(divider)
            }
            return if (text.length <= divider.length) "" else text.substring(0, text.length - divider.length)
                .trim { it <= ' ' }
        }
    }
}