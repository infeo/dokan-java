package com.dokan.java.structure;

import com.dokan.java.constants.EnumInteger;
import com.dokan.java.constants.dokany.MountOption;
import com.dokan.java.constants.microsoft.FileSystemFlag;

import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;

/**
 * Used to store multiple {@link EnumInteger} values such as {@link FileSystemFlag} and {@link MountOption}.
 *
 * @param <T> Type of {@link EnumInteger}
 */
public final class EnumIntegerSet<T extends Enum<T> & EnumInteger> extends AbstractSet<T> {

    private final EnumSet<T> elements;

    public EnumIntegerSet(final Class<T> clazz) {
        elements = EnumSet.noneOf(clazz);
    }

    public EnumIntegerSet(T first, T... others) {
        this.elements = EnumSet.of(first, others);
    }

    /**
     * Creates a set of enumInteger objects which corresponds to the bit flag given as an integer.
     *
     * @param intValue the integer value of the combined bitflag
     * @param allEnumValues all possible values of this enumInteger
     * @return a set of enumInteger values whose mask were actie in the intValue
     */
    public static <T extends Enum<T> & EnumInteger> EnumIntegerSet<T> enumSetFromInt(final int intValue, final T[] allEnumValues) {
        EnumIntegerSet<T> elements = new EnumIntegerSet<>(allEnumValues[0].getDeclaringClass());
        int remainingValues = intValue;
        for (T current : allEnumValues) {
            int mask = current.getMask();

            if ((remainingValues & mask) == mask) {
                elements.add(current);
                remainingValues -= mask;
            }
        }
        return elements;
    }

    public final void add(T item, T... items) {
        if (item == null) {
            throw new IllegalArgumentException("Adding null is not allowed.");
        } else {
            elements.add(item);
            for (final T it : items) {
                if (it != null) {
                    elements.add(it);
                }
            }
        }
    }

    public int toInt() {
        int toReturn = 0;
        for (final T current : elements) {
            toReturn |= current.getMask();
        }
        return toReturn;
    }

    @Override
    public boolean add(final T e) {
        return elements.add(e);
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public String toString() {
        return "EnumIntegerSet(elements=" + this.elements + ")";
    }
}
