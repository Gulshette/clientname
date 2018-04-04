package com.clientname.components.content.menublock

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Tab
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaConstant
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField


@NilayaComponent(value = "Menu Block", name = "menublock", group = NilayaConstant.GROUP_NAME,
        tabs = [
                @Tab(title = "Menu Block"),
                @Tab(title = "Dropdown Block")
        ])

@AutoInstantiate
class MenuBlock extends AbstractComponent {

    @DialogField(fieldLabel = "Menu Block Fields",ranking = 1D, tab = 1)
    @MultiCompositeField
    List<MenuBlockFields> getMenuBlockFields() {
        getNodesInherited("menuBlockFields").collect { child -> child.resource.adaptTo(MenuBlockFields) }
    }

    @DialogField(fieldLabel = "Dropdown Fields",ranking = 2D, tab = 2)
    @MultiCompositeField
    List<DropdownFields> getDropdownFields() {
        getNodesInherited("dropdownFields").collect { child -> child.resource.adaptTo(DropdownFields) }
    }

}
