package com.clientname.components.content.video

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.DialogLinkTarget
import com.clientname.annotations.MultiCompositeFieldItem
import com.clientname.constants.NilayaConstant
import com.icfolson.aem.library.core.components.AbstractComponent

import javax.inject.Inject

@MultiCompositeFieldItem
class SocialIcons extends AbstractComponent{

    @DialogField(fieldDescription = "Enter the social link to share", fieldLabel = "Social Link")
    @PathField
    @Inject
    private String socialLink

    @DialogField(fieldDescription = "Enter the social icon title", fieldLabel = "Social icon title")
    @TextField
    @Inject
    private String iconTitle

    @DialogField(fieldLabel = "Social icon", fieldDescription = "Social icon image")
    @PathField(rootPath = NilayaConstant.DAM_ROOT_PATH)
    @Inject
    private String socialIconImage;

    @DialogLinkTarget
    String socialOpenLinkIn

    String getSocialOpenLinkIn(){
        return  socialOpenLinkIn
    }

    String getSocialLink() {
        return socialLink
    }

    String getIconTitle() {
        return iconTitle
    }

    String getSocialIconImage() {
        return socialIconImage
    }
}
