package com.clientname.annotations

import com.citytechinc.cq.component.annotations.Component
import com.citytechinc.cq.component.annotations.Listener
import com.clientname.constants.NilayaComponentGroup
import groovy.transform.AnnotationCollector
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model

import static com.icfolson.aem.library.core.constants.ComponentConstants.*

@AnnotationCollector
@Component(value = "Nilaya Component", group = NilayaComponentGroup.AP_NILAYA, disableTargeting = true,listeners = [
        @Listener(name = EVENT_AFTER_INSERT, value = REFRESH_PAGE),
        @Listener(name = EVENT_AFTER_EDIT, value = REFRESH_PAGE),
        @Listener(name = EVENT_AFTER_DELETE, value = REFRESH_PAGE)
])
@Model(adaptables = Resource, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@interface NilayaComponent {

}