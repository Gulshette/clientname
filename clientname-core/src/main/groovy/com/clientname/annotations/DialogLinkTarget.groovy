package com.clientname.annotations

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Option
import com.citytechinc.cq.component.annotations.widgets.Selection
import groovy.transform.AnnotationCollector
import org.apache.sling.models.annotations.Default

@DialogField(fieldLabel = "Link Target")
@Selection(type = Selection.SELECT, options = [
        @Option(text = "Open in the Current Window", qtip = "Opens link to specified path in current window.",
                value = "_self", selected = true),
        @Option(text = "Open in a New Window/Tab", qtip = "Opens link to specified path in a new window or tab.",
                value = "_blank")
])
@Default(values = "_self")
@AnnotationCollector
@interface DialogLinkTarget {

}