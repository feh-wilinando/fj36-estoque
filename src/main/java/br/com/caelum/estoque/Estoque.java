package br.com.caelum.estoque;

import br.com.caelum.estoque.modelo.Item;
import br.com.caelum.estoque.modelo.ItemEstoque;
import br.com.caelum.estoque.util.JPAUtil;
import br.com.caelum.estoque.util.Serializador;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by nando on 19/06/17.
 */
public class Estoque {

    public static void main(String[] args) {

        Item arq = new Item("ARQ", 5);
        Item soa = new Item("SOA", 2);
        Item tdd = new Item("TDD", 3);
        Item res = new Item("RES", 4);
        Item log = new Item("LOG", 3);
        Item web = new Item("WEB", 4);

        ItemEstoque itemArq = new ItemEstoque(arq.getCodigo(),Serializador.toXML(arq, Item.class));
        ItemEstoque itemSoa = new ItemEstoque(soa.getCodigo(),Serializador.toXML(soa, Item.class));
        ItemEstoque itemTdd = new ItemEstoque(tdd.getCodigo(),Serializador.toXML(tdd, Item.class));
        ItemEstoque itemRes = new ItemEstoque(res.getCodigo(),Serializador.toXML(res, Item.class));
        ItemEstoque itemLog = new ItemEstoque(log.getCodigo(),Serializador.toXML(log, Item.class));
        ItemEstoque itemWeb = new ItemEstoque(web.getCodigo(),Serializador.toXML(web, Item.class));

        EntityManager entityManager = new JPAUtil().getEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(itemArq);
        entityManager.persist(itemSoa);
        entityManager.persist(itemTdd);
        entityManager.persist(itemRes);
        entityManager.persist(itemLog);
        entityManager.persist(itemWeb);

        entityManager.getTransaction().commit();


        List<ItemEstoque> resultList = entityManager.createQuery("select i from ItemEstoque i", ItemEstoque.class).getResultList();


        resultList.stream().map(Estoque::getItem).forEach(System.out::println);

        entityManager.close();

    }

    private static Item getItem(ItemEstoque itemEstoque) {
        return Serializador.fromXML(itemEstoque.getXml(), Item.class);
    }


}
