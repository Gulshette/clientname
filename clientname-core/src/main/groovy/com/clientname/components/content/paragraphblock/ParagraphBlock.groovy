package com.clientname.components.content.paragraphblock

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.Option
import com.citytechinc.cq.component.annotations.widgets.Selection
import com.citytechinc.cq.component.annotations.widgets.TextField
import com.clientname.annotations.DefaultRichTextEditor
import com.clientname.annotations.NilayaComponent
import com.clientname.constants.NilayaConstant
import com.icfolson.aem.library.api.components.annotations.AutoInstantiate
import com.icfolson.aem.library.core.components.AbstractComponent

import javax.inject.Inject

@NilayaComponent(value = "Paragraph Block", inPlaceEditingEditorType = "text", inPlaceEditingActive = true,
        inPlaceEditingConfigPath = "../../dialog/items/tabs/items/ParagraphBlock/items/text",
        name="paragraphblock",
        group = NilayaConstant.GROUP_NAME)

@AutoInstantiate
class ParagraphBlock extends AbstractComponent {

    @DialogField(fieldLabel = "Select Variant")
    @Selection(options = [
            @Option(text = "Home page paragraph block", value = "homePageParagraphBlock", selected = true),
            @Option(text = "Story paragraph", value = "storyParagraph")], type = Selection.SELECT)
    @Inject
    String variant

    @DialogField(fieldLabel = "Paragraph Block Title", ranking = 1D)
    @TextField
    @Inject
    String title;

    @DialogField(fieldLabel = "Paragraph Block Sub Title", ranking = 2D)
    @TextField
    @Inject
    String subTitle;

    @DialogField(fieldLabel = "Paragraph Block Description", ranking = 3D)
    @DefaultRichTextEditor
    @Inject
    String description;
}