package com.clientname.components.content.watchseason

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.NilayaComponent
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField

import javax.inject.Inject

@NilayaComponent(value = "Watch Season",
        name="watchseason",
        group = "ap-nilaya",
        listeners = [
                @Listener(name = "afteredit", value = "REFRESH_PAGE"),
                @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
                @Listener(name = "afterdelete", value = "REFRESH_PAGE")
        ])
@AutoInstantiate
class WatchSeason extends AbstractComponent{
    @DialogField(fieldLabel = "Title",ranking = 1D)
    @TextField
    @Inject
    String title

    @DialogField(fieldLabel = "Gallery title")
    @TextField
    @Inject
    String galleryTitle

    @DialogField(fieldLabel = "Gallery section data",ranking = 2D)
    @MultiCompositeField
    List<GalleryData> getGalleryData() {
        getNodesInherited("galleryData").collect { child ->
            child.resource.adaptTo(GalleryData)
        }
    }
}
