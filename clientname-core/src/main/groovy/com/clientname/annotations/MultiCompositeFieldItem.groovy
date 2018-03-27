package com.clientname.annotations

import groovy.transform.AnnotationCollector
import org.apache.sling.api.SlingHttpServletRequest
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model

@AnnotationCollector
@Model(adaptables = [Resource, SlingHttpServletRequest], defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@interface MultiCompositeFieldItem {

}