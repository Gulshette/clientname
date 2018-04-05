package com.clientname.components.content.tabscomponent

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaConstant
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField

import javax.inject.Inject

@NilayaComponent(value = "Tabs Component", name = "tabscomponent", group = NilayaConstant.GROUP_NAME)
@AutoInstantiate
class TabsComponent extends AbstractComponent {

    @DialogField(fieldLabel = "Logo",ranking = 1D,required = true)
    @PathField(rootPath = "/content/dam/clientname")
    @Inject logo;

    @DialogField(fieldLabel = "Alt Text",ranking = 2D,required = true)
    @TextField
    @Inject altText;

    @DialogField(fieldLabel = "Tab Component Fields",ranking = 3D)
    @MultiCompositeField
    List<TabFields> getTabFields(){
        getNodesInherited("tabFields").collect { child -> child.resource.adaptTo(TabFields) }
    }
}
