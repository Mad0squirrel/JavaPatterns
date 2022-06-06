package com.example.newtask15;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CardDriver implements Driver<Card>{
    EntityManager em;
    private final SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public CardDriver(SessionFactory sessionFactory, EntityManager em) {
        this.em = em;
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Card> readAll() {
        session = sessionFactory.openSession();
        List<Card> cards = session.createQuery("select i from Card i", Card.class).getResultList();
        for (Card card : cards) Hibernate.initialize(card.getManufactures());
        session.close();
        return cards;
    }

    @Override
    public Card read(long id) {
        session = sessionFactory.openSession();
        Card card = session.createQuery("from Card where id = :id", Card.class).setParameter("id", id).getSingleResult();
        Hibernate.initialize(card.getManufactures());
        session.close();
        return card;
    }

    public List<Card> findCardsByCode(int code) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Card> cq = cb.createQuery(Card.class);

        Root<Card> card = cq.from(Card.class);
        Predicate addressPredicate = cb.equal(card.get("code"), code);
        cq.where(addressPredicate);
        TypedQuery<Card> query = em.createQuery(cq);
        return query.getResultList();
    }
}
