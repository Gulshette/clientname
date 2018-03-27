package com.clientname.annotations

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage
import com.icfolson.aem.library.models.annotations.ImageInject
import groovy.transform.AnnotationCollector

@DialogField(fieldLabel = "Image")
@Html5SmartImage(tab = false, isSelf = true, allowUpload = false)
@ImageInject(isSelf = true)
@AnnotationCollector
@interface DialogSelfImageField {

}