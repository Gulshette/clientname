package com.clientname.components.content.gallery

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.MultiField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaComponentGroup
import com.clientname.constants.NilayaConstant
import com.day.cq.dam.api.Asset
import com.day.cq.dam.api.DamConstants
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import org.apache.sling.api.resource.ResourceResolver

import javax.annotation.PostConstruct
import javax.inject.Inject

@NilayaComponent(value="Gallery component",
        name="gallery",
        group = NilayaComponentGroup.AP_NILAYA,
        listeners = [
                @Listener(name = NilayaConstant.AFTER_EDIT, value = NilayaConstant.REFRESH_PAGE),
                @Listener(name = NilayaConstant.AFTER_INSERT, value = NilayaConstant.REFRESH_PAGE),
                @Listener(name = NilayaConstant.AFTER_DELETE, value = NilayaConstant.REFRESH_PAGE)
        ])
@AutoInstantiate
class Gallery {

    String getGalleryTitle() {
        return galleryTitle
    }

    String[] getGalleryList() {
        return galleryList
    }
    @DialogField(fieldLabel = "Gallery title", fieldDescription = "Enter the gallery title")
    @TextField
    @Inject
    private String galleryTitle

    @DialogField(fieldLabel = "Gallery image", fieldDescription = "Select the gallery images to display")
    @MultiField
    @PathField(rootPath = NilayaConstant.DAM_ROOT_PATH)
    @Inject
    private String[] galleryList

    def getImageItemList() {
        return imageItemList
    }
    def imageItemList

    @Inject
    private ResourceResolver resourceResolver

    @PostConstruct
    void init(){
        if(galleryList) {
            imageItemList = new ArrayList<ImageItem>()
            galleryList.each { imagePath ->
                ImageItem imageItem = new ImageItem()
                if(!imagePath.isEmpty()) {
                    def imageresource = resourceResolver.getResource(imagePath)
                    def imgDamResource = imageresource.adaptTo(Asset.class)
                    def imgTitle = imgDamResource.getMetadataValue(DamConstants.DC_TITLE)

                    if(imgTitle){
                        imageItem.setImagePath(imagePath)
                        imageItem.setImageTitle(imgTitle)
                    }else{
                        imageItem.setImagePath(imagePath)
                        imageItem.setImageTitle("Image")
                    }
                }
                imageItemList.add(imageItem)
            }
        }
    }

}
