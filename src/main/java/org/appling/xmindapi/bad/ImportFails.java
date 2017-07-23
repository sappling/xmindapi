package org.appling.xmindapi.bad;

import org.appling.xmindapi.Sample;
import org.jetbrains.annotations.NotNull;
import org.xmind.core.*;
import org.xmind.core.marker.IMarker;
import org.xmind.core.marker.IMarkerGroup;
import org.xmind.core.marker.IMarkerSheet;

import java.io.IOException;

/**
 * Seems like this should work, but IMarkerSheet.importFrom does not copy the resources for the markers in.
 * There is code in the implementation to do that, but it does not seem to work for some reason.
 * The xmind file will not contain the image resource and the marker will show with a broken image.
 */
public class ImportFails implements Sample{
    public static final String COMMAND = "importfails";
    private static final String OUTFILE = COMMAND+".xmind";


    @NotNull
    @Override
    public String getCommand() {
        return COMMAND;
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Tries (unsuccesfully) to use IMakerSheet.importFrom to import markers";
    }

    @Override
    public void run(String[] args) throws Exception {
        IWorkbookBuilder builder = Core.getWorkbookBuilder();
        IWorkbook wb = builder.createWorkbook(OUTFILE);
        ISheet sh = wb.getPrimarySheet();

        ITopic rootTopic = sh.getRootTopic();
        rootTopic.setTitleText("This is a test");

        IMarkerSheet markerSheet = wb.getMarkerSheet();
        // note that the resources for the marker imported here is not really copied
        markerSheet.importFrom("markers");

        IMarkerGroup markerGroup = markerSheet.getMarkerGroups().get(0);
        IMarker greenCheck = markerGroup.getMarkers().get(0);

        rootTopic.addMarker(greenCheck.getId());

        wb.save(OUTFILE);
    }
}
