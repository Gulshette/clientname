package com.clientname.components.content.subheader

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Listener
import com.citytechinc.cq.component.annotations.Tab
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaComponentGroup
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent
import com.icfolson.aem.multicompositeaddon.widget.MultiCompositeField

import javax.inject.Inject

@NilayaComponent(value = "subheader", name="subheader", group = NilayaComponentGroup.AP_NILAYA, listeners = [
        @Listener(name = "afteredit", value = "REFRESH_PAGE"),
        @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
        @Listener(name = "afterdelete", value = "REFRESH_PAGE")
],
        tabs = [
                @Tab(title = "Top Links tab"),
                @Tab(title = "Other Division tab"),
                @Tab(title = "Language tab"),
                @Tab(title = "Country Details tab"),
                @Tab(title = "Social Icons tab"),
        ])
@AutoInstantiate
class SubHeader extends AbstractComponent{



    @DialogField(fieldLabel = "Sub Header Links",tab = 1)
    @MultiCompositeField(limit = 6)
    /*List<LinkItem> linkItem=[]*/
    List<LinkItem> getLinkItem() {
        getNodesInherited("linkItem").collect { child ->
            child.resource.adaptTo(LinkItem)
        }
    }
    @DialogField(fieldLabel = "Enter the Other Divison title",tab =2)
    @TextField
    @Inject
    String otherDivisonTitle

    @DialogField(fieldLabel = "Enter Other Division Dropdown List",tab=2)
    @MultiCompositeField
    List<LinkItem> getLinkItem1(){
       getNodesInherited("linkItem1").collect{ child ->
           child.resource.adaptTo(LinkItem)
       }
    }

    @DialogField(fieldLabel = "Enter the Language Divison title",tab =3)
    @TextField
    @Inject
    String languageTitle

    @DialogField(fieldLabel = "Enter the Language Dropdown List",tab =3)
    @MultiCompositeField
    List<LinkItem> getLinkItem2(){
        getNodesInherited("linkItem2").collect{ child ->
            child.resource.adaptTo(LinkItem)
        }
    }

    @DialogField(fieldLabel = "Enter the country image",fieldDescription = "Enter the country iamge",tab =4)
    @PathField
    @Inject
    String mainCountryImage

    @DialogField(fieldLabel = "Enter the Country dropdown list",tab =4)
    @MultiCompositeField
    List<CountryName> getCountryName(){
        getNodesInherited("countryName").collect{ child ->
            child.resource.adaptTo(CountryName)
        }
    }
   @DialogField(fieldLabel = "Enter the Social Icons Details",tab=5)
    @MultiCompositeField
   /* List<SocialIcons> socialIcons=[]*/
    List<SocialIcons> getSocialIcons() {
        getNodesInherited("socialIcons").collect { child ->
            child.resource.adaptTo(SocialIcons)
        }
    }


}

