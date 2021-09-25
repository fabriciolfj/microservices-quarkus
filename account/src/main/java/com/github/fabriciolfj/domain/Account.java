package com.github.fabriciolfj.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Account {

    private String code;
    private String customer;
    private List<Extract> extracts;

    public void generatedCode() {
        this.code = UUID.randomUUID().toString();
    }
}
