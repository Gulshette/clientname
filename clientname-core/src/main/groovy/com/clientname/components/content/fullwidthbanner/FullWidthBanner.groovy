package com.clientname.components.content.fullwidthbanner

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextArea
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaConstant
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent

import javax.inject.Inject


@NilayaComponent(value = "Full Width Banner", name = "fullwidthbanner", group = NilayaConstant.GROUP_NAME)

@AutoInstantiate
class FullWidthBanner extends AbstractComponent {

    @DialogField(fieldLabel = "Background Image",ranking = 1D,required = true)
    @PathField(rootPath = "/content/dam/clientname")
    @Inject bgImage;

    @DialogField(fieldLabel = "Banner Title",ranking = 2D)
    @TextField
    @Inject title;

    @DialogField(fieldLabel = "Banner Description", ranking = 3D)
    @TextArea
    @Inject description;

}
