package pl.studies.sporthub.service;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class SimpleRowDto {

    private Long id;
    private String label;
}
