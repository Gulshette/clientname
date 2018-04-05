package com.clientname.components.content.carousel

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.NilayaComponent
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField

import javax.inject.Inject

@NilayaComponent(value = "carousel",
        name="carousel",
        group = "ap-nilaya")
@AutoInstantiate
class Carousel extends AbstractComponent {
    @DialogField(fieldLabel = "Carousel Title",ranking = 1D)
    @TextField
    @Inject
    String carouselTitle

    @DialogField(fieldLabel = "Quote Open Icon Link",ranking = 1D)
    @PathField(rootPath = "/content/dam")
    @Inject
    String quoteOpenIcon

    @DialogField(fieldLabel = "Quote Close Icon Link",ranking = 1D)
    @PathField(rootPath = "/content/dam")
    @Inject
    String quoteCloseIcon

    @DialogField(fieldLabel = "Testimonial data",ranking = 2D)
    @MultiCompositeField
    List<TestimonialData> getTestimonialData() {
        getNodesInherited("testimonialData").collect { child ->
            child.resource.adaptTo(TestimonialData)
        }
    }
}