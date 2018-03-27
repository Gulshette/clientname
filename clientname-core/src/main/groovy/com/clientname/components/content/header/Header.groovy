package com.clientname.components.content.header

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaComponentGroup
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField

import javax.inject.Inject

/**
 * Created by icf2025814 on 19/03/18.
 */

@NilayaComponent(value = "header",name="header", group = NilayaComponentGroup.AP_NILAYA,listeners = [
        @Listener(name = "afteredit", value = "REFRESH_PAGE"),
        @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
        @Listener(name = "afterdelete", value = "REFRESH_PAGE")
])
@AutoInstantiate
class Header  extends AbstractComponent{


  @DialogField
  @MultiCompositeField
  @Inject
  List<HeaderMainStripPojo> headerMainStripPojo(){
    getNodesInherited("headerMainStripPojo").collect{ child ->

      child.resource.adaptTo(HeaderMainStripPojo)

    }
  }




}
