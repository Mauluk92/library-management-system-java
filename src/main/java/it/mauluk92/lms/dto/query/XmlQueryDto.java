package it.mauluk92.lms.dto.query;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class XmlQueryDto {

    private String name;
    private String value;
    private String description;
}
