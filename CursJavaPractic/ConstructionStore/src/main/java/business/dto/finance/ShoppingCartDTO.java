package business.dto.finance;


import business.dto.products.CementDTO;
import business.dto.products.PaintDTO;
import business.dto.products.ScrewdriverDTO;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class ShoppingCartDTO {

    @NotNull
    private Set<CementDTO> cementDTOSet;
    @NotNull
    private Set<PaintDTO> paintDTOSet;
    @NotNull
    private Set<ScrewdriverDTO> screwdriverDTOSet;

    public ShoppingCartDTO(){
    }

    public Set<CementDTO> getCementDTOSet() {
        return cementDTOSet;
    }

    public void setCementDTOSet(Set<CementDTO> cementDTOSet) {
        this.cementDTOSet = cementDTOSet;
    }

    public Set<PaintDTO> getPaintDTOSet() {
        return paintDTOSet;
    }

    public void setPaintDTOSet(Set<PaintDTO> paintDTOSet) {
        this.paintDTOSet = paintDTOSet;
    }

    public Set<ScrewdriverDTO> getScrewdriverDTOSet() {
        return screwdriverDTOSet;
    }

    public void setScrewdriverDTOSet(Set<ScrewdriverDTO> screwdriverDTOSet) {
        this.screwdriverDTOSet = screwdriverDTOSet;
    }

    @Override
    public String toString() {
        return "ShoppingCartDTO: " + "cementDTOSet: " + cementDTOSet + ", paintDTOSet: " + paintDTOSet + ", screwdriverDTOSet: " + screwdriverDTOSet ;
    }
}
