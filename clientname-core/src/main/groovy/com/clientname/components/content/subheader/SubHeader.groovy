package com.clientname.components.content.subheader

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.Tab
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaConstant
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField
import org.apache.sling.models.annotations.injectorspecific.Self

import javax.inject.Inject

@NilayaComponent(value = "subheader", name="subheader", group = NilayaConstant.GROUP_NAME
)
@AutoInstantiate
class SubHeader extends AbstractComponent{



    @DialogField(fieldLabel = "Sub Header Links")
    @MultiCompositeField(limit = 6)
    @DialogFieldSet
    @Self
    /*List<LinkItem> linkItem=[]*/
    List<LinkItem> getLinkItem() {
        getNodesInherited("linkItem").collect { child ->
            child.resource.adaptTo(LinkItem)
        }
    }
    @DialogField(fieldLabel = "Enter the Other Divison title")
    @TextField
    @Inject
    String otherDivisonTitle

    @DialogField(fieldLabel = "Enter Other Division Dropdown List")
    @MultiCompositeField
    @DialogFieldSet
    @Self
    List<LinkItem> getLinkItem1(){
       getNodesInherited("linkItem1").collect{ child ->
           child.resource.adaptTo(LinkItem)
       }
    }

    @DialogField(fieldLabel = "Enter the Language Divison title")
    @TextField
    @Inject
    String languageTitle

    @DialogField(fieldLabel = "Enter the Language Dropdown List")
    @MultiCompositeField
    @DialogFieldSet
    @Self
    List<LinkItem> getLinkItem2(){
        getNodesInherited("linkItem2").collect{ child ->
            child.resource.adaptTo(LinkItem)
        }
    }

    @DialogField(fieldLabel = "Enter the country image",fieldDescription = "Enter the country iamge")
    @PathField
    @Inject
    String mainCountryImage

    @DialogField(fieldLabel = "Enter the Country dropdown list")
    @MultiCompositeField
    @DialogFieldSet
    @Self
    List<CountryName> getCountryName(){
        getNodesInherited("countryName").collect{ child ->
            child.resource.adaptTo(CountryName)
        }
    }
   @DialogField(fieldLabel = "Enter the Social Icons Details")
    @MultiCompositeField
   @DialogFieldSet
   @Self
   /* List<SocialIcons> socialIcons=[]*/
    List<SocialIcons> getSocialIcons() {
        getNodesInherited("socialIcons").collect { child ->
            child.resource.adaptTo(SocialIcons)
        }
    }


}

