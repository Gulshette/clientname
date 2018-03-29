package com.clientname.components.content.menublock

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Option
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.Selection
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.icfolson.aem.library.api.link.Link
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.Default
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model

import javax.inject.Inject

/**
 * Created by icf2025295 on 21/03/18.
 */
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

    @DialogField(fieldLabel = "Open Link In", ranking = 4D)
    @Selection(options = [
            @Option(text = "Same Window", value = "samewindow", selected = true),
            @Option(text = "New Window", value = "newwindow")
    ], type="select")
    @Inject
    @Default(values = "")
    String openLinkIn
    String getOpenLink(){
        return  openLinkIn
    }

}
