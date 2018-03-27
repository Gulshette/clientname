package com.clientname.components.content.footer

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.Tab
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.AEMComponent
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField

import javax.inject.Inject

/**
 * Created by icf2025840 on 21/03/18.
 */
@AEMComponent(value = "footer",
        name="footer",
        group = "ap-nilaya", tabs = [
                @Tab(title = "Column-1"),
                @Tab(title = "Column-2"),
                @Tab(title = "Column-3")
        ],
        listeners = [
                @Listener(name = "afteredit", value = "REFRESH_PAGE"),
                @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
                @Listener(name = "afterdelete", value = "REFRESH_PAGE")
        ])
@AutoInstantiate
class Footer extends AbstractComponent{

    @DialogField(fieldLabel = "News letter text",ranking = 1D,tab = 1)
    @TextField
    @Inject
    String newsletter

    @DialogField(fieldLabel = "Colour Quotient text",ranking = 2D,tab = 1)
    @TextField
    @Inject
    String colourQuotient

    @DialogField(fieldLabel = "Social Link Data",ranking = 3D,tab = 1)
    @MultiCompositeField
    List<TextLinkData> getSocialLinkData() {
        getNodesInherited("socialLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }

    @DialogField(fieldLabel = "Text and Link Data",ranking = 1D,tab = 2)
    @MultiCompositeField
    List<TextLinkData> getTextLinkData() {
        getNodesInherited("textLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }
    @DialogField(fieldLabel = "Coloumn 2 Text and Link Data",ranking = 2D,tab = 2)
    @MultiCompositeField
    List<TextLinkData> getFaqTextLinkData() {
        getNodesInherited("faqTextLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }
    @DialogField(fieldLabel = "Coloumn 3 Text and Link Data",ranking = 3D,tab = 2)
    @MultiCompositeField
    List<TextLinkData> getDownloadTextLinkData() {
        getNodesInherited("downloadTextLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }
    @DialogField(fieldLabel = "Coloumn 4 Text and Link Data",ranking = 4D,tab = 2)
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

    @DialogField(fieldLabel = "Text and Link Data",ranking = 2D,tab = 3)
    @MultiCompositeField
    List<TextLinkData> getColumnTextLinkData() {
        getNodesInherited("columnTextLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }




}
