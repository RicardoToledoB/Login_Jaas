package com.ricardo.dao;

import com.ricardo.model.Rol;
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
public class RolDAOImpl implements RolDAO{
     public boolean save(Rol c) {
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
            sesion.close();
            bandera=true;
        } catch (Exception ex) {
            bandera=false;
            tx.rollback();
            ex.printStackTrace();
            throw new RuntimeException("NO SE PUDO INSERTAR");
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
            Rol roles = (Rol) sesion.get(Rol.class, id);
            sesion.delete(roles);
            tx.commit();
            sesion.close();
            bandera=true;
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
            bandera=false;
            throw new RuntimeException("NO SE PUDO BORRAR");
        }
        return bandera;
    }

    public List showAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Query query = sesion.createQuery("from Rol where estado='ACTIVO'");
        List<Rol> lista = query.list();
        return lista;

    }

    public Rol buscarRoles(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Rol rol = (Rol) sesion.get(Rol.class, id);
        return rol;
    }

    public boolean edit(Rol c) {
        boolean bandera;
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        try {
            sf=HibernateUtil.getSessionFactory();
            sesion=sf.openSession();
            tx=sesion.beginTransaction();
            Rol pbuscar=(Rol)sesion.get(Rol.class, c.getId());
            pbuscar.setTipo(c.getTipo());
            pbuscar.setEstado(c.getEstado());
                  
            
            sesion.update(pbuscar);
            tx.commit();
            sesion.close();
             bandera=true;   
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
            bandera=false;
            throw new RuntimeException("NO SE PUDO EDITAR");
            
        }
        return bandera;
    }
}
