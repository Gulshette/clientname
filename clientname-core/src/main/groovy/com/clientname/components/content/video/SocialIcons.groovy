package com.clientname.components.content.video

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Option
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.Selection
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.MultiCompositeFieldItem
import com.icfolson.aem.library.core.components.AbstractComponent
import org.apache.sling.models.annotations.Default

import javax.inject.Inject
/**
 * Created by Krupa on 21/03/18.
 */
@MultiCompositeFieldItem
class SocialIcons extends AbstractComponent{

    String getSocialLink() {
        return socialLink
    }

    String getIconTitle() {
        return iconTitle
    }

    String getSocialIconImage() {
        return socialIconImage
    }
    @DialogField(fieldDescription = "Enter the social link to share", fieldLabel = "Social Link")
    @PathField
    @Inject
    private String socialLink

    @DialogField(fieldDescription = "Enter the social icon title", fieldLabel = "Social icon title")
    @TextField
    @Inject
    private String iconTitle

    @DialogField(fieldLabel = "Social icon", fieldDescription = "Social icon image")
    @PathField
    @Inject
    private String socialIconImage;

    @DialogField(fieldLabel = "Open Link In", ranking = 4D)
    @Selection(options = [
            @Option(text = "Same Window", value = "samewindow", selected = true),
            @Option(text = "New Window", value = "newwindow")
    ], type="select")
    @Inject
    @Default(values = "")
    String socialOpenLinkIn
    String getSocialOpenLinkIn(){
        return  socialOpenLinkIn
    }
}
