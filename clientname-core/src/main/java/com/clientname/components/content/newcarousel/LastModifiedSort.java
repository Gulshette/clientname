package com.clientname.components.content.newcarousel;

import java.util.Comparator;

public class LastModifiedSort implements Comparator<CarouselModel>{

    public int compare(CarouselModel c1,CarouselModel c2)
    {
    return c1.getLastModified().compareTo(c2.getLastModified());
    }

}
