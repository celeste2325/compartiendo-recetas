package com.distribuidas.recetas.modelo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "recetas")
public class Receta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idReceta")
    private Integer idReceta;
    @Basic
    @Column(name = "idUsuario", insertable = false, updatable = false)
    private Integer idUsuario;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "foto")
    private String foto;
    @Basic
    @Column(name = "porciones")
    private Integer porciones;
    @Basic
    @Column(name = "cantidadPersonas")
    private Integer cantidadPersonas;
    @Basic
    @Column(name = "idTipo", insertable = false, updatable = false)
    private Integer idTipo;
    @OneToMany(mappedBy = "recetasByIdReceta")
    private Collection<Calificacion> calificacionesByIdReceta;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "recetasByIdReceta")
    private Collection<Favorito> favoritosByIdReceta;

    @OneToMany(mappedBy = "recetasByIdReceta", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Foto> fotosByIdReceta;

    @OneToMany(mappedBy = "recetasByIdReceta", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Paso> pasosByIdReceta;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @JsonBackReference(value = "receta-usuario")
    private Usuario usuariosByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "idTipo", referencedColumnName = "idTipo")
    @JsonBackReference(value = "receta-tipo")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Tipo tiposByIdTipo;
    @OneToMany(mappedBy = "recetasByIdReceta", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Utilizado> utilizadosByIdReceta;

    @OneToOne(mappedBy = "recetaByIdReceta", cascade = CascadeType.ALL)
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private FechaReceta fechaRecetaByIdReceta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receta receta = (Receta) o;

        if (!Objects.equals(idReceta, receta.idReceta)) return false;
        if (!Objects.equals(idUsuario, receta.idUsuario)) return false;
        if (!Objects.equals(nombre, receta.nombre)) return false;
        if (!Objects.equals(descripcion, receta.descripcion)) return false;
        if (!Objects.equals(foto, receta.foto)) return false;
        if (!Objects.equals(porciones, receta.porciones)) return false;
        if (!Objects.equals(cantidadPersonas, receta.cantidadPersonas))
            return false;
        return Objects.equals(idTipo, receta.idTipo);
    }

    @Override
    public int hashCode() {
        int result = idReceta != null ? idReceta.hashCode() : 0;
        result = 31 * result + (idUsuario != null ? idUsuario.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (foto != null ? foto.hashCode() : 0);
        result = 31 * result + (porciones != null ? porciones.hashCode() : 0);
        result = 31 * result + (cantidadPersonas != null ? cantidadPersonas.hashCode() : 0);
        result = 31 * result + (idTipo != null ? idTipo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "idReceta=" + idReceta +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", porciones=" + porciones +
                ", fecha" + fechaRecetaByIdReceta +
                ", cantidadPersonas=" + cantidadPersonas +
                ", url foto=" + foto +
                ", fotosByIdReceta=" + fotosByIdReceta +
                ", pasosByIdReceta=" + pasosByIdReceta +
                ", tiposByIdTipo=" + tiposByIdTipo +
                ", utilizadosByIdReceta=" + utilizadosByIdReceta +
                '}';
    }
}
