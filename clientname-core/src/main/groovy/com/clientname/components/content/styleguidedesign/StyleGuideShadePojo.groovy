package com.clientname.components.content.styleguidedesign

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.ColorsSelection
import com.icfolson.aem.library.core.components.AbstractComponent
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model

import javax.inject.Inject

/**
 * Created by AshwiniPawar on 27/03/18.
 */
@Model(adaptables = Resource,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
class StyleGuideShadePojo extends AbstractComponent {

    @DialogField( fieldLabel = "Select the color", ranking = 1D)
    @ColorsSelection
    @Inject
    String colour

    @DialogField(fieldLabel = "Shade title",ranking = 2D)
    @TextField
    @Inject
    String shadeTitle

    @DialogField(fieldLabel = "Shade number",ranking = 3D)
    @TextField
    @Inject
    String shadeNumber
}