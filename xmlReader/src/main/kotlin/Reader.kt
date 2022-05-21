import dto2.FictionBook
import java.io.File
import java.io.PrintWriter


class Reader {

    fun parse(result: String?): String {
        main(result.orEmpty())
        return result.orEmpty()
    }
}

fun main(text: String) {
    val fileSchemaName = "book.fb2"
    PrintWriter(fileSchemaName).use { out -> out.println(text) }

    val fb2 = FictionBook(File("book.fb2"))

    println("GGGG: :main ${fb2.description?.titleInfo?.bookTitle}")
}