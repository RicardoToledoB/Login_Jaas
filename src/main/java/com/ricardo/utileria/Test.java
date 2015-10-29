package com.ricardo.utileria;

import com.ricardo.dao.RolDAO;
import com.ricardo.dao.RolDAOImpl;
import com.ricardo.dao.UsuarioDAO;
import com.ricardo.dao.UsuarioDAOImpl;
import com.ricardo.model.Rol;
import com.ricardo.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ricardo
 */
public class Test {
    public static void main(String[] args){
       /* Usuario u=new Usuario();
        u.setUsuario("STOLEDO");
        u.setClave("123456");
        u.setEstado("ACTIVO");
        
        Rol r=new Rol();
        r.setTipo("ADMINISTRADOR");
        r.setEstado("ACTIVO");
        
        UsuarioDAO uDAO=new UsuarioDAO();
        
        uDAO.save(u);
        
        RolDAO rDAO=new RolDAO();
        rDAO.save(r);*/
        /////////////////////////////
       /* Usuario user=new Usuario();
        user.setUsuario("Andres");
        user.setClave("1234");
        user.setEstado("ACTIVO");
        Rol rol=new Rol();
        rol.setTipo("EJECUTIVO");
        rol.setEstado("ACTIVO");
        List<Rol> roles=new ArrayList<Rol>();
        roles.add(rol);
        user.setRoles(roles);
        UsuarioDAO uDAO=new UsuarioDAOImpl();
        uDAO.save(user);
        */
       /* Usuario u=new Usuario();
       
        u.setId(1);
        u.setUsuario("FTOLEDO");
        u.setEstado("ACTIVO");
        u.setClave("123456");
        UsuarioDAOImpl uDAO=new UsuarioDAOImpl();
        uDAO.update(u);*/
        UsuarioDAOImpl uDAO=new UsuarioDAOImpl();
        Usuario u=uDAO.buscarContactos(1);
        RolDAOImpl rDAO=new RolDAOImpl();
        Rol r=rDAO.buscarRoles(2);
        u.getRoles().add(r);
        uDAO.save(u);
        
        //CREO ESO DEBERIA ESTAR BIEN
        
              
        
    }
}
