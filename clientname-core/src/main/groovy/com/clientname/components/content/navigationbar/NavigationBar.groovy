package com.clientname.components.content.navigationbar

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.clientname.annotations.NilayaComponent
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.api.link.NavigationLink
import com.icfolson.aem.library.api.page.PageDecorator
import com.icfolson.aem.library.core.components.AbstractComponent

import javax.inject.Inject

/**
 * Created by icf2025840 on 28/03/18.
 */
@NilayaComponent(value = "NavigationBar", name = "navigationbar")
@AutoInstantiate
class NavigationBar extends AbstractComponent {

    @Inject
    PageDecorator currentPage

    @DialogField(fieldLabel = "Root Page", tab = 1, required = true)
    @PathField(rootPath = "/content/clientname")
    PageDecorator getRootPage() {
        getAsPageInherited("rootPage").or(currentPage)
    }

    List<NavigationDetails> getMainNavPages() {
        getAsPageInherited("rootPage").or(currentPage).getChildren(true).collect { page ->
            new NavigationDetails(page)
        }
    }
    /*List<NavigationLink> getNavigationLinks() {
        def links = []
        if (rootPage) {
            links = rootPage.getChildren().collect { page ->
                page.navigationLink
            }
        }
        links
    }*/




}
