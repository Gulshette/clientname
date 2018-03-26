package com.clientname.components.content.styleguide

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.Tab
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.AEMComponent
import com.clientname.components.content.footer.TextLinkData
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField

import javax.inject.Inject

/**
 * Created by icf2025840 on 22/03/18.
 */
@AEMComponent(value = "StyleGuide",
        name="styleguide",
        group = "ap-nilaya",
        listeners = [
                @Listener(name = "afteredit", value = "REFRESH_PAGE"),
                @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
                @Listener(name = "afterdelete", value = "REFRESH_PAGE")
        ])
@AutoInstantiate
class StyleGuide extends AbstractComponent {

    @DialogField(fieldLabel = "Title",ranking = 1D)
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
