package com.dokan.java;

import com.dokan.java.structure.DokanOptions;

import java.nio.file.Path;

/**
 * An object which can be mounted in a filesystem.
 *
 * @author Armin Schrnek
 * @since 2.0
 */
public interface Mountable {

    void mount(Path mountPoint, String volumeName, int volumeSerialnumber, DokanOptions dokanOptions, boolean blocking);

    void unmount();

}
