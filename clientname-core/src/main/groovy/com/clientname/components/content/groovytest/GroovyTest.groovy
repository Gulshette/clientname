package com.clientname.components.content.groovytest

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.clientname.annotations.NilayaComponent
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate

import javax.inject.Inject

/**
 * Created by icf2025814 on 19/03/18.
 */

@NilayaComponent(value="groovytest",
              name="groovytest",
        group = "ap-nilaya",
        listeners = [
                @Listener(name = "afteredit", value = "REFRESH_PAGE"),
                @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
                @Listener(name = "afterdelete", value = "REFRESH_PAGE")
        ])
@AutoInstantiate
class GroovyTest {

    @DialogField
    @PathField
    @Inject
    String imagePath
}
