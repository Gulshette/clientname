package com.clientname.components.content.footer

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.icfolson.aem.library.api.link.Link
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.library.models.annotations.LinkInject
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model

import javax.inject.Inject

/**
 * Created by icf2025840 on 21/03/18.
 */
@Model(adaptables = Resource,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
class TextLinkData extends AbstractComponent{
    @DialogField(fieldLabel = "Link Text",ranking = 1D)
    @TextField
    @Inject
    String linkText

    @DialogField(fieldLabel = "Path Link",ranking = 2D)
    @PathField(rootPath = "/content/")
    @Inject
    String pathLink

    @DialogField(fieldLabel = "Image", ranking = 3D)
    @PathField(rootPath = "/content/dam")
    @Inject
    String imgPath

}
