package com.clientname.annotations

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Option
import com.citytechinc.cq.component.annotations.widgets.Selection
import groovy.transform.AnnotationCollector

/**
 * Created by AshwiniPawar on 26/03/18.
 */

@DialogField(fieldLabel = "Style", defaultValue = "style1")
@Selection(options = [
        @Option(text = "Light Green", value = "style1"),
        @Option(text = "Dark Green", value = "style2"),
        @Option(text = "Gold", value = "style3"),
        @Option(text = "Light Yellow", value = "style4"),
        @Option(text = "Lavender", value = "style5"),
        @Option(text = "Darkmagenta", value = "style6"),
        @Option(text = "Darkcyna", value = "style7"),
        @Option(text = "Light Steel Blue", value = "style8"),

], type = "select")
@AnnotationCollector
@interface ColorsSelection {

}