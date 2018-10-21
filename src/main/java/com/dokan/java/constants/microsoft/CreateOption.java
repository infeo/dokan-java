package com.dokan.java.constants.microsoft;

import com.dokan.java.constants.EnumInteger;
import com.dokan.java.structure.EnumIntegerSet;

/**
 * Enum of flags specifying the options to apply when the driver creates or opens the file.
 *
 * @see <a href="https://docs.microsoft.com/en-us/windows-hardware/drivers/ddi/content/wdm/nf-wdm-zwcreatefile">Microsofts documentation of ZwCreateFile</a>
 * @see <a href="https://dokan-dev.github.io/dokany-doc/html/struct_d_o_k_a_n___o_p_e_r_a_t_i_o_n_s.html#a40c2f61e1287237f5fd5c2690e795183">Dokany documentation of ZwCreateFile</a>
 */
public enum CreateOption implements EnumInteger {
    FILE_DIRECTORY_FILE(0x00000001),
    FILE_WRITE_THROUGH(0x00000002),
    FILE_SEQUENTIAL_ONLY(0x00000004),
    FILE_NO_INTERMEDIATE_BUFFERING(0x00000008),
    FILE_SYNCHRONOUS_IO_ALERT(0x00000010),
    FILE_SYNCHRONOUS_IO_NONALERT(0x00000020),
    FILE_NON_DIRECTORY_FILE(0x00000040),
    FILE_CREATE_TREE_CONNECTION(0x00000080),

    FILE_COMPLETE_IF_OPLOCKED(0x00000100),
    FILE_NO_EA_KNOWLEDGE(0x00000200),
    FILE_OPEN_REMOTE_INSTANCE(0x00000400),
    FILE_RANDOM_ACCESS(0x00000800),

    FILE_DELETE_ON_CLOSE(0x00001000),
    FILE_OPEN_BY_FILE_ID(0x00002000),
    FILE_OPEN_FOR_BACKUP_INTENT(0x00004000),
    FILE_NO_COMPRESSION(0x00008000);

    private final int mask;

    CreateOption(final int i) {
        mask = i;
    }

    public static EnumIntegerSet<CreateOption> fromInt(final int value) {
        return EnumIntegerSet.enumSetFromInt(value, values());
    }

    @Override
    public int getMask() {
        return mask;
    }

}
