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
import java.util.ArrayList

open class TitleInfo {
    var genres = ArrayList<String>()
        protected set
        get() = field

    //  TODO http://www.fictionbook.org/index.php/Жанры_FictionBook_2.1
    var keywords = ArrayList<String>()
        protected set
    var bookTitle: String? = null
        protected set
    var date: String? = null
        protected set
    var lang: String? = null
    var srcLang: String? = null
        protected set
    var authors = ArrayList<Person>()
        protected set
    var translators = ArrayList<Person>()
        protected set
    var annotation: Annotation? = null
        protected set
    var coverPage = ArrayList<Image>()
        protected set
    var sequence: Sequence? = null
        protected set

    constructor() {}
    internal constructor(document: Document) {
        val description = document.getElementsByTagName("title-info")
        for (item in 0 until description.length) {
            val map = description.item(item).childNodes
            for (index in 0 until map.length) {
                val node = map.item(index)
                when (node.nodeName) {
                    "sequence" -> sequence = Sequence(node)
                    "coverpage" -> {
                        val images = node.childNodes
                        var image = 0
                        while (image < images.length) {
                            if (images.item(image).nodeName == "image") {
                                coverPage.add(Image(images.item(image)))
                            }
                            image++
                        }
                    }
                    "elements" -> annotation = Annotation(node)
                    "date" -> date = node.textContent
                    "author" -> authors.add(Person(node))
                    "translator" -> translators.add(Person(node))
                    "keywords" -> keywords.add(node.textContent)
                    "genre" -> genres.add(node.textContent)
                    "book-title" -> bookTitle = node.textContent
                    "lang" -> lang = node.textContent
                    "src-lang" -> srcLang = node.textContent
                }
            }
        }
    }
}