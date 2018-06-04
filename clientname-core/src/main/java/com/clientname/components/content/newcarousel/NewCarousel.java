package com.clientname.components.content.newcarousel;


import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.DamConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.Self;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class NewCarousel {

    private static final String CQ_PAGE="cq:Page";
    private static final String IMAGE="image";


    @Self
    Resource resource;

    @Inject
    private String path;

    @Inject
    private String choose;

    @Inject
    private String numchoose;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose;
    }

    public String getNumchoose() {
        return numchoose;
    }

    public void setNumchoose(String numchoose) {
        this.numchoose = numchoose;
    }
    @Inject
    List<CarouselModel> carouselModelList;

    public List<CarouselModel> getCarouselModelList() {
        return carouselModelList;
    }

    @PostConstruct
    public void init(){

        carouselModelList=new ArrayList<>();

        ResourceResolver resourceResolver= resource.getResourceResolver();
        Resource pageResource1 =resourceResolver.getResource(path);
        if(pageResource1 !=null)
        {
            String resType= pageResource1.getResourceType();
            if(StringUtils.equals(resType,CQ_PAGE))
            {
                Page pageResource= getPageFromResouce(pageResource1);
                listChild(pageResource);
            }
            else{
                if(StringUtils.equals(resType,DamConstants.NT_SLING_ORDEREDFOLDER))
                {
                    Resource damResource=resourceResolver.getResource(path);
                    if(damResource !=null && damResource.hasChildren())
                    {
                        Iterable<Resource> itr=damResource.getChildren();
                        for(Resource res :itr)
                        {
                            Asset assetResource =adaptToAssetResource(res);
                            if(assetResource !=null)
                            {
                                CarouselModel carouselModel=new CarouselModel();
                                carouselModel.setImageTitle(assetResource.getName());
                                carouselModel.setImagePath(assetResource.getPath());
                                carouselModelList.add(carouselModel);
                            }
                    }
                    }
                }
            }
        }

    }
    private Page getPageFromResouce(Resource resource)
    {
        Page currentPage=null;
        PageManager pageManager =resource.getResourceResolver().adaptTo(PageManager.class);
        if(pageManager !=null)
        {
            currentPage =pageManager.getContainingPage(resource);
        }
        return  currentPage;
    }

    private void listChild(Page page)
    {

        Iterator<Page> children = page.listChildren();
        while(children.hasNext())
        {
            Page childPage=children.next();
            CarouselModel carouselModel = setCarouselModel(childPage);
            if(carouselModel !=null)
            {
                carouselModelList.add(carouselModel);
            }

        }
    }

    private CarouselModel setCarouselModel(Page pageResource)
    {

        CarouselModel carouselModel=null;
        if(pageResource!=null)
        {
            carouselModel=new CarouselModel();
            carouselModel.setImageTitle(pageResource.getTitle());
            carouselModel.setImagePath(pageResource.getPath());
        }
        return carouselModel;
    }

   private static Asset adaptToAssetResource(Resource resource)
   {
       Asset asset =null;
       if(resource !=null)
       {
           asset =resource.adaptTo(Asset.class);
       }
       return asset;
   }


}
