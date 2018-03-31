package com.clientname.components.content.header

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaComponentGroup
import com.clientname.constants.NilayaConstant
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField

import javax.inject.Inject

import static com.icfolson.aem.library.core.constants.ComponentConstants.EVENT_AFTER_DELETE
import static com.icfolson.aem.library.core.constants.ComponentConstants.EVENT_AFTER_EDIT
import static com.icfolson.aem.library.core.constants.ComponentConstants.EVENT_AFTER_INSERT
import static com.icfolson.aem.library.core.constants.ComponentConstants.REFRESH_PAGE

/**
 * Created by icf2025814 on 19/03/18.
 */

@NilayaComponent(value = "header",name="header", group = NilayaConstant.GROUP_NAME,listeners = [
        @Listener(name = EVENT_AFTER_EDIT, value = REFRESH_PAGE),
        @Listener(name = EVENT_AFTER_INSERT, value = REFRESH_PAGE),
        @Listener(name = EVENT_AFTER_DELETE, value = REFRESH_PAGE)
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
