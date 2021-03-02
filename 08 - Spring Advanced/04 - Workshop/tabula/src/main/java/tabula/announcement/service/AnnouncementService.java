package tabula.announcement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tabula.announcement.model.AnnouncementDTO;
import tabula.announcement.model.AnnouncementMapper;
import tabula.announcement.repository.AnnouncementRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;

    public List<AnnouncementDTO> findAll(){
        return announcementRepository
                .findAll()
                .stream()
                .map(AnnouncementMapper.INSTANCE::mapAnnouncementEntityToDto)
                .collect(Collectors.toList());


    }

}
