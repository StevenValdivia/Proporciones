package org.example.infrastructure.database;

import org.example.domain.Proporcion;
import org.example.infrastructure.configuration.HibernateUtil;
import org.example.usecase.ProporcionRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProporcionRepositoryImpl implements ProporcionRepository {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Proporcion save(Proporcion proporcion) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            ProporcionEntity entity = new ProporcionEntity();
            entity.setTotal(proporcion.getTotal());
            entity.setMedida1(proporcion.getMedida1());
            entity.setMedida2(proporcion.getMedida2());
            entity.setSeparador(proporcion.getSeparador());

            if (proporcion.getId() == 0) { // Assuming 0 is not a valid ID
                session.save(entity);
            } else {
                entity.setId(proporcion.getId());
                session.merge(entity);
            }
            proporcion.setId(entity.getId()); // Update the Proporcion object with the ID

            session.getTransaction().commit();
        }
        return proporcion;
    }

    @Override
    public List<Proporcion> getAll() {
        try (Session session = sessionFactory.openSession()) {
            List<ProporcionEntity> entities = session.createQuery("FROM ProporcionEntity", ProporcionEntity.class).getResultList();
            return entities.stream().map(this::convertToDomain).toList();
        }
    }

    @Override
    public Proporcion getProporcionById(int id) {
        try (Session session = sessionFactory.openSession()) {
            ProporcionEntity entity = session.get(ProporcionEntity.class, id);
            return convertToDomain(entity);
        }
    }

    private Proporcion convertToDomain(ProporcionEntity entity) {
        if (entity == null) return null;
        Proporcion proporcion = new Proporcion();
        proporcion.setId(entity.getId());
        proporcion.setTotal(entity.getTotal());
        proporcion.setMedida1(entity.getMedida1());
        proporcion.setMedida2(entity.getMedida2());
        proporcion.setSeparador(entity.getSeparador());
        return proporcion;
    }
}
