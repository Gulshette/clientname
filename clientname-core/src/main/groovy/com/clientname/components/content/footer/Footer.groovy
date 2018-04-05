package com.clientname.components.content.footer

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaConstant
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField
import org.apache.sling.models.annotations.injectorspecific.Self

import javax.inject.Inject


@NilayaComponent(value = "footer",
        name="footer",
        group = NilayaConstant.GROUP_NAME)
@AutoInstantiate
class Footer extends AbstractComponent{


    @DialogField(fieldLabel = "News letter text",ranking = 1D)
    @TextField
    @Inject
    String newsLetter

    @DialogField(fieldLabel = "Colour Quotient text",ranking = 2D)
    @TextField
    @Inject
    String colourQuotient


    @DialogField(fieldLabel = "Social Links",ranking = 3D)
    @DialogFieldSet
    @Self
    @MultiCompositeField
    List<TextLinkData> getSocialLinkData() {
        getNodesInherited("socialLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }

    @DialogField(fieldLabel = "Footer Links For Coloumn 1",ranking = 4D)
    @DialogFieldSet
    @Self
    @MultiCompositeField
    List<TextLinkData> getTextLinkData() {
        getNodesInherited("textLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }

    @DialogField(fieldLabel = "Footer Links For Coloumn 2",ranking = 5D)
    @DialogFieldSet
    @Self
    @MultiCompositeField
    List<TextLinkData> getFaqTextLinkData() {
        getNodesInherited("faqTextLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }

    @DialogField(fieldLabel = "Footer Links For Coloumn 3",ranking = 6D)
    @DialogFieldSet
    @Self
    @MultiCompositeField
    List<TextLinkData> getDownloadTextLinkData() {
        getNodesInherited("downloadTextLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }

    @DialogField(fieldLabel = " Footer Links For Coloumn 4",ranking = 7D)
    @DialogFieldSet
    @Self
    @MultiCompositeField
    List<TextLinkData> getRequestTextLinkData() {
        getNodesInherited("requestTextLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }

    @DialogField(fieldLabel = "Copy Right Text",ranking = 8D)
    @TextField
    @Inject
    String title

    @DialogField(fieldLabel = "Copy Right Links",ranking = 9D)
    @DialogFieldSet
    @Self
    @MultiCompositeField
    List<TextLinkData> getColumnTextLinkData() {
        getNodesInherited("columnTextLinkData").collect { child ->
            child.resource.adaptTo(TextLinkData)
        }
    }

}
