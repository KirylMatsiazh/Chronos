package org.example.chronos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Entry {

    @Id
    @GeneratedValue
    private UUID id;

    private Long sequenceNumber;

    private String hmacSignature;
    private Instant timestamp;
    private String prevHash;
    private String entryHash;


    private String eventType;
    private String actor;
    private String resource;
    private String action;
    private String sourceService;
    private String payload;
}

//JPA

//The class must not be declared final. No methods or persistent instance variables must be declared final.
//JPA implementations use proxies in front of entities to manage for example:
// Lazy loading. As a final class cannot be extended, a proxy cannot be built.

//The class must have a public or protected, no-argument constructor.
//These kind of frameworks and others in order to create new objects use ```Class.newInstance()``
// that is the reason why a no arg constructor is needed.

//Persistent instance variables must be declared private, protected, or package-private.
//Being only accessible through accessor or business methods allow interception in proxies.



