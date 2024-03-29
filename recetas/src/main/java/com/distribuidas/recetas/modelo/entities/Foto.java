package com.distribuidas.recetas.modelo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "fotos")
public class Foto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idfoto")
    private Integer idfoto;
    /*@Basic
    @Column(name = "idReceta", insertable = false, updatable = false)
    private Integer idReceta;*/
    @Basic
    @Column(name = "urlFoto")
    private String urlFoto;
    @Basic
    @Column(name = "extension")
    private String extension;
    @ManyToOne
    @JoinColumn(name = "idReceta", referencedColumnName = "idReceta", nullable = false)
    @JsonBackReference(value = "receta-foto")
    private Receta recetasByIdReceta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Foto foto = (Foto) o;

        if (!Objects.equals(idfoto, foto.idfoto)) return false;
        //if (!Objects.equals(idReceta, foto.idReceta)) return false;
        if (!Objects.equals(urlFoto, foto.urlFoto)) return false;
        return Objects.equals(extension, foto.extension);
    }

    @Override
    public int hashCode() {
        int result = idfoto != null ? idfoto.hashCode() : 0;
        //result = 31 * result + (idReceta != null ? idReceta.hashCode() : 0);
        result = 31 * result + (urlFoto != null ? urlFoto.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        return result;
    }
}
