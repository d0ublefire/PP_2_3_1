package hiber.dao;

import hiber.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   public User getUser(long id) {
      return entityManager.find(User.class, id);
   }


   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      return entityManager.createQuery("from User").getResultList();
   }

   @Override
   public void update(User user) {
      entityManager.merge(user);
   }

//   @Override
//   public void remove(long id) {
//      entityManager.remove(entityManager.find(User.class, id));
//   }

   @Override
   public void remove(long id) {
      entityManager.remove(getUser(id));
   }

}
