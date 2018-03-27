package com.clientname.components.content.carousel

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.NilayaComponent
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField

import javax.inject.Inject

@NilayaComponent(value = "carousel",
        name="carousel",
        group = "ap-nilaya",
        listeners = [
                @Listener(name = "afteredit", value = "REFRESH_PAGE"),
                @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
                @Listener(name = "afterdelete", value = "REFRESH_PAGE")
        ])
@AutoInstantiate
class Carousel extends AbstractComponent {
    @DialogField(fieldLabel = "Title",ranking = 1D)
    @TextField
    @Inject
    String title

    @DialogField(fieldLabel = "Testimonial data",ranking = 2D)
    @MultiCompositeField
    List<TestimonialData> getTestimonialData() {
        getNodesInherited("testimonialData").collect { child ->
            child.resource.adaptTo(TestimonialData)
        }
    }
}
