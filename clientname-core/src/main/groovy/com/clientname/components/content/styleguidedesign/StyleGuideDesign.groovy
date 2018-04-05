package com.clientname.components.content.styleguidedesign

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.DialogLinkTarget
import com.clientname.annotations.NilayaComponent
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField

import javax.inject.Inject
/**
 * Created by AshwiniPawar on 26/03/18.
 */
@NilayaComponent(value = "Style Guide Design",
        name="styleguidedesign",
        group = "ap-nilaya",
        listeners = [
                @Listener(name = "afteredit", value = "REFRESH_PAGE"),
                @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
                @Listener(name = "afterdelete", value = "REFRESH_PAGE")
        ])
@AutoInstantiate
class StyleGuideDesign extends AbstractComponent {

    @DialogField(fieldLabel = "Title",ranking = 1D)
    @TextField
    @Inject
    String title

    @DialogField(fieldLabel = "Sub title",ranking = 2D)
    @TextField
    @Inject
    String subTitle

    @DialogField(fieldLabel = "Image path",ranking = 3D)
    @PathField(rootPath = "/content/dam")
    @Inject
    String imgPath

    @DialogField(fieldLabel = "Redirection path",ranking = 4D)
    @PathField
    @Inject
    String getImgLink() {
        getAsHrefInherited("imgLink").or("")
    }

    @DialogLinkTarget(ranking = 5D)
    @Inject
    String newWindow

    @DialogField(fieldLabel = "Button text",ranking = 6D)
    @PathField
    @Inject
    String buttonText

    @DialogField(fieldLabel = "Button link",ranking = 7D)
    @PathField
    @Inject
    String getButtonLink() {
        getAsHrefInherited("buttonLink").or("")
    }

    @DialogLinkTarget(ranking = 8D)
    @Inject
    String newTab

    @DialogField(fieldLabel = "Configure color shades",ranking = 9D)
    @MultiCompositeField
    List<StyleGuideShadePojo> getStyleGuideShadePojo() {
        getNodesInherited("styleGuideShadePojo").collect { child ->
            child.resource.adaptTo(StyleGuideShadePojo)
        }
    }
}