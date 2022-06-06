package com.example.newtask15;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public class CardDriver implements Driver<Card>{

    private final SessionFactory sessionFactory;
    private Session session;

    public CardDriver(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Card card) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(card);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Card> readAll() {
        session = sessionFactory.openSession();
        List<Card> cards = session.createQuery("select i from Card i", Card.class).getResultList();
        for(Card card : cards){
            Hibernate.initialize(card.getManufactures());
        }
        session.close();
        return cards;
    }

    @Override
    public Card read(long id){
        session = sessionFactory.openSession();
        Card card = session.createQuery("from Card where id = :id", Card.class).setParameter("id", id).getSingleResult();
        Hibernate.initialize(card.getManufactures());
        session.close();
        return card;
    }

    /*@Override
    public Card read(long id){
        session = sessionFactory.openSession();
        Card card = session.createQuery("select id from Card where id=:id", Card.class).setParameter("id", id).getSingleResult();
        session.close();
        return card;
    }*/

    @Override
    public boolean update(Card card, long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update Card set card_number=:cn, code=:c where id = :id")
                .setParameter("id", id)
                .setParameter("c", card.getCard_number())
                .setParameter("cn", card.getCode());
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Card where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }
}
