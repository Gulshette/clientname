package com.clientname.components.content.styleguide

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.TextArea
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.icfolson.aem.library.core.components.AbstractComponent
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model

import javax.inject.Inject

/**
 * Created by icf2025840 on 22/03/18.
 */
@Model(adaptables = Resource,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
class StyleGuideData  extends AbstractComponent{

    @DialogField(fieldLabel = "SubTitle text",ranking = 1D)
    @TextField
    @Inject
    String subTitle


    @DialogField(fieldLabel = "Description",ranking = 2D)
    @TextArea
    @Inject
    String description


}
