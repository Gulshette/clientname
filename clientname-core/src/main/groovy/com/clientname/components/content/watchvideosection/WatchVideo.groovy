package com.clientname.components.content.watchvideosection

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextArea
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.NilayaComponent
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent

import javax.inject.Inject

@NilayaComponent(value = "Watch Video Section",
        name="watchvideosection",
        group = "ap-nilaya",
        listeners = [
                @Listener(name = "afteredit", value = "REFRESH_PAGE"),
                @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
                @Listener(name = "afterdelete", value = "REFRESH_PAGE")
        ])
@AutoInstantiate
class WatchVideo extends AbstractComponent {
    @DialogField(fieldLabel = "Title")
    @TextField
    @Inject
    String title

    @DialogField(fieldLabel = "Description")
    @TextArea
    @Inject
    String description

    @DialogField(fieldLabel = "Video Image")
    @PathField(rootPath = "/content/dam")
    @Inject
    String img

    @DialogField(fieldLabel = "Button text")
    @TextField
    @Inject
    String btnText

    @DialogField(fieldLabel = "Video link")
    @PathField(rootPath = "/content")
    @Inject
    String videoLink
}