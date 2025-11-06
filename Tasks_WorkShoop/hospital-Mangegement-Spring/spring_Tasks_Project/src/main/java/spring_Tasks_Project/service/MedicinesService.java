package spring_Tasks_Project.service;

import spring_Tasks_Project.dto.MedicinesDto;

import java.util.List;

public interface MedicinesService {

    MedicinesDto saveMedicines(MedicinesDto medicinesDto);

    MedicinesDto findMedicinesById(Long id);

    void deleteMedicinesById(Long id);

    MedicinesDto updateMedicines(MedicinesDto medicinesDto);

    List<MedicinesDto> findAllMedicines();
}
