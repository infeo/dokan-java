package com.dokan.java;

import com.dokan.java.constants.dokany.MountOption;
import com.dokan.java.structure.EnumIntegerSet;

import java.nio.file.Path;

/**
 * An object which can be mounted in a filesystem.
 *
 * @author Armin Schrnek
 * @since 2.0
 */
public interface Mountable extends AutoCloseable {

    void mount(Path mountPoint, String volumeName, int volumeSerialnumber, boolean blocking, long timeout, long allocationUnitSize, long sectorSize, String UNCName, short threadCount, EnumIntegerSet<MountOption> options);

    void unmount();

}
