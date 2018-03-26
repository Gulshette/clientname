package com.clientname.components.content.watchseason

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextArea
import com.icfolson.aem.library.core.components.AbstractComponent
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model

import javax.inject.Inject

/**
 * Created by AshwiniPawar on 20/03/18.
 */
@Model(adaptables = Resource,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
class GalleryData extends AbstractComponent{

    @DialogField(fieldLabel = "Episode Image")
    @PathField(rootPath = "/content/dam")
    @Inject
    String imgPath

    @DialogField(fieldLabel = "Episode link")
    @PathField(rootPath = "/content/")
    @Inject
    String episodeLink

    @DialogField(fieldLabel = "Episode description")
    @TextArea
    @Inject
    String episodeDescription

}
