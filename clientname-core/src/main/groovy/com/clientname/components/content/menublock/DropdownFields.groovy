package com.clientname.components.content.menublock

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.DialogLinkTarget
import com.icfolson.aem.library.api.link.Link
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model

import javax.inject.Inject

@Model(adaptables = Resource,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
class DropdownFields {
    @DialogField(fieldLabel = "Dropdown URL",ranking = 1D)
    @PathField(rootPath = "/content/clientname")
    @Inject
    Link dropdownUrl;

    @DialogField(fieldLabel = "Dropdown Link Text",ranking = 2D)
    @TextField
    @Inject
    String dropdownLinkText;

    @DialogLinkTarget
    @DialogField(fieldLabel = "Link Target")
    @Inject
    String dropdownTargetValue
}
