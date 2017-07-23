package org.appling.xmindapi.good;

import org.appling.xmindapi.Sample;
import org.jetbrains.annotations.NotNull;
import org.xmind.core.*;
import org.xmind.core.marker.IMarker;
import org.xmind.core.marker.IMarkerGroup;
import org.xmind.core.marker.IMarkerResource;
import org.xmind.core.marker.IMarkerSheet;

import java.io.*;

/**
 * Seems like this should work, but IMarkerSheet.importFrom does not copy the resources for the markers in.
 * There is code in the implementation to do that, but it does not seem to work for some reason.
 * The xmind file will not contain the image resource and the marker will show with a broken image.
 */
public class CustomMarker implements Sample{
    public static final String COMMAND = "custommarker";
    private static final String OUTFILE = COMMAND+".xmind";


    @NotNull
    @Override
    public String getCommand() {
        return COMMAND;
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Adds a custom marker to the root topic";
    }

    @Override
    public void run(String[] args) throws Exception {
        IWorkbookBuilder builder = Core.getWorkbookBuilder();
        IWorkbook wb = builder.createWorkbook(OUTFILE);
        ISheet sh = wb.getPrimarySheet();

        ITopic rootTopic = sh.getRootTopic();
        rootTopic.setTitleText("This is a test");

        // Create Marker Group
        IMarkerSheet markerSheet = wb.getMarkerSheet();
        IMarkerGroup markerGroup = markerSheet.createMarkerGroup(true);
        markerGroup.setName("test");

        IMarker greenCheck = createMarker("GreenCheck", "markers/GreenCheck.png", wb, markerGroup);
        rootTopic.addMarker(greenCheck.getId());

        wb.save(OUTFILE);
    }


    private IMarker createMarker(String markerName, String iconPath, IWorkbook workbook, IMarkerGroup group) throws IOException {
        IMarker marker = null;
        IMarkerSheet ims = workbook.getMarkerSheet();
        File iconFile = new File(iconPath);
        InputStream is = new FileInputStream(iconFile);
        if (is != null) {
            marker = ims.createMarker(iconFile.getName());
            marker.setName(markerName);

            IMarkerResource resource = marker.getResource();
            OutputStream os = resource.getOutputStream();
            org.xmind.core.util.FileUtils.transfer(is, os, true);
        }
        group.addMarker(marker);
        return marker;
    }

}
