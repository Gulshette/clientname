package com.clientname.components.content.footer

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Tab
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaConstant
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField

import javax.inject.Inject

/**
 * Created by icf2025840 on 21/03/18. //Remove this
 */
@NilayaComponent(value = "footer",
        name="footer",
        group = NilayaConstant.GROUP_NAME, tabs = [
                @Tab(title = "Tab-1"),//Change Title
                @Tab(title = "Tab-2"),//Change Title
                @Tab(title = "Tab-3")//Change Title
        ]) //add disable target
@AutoInstantiate
class Footer extends AbstractComponent{
    //Use Dialog field set avoid using tabs for less number of fields.

    @DialogField(fieldLabel = "News letter text",ranking = 1D,tab = 1)
    @TextField
    @Inject
    String newsletter //new3sLetter

    @DialogField(fieldLabel = "Colour Quotient text",ranking = 2D,tab = 1)
    @TextField
    @Inject
    String colourQuotient


    @DialogField(fieldLabel = "Social Link Data",ranking = 3D,tab = 1) // dont return this object Iterate using sly-list or sly-repeat.
    @MultiCompositeField
    List<TextLinkData> getSocialLinkData() {
        getNodesInherited("socialLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }

    @DialogField(fieldLabel = "Text and Link Data",ranking = 1D,tab = 2)// dont return this object Iterate using sly-list or sly-repeat.
    @MultiCompositeField
    List<TextLinkData> getTextLinkData() {
        getNodesInherited("textLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }

    @DialogField(fieldLabel = "Coloumn 2 Text and Link Data",ranking = 2D,tab = 2) //Change field labels
    @MultiCompositeField
    List<TextLinkData> getFaqTextLinkData() {
        getNodesInherited("faqTextLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }

    @DialogField(fieldLabel = "Coloumn 3 Text and Link Data",ranking = 3D,tab = 2) //Change field labels
    @MultiCompositeField
    List<TextLinkData> getDownloadTextLinkData() {
        getNodesInherited("downloadTextLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }

    @DialogField(fieldLabel = "Coloumn 4 Text and Link Data",ranking = 4D,tab = 2) //Change field labels
    @MultiCompositeField
    List<TextLinkData> getRequestTextLinkData() {
        getNodesInherited("requestTextLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }

    @DialogField(fieldLabel = "Title",ranking = 1D,tab = 3)
    @TextField
    @Inject
    String title

    @DialogField(fieldLabel = "Text and Link Data",ranking = 2D,tab = 3) //Change field labels
    @MultiCompositeField
    List<TextLinkData> getColumnTextLinkData() {
        getNodesInherited("columnTextLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }




}
