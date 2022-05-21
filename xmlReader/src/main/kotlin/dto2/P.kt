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
import dto2.fonts.Strong
import org.w3c.dom.Node
import java.util.ArrayList

open class P : Element {
    var images: ArrayList<Image>? = null
        protected set
    protected var emphasis: ArrayList<Emphasis>? = null
    protected var strong: ArrayList<Strong>? = null
    protected var strikeThrough: ArrayList<StrikeThrough>? = null

    //    TODO
    //    Для нижних индексов <sub>, а для верхних индексов <sup>
    //    Программный код - <code>
    //    <subtitle>* * *</subtitle>
    //  <cite>
    //  <p>Время - деньги.<p>
    //  <text-author>Бенджамин Франклин</text-author>
    //  </cite>
    //  <p>Об этом вы можете прочитать <a l:href="#n1">здесь</a>.</p>
    //  <p>text<a l:href="#n_2" type="note">[2]</a>
    constructor() : super() {}
    constructor(image: Image) : super() {
        if (images == null) images = ArrayList()
        images!!.add(image)
    }

    constructor(p: Node) : super(p) {
        val nodeList = p.childNodes
        for (index in 0 until nodeList.length) {
            val node = nodeList.item(index)
            when (nodeList.item(index).nodeName) {
                "image" -> {
                    if (images == null) images = ArrayList()
                    images!!.add(Image(node))
                }
                "strikethrough" -> {
                    if (strikeThrough == null) strikeThrough = ArrayList()
                    strikeThrough!!.add(StrikeThrough(node.textContent, p.textContent))
                }
                "strong" -> {
                    if (strong == null) strong = ArrayList()
                    strong!!.add(Strong(node.textContent, p.textContent))
                }
                "emphasis" -> {
                    if (emphasis == null) emphasis = ArrayList()
                    emphasis!!.add(Emphasis(node.textContent, p.textContent))
                }
                "subtitle" -> {
                    if (emphasis == null) emphasis = ArrayList()
                    emphasis!!.add(Emphasis(node.textContent, p.textContent))
                }
            }
        }
    }

    constructor(p: String?) : super(p) {}
}