package com.clientname.components.content.hello

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.AEMComponent
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate

import javax.inject.Inject

/**
 * Created by icf2025814 on 19/03/18.
 */
@AEMComponent(value = "hello",
        name="hello",
        group = "ap-nilaya",
        listeners = [
                @Listener(name = "afteredit", value = "REFRESH_PAGE"),
                @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
                @Listener(name = "afterdelete", value = "REFRESH_PAGE")
        ])
@AutoInstantiate
class Hello {
    @DialogField
    @TextField
    @Inject
    String text;
}
