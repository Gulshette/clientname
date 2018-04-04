package com.clientname.components.content.styleguide

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.NilayaComponent
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField

import javax.inject.Inject

@NilayaComponent(value = "StyleGuide",
        name="styleguide")
@AutoInstantiate
class StyleGuide extends AbstractComponent {

    @DialogField(fieldLabel = " Style Guide Title",ranking = 1D)
    @TextField
    @Inject
    String title

    @DialogField(fieldLabel = "Style Guide details",ranking = 2D)
    @MultiCompositeField
    List<StyleGuideData> getStyleGuideData() {
        getNodesInherited("styleGuideData").collect { child ->
            child.resource.adaptTo(StyleGuideData)
        }
    }
}
