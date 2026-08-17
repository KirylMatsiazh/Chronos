package org.example.chronos.exception;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class HashComputationException extends RuntimeException {
    private final String algorithmName;
    public HashComputationException(String message, Exception e, String algorithmName) {
        super(message, e);
        this.algorithmName = algorithmName;
    }
}
