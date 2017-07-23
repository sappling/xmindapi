package org.appling.xmindapi.good;

import org.appling.xmindapi.Sample;
import org.jetbrains.annotations.NotNull;
import org.xmind.core.*;
import org.xmind.core.style.IStyle;
import org.xmind.core.style.IStyleSheet;
import org.xmind.ui.style.Styles;

/**
 * Creates a simple map and applies a markthrough style
 */
public class MarkthroughStyle implements Sample{
    public static final String COMMAND = "markthrough";
    private static final String OUTFILE = COMMAND+".xmind";


    @NotNull
    @Override
    public String getCommand() {
        return COMMAND;
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Demonstrates the markthrough style";
    }

    @Override
    public void run(String[] args) throws Exception {
        IWorkbookBuilder builder = Core.getWorkbookBuilder();
        IWorkbook wb = builder.createWorkbook(OUTFILE);
        ISheet sh = wb.getPrimarySheet();

        ITopic rootTopic = sh.getRootTopic();
        rootTopic.setTitleText("Root");

        ITopic one = wb.createTopic();
        one.setTitleText("One");
        rootTopic.add(one);

        ITopic two = wb.createTopic();
        two.setTitleText("Two");
        one.add(two);

        IStyle markthrough = addMarkthroughStyle(wb);
        two.setStyleId(markthrough.getId());

        wb.save(OUTFILE);
    }

    private static IStyle addMarkthroughStyle(IWorkbook workbook) {
        IStyleSheet ss = workbook.getStyleSheet();
        IStyle markthrough = ss.createStyle("topic");
        markthrough.setProperty(Styles.TextDecoration, Styles.TEXT_DECORATION_LINE_THROUGH);
        markthrough.setProperty(Styles.TEXT_DECORATION_LINE_THROUGH, "true");
        ss.addStyle(markthrough, IStyleSheet.NORMAL_STYLES);
        return markthrough;
    }
}
