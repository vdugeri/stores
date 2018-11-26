package com.danverem.stores.validators;

import com.danverem.stores.dtos.DesignationDTO;
import com.danverem.stores.models.Designation;
import com.danverem.stores.repositories.DesignationRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Stateless
@LocalBean
public class DesignationValidator {

    @Inject
    private DesignationRepository repository;

    public String validateCode(DesignationDTO designationDTO) {
        Map<String, Object> params = new HashMap<>();
        params.put("code", designationDTO.getCode());

        Designation designation = repository.findSingleWithNamedQuery(Designation.FIND_BY_CODE, params);

        if (designation != null) {
            return "Designation already exists";
        }

        return null;
    }
}
