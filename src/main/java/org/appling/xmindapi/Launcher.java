package org.appling.xmindapi;

import org.appling.xmindapi.bad.ImportFails;
import org.appling.xmindapi.good.CustomMarker;
import org.appling.xmindapi.good.MarkthroughStyle;
import org.appling.xmindapi.good.SimpleTree;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sappling on 7/23/2017.
 */
public class Launcher {
    public static void main(String args[]) {
        List<Sample> samples = new ArrayList<>();

        samples.add(new SimpleTree());
        samples.add(new CustomMarker());
        samples.add(new MarkthroughStyle());
        samples.add(new ImportFails());

        if (args.length == 0) {
            printHelp(samples);
            System.exit(-1);
        }

        String command = args[0];
        String remaining[] = Arrays.copyOfRange(args, 1, args.length);

        Sample sample = findSample(samples, command);

        try {
            sample.run(remaining);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        System.out.println("Done!");
    }

    private static void printHelp(List<Sample> samples) {
        System.out.println("Missing argument.  Please specify a sample to run.");
        for (Sample sample : samples) {
            System.out.format("%s - %s\n",sample.getCommand(), sample.getDescription());
        }
    }

    @Nullable
    private static Sample findSample(List<Sample> samples, @NotNull String command) {
        for (Sample sample : samples) {
            if (sample.getCommand().equalsIgnoreCase(command)) {
                return sample;
            }
        }
        return null;
    }
}
