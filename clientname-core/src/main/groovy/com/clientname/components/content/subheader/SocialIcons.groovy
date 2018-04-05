package com.clientname.components.content.subheader

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.clientname.annotations.DialogLinkTarget
import com.clientname.annotations.MultiCompositeFieldItem
import com.icfolson.aem.library.api.link.Link
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model

import javax.inject.Inject


@MultiCompositeFieldItem
class SocialIcons {

    @DialogField(fieldLabel = "Enter the image path")
    @PathField
    @Inject
    String imagePath

    @DialogField(fieldLabel = "Enter the image redirection path")
    @PathField
    @Inject
    Link imagePathRedirection

    @DialogLinkTarget
    @DialogField(fieldLabel = "Link Target")
    @Inject
    String sameNewTab

}
