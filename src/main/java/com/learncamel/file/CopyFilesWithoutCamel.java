package com.learncamel.file;

import java.io.*;

public class CopyFilesWithoutCamel {

    public static void main(String[] args) throws IOException {
        // Step 1: Create a file object to read the directories
        File inputDirectory = new File("data/input");
        File outputDirectory = new File("data/output");

        // Step 2: Read the files from the directory and iterate the files
        File[] files = inputDirectory.listFiles();

        // Step 3.1: Create an Output Stream to READ the files
        for (File source : files) {
            if (source.isFile()) {
                File dest = new File(
                        outputDirectory.getPath() + File.separator + source.getName()
                );


                // Step 3.2: Create an Output Stream to WRITE the files
                OutputStream oStream = new FileOutputStream(dest);
                byte[] buffer = new byte[(int) source.length()];
                FileInputStream iStream = new FileInputStream(source);
                iStream.read(buffer);
                try {
                    oStream.write(buffer);
                } finally {
                    oStream.close();
                    iStream.close();
                }
            }
        }

        // Step 4: Close the streams
    }
}
