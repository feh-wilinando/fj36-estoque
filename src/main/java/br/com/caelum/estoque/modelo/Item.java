package br.com.caelum.estoque.modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by nando on 19/06/17.
 */
@XmlRootElement
public class Item {

    private String codigo;
    private Integer quantidade;

    public Item() {
    }

    public Item(String codigo, Integer quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo='" + codigo + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
