package com.backend.clinicaodontologica.dto.entrada;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@ApiModel(description = "Estructura de datos de entrada para el domicilio del paciente")
public class DomicilioEntradaDto {

    @NotNull(message = "El campo calle no puede ser nulo")
    @NotBlank(message = "El campo calle no puede estar en blanco")

    private String calle;

    //@NotNull(message = "El campo numero no puede ser nulo")
    @Positive(message = "El numero no puede ser nulo o menor a cero")
    @Digits(integer = 8, fraction = 0, message = "El número debe tener como máximo 8 dígitos")
    private int numero;

    @NotNull(message = "El campo localidad no puede ser nulo")
    @NotBlank(message = "El campo localidad no puede estar en blanco")
    private String localidad;

    @NotNull(message = "El campo provincia no puede ser nulo")
    @NotBlank(message = "El campo provincia no puede estar en blanco")
    @ApiModelProperty(notes = "Hace referencia a la provincia correspondiente al domicilio. Opciones: CO, BA, CH")
    private String provincia;



    public DomicilioEntradaDto() {
    }

    public DomicilioEntradaDto(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
