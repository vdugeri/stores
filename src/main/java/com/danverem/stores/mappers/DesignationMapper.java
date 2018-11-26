package com.danverem.stores.mappers;

import com.danverem.stores.dtos.DesignationDTO;
import com.danverem.stores.models.Designation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DesignationMapper {

    public static Designation mapTo(DesignationDTO designationDTO) {
        if (designationDTO == null) {
            return null;
        }

        Designation designation = new Designation();
        designation.setCode(designationDTO.getCode());
        designation.setID(designationDTO.getID());
        designation.setName(designationDTO.getName());

        return designation;
    }


    public static DesignationDTO mapTo(Designation designation) {
        if (designation == null) {
            return null;
        }

        return new DesignationDTO(
            designation.getCode(),
            designation.getName(),
            designation.getID()
        );
    }


    public static List<DesignationDTO> mapTo(List<Designation> designations) {
        if (designations.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return designations.stream()
            .map(designation -> mapTo(designation))
            .filter(designationDTO -> designationDTO != null)
            .collect(Collectors.toList());
    }
}
