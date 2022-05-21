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

class Description {
    var titleInfo: TitleInfo? = null
        protected set
    var srcTitleInfo: SrcTitleInfo? = null
        protected set
    var documentInfo: DocumentInfo? = null
        protected set
    var publishInfo: PublishInfo? = null
        protected set
    var customInfo = ArrayList<CustomInfo>()
        protected set

    constructor() {}
    internal constructor(doc: Document) {
        titleInfo = TitleInfo(doc)
        srcTitleInfo = SrcTitleInfo(doc)
        documentInfo = DocumentInfo(doc)
        publishInfo = PublishInfo(doc)
    }
}