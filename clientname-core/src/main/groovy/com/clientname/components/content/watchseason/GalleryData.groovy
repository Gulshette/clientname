package com.clientname.components.content.watchseason

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextArea
import com.clientname.annotations.DialogLinkTarget
import com.icfolson.aem.library.core.components.AbstractComponent
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model

import javax.inject.Inject


@Model(adaptables = Resource,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
class GalleryData extends AbstractComponent{

    @DialogField(fieldLabel = "Episode Image")
    @PathField(rootPath = "/content/dam")
    @Inject
    String imgPath

    @DialogField(fieldLabel = "Episode link")
    @PathField(rootPath = "/content/")
    @Inject
    String getEpisodeLink() {
        getAsHrefInherited("episodeLink").or("")
    }

    @DialogLinkTarget(ranking = 3D)
    @Inject
    String newTab

    @DialogField(fieldLabel = "Episode description")
    @TextArea
    @Inject
    String episodeDescription

}
