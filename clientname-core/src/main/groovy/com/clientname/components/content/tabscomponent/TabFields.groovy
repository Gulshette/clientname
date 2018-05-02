package com.clientname.components.content.tabscomponent

import com.clientname.annotations.DialogLinkTarget
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.Model
import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Option
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.Selection
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.icfolson.aem.library.core.components.AbstractComponent
import org.apache.sling.models.annotations.Default
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import com.icfolson.aem.library.api.link.Link

import javax.inject.Inject

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

    @DialogLinkTarget
    @DialogField(fieldLabel = "Link Target")
    @Inject
    String tabTargetValue

    @DialogField(fieldLabel = "Active/Inactive", ranking = 4D)
    @Selection(options = [
            @Option(text = "Active", value = "active", selected = true),
            @Option(text = "Inactive", value = "inactive")
    ], type="select")
    @Inject
    @Default(values = "")
    String activeState
    String getActiveState(){
        return  activeState
    }
}
