package com.apidian.apix.persistence.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "numeracion")
public class NumeracionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnumeracion")
    private Long id;


    @Column(nullable = false, length = 8)
    private String prefijo;

    @Column(nullable = false)
    private int consecutivoinicial;

    @Column(nullable = false)
    private int consecutivofinal;

    @Column(nullable = false)
    private Date vigenciainicial;

    @Column(nullable = false)
    private Date vigenciafinal;


    @OneToMany(mappedBy = "numeracion", cascade = CascadeType.ALL)
    private List<DocumentoEntity> documentos;   

    @ManyToOne()
    @JoinColumn(name = "idempresa", nullable = false)
    private EmpresaEntity empresa;

    @ManyToOne()
    @JoinColumn(name = "idtipodocumento", nullable = false)
    private TipoDocumentoEntity tipoDocumento;


    public NumeracionEntity() {
    }

    public NumeracionEntity(Long id, String prefijo, int consecutivoinicial, int consecutivofinal, Date vigenciainicial, Date vigenciafinal, List<DocumentoEntity> documentos, EmpresaEntity empresa, TipoDocumentoEntity tipoDocumento) {
        this.id = id;
        this.prefijo = prefijo;
        this.consecutivoinicial = consecutivoinicial;
        this.consecutivofinal = consecutivofinal;
        this.vigenciainicial = vigenciainicial;
        this.vigenciafinal = vigenciafinal;
        this.documentos = documentos;
        this.empresa = empresa;
        this.tipoDocumento = tipoDocumento;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrefijo() {
        return this.prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public int getConsecutivoinicial() {
        return this.consecutivoinicial;
    }

    public void setConsecutivoinicial(int consecutivoinicial) {
        this.consecutivoinicial = consecutivoinicial;
    }

    public int getConsecutivofinal() {
        return this.consecutivofinal;
    }

    public void setConsecutivofinal(int consecutivofinal) {
        this.consecutivofinal = consecutivofinal;
    }

    public Date getVigenciainicial() {
        return this.vigenciainicial;
    }

    public void setVigenciainicial(Date vigenciainicial) {
        this.vigenciainicial = vigenciainicial;
    }

    public Date getVigenciafinal() {
        return this.vigenciafinal;
    }

    public void setVigenciafinal(Date vigenciafinal) {
        this.vigenciafinal = vigenciafinal;
    }

    public List<DocumentoEntity> getDocumentos() {
        return this.documentos;
    }

    public void setDocumentos(List<DocumentoEntity> documentos) {
        this.documentos = documentos;
    }

    public EmpresaEntity getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

    public TipoDocumentoEntity getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public NumeracionEntity id(Long id) {
        setId(id);
        return this;
    }

    public NumeracionEntity prefijo(String prefijo) {
        setPrefijo(prefijo);
        return this;
    }

    public NumeracionEntity consecutivoinicial(int consecutivoinicial) {
        setConsecutivoinicial(consecutivoinicial);
        return this;
    }

    public NumeracionEntity consecutivofinal(int consecutivofinal) {
        setConsecutivofinal(consecutivofinal);
        return this;
    }

    public NumeracionEntity vigenciainicial(Date vigenciainicial) {
        setVigenciainicial(vigenciainicial);
        return this;
    }

    public NumeracionEntity vigenciafinal(Date vigenciafinal) {
        setVigenciafinal(vigenciafinal);
        return this;
    }

    public NumeracionEntity documentos(List<DocumentoEntity> documentos) {
        setDocumentos(documentos);
        return this;
    }

    public NumeracionEntity empresa(EmpresaEntity empresa) {
        setEmpresa(empresa);
        return this;
    }

    public NumeracionEntity tipoDocumento(TipoDocumentoEntity tipoDocumento) {
        setTipoDocumento(tipoDocumento);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NumeracionEntity)) {
            return false;
        }
        NumeracionEntity numeracionEntity = (NumeracionEntity) o;
        return Objects.equals(id, numeracionEntity.id) && Objects.equals(prefijo, numeracionEntity.prefijo) && consecutivoinicial == numeracionEntity.consecutivoinicial && consecutivofinal == numeracionEntity.consecutivofinal && Objects.equals(vigenciainicial, numeracionEntity.vigenciainicial) && Objects.equals(vigenciafinal, numeracionEntity.vigenciafinal) && Objects.equals(documentos, numeracionEntity.documentos) && Objects.equals(empresa, numeracionEntity.empresa) && Objects.equals(tipoDocumento, numeracionEntity.tipoDocumento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prefijo, consecutivoinicial, consecutivofinal, vigenciainicial, vigenciafinal, documentos, empresa, tipoDocumento);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", prefijo='" + getPrefijo() + "'" +
            ", consecutivoinicial='" + getConsecutivoinicial() + "'" +
            ", consecutivofinal='" + getConsecutivofinal() + "'" +
            ", vigenciainicial='" + getVigenciainicial() + "'" +
            ", vigenciafinal='" + getVigenciafinal() + "'" +
            ", documentos='" + getDocumentos() + "'" +
            ", empresa='" + getEmpresa() + "'" +
            ", tipoDocumento='" + getTipoDocumento() + "'" +
            "}";
    }
    

}
