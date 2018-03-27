package com.clientname.annotations

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.Switch
import groovy.transform.AnnotationCollector

@DialogField
@Switch(offText = "No", onText = "Yes")
@AnnotationCollector
@interface DialogSwitchField {

}