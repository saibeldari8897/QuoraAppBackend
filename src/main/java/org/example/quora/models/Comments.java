package org.example.quora.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long parentId;

    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedAt;


    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

}
