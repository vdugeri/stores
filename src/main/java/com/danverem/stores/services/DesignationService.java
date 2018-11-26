package com.danverem.stores.services;

import com.danverem.stores.dtos.DesignationDTO;
import com.danverem.stores.mappers.DesignationMapper;
import com.danverem.stores.repositories.DesignationRepository;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Stateless
@LocalBean
public class DesignationService {

    @Inject
    private DesignationRepository repository;


    /**
     * @author Verem Dugeri <verem.dugeri@gmail.com>
     *
     * @return list of designations
     */
    public List<DesignationDTO> getAll() {
        return DesignationMapper.mapTo(repository.findAll());
    }

    /**
     * @author Verem Dugeri <verem.dugeri@gmail.com>
     *
     * @param designationDTO
     *
     * @return created designation
     */
    public DesignationDTO create(DesignationDTO designationDTO) {
        return DesignationMapper.mapTo(
            repository.create(
                DesignationMapper.mapTo(
                    designationDTO
                )
            )
        );
    }

    /**
     * @author Verem Dugeri <verem.dugeri@gmail.com>
     *
     * @param ID designation id
     *
     * @return found designation
     */
    public Optional<DesignationDTO> find(Long ID) {
        return Optional.ofNullable(DesignationMapper.mapTo(repository.find(ID)));
    }

    /**
     * @author Verem Dugeri <verem.dugeri@gmail.com>
     *
     * @param ID
     * @param designationDTO
     *
     * @return updated Designation or null if it does not exist.
     */
    public Optional<DesignationDTO> edit(Long ID, DesignationDTO designationDTO) {
        Optional<DesignationDTO> designation = find(ID);

        if (designation.isPresent()) {
            return Optional.ofNullable(
                DesignationMapper.mapTo(
                    repository.edit(
                        DesignationMapper.mapTo(
                            designationDTO
                        )
                    )
                )
            );
        }

        return Optional.empty();
    }

    /**
     * @author Verem Dugeri <verem.dugeri@gmail.com>
     *
     * @param ID
     */
    public void delete(Long ID) {
        repository.delete(ID);
    }
}
