package com.clientname.components.content.subheader

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.DialogLinkTarget
import com.clientname.annotations.MultiCompositeFieldItem
import com.icfolson.aem.library.api.link.Link
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model

import javax.inject.Inject

@MultiCompositeFieldItem
class LinkItem {

    @DialogField(fieldLabel = "Enter the sub header title",fieldDescription = "Enter the sub header title")
    @TextField
    @Inject
    String titleText

    @DialogField(fieldLabel = "Enter redirection path for sub title",fieldDescription = "Enter redirection path for sub title")
    @PathField(rootPath = "/content/")
    @Inject
    Link reDirectPath

    @DialogLinkTarget
    @DialogField(fieldLabel = "Link Target")
    @Inject
    String tabsVal

}
