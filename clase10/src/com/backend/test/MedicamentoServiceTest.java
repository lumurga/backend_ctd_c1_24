package com.backend.test;

import com.backend.dao.impl.MedicamentoDaoH2;
import com.backend.entity.Medicamento;
import com.backend.service.MedicamentoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicamentoServiceTest {

    private MedicamentoService medicamentoService;

    @Test
    void deberiaInsertarYRetornarIdDeMedicamentoEnH2(){
        //Arrange
        medicamentoService = new MedicamentoService(new MedicamentoDaoH2());
        Medicamento medicamentoAPersistir = new Medicamento(2558, "Aspirina", "Bayer", 50, 1500);
        //Act
        Medicamento medicamentoPersistido = medicamentoService.registrarMedicamento(medicamentoAPersistir);
        //Assert
        assertNotNull(medicamentoPersistido.getId());

    }


}