package org.example.chronos.model;

import org.bouncycastle.util.encoders.Hex;
import org.example.chronos.exception.HashComputationException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

public class SHA256HashCalculator implements EntryHashCalculator{
    public String calculateEntryHash(
            Long sequenceNumber,
            Instant timeStamp,
            String prevHash,
            String eventType,
            String actor,
            String resource,
            String action,
            String payload
    ){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(
                    (sequenceNumber.toString() + timeStamp.toString() + prevHash + eventType + actor + resource + action + payload).getBytes(StandardCharsets.UTF_8)
            );

            return new String(Hex.encode(hash));
        } catch (NoSuchAlgorithmException e) {
            throw new HashComputationException("No SHA-256 algorithm exception", e, "SHA-256");
        }


    }
}

// Has created a custom exception for future exception handling convenience
// and for keeping exception loudness not to silently store corrupted entry.

