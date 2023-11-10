package com.junkfoood.contants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusContants {

    ACTIVE(1),
    INACTIVE(0);

    private final int status;

}
