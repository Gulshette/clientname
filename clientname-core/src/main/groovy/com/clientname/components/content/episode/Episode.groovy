package com.clientname.components.content.episode

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextArea
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.DialogImageField
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaComponentGroup
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent

import javax.inject.Inject
/**
 * Created by Krupa on 20/03/18.
 */
@NilayaComponent(value="Episode component",
        name="episode",
        group = NilayaComponentGroup.AP_NILAYA,
        listeners = [
                @Listener(name = "afteredit", value = "REFRESH_PAGE"),
                @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
                @Listener(name = "afterdelete", value = "REFRESH_PAGE")
        ])
@AutoInstantiate
class Episode extends AbstractComponent{

    @DialogField(fieldDescription = "Enter the episode title", fieldLabel = "Episode Title", ranking = 1D)
    @TextField
    @Inject
    String episodeTitle

    String getEpisodeButtonLink() {
        return episodeButtonLink
    }

    String getEpisodeAlignment() {
        return episodeAlignment
    }

    @DialogField(fieldDescription = "Select the image for the episode", required = true, fieldLabel = "Episode image" ,ranking = 2D)
    @DialogImageField(title = "Drag & Drop Image")
    String getImage() {
        imageReference.or("")
    }

    @DialogField(fieldDescription = "Enter the episode description", fieldLabel = "Episode description", ranking = 3D)
    @TextArea
    @Inject
    String episodeDescription

    @DialogField(fieldDescription = "Enter the episode button label text", fieldLabel = "Button label text", ranking = 4D)
    @TextField
    @Inject
    String episodeButtonText

    @DialogField(fieldDescription = "Enter the episode description", fieldLabel = "Episode button link", ranking = 5D)
    @PathField
    @Inject
    String episodeButtonLink
}
