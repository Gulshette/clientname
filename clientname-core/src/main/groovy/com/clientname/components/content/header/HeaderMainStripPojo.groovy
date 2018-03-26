package com.clientname.components.content.header

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.MultiCompositeFieldItem
import com.icfolson.aem.library.api.link.Link
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField

import javax.inject.Inject

@MultiCompositeFieldItem
class HeaderMainStripPojo extends AbstractComponent {

    @DialogField(fieldLabel = "Header Title",fieldDescription = "enter the header title")
    @TextField
    @Inject
    String headerTitle

    @DialogField(fieldLabel = "Header Icon",fieldDescription = "Enter the header icon")
    @PathField
    @Inject
    String headerIcon

    @DialogField(fieldLabel = "Enter the redirection path",fieldDescription = "Enter the header title redirection path")
    @PathField
    @Inject
    Link redirectionPath


    @DialogField(fieldLabel = "Sub Titles",fieldDescription = "Enter the subTitles")
    @MultiCompositeField
    @Inject
    List<HeaderSecondLevelStripPojo> headerSecondLevelStripPojo(){

        getNodesInherited("headerSecondLevelStripPojo").collect{child ->
            child.resource.adaptTo(HeaderSecondLevelStripPojo)
        }
    }
}
