package com.clientname.components.content.navigationbar

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.icfolson.aem.library.api.page.PageDecorator
import com.icfolson.aem.library.core.components.AbstractComponent
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model

import javax.inject.Inject

/**
 * Created by icf2025840 on 28/03/18.
 */
@Model(adaptables = Resource,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
class NavigationBar  extends AbstractComponent{
    
    @Inject
    String linkText

    @Inject
    String pathLink

    String getPathLink() {
        getAsHrefInherited("pathLink").or("")
    }

    String getLinkText() {
        return linkText
    }
}
