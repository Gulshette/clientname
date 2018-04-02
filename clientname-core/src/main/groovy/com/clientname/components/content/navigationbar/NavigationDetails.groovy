package com.clientname.components.content.navigationbar

import com.icfolson.aem.library.api.page.PageDecorator

/**
 * Created by icf2025840 on 29/03/18.
 */
class NavigationDetails {


    @Delegate
    PageDecorator pageDecorator

    int mainNavForkIndexValue = 0

    NavigationDetails(PageDecorator page) {
        this.pageDecorator = page

        def navMap = [:]
        def navContainer = []

        pageDecorator.children.withIndex().findAll { level2 ->
            navContainer = []
            if (!level2.first.isHideInNav()) {
                navContainer.add(level2.first.path)
                level2.first.children.findAll { level3 ->
                    if (!level3.isHideInNav()) {
                        navContainer.add(level3.path)
                    }
                }
                navMap.put(level2.second, navContainer)
            }
        }
        def flattenList = navMap.values().flatten()

        if (flattenList) {
            String pagePathAtMidIndex = flattenList.get((int) (flattenList.size() / 2) - 1)
            navMap.each { key, childContainer ->
                childContainer.any { path ->
                    if (path == pagePathAtMidIndex) {
                        mainNavForkIndexValue = key as Integer
                        return true
                    }
                }
            }
        }

    }

    List<NavigationDetails> getChildren() {
        pageDecorator.getChildren(true).collect { childPage ->
            new NavigationDetails(childPage)
        }
    }
}
