package persistance.dao;

import business.config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistance.entities.Section;

import javax.persistence.Query;
import java.util.List;
@Repository
public class SectionDAO {


    public void insertSection(Section section){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(section);
        session.getTransaction().commit();
        session.close();
    }

    public List<Section> findSection(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findSectionQuery = session.createNamedQuery("findSection");
        List<Section> sectionList = findSectionQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return sectionList;
    }
}
