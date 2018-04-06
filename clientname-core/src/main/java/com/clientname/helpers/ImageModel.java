package com.clientname.helpers;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import javax.annotation.PostConstruct;
import javax.inject.Inject;


@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImageModel {

  @Self
  SlingHttpServletRequest request;
  @Inject
  private String imagePath;
  private String alt;
  private String description;
  private String extension;

  @PostConstruct
  public void init() {
    AssetHelper.setImageModelFromResource(
        request.getResource().getResourceResolver().resolve(this.imagePath), this);
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public void setRequest(SlingHttpServletRequest request) {
    this.request = request;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;

  }

  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  public String getAlt() {
    return alt;
  }

  public void setAlt(String alt) {
    this.alt = alt;
  }

}
