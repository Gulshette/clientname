package com.clientname.components.content.tabscomponent

import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.Model
import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Option
import com.citytechinc.cq.component.annotations.widgets.CheckBox
import com.citytechinc.cq.component.annotations.widgets.Hidden
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.Selection
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.icfolson.aem.library.core.components.AbstractComponent
import org.apache.sling.models.annotations.Default
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import com.icfolson.aem.library.api.link.Link

import javax.inject.Inject

/**
 * Created by icf2025295 on 28/03/18.
 */
@Model(adaptables = Resource,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
class TabFields extends AbstractComponent{
    @DialogField(fieldLabel = "Link Text",ranking = 1D)
    @TextField
    @Inject
    String linkText;

    @DialogField(fieldLabel = "URL path",ranking = 2D)
    @PathField(rootPath = "/content/clientname")
    @Inject
    Link urlPath;

    @DialogField(fieldLabel = "Open Link In", ranking = 3D)
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
