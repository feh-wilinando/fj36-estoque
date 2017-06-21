package br.com.caelum.estoque.modelo;

import javax.persistence.*;

/**
 * Created by nando on 19/06/17.
 */
@Entity
public class ItemEstoque {


    @Id
    private String codigo;

    @Column(columnDefinition = "BLOB")
    private String xml;

    public ItemEstoque(String codigo, String xml) {
        this.codigo = codigo;
        this.xml = xml;
    }

    public String getXml() {
        return xml;
    }

    public String getCodigo() {
        return codigo;
    }
}
