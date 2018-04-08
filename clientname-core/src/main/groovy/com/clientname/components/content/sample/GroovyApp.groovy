package com.clientname.components.content.sample

import com.adobe.cq.social.filelibrary.client.api.Asset
import com.day.cq.replication.ReplicationException
import com.day.cq.search.PredicateGroup
import com.day.cq.search.Query
import com.day.cq.search.QueryBuilder
import com.day.cq.search.result.Hit
import com.day.cq.search.result.SearchResult
import org.apache.sling.api.resource.ResourceResolver

import javax.annotation.Resource
import javax.inject.Inject
import javax.jcr.Session

/**
 * Created by icf2025840 on 04/04/18.
 */
class GroovyApp {

    def noOfPages = 0

    @Inject
    ResourceResolver resourceResolver

    def findAllPages(){
        def itr = resourceResolver.findResources("/jcr:root/content/clientname//element(*, cq:Page) [ @cq:tags ]","xpath");
        itr.each{res->
            println res.path
        }
    }



}
