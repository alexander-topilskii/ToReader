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

//http://www.fictionbook.org/index.php/Элемент_author
open class Person {
    var id: String? = null
    var firstName: String? = null
    var middleName: String? = null
    var lastName: String? = null
    var nickname: String? = null
    private var homePages: ArrayList<String>? = null
    private var emails: ArrayList<String>? = null

    constructor() {}
    internal constructor(node: Node) {
        val nodeList = node.childNodes
        for (i in 0 until nodeList.length) {
            val author = nodeList.item(i)
            when (author.nodeName) {
                "id" -> id = author.textContent
                "home-page" -> {
                    if (homePages == null) homePages = ArrayList()
                    homePages!!.add(author.textContent)
                }
                "email" -> {
                    if (emails == null) emails = ArrayList()
                    emails!!.add(author.textContent)
                }
                "nickname" -> nickname = author.textContent
                "first-name" -> firstName = author.textContent
                "middle-name" -> middleName = author.textContent
                "last-name" -> lastName = author.textContent
            }
        }
    }

    fun setEmails(emails: ArrayList<String>?) {
        this.emails = emails
    }

    fun setHomePages(homePages: ArrayList<String>?) {
        this.homePages = homePages
    }

    val fullName: String
        get() = ((if (firstName == null) "" else "$firstName ")
                + (if (middleName == null) "" else "$middleName ")
                + if (lastName == null) "" else lastName)

    fun getEmails(): ArrayList<String> {
        return if (emails == null) ArrayList() else emails!!
    }

    fun getHomePages(): ArrayList<String> {
        return if (homePages == null) ArrayList() else homePages!!
    }
}