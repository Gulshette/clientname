package com.clientname.components.content.gallery

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.MultiField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaComponentGroup
import com.clientname.constants.NilayaConstant
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate

import javax.inject.Inject
/**
 * Created by Krupa on 21/03/18.
 */
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
    @PathField
    @Inject
    private String[] galleryList

}
