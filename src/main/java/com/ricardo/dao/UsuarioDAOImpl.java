package com.ricardo.dao;

import com.ricardo.model.Usuario;
import com.ricardo.utileria.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ricardo
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    public boolean save(Usuario c) {
        boolean bandera;
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            sesion.save(c);
            tx.commit();
            //sesion.close();
            bandera = true;
        } catch (Exception ex) {
            bandera = false;
            tx.rollback();
            ex.printStackTrace();
            throw new RuntimeException("NO SE PUDO INSERTAR");
        } finally {
            sesion.close();
        }
        return bandera;
    }

    public boolean delete(int id) {
        boolean bandera;
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            Usuario contactos = (Usuario) sesion.get(Usuario.class, id);
            sesion.delete(contactos);
            tx.commit();
            sesion.close();
            bandera = true;
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
            bandera = false;
            throw new RuntimeException("NO SE PUDO BORRAR");
        }
        return bandera;
    }

    public List showAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Query query = sesion.createQuery("from Usuario where estado='ACTIVO'");
        List<Usuario> lista = query.list();
        return lista;

    }

    public Usuario buscarContactos(int id) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Usuario c = (Usuario) sesion.get(Usuario.class, id);
        
        return c;

    }

    public void update(Usuario u) {
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            sesion.update(u);
            tx.commit();
            sesion.close();

        } catch (Exception ex) {

        }
    }

    public boolean edit(Usuario c) {
        boolean bandera;
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            Usuario pbuscar = (Usuario) sesion.get(Usuario.class, c.getId());
            pbuscar.setUsuario(c.getUsuario());
            pbuscar.setEstado(c.getEstado());

            sesion.update(pbuscar);
            tx.commit();
            sesion.close();
            bandera = true;
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
            bandera = false;
            throw new RuntimeException("NO SE PUDO EDITAR");

        }
        return bandera;
    }

    public Usuario findByUsuario(Usuario user) {
        Usuario model = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        String sql = "from Usuario where usuario='" + user.getUsuario() + "'";
        try {
            model = (Usuario) sesion.createQuery(sql).uniqueResult();
        } catch (Exception ex) {
        }
        return model;
    }

    public Usuario login(Usuario usuario) {
        Usuario model = this.findByUsuario(usuario);
        if (model != null) {
            if (!usuario.getClave().equals(model.getClave())) {
                return null;
            }
        }
        return model;
    }
}
