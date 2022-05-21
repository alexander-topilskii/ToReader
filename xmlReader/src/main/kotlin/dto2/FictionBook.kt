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
import org.w3c.dom.Node
import org.xml.sax.InputSource
import java.io.*
import java.lang.Exception
import java.lang.StringBuilder
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory

class FictionBook {
    private var xmlns: Array<Xmlns?> = arrayOf()
    var description: Description? = null
        protected set
    protected var bodies: MutableList<Body> = ArrayList()
    private var binaries: MutableMap<String, Binary>? = null
    var encoding = "utf-8"

    constructor(file: File?) {
        val dbf = DocumentBuilderFactory.newInstance()
        val db = dbf.newDocumentBuilder()
        val inputStream: InputStream = FileInputStream(file)
        var br = BufferedReader(FileReader(file))
        var foundIllegalCharacters = false
        try {
            var line = br.readLine().trim { it <= ' ' }
            if (!line.startsWith("<")) {
                foundIllegalCharacters = true
            }
            while (!line.endsWith("?>")) {
                line += """
                    
                    ${br.readLine().trim { it <= ' ' }}
                    """.trimIndent()
            }
            val start = line.indexOf("encoding") + 8
            var substring = line.substring(start)
            substring = substring.substring(substring.indexOf("\"") + 1)
            encoding = substring.substring(0, substring.indexOf("\"")).lowercase(Locale.getDefault())
            br.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val doc: Document
        if (foundIllegalCharacters) {
            val text = StringBuilder()
            br = BufferedReader(FileReader(file))
            var line = br.readLine()
            if (line != null && line.contains("<")) {
                line = line.substring(line.indexOf("<"))
            }
            while (line != null) {
                text.append(line)
                line = br.readLine()
            }
            br.close()
            doc = db.parse(InputSource(StringReader(text.toString())))
        } else {
            doc = db.parse(InputSource(InputStreamReader(inputStream, encoding)))
        }
        initXmlns(doc)
        description = Description(doc)
        val bodyNodes = doc.getElementsByTagName("body")
        for (item in 0 until bodyNodes.length) {
            bodies.add(Body(bodyNodes.item(item)))
        }
        val binary = doc.getElementsByTagName("binary")
        for (item in 0 until binary.length) {
            if (binaries == null) binaries = HashMap()
            val binary1 = Binary(binary.item(item))
            binaries!![binary1.id!!.replace("#", "")] = binary1
        }
    }

    protected fun setXmlns(nodeList: ArrayList<Node>) {
        xmlns = arrayOfNulls(nodeList.size)
        for (index in nodeList.indices) {
            val node = nodeList[index]
            xmlns[index] = Xmlns(node)
        }
    }

    protected fun initXmlns(doc: Document) {
        val fictionBook = doc.getElementsByTagName("FictionBook")
        val xmlns = ArrayList<Node>()
        for (item in 0 until fictionBook.length) {
            val map = fictionBook.item(item).attributes
            for (index in 0 until map.length) {
                val node = map.item(index)
                xmlns.add(node)
            }
        }
        setXmlns(xmlns)
    }

    val authors: ArrayList<Person>
        get() = description!!.documentInfo!!.authors
    val body: Body?
        get() = getBody(null)
    val notes: Body?
        get() = getBody("notes")
    val comments: Body?
        get() = getBody("comments")

    private fun getBody(name: String?): Body {
        for (body in bodies) {
            if (name + "" == body.name + "") {
                return body
            }
        }
        return bodies[0]
    }

    fun getBinaries(): Map<String, Binary> {
        return if (binaries == null) HashMap() else binaries!!
    }

    val title: String?
        get() = description?.titleInfo?.bookTitle
    val lang: String?
        get() = description?.titleInfo?.lang
    val annotation: Annotation?
        get() = description?.titleInfo?.annotation
}