package com.maxwell.mongodb.model;

public enum Status {

    UNPAID("PENDENTE"), PAID("PAGO");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
