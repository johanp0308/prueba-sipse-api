package com.apidian.apix.domain.repositories;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apidian.apix.persistence.entities.EmpresaEntity;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity,Long>{
    

    @Query(nativeQuery = true, value = "SELECT e.idempresa, e.razonsocial, SUM(CASE WHEN es.exitoso = 1 THEN 1 ELSE 0 END) AS exitosos, SUM(CASE WHEN d.idestado = 0 THEN 1 ELSE 0 END) AS fallidos FROM empresa e JOIN numeracion n ON e.idempresa = n.idempresa JOIN documento d ON n.idnumeracion = d.idnumeracion JOIN estado es ON es.idestado = d.idestado GROUP BY e.idempresa, e.razonsocial HAVING fallidos > exitosos")
    List<Object[]> findEmpresasDocumentosMoreFallidosThanExitosos();

    @Query(value = "SELECT e.idempresa, e.razonsocial, " +
                   "SUM(CASE WHEN n.prefijo = 'FAC' AND d.fecha BETWEEN ?1 AND ?2 THEN 1 ELSE 0 END) AS total_facturas, " +
                   "SUM(CASE WHEN n.prefijo = 'NDEB' AND d.fecha BETWEEN ?1 AND ?2 THEN 1 ELSE 0 END) AS total_notas_debito, " +
                   "SUM(CASE WHEN n.prefijo = 'NCRE' AND d.fecha BETWEEN ?1 AND ?2 THEN 1 ELSE 0 END) AS total_notas_credito " +
                   "FROM empresa e " +
                   "LEFT JOIN numeracion n ON e.idempresa = n.idempresa " +
                   "LEFT JOIN documento d ON n.idnumeracion = d.idnumeracion " +
                   "GROUP BY e.idempresa, e.razonsocial", nativeQuery = true)
    List<Object[]> countDocumentosByPrefijoAndFecha(String fechaInicio, String fechaFin);


    @Query(value = "SELECT e.idempresa, e.razonsocial, " +
                   "SUM(CASE WHEN es.exitoso = 1 THEN 1 ELSE 0 END) AS exitosos, " +
                   "SUM(CASE WHEN es.exitoso = 0 THEN 1 ELSE 0 END) AS fallidos " +
                   "FROM empresa e " +
                   "LEFT JOIN numeracion n ON e.idempresa = n.idempresa " +
                   "LEFT JOIN documento d ON n.idnumeracion = d.idnumeracion " +
                   "LEFT JOIN estado es ON d.idestado = es.idestado"+
                   "GROUP BY e.idempresa, e.razonsocial", nativeQuery = true)
    List<Object[]> countDocumentosByEstado();

    @Query(value = "SELECT e.idempresa, e.razonsocial, " +
                   "SUM(CASE WHEN es.exitoso = 0 THEN 1 ELSE 0 END) AS no_exitosos " +
                   "FROM empresa e " +
                   "LEFT JOIN numeracion n ON e.idempresa = n.idempresa " +
                   "LEFT JOIN documento d ON n.idnumeracion = d.idnumeracion " +
                   "LEFT JOIN estado es ON d.idestado = es.idestado " +
                   "GROUP BY e.idempresa, e.razonsocial " +
                   "HAVING no_exitosos > 3" , nativeQuery = true)
    List<Object[]> findEmpresasConMasTresDocumentosNoExitosos();

    @Query(nativeQuery = true, value = 
        "SELECT " +
            "e.idempresa, " +
            "e.razonsocial, " +
            "SUM(CASE WHEN d.numero NOT BETWEEN n.consecutivoinicial AND n.consecutivofinal THEN 1 " +
                    "WHEN d.fecha NOT BETWEEN n.vigenciainicial AND n.vigenciafinal THEN 1 " +
                    "ELSE 0 END) AS documentos_fuera_rango_vigencia " +
        "FROM " +
            "empresa e " +
            "LEFT JOIN numeracion n ON e.idempresa = n.idempresa " +
            "LEFT JOIN documento d ON n.idnumeracion = d.idnumeracion " +
        "GROUP BY " +
            "e.idempresa, " +
            "e.razonsocial")
    List<Object[]> countDocumentosFueraRangoVigencia();


    @Query(value = 
        "SELECT " +
            "e.idempresa, " +
            "e.razonsocial, " +
            "SUM(CASE " +
                "WHEN n.prefijo = 'FAC' THEN d.base + d.impuestos " +
                "WHEN n.prefijo = 'NDEB' THEN d.base + d.impuestos " +
                "ELSE 0 " +
            "END) AS total_dinero_recibido " +
        "FROM " +
            "empresa e " +
            "LEFT JOIN numeracion n ON e.idempresa = n.idempresa " +
            "LEFT JOIN documento d ON n.idnumeracion = d.idnumeracion " +
        "GROUP BY " +
            "e.idempresa, " +
            "e.razonsocial", nativeQuery = true)
    List<Object[]> calcularTotalDineroRecibido();


    @Query(value = 
        "SELECT " +
            "numero_completo, " +
            "COUNT(*) AS veces_repetido " +
        "FROM ( " +
            "SELECT " +
                "CONCAT(n.prefijo, d.numero) AS numero_completo " +
            "FROM " +
                "numeracion n " +
                "JOIN documento d ON n.idnumeracion = d.idnumeracion " +
        ") AS numeros_completos " +
        "GROUP BY " +
            "numero_completo " +
        "HAVING " +
            "COUNT(*) > 1", nativeQuery = true)
    List<Object[]> encontrarNumerosCompletosRepetidos();

}
