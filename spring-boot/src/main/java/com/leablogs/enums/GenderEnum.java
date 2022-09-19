package com.leablogs.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderEnum {
    Male("1", "男"),
    Female("0", "女");
    private String code;
    private String name;
}
