package org.example.quora.dtos;


import jdk.jfr.Name;
import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private String userName;

    private String Email;

}
