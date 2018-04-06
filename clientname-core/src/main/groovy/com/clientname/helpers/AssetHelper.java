package com.clientname.helpers;


import com.bostonpizza.service.constants.BPConstants;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.DamConstants;
import com.day.cq.dam.api.Rendition;
import com.google.common.escape.Escaper;
import com.google.common.net.UrlEscapers;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.query.SlingQuery;

import java.util.ArrayList;
import java.util.List;

import static org.apache.sling.query.SlingQuery.$;


/**
 * Utility class to help with asset related operations
 */
public class AssetHelper {
    private static final Escaper URL_ESCAPER = UrlEscapers.urlFragmentEscaper();

    private AssetHelper() {

    }

    /**
     * @param resource asset resource to get asset details
     * @return ImageModel consisting of the image path and image title for alt text
     */
    public static ImageModel getImageModelFromResource(Resource resource) {
        ImageModel imageModel = new ImageModel();
        setImageModelFromResource(resource, imageModel);
        return imageModel;
    }

    public static void setImageModelFromResource(Resource resource, ImageModel imageModel) {
        Asset asset = adaptResourceToAsset(resource);
        setImageModelFromResource(asset, imageModel, resource);
    }

    private static void setImageModelFromResource(Asset asset, ImageModel imageModel, Resource resource) {
        if (asset != null) {

            String title = asset.getMetadataValue(DamConstants.DC_TITLE);
            String description = asset.getMetadataValue(DamConstants.DC_DESCRIPTION);

            if (StringUtils.isEmpty(title)) {
                title = FilenameUtils.removeExtension(asset.getName());
            }

            if (StringUtils.isEmpty(description)) {
                description = StringUtils.EMPTY;
            }

            imageModel.setAlt(title);
            imageModel.setImagePath(URL_ESCAPER.escape(asset.getPath()));
            imageModel.setDescription(description);
            /*Transformation on the image with extension .gif reducing the image quality,
            So all such .gif images are transformed as .png images*/
            String imageExtension = FilenameUtils.getExtension(asset.getName());
            if (imageExtension.equalsIgnoreCase(BPConstants.EXTENSION_GIF)) {
                imageModel.setExtension(BPConstants.EXTENSION_PNG);
            }else if (imageExtension.equalsIgnoreCase(BPConstants.EXTENSION_JPG) || imageExtension.equalsIgnoreCase(BPConstants.EXTENSION_JPEG)) {
                imageModel.setExtension(BPConstants.EXTENSION_JPEG);
            }
            else {
                imageModel.setExtension(imageExtension);
            }
        } else {
            imageModel.setExtension(FilenameUtils.getExtension(resource.getName()));
            imageModel.setAlt(FilenameUtils.getExtension(resource.getName()));

        }

    }

    public static String getAssetRendition(Asset asset, String renditionName) {
        Rendition rendition = asset.getRendition(renditionName);
        if (rendition != null) {
            return rendition.getPath();
        }
        return StringUtils.EMPTY;
    }

    private static Asset adaptResourceToAsset(Resource resource) {
        Asset asset = null;
        if (resource != null) {
            asset = resource.adaptTo(Asset.class);
        }
        return asset;
    }

    public static List<Resource> getAssetResourcesFromPath(List<String> resourcePaths,
                                                           ResourceResolver resourceResolver) {
        List<Resource> assets = null;
        if (resourcePaths != null && !resourcePaths.isEmpty()) {
            assets = getAssetResources(resourcePaths, resourceResolver);
        }
        return assets;
    }


    public static List<Resource> getAssetResources(List<String> resourcePaths,
                                                   ResourceResolver resourceResolver) {
        List<Resource> listToReturn = new ArrayList<>();
        for (String path : resourcePaths) {
            Resource resource = resourceResolver.getResource(path);
            if (resource != null) {
                String resourceType = resource.getResourceType();
                //Checking if resources is of type folder
                if (StringUtils.equals(resourceType, DamConstants.NT_SLING_ORDEREDFOLDER)) {
                    //If resource is a Directory then getting its child resources whose type is dam:asset
                    SlingQuery damResources = $(resource).children(DamConstants.NT_DAM_ASSET);
                    listToReturn.addAll(damResources.asList());
                } else if (StringUtils.equals(resourceType, DamConstants.NT_DAM_ASSET)) {
                    //If resource is not a directory then add it to the list directly
                    listToReturn.add(resource);
                }
            }
        }
        return listToReturn;
    }

    public static String getFolderTitle(Resource folderResource){
        String folderTitle = folderResource.getName();

        Resource folderContentResource = folderResource.getChild(JcrConstants.JCR_CONTENT);
        if (folderContentResource != null) {
            folderTitle =
                folderContentResource.getValueMap()
                    .get(JcrConstants.JCR_TITLE, folderTitle);
        }
        return folderTitle;
    }

}





