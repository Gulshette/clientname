package com.clientname.components.content.searchpage

import com.adobe.cq.social.commons.comments.api.Comment
import com.adobe.cq.wcm.core.components.models.Page
import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.PathField
import com.clientname.annotations.NilayaComponent
import com.day.cq.replication.ReplicationActionType
import com.day.cq.replication.ReplicationException
import com.day.cq.search.PredicateGroup
import com.day.cq.search.Query
import com.day.cq.search.QueryBuilder
import com.day.cq.search.result.Hit
import com.day.cq.search.result.SearchResult
import com.day.cq.searchpromote.Search
import com.day.cq.tagging.Tag
import com.day.cq.tagging.TagManager
import com.icfolson.aem.library.api.link.NavigationLink
import com.icfolson.aem.library.api.page.PageDecorator
import com.icfolson.aem.library.core.components.AbstractComponent
import org.apache.sling.api.resource.ModifiableValueMap
import org.apache.sling.api.resource.Resource
import org.apache.sling.api.resource.ResourceResolver
import org.apache.sling.api.resource.ValueMap

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

   List<SearchPagePojo> searchDataList;

    List<SearchPagePojo> getSearchDataList() {
        return searchDataList
    }

    void setSearchDataList(List<SearchPagePojo> searchDataList) {
        this.searchDataList = searchDataList
    }

    @PostConstruct
   public  void init(){

       /* searchDataList=new ArrayList<>();
       QueryBuilder queryBuilder = resourceResolver.adaptTo(QueryBuilder.class);
       Session session = resourceResolver.adaptTo(Session.class);
       final Map<String, String> map = new HashMap<>();
       map.put("path", "/content/clientname");
       map.put("type", "cq:PageContent");
       map.put("property", "cq:tags");
       map.put("property.value","level1");
       map.put("property.operation","exists");

       Query query = queryBuilder.createQuery(PredicateGroup.create(map), session);
       SearchResult searchResult = query.getResult();
       if (searchResult != null && searchResult.totalMatches > 0) {
           List<Hit> hits = searchResult.getHits();
           for (Hit hit : hits) {
               Resource resultResource=hit.getResource();

               try {
                   searchDataList.add(resultResource.parent.getName());
                   searchDataList.add(resultResource.parent.getPath());


               } catch (ReplicationException e) {
                   //LOGGER.error("ReplicationException", e.getMessage(),e);
               }
           }

       }*/
       /* def itr = resourceResolver.findResources("/jcr:root/content/clientname//element(*, cq:PageContent) [ @cq:tags ]","xpath");
        itr.each{res->
            println res.path
        }*/
    }

}
