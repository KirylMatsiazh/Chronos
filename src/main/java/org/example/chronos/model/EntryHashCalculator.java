package org.example.chronos.model;

import java.security.NoSuchAlgorithmException;
import java.time.Instant;

public interface EntryHashCalculator {
    String calculateEntryHash(
            Long sequenceNumber,
            Instant timeStamp,
            String prevHash,
            String eventType,
            String actor,
            String resource,
            String action,
            String payload
    );
}
