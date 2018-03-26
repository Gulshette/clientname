package com.clientname.annotations

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage
import groovy.transform.AnnotationCollector

@DialogField(fieldLabel = "Image")
@Html5SmartImage(tab = false, allowUpload = false)
@AnnotationCollector
@interface DialogImageField {

}