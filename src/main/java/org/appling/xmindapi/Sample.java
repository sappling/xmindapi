package org.appling.xmindapi;

import org.jetbrains.annotations.NotNull;

/**
 * Created by sappling on 7/23/2017.
 */
public interface Sample {
    /**
     * Gets the command to execute this sample
     * @return Command
     */
    @NotNull
    String getCommand();

    /**
     * Gets a short (one line) description of the sample
     * @return description
     */
    @NotNull
    String getDescription();


    /**
     * Run the sample
     * @param args remaining command line arguments (after the command)
     */
    void run(String args[]) throws Exception;
}
