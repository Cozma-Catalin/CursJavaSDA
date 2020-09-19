package business.service;


import business.dto.SectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistance.dao.SectionDAO;
import persistance.entities.Section;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService {
    @Autowired
    SectionDAO sectionDAO;

    public void insertSectionDTO(SectionDTO sectionDTO){
        Section section = new Section();
        section.setName(sectionDTO.getName());
        sectionDAO.insertSection(section);
    }

    public List<SectionDTO> findSectionDTO(){
        List<Section> sectionList = sectionDAO.findSection();
        List<SectionDTO> sectionDTOList = new ArrayList<SectionDTO>();

        for(Section section:sectionList){
            SectionDTO sectionDTO = new SectionDTO();
            sectionDTO.setName(section.getName());
            sectionDTOList.add(sectionDTO);
        }

        return sectionDTOList;
    }

}
