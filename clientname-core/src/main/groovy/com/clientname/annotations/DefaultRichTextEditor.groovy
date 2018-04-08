package com.clientname.annotations

import com.citytechinc.cq.component.annotations.DialogField
import com.citytechinc.cq.component.annotations.widgets.Popover
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor
import com.citytechinc.cq.component.annotations.widgets.ToolbarConfig
import com.citytechinc.cq.component.annotations.widgets.rte.*
import groovy.transform.AnnotationCollector

@DialogField(fieldLabel = "Text")
@RichTextEditor(
        format = @Format,
        justify = @Justify,
        lists = @Lists,
        edit = @Edit,
        undo = @Undo,
        findreplace = @FindReplace,
        paraformat = [
                @ParaFormat(tag = "p", description = "Paragraph"),
                @ParaFormat(tag = "h2", description = "Heading 2"),
                @ParaFormat(tag = "h3", description = "Heading 3"),
                @ParaFormat(tag = "h4", description = "Heading 4"),
                @ParaFormat(tag = "h5", description = "Heading 5"),
                @ParaFormat(tag = "h6", description = "Heading 6")
        ],
        links = @Links,
        image = @Image,
        misctools = @MiscTools(sourceedit = false),
        subsuperscript = @SubSuperscript,
        styles = [
                @Style(cssName = "text-content", text = "Story Paragraph font")
        ],
        uiSettings = @UISettings(inline = @ToolbarConfig(
                toolbars = [
                        ToolbarConfig.FORMAT_BOLD,
                        ToolbarConfig.FORMAT_ITALIC,
                        ToolbarConfig.FORMAT_UNDERLINE,
                        ToolbarConfig.PARAFORMAT,
                        ToolbarConfig.IMAGE_IMAGEPROPS,
                        "#justify",
                        "#lists",
                        "#styles",
                        ToolbarConfig.LINKS_MODIFYLINK,
                        ToolbarConfig.LINKS_UNLINK,
                        ToolbarConfig.MISCTOOLS_SPECIALCHARS,
                        "-",
                        ToolbarConfig.FINDREPLACE_FIND,
                        ToolbarConfig.FINDREPLACE_REPLACE,
                        "-",
                        ToolbarConfig.UNDO_UNDO,
                        ToolbarConfig.UNDO_REDO
                ], popovers = [
                        @Popover(ref = "justify", items = [
                                ToolbarConfig.JUSTIFY_JUSITFYLEFT,
                                ToolbarConfig.JUSTIFY_JUSITFYCENTER,
                                ToolbarConfig.JUSTIFY_JUSITFYRIGHT
                        ]),
                        @Popover(ref = "lists", items = [
                                ToolbarConfig.LISTS_UNORDERED,
                                ToolbarConfig.LISTS_ORDERED,
                                ToolbarConfig.LISTS_OUTDENT,
                                ToolbarConfig.LISTS_INDENT
                        ]),
                        @Popover(ref = "styles", items = [
                                "styles:getStyles:styles-pulldown"
                        ]),
                        @Popover(ref = "paraformat", items = [
                                "paraformat:getFormats:paraformat-pulldown"
                        ])
                ])
        ))

@AnnotationCollector
@interface DefaultRichTextEditor {

}