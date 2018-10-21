package com.dokan.java.constants;

/**
 * An EnumInteger is an object that is represented by an 32bit integer value. TODO: Maybe make this an abstract class
 */
public interface EnumInteger {

    /**
     * @param value
     * @param enumValues
     * @param <T>
     * @return
     */
    static <T extends EnumInteger> T enumFromInt(final int value, final T[] enumValues) {
        for (final T current : enumValues) {
            if (value == current.getMask()) {
                return current;
            }
        }
        throw new IllegalArgumentException("Invalid int value: " + value);
    }

    /**
     * Returns the 32bit integer value which represents this object.
     *
     * @return the value representing this object.
     */
    int getMask();

}
