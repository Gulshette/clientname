package com.clientname.components.content.episode

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextArea
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.DialogImageField
import com.clientname.annotations.DialogLinkTarget
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaComponentGroup
import com.clientname.constants.NilayaConstant
import com.day.cq.dam.api.Asset
import com.day.cq.dam.api.DamConstants
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import org.apache.sling.api.resource.ResourceResolver

import javax.annotation.PostConstruct
import javax.inject.Inject

@NilayaComponent(value="Episode component",
        name="episode",
        group = NilayaComponentGroup.AP_NILAYA,
        listeners = [
                @Listener(name = NilayaConstant.AFTER_EDIT, value = NilayaConstant.REFRESH_PAGE),
                @Listener(name = NilayaConstant.AFTER_INSERT, value = NilayaConstant.REFRESH_PAGE),
                @Listener(name = NilayaConstant.AFTER_DELETE, value = NilayaConstant.REFRESH_PAGE)
        ])
@AutoInstantiate
class Episode extends AbstractComponent{

    @DialogField(fieldDescription = "Enter the episode title", fieldLabel = "Episode Title", ranking = 1D)
    @TextField
    @Inject
    String episodeTitle

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
    @PathField(rootPath = NilayaConstant.CONTENT_ROOT_PATH)
    @Inject
    String episodeButtonLink

    @DialogLinkTarget(ranking = 6D)
    @Inject
    String episodeOpenLinkIn

    def episodeImgTitle

    @Inject
    private ResourceResolver resourceResolver

    def getEpisodeImgTitle() {
        return episodeImgTitle
    }

    String getEpisodeOpenLinkIn(){
        return  episodeOpenLinkIn
    }

    String getEpisodeButtonLink() {
        return episodeButtonLink
    }

    @PostConstruct
    void init(){
        if(getImage()){
            def imgAsset = resourceResolver.getResource(getImage()).adaptTo(Asset.class)
            episodeImgTitle = imgAsset.getMetadataValue(DamConstants.DC_TITLE)
            if(episodeImgTitle){
                episodeImgTitle = NilayaConstant.IMAGE
            }
        }
    }
}
