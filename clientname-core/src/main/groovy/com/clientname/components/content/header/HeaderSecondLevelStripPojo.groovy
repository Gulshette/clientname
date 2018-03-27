package com.clientname.components.content.header

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextArea
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.MultiCompositeFieldItem
import com.icfolson.aem.library.api.link.Link

import javax.inject.Inject

@MultiCompositeFieldItem
class HeaderSecondLevelStripPojo {

    @DialogField(fieldLabel = "Enter the  small icon")
    @PathField
    @Inject
    String smallIcon

    @DialogField(fieldLabel = "enter the second level page title")
    @TextField
    @Inject
    String title

    @DialogField(fieldLabel = "Enter the description")
    @TextArea
    @Inject
    String description

    @DialogField(fieldLabel = "Enter the second level page path")
    @PathField
    @Inject
    Link path

}
