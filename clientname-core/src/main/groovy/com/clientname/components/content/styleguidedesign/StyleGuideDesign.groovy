package com.clientname.components.content.styleguidedesign

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
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
        group = "ap-nilaya")
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
    String imgLink

    @DialogField(fieldLabel = "Button text",ranking = 5D)
    @PathField
    @Inject
    String buttonText

    @DialogField(fieldLabel = "Button link",ranking = 6D)
    @PathField
    @Inject
    String buttonLink


    @DialogField(fieldLabel = "Configure color shades",ranking = 7D)
    @MultiCompositeField
    List<StyleGuideShadePojo> getStyleGuideShadePojo() {
        getNodesInherited("styleGuideShadePojo").collect { child ->
            child.resource.adaptTo(StyleGuideShadePojo)
        }
    }
}