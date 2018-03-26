package com.clientname.annotations

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.clientname.constants.NilayaConstant
import groovy.transform.AnnotationCollector

@DialogField(fieldLabel = "Link")
@PathField(rootPath = NilayaConstant.ROOT_PATH)
@AnnotationCollector
@interface DialogPathField {

}