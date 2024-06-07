package Emanuele_Mangano.Entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Archive {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D5");
    private EntityManager em = emf.createEntityManager();

    public void addCatalogItem(Catalog item) {
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    public void removeCatalogItem(long isbn) {
        em.getTransaction().begin();
        Catalog item = em.find(Catalog.class, isbn);
        if (item != null) {
            em.remove(item);
        }
        em.getTransaction().commit();
    }

    public Catalog searchByISBN(long isbn) {
        return em.find(Catalog.class, isbn);
    }

    public List<Catalog> searchByPublicationYear(int year) {
        TypedQuery<Catalog> query = em.createQuery("SELECT c FROM Catalog c WHERE c.publicationYear = :year", Catalog.class);
        query.setParameter("year", year);
        return query.getResultList();
    }

    public List<Book> searchByAuthor(String author) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.author = :author", Book.class);
        query.setParameter("author", author);
        return query.getResultList();
    }

    public List<Catalog> searchByTitle(String title) {
        TypedQuery<Catalog> query = em.createQuery("SELECT c FROM Catalog c WHERE c.title LIKE :title", Catalog.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }



}
