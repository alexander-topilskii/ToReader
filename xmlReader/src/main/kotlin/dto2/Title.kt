package dto2

import org.w3c.dom.Node
import java.util.ArrayList

class Title {

    var paragraphs = ArrayList<P>()
        protected set

    constructor() {}
    internal constructor(root: Node) {
        val body = root.childNodes
        for (item in 0 until body.length) {
            val node = body.item(item)
            when (node.nodeName) {
                "p" -> paragraphs.add(P(node))
            }
        }
    }
}