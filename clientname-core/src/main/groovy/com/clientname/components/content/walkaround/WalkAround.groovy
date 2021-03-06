package com.clientname.components.content.walkaround

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.AEMComponent
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent

import javax.inject.Inject

/**
 * Created by icf2025840 on 22/03/18.
 */
@AEMComponent(value = "WalkAround",
        name="walkaround",
        group = "ap-nilaya",
        listeners = [
                @Listener(name = "afteredit", value = "REFRESH_PAGE"),
                @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
                @Listener(name = "afterdelete", value = "REFRESH_PAGE")
        ])
@AutoInstantiate
class WalkAround extends AbstractComponent{

    @DialogField(fieldLabel = "Title",ranking = 1D)
    @TextField
    @Inject
    String title

    @DialogField(fieldLabel = "Iframe Path",ranking = 2D)
    @PathField
    @Inject
    String iframePath

    @DialogField(fieldLabel = " No of likes",ranking = 3D)
    @TextField
    @Inject
    String like

    @DialogField(fieldLabel = "Watched Count",ranking = 4D)
    @TextField
    @Inject
    String watched

    @DialogField(fieldLabel = "Shared Count",ranking = 5D)
    @TextField
    @Inject
    String shared


}
