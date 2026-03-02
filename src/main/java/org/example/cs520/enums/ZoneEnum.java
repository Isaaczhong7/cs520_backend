package org.example.cs520.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Getter
@AllArgsConstructor
public enum ZoneEnum {
    NEW_YORK("America/New_York", "NY");

    /**
     * timezone
     */
    private final String zone;

    private final String desc;
}
