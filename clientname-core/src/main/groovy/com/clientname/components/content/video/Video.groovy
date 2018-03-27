package com.clientname.components.content.video

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.Property
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaComponentGroup
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField

import javax.inject.Inject
/**
 * Created by Krupa on 21/03/18.
 */
@NilayaComponent(value="Video component",
        name="video",
        group = NilayaComponentGroup.AP_NILAYA,
        listeners = [
                @Listener(name = "afteredit", value = "REFRESH_PAGE"),
                @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
                @Listener(name = "afterdelete", value = "REFRESH_PAGE")
        ])
@AutoInstantiate
class Video {

    String getVideoPath() {
        return videoPath
    }
    @DialogField(fieldDescription = "Enter the path of the video to display", fieldLabel = "Video Link")
    @PathField
    @Inject
    private String videoPath

    List<SocialIcons> getSocialShareData() {
        return socialShareData
    }
    @DialogField(fieldDescription = "Enter all the social icon details to share", fieldLabel = "Social icons",
    additionalProperties = @Property(name = "class", value = "gallery-imageblock"))
    @MultiCompositeField
    @Inject
    private List<SocialIcons> socialShareData
}
