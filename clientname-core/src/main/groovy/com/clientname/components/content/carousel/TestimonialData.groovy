package com.clientname.components.content.carousel

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.TextArea
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.icfolson.aem.library.core.components.AbstractComponent
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model

import javax.inject.Inject


@Model(adaptables = Resource,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
class TestimonialData extends AbstractComponent{

    @DialogField(fieldLabel = "Testimonial Description",ranking = 1D)
    @TextArea
    @Inject
    String description

    @DialogField(fieldLabel = "Testimonial Text",ranking = 2D)
    @TextField
    @Inject
    String text


}