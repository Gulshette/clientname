package com.clientname.components.content.wrapper

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Option
import com.citytechinc.cq.component.annotations.widgets.Selection
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaComponentGroup
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent

import javax.inject.Inject
/**
 * Created by icf2025840 on 23/03/18.
 */
@NilayaComponent(value = "Wrapper component",
        name="wrapper",
        group = NilayaComponentGroup.AP_NILAYA)
@AutoInstantiate
class Wrapper extends AbstractComponent{

    @DialogField(fieldLabel = "Wrapper Classes", ranking = 3D)
    @Selection(type = Selection.SELECT, options = [
            @Option(text = "Container", value = "container"),
            @Option(text ="Home-Page",value= "wthi-container"),
            @Option(text ="Full-Width-Container of Hompepage",value = "full-widt-container"),
            @Option(text ="Episode-main-container",value= "episode-container clearfix"),
            @Option(text ="Fullwidth_episode-container",value= "episode-wrapper full-width"),
            @Option(text ="Halfwidth_episode-container",value= "other-episode-block")
    ])
    @Inject
    String wrapper
}
