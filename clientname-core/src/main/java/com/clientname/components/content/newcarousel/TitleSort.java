package com.clientname.components.content.newcarousel;

import java.util.Comparator;

public class TitleSort implements Comparator<CarouselModel> {

    public int compare(CarouselModel cc1,CarouselModel cc2)
    {
        return cc1.getImageTitle().compareTo(cc2.getImageTitle());
    }
}
