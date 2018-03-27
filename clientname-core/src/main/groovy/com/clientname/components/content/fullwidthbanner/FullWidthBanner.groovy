package com.clientname.components.content.fullwidthbanner

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextArea
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.NilayaComponent
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent

import javax.inject.Inject

/**
 * Created by icf2025295 on 21/03/18.
 */

@NilayaComponent(value = "Full Width Banner",
name = "fullwidthbanner",
group = "ap-nilaya",
        listeners = [
                @Listener(name = "afteredit", value = "REFRESH_PAGE"),
                @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
                @Listener(name = "afterdelete", value = "REFRESH_PAGE")
        ])
@AutoInstantiate
class FullWidthBanner extends AbstractComponent {

    @DialogField(fieldLabel = "Background Image",ranking = 1D,required = true)
    @PathField(rootPath = "/content/dam")
    @Inject bgimage;

    @DialogField(fieldLabel = "Title",ranking = 2D)
    @TextField
    @Inject title;

    @DialogField(fieldLabel = "Description", ranking = 3D)
    @TextArea
    @Inject description;

}
