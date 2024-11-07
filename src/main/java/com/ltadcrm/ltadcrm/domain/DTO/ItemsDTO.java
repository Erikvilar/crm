package com.ltadcrm.ltadcrm.domain.DTO;

public record ItemsDTO(
    Long idPtr, 
    String nPtr, 
    String modeloPtr, 
    String marcaPtr, 
    String seriePtr, 
    String descriPtr, 
    String locPtr, 
    String usuario, 
    String tipo, 
    String nomeCdc, 
    String siglaCdc, 
    java.util.Date dataIniCdc, 
    java.util.Date dataFimCdc
) {}