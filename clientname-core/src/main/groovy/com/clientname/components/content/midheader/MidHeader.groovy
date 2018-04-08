package com.clientname.components.content.midheader

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.clientname.annotations.DialogLinkTarget
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaConstant
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.api.link.Link
import com.icfolson.aem.library.core.components.AbstractComponent

import javax.inject.Inject

@NilayaComponent(value = "midheader", name="midheader", group = NilayaConstant.GROUP_NAME)
@AutoInstantiate
class MidHeader extends AbstractComponent{

    @DialogField(fieldLabel = "Enter the Logo image")
    @PathField
    @Inject
    String logoImage

    @DialogField(fieldLabel = "Enter the redirection path for logo")
    @PathField
    @Inject
    Link logoPath

    @DialogLinkTarget
    @DialogField(fieldLabel = "Link Target")
    @Inject
    String targetVal1

    @DialogField(fieldLabel = "Enter the user iocn")
    @PathField
    @Inject
    String userIcon

    @DialogField(fieldLabel = "Enter the user icon path")
    @PathField
    @Inject
    Link userIconPath

    @DialogLinkTarget
    @DialogField(fieldLabel = "Link Target")
    @Inject
    String targetVal2



    @DialogField(fieldLabel = "Enter the Cart icon")
    @PathField
    @Inject
    String cartIcon

    @DialogField(fieldLabel = "Enter the Cart icon path")
    @PathField
    @Inject
    Link cartIconPath

    @DialogLinkTarget
    @DialogField(fieldLabel = "Link Target")
    @Inject
    String targetVal3

    @DialogField(fieldLabel = "Enter the home decor icon")
    @PathField
    @Inject
    String homeDecorIcon

    @DialogField(fieldLabel = "Enter the home decor icon path")
    @PathField
    @Inject
    Link homeDecorIconPath

    @DialogLinkTarget
    @DialogField(fieldLabel = "Link Target")
    @Inject
    String targetVal4


}
