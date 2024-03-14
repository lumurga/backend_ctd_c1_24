package com.backend.clinicaodontologica.dto.salida;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class TurnoSalidaDto {
    private Long id;
    private PacienteSalidaDto pacienteSalidaDto;
    private OdontologoSalidaDto odontologoSalidaDto;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime fechaYHora;

    public TurnoSalidaDto() {
    }

    public TurnoSalidaDto(Long id, PacienteSalidaDto pacienteSalidaDto, OdontologoSalidaDto odontologoSalidaDto, LocalDateTime fechaYHora) {
        this.id = id;
        this.pacienteSalidaDto = pacienteSalidaDto;
        this.odontologoSalidaDto = odontologoSalidaDto;
        this.fechaYHora = fechaYHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PacienteSalidaDto getPacienteSalidaDto() {
        return pacienteSalidaDto;
    }

    public void setPacienteSalidaDto(PacienteSalidaDto pacienteSalidaDto) {
        this.pacienteSalidaDto = pacienteSalidaDto;
    }

    public OdontologoSalidaDto getOdontologoSalidaDto() {
        return odontologoSalidaDto;
    }

    public void setOdontologoSalidaDto(OdontologoSalidaDto odontologoSalidaDto) {
        this.odontologoSalidaDto = odontologoSalidaDto;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}
