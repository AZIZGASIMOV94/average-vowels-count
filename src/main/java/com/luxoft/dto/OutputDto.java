package com.luxoft.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputDto implements Serializable {

    private static final long serialVersionUUID =1l;

    private Set<String> set;
    private Integer wordLength;
    private Double average;
}
