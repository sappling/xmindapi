package org.appling.xmindapi.good;

import org.appling.xmindapi.Sample;
import org.jetbrains.annotations.NotNull;
import org.xmind.core.*;
import org.xmind.core.marker.IMarker;
import org.xmind.core.marker.IMarkerGroup;
import org.xmind.core.marker.IMarkerSheet;

/**
 * Creates a simple map with the root and 30 more topics.
 * Assigns a balanced map clockwise structure
 */
public class SimpleTree implements Sample{
    public static final String COMMAND = "simpletree";
    private static final String OUTFILE = COMMAND+".xmind";


    @NotNull
    @Override
    public String getCommand() {
        return COMMAND;
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Creates a simple map two levels deep and sets the structure";
    }

    @Override
    public void run(String[] args) throws Exception {
        IWorkbookBuilder builder = Core.getWorkbookBuilder();
        IWorkbook wb = builder.createWorkbook(OUTFILE);
        ISheet sh = wb.getPrimarySheet();

        ITopic rootTopic = sh.getRootTopic();
        rootTopic.setTitleText("Root");

        // sets the layout to balanced map clockwise
        rootTopic.setStructureClass("org.xmind.ui.map.clockwise");

        for (char inner='A'; inner<'F'; inner++) {
            ITopic innerTopic = wb.createTopic();
            innerTopic.setTitleText("Node "+inner);
            rootTopic.add(innerTopic, ITopic.ATTACHED);

            for (int outer=1; outer<6; outer++) {
                ITopic outerTopic = wb.createTopic();
                outerTopic.setTitleText("Leaf "+outer);
                innerTopic.add(outerTopic);
            }
        }

        wb.save(OUTFILE);
    }
}
