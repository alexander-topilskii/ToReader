import org.xml.sax.SAXException
import java.io.File
import java.io.PrintWriter
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.SchemaFactory

class Reader {

    fun parse(result: String?): String {
        return text
    }

    val text = "dfsd"
}

class MyClass

fun main(text: String) {
    val factory: SchemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema")

    val fileSchemaName = "schema.xml"
    PrintWriter(fileSchemaName).use { out -> out.println(schema) }
    val schema = factory.newSchema(File(fileSchemaName))
    val validator = schema.newValidator()

    val source = StreamSource(text)

    println("Validation Starts now!")

    val start = System.currentTimeMillis()
    try {
        validator.validate(source)
        println(" XML is valid.")
    } catch (ex: SAXException) {
        println(" XML not valid because " + ex.message)
    }

    println("Validation complete!")

    println("Time (ms): " + (System.currentTimeMillis() - start))
}