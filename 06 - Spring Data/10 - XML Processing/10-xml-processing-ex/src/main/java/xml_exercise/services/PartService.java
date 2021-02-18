package xml_exercise.services;

import xml_exercise.models.dto.PartSeedDto;
import xml_exercise.models.entities.Part;

import java.util.List;
import java.util.Set;

public interface PartService {
    void seedParts(List<PartSeedDto> partSeedDtos);
    Set<Part> getRandomParts();
}
