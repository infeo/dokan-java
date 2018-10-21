package com.dokan.java.constants.microsoft;

import com.dokan.java.DokanyOperations;
import com.dokan.java.constants.EnumInteger;
import com.sun.jna.ptr.IntByReference;

/**
 * Enum of possible actions to perform on a file when the function {@link DokanyOperations.ZwCreateFile} is called.
 *
 * <p>
 * <b> Attention!</b>
 * The members of this enum are the kernel flags, not to be confused with the user flags in {@link CreationDisposition}. To convert them, use {@link com.dokany.java.migrated.NativeMethods#DokanMapKernelToUserCreateFileFlags(long, long, long, long, IntByReference, IntByReference, IntByReference)}. The relation between this two is also
 * descriped under this <a href="https://stackoverflow.com/questions/22552697/correspondence-between-procmon-and-createfile-disposition-options#22553544">link</a>.
 * </p>
 *
 * <p>
 * The following table shows the actions performed on a file for the given flag distinguishing if the file already exists or not:
 *
 * <table class="striped">
 * <caption style="display:none">additional options</caption>
 * <thead>
 * <tr>
 * <th scope="col">Option</th>
 * <th scope="col">Action if file exists</th>
 * <th scope="col">Action if file does not exist</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <th scope="row">FILE_SUPERSEDE</td>
 * <td>Replace the file.</td>
 * <td>Create the file.</td>
 * </tr>
 * <tr>
 * <th scope="row">FILE_CREATE</td>
 * <td>Return an error.</td>
 * <td>Create the file.</td>
 * </tr>
 * <tr>
 * <th scope="row">FILE_OPEN</td>
 * <td>Open the file.</td>
 * <td>Return an error.</td>
 * </tr>
 * <tr>
 * <th scope="row">FILE_OPEN_IF</td>
 * <td>Open the file.</td>
 * <td>Create the file.</td>
 * </tr>
 * <tr>
 * <th scope="row">FILE_OVERWRITE</td>
 * <td>Open the file, and overwrite it.</td>
 * <td>Return an error.</td>
 * </tr>
 * <tr>
 * <th scope="row">FILE_OVERWRITE_IF</td>
 * <td>Open the file, and overwrite it.</td>
 * <td>Create the file.</td>
 * </tr>
 * </tbody>
 * </table>
 * </p>
 *
 * @see <a href="https://docs.microsoft.com/en-us/windows-hardware/drivers/ddi/content/wdm/nf-wdm-zwcreatefile#parameters">Microsoft documentation of ZwCreateFile</a>
 * @see <a href="https://dokan-dev.github.io/dokany-doc/html/struct_d_o_k_a_n___o_p_e_r_a_t_i_o_n_s.html#a40c2f61e1287237f5fd5c2690e795183">Dokany documentation of ZwCreateFile</a>
 */
public enum CreateDisposition implements EnumInteger {

    FILE_SUPERSEDE(1),
    FILE_CREATE(2),
    FILE_OPEN(3),
    FILE_OPEN_IF(4),
    FILE_OVERWRITE(5),
    FILE_OVERWRITE_IF(6);

    private final int mask;

    CreateDisposition(int mask) {
        this.mask = mask;
    }

    @Override
    public int getMask() {
        return mask;
    }
}
