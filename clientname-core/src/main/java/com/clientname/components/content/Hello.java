package com.clientname.components.content;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.TextField;
import com.icfolson.aem.library.core.components.AbstractComponent;

import javax.inject.Inject;

/**
 * Created by icf2025814 on 19/03/18.
 */


public class Hello extends AbstractComponent {
    @DialogField(fieldLabel = "Test Title", fieldDescription = "This is the test title.")
    @TextField
    @Inject
    private String title;
}
