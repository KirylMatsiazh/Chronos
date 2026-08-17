package org.example.chronos.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

@ExtendWith(MockitoExtension.class)
public class SHA256HashCalculatorTest {

    private final SHA256HashCalculator calculator = new SHA256HashCalculator();

    @Test
    void EntryHashSimilarInputSimilarOutput(){

        String firstHash = calculator.calculateEntryHash(
                1L,
                Instant.MIN,
                "prevHash",
                "eventType",
                "actor",
                "resource",
                "action",
                "payload"
        );
        String secondHash = calculator.calculateEntryHash(
                1L,
                Instant.MIN,
                "prevHash",
                "eventType",
                "actor",
                "resource",
                "action",
                "payload"
        );

        Assertions.assertEquals(firstHash, secondHash);
    };

    @Test
    void EntryHashDifferentInputDifferentOutput(){

        String firstHash = calculator.calculateEntryHash(
                1L,
                Instant.MIN,
                "prevHash",
                "eventType",
                "actor",
                "resource",
                "action",
                "payload"
        );

        String secondHash = calculator.calculateEntryHash(
                1L,
                Instant.MIN,
                "prevHash",
                "eventType",
                "differentActor",
                "resource",
                "action",
                "payload"
        );
        String thirdHash = calculator.calculateEntryHash(
                1L,
                Instant.MIN,
                "differentPrevHash",
                "eventType",
                "actor",
                "resource",
                "action",
                "payload"
        );

        Assertions.assertNotEquals(firstHash, secondHash);
        Assertions.assertNotEquals(firstHash, thirdHash);
    }

    @Test
    void EntryHashKnownInputOutputVector(){

        String firstHash = calculator.calculateEntryHash(
                1L,
                Instant.MIN,
                "prevHash",
                "eventType",
                "actor",
                "resource",
                "action",
                "payload"
        );
        String secondHash = "9123a85f2bfdb04fc908ab028d88d98e9c8747040da772bb55efd08984d9f615";

        Assertions.assertEquals(firstHash, secondHash);
    };
}
