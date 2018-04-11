package com.clientname.components.content.searchpage


import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.clientname.annotations.NilayaComponent
import com.day.cq.search.PredicateGroup
import com.day.cq.search.Query
import com.day.cq.search.QueryBuilder
import com.day.cq.search.result.Hit
import com.day.cq.search.result.SearchResult

import com.icfolson.aem.library.api.page.PageDecorator
import com.icfolson.aem.library.core.components.AbstractComponent
import org.apache.sling.api.resource.Resource
import org.apache.sling.api.resource.ResourceResolver


import javax.annotation.PostConstruct
import javax.inject.Inject
import javax.jcr.Session

/**
 * Created by icf2025840 on 03/04/18.
 */
@NilayaComponent(name="searchpage", value="Search Page")
class SearchPage extends AbstractComponent{

    @Inject
    PageDecorator currentPage

    @Inject
    ResourceResolver resourceResolver

    @DialogField(fieldLabel = "Root Page", tab = 1, required = true)
    @PathField(rootPath = "/content/clientname")
    PageDecorator getRootPage() {
        getAsPageInherited("rootPage").or(currentPage)
    }


   def List<SearchPagePojo> searchDataList;


    @PostConstruct
   public  void init(){


       searchDataList=new ArrayList<>()
       QueryBuilder queryBuilder = resourceResolver.adaptTo(QueryBuilder.class)
       Session session = resourceResolver.adaptTo(Session.class)

       final Map<String, String> map = new HashMap<>()
       map.put("path", "/content/clientname")
       map.put("type", "cq:PageContent")
       map.put("property", "cq:tags")
       map.put("property.value","level1")
       map.put("property.operation","exists")

       Query query = queryBuilder.createQuery(PredicateGroup.create(map), session)
       SearchResult searchResult = query.getResult();

       if (searchResult != null && searchResult.totalMatches > 0) {
           List<Hit> hits = searchResult.getHits();
           for (Hit hit : hits) {
               SearchPagePojo searchPagePojo=new SearchPagePojo()
               Resource resultResource=hit.getResource();
               searchPagePojo.setTitle(resultResource.parent.getName().toString())
               searchPagePojo.setPath(resultResource.parent.getPath())
               searchDataList.add(searchPagePojo)

           }
       }
        searchDataList
    }

}
