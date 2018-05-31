package co.edu.uniandes.isis2503.muebles.logic.dto;

import java.util.List;

/**
 *
 * @author Jj.alarcon10
 */
public class MueblePageDTO {

    private Long totalRecords;
    private List<MuebleDTO> muebles;

    public MueblePageDTO() {

    }

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<MuebleDTO> getMuebles() {
        return muebles;
    }

    public void setMuebles(List<MuebleDTO> muebles) {
        this.muebles = muebles;
    }
}
