package com.dokan.java.examples;

import com.dokan.java.DokanyFileSystemStub;
import com.dokan.java.FileSystemInformation;

/**
 * This filesystem shows the content of a given directory and it sub directories
 */
public class DirListingFileSystem extends DokanyFileSystemStub {

    public DirListingFileSystem(FileSystemInformation fileSystemInformation) {
        super(fileSystemInformation, false);
    }


}
