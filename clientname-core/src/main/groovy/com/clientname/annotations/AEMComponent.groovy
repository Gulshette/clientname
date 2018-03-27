package com.clientname.annotations

import com.citytechinc.cq.component.annotations.Component
import com.citytechinc.cq.component.annotations.Listener
import groovy.transform.AnnotationCollector
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model

@AnnotationCollector
@Component(value = "Nilaya Component", group = "ap-nilaya", listeners = [
        @Listener(name = "afteredit", value = "REFRESH_PAGE"),
        @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
        @Listener(name = "afterdelete", value = "REFRESH_PAGE")
])
@Model(adaptables = Resource, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@interface AEMComponent{

}
