package com.clientname.components.content.episodewrapper

import com.citytechinc.cq.component.annotations.Listener
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaComponentGroup
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
/**
 * Created by Krupa on 26/03/18.
 */
@NilayaComponent(value="Episode Wrapper",
        name="episodewrapper",
        group = NilayaComponentGroup.AP_NILAYA,
        listeners = [
                @Listener(name = "afteredit", value = "REFRESH_PAGE"),
                @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
                @Listener(name = "afterdelete", value = "REFRESH_PAGE")
        ])
@AutoInstantiate
class EpisodeWrapper {

}
