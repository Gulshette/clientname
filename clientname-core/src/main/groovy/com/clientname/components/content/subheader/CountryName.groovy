package com.clientname.components.content.subheader

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.DialogLinkTarget
import com.clientname.annotations.MultiCompositeFieldItem
import com.icfolson.aem.library.api.link.Link

import javax.inject.Inject
@MultiCompositeFieldItem
class CountryName {

    @DialogField(fieldLabel = "Enter the  country image")
    @PathField
    @Inject
    String countryImage

    @DialogField(fieldLabel = "Enter the country name")
    @TextField
    @Inject
    String countryName

    @DialogField(fieldLabel = "Enter the country redirection path")
    @PathField
    @Inject
    Link countryRedirectPath

    @DialogLinkTarget
    @DialogField(fieldLabel = "Link Target")
    @Inject
    String targetVal


}
