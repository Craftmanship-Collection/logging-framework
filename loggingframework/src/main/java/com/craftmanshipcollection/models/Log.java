package com.craftmanshipcollection.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Log {
    
    @Id
    private int id;
    private LocalDateTime timeStamp;
    private String message;


}
