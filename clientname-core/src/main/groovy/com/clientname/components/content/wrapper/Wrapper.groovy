package com.clientname.components.content.wrapper

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Option
import com.citytechinc.cq.component.annotations.widgets.Selection
import com.clientname.annotations.NilayaComponent
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent

import javax.inject.Inject

/**
 * Created by icf2025840 on 23/03/18.
 */
@NilayaComponent(value = "wrapper",
        name="wrapper")
@AutoInstantiate
class Wrapper extends AbstractComponent{

    @DialogField(fieldLabel = "Wrapper Classes",defaultValue = "container", ranking = 3D)
    @Selection(type = Selection.SELECT, options = [
            @Option(text = "Container", value = "container"),
            @Option(text = "Menu-block", value = "wthi-menu-block"),
            @Option(text ="Home-Page",value= "wthi-container")
    ])
    @Inject
    String wrapper


}
