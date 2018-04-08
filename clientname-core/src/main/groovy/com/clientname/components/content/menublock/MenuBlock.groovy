package com.clientname.components.content.menublock

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaConstant
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField
import org.apache.sling.models.annotations.injectorspecific.Self


@NilayaComponent(value = "Menu Block", name = "menublock", group = NilayaConstant.GROUP_NAME)

@AutoInstantiate
class MenuBlock extends AbstractComponent {

    @DialogField(fieldLabel = "Menu Block Fields",ranking = 1D)
    @DialogFieldSet
    @Self
    @MultiCompositeField
    List<MenuBlockFields> getMenuBlockFields() {
        getNodesInherited("menuBlockFields").collect { child -> child.resource.adaptTo(MenuBlockFields) }
    }

    @DialogField(fieldLabel = "Dropdown Fields",ranking = 2D)
    @DialogFieldSet
    @Self
    @MultiCompositeField
    List<DropdownFields> getDropdownFields() {
        getNodesInherited("dropdownFields").collect { child -> child.resource.adaptTo(DropdownFields) }
    }

}
