package spring_Tasks_Project.service;

import spring_Tasks_Project.dto.PrescriptionsDto;

import java.util.List;

public interface PrescriptionsService {



        PrescriptionsDto savePrescriptions(PrescriptionsDto prescriptionsDto);

        PrescriptionsDto findPrescriptionsById(Long id);

        void deletePrescriptionsById(Long id);

        PrescriptionsDto updatePrescriptions(PrescriptionsDto prescriptionsDto);

        List<PrescriptionsDto> findAllPrescriptions();
}
