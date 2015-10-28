/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.utileria;

import com.ricardo.dao.RolDAO;
import com.ricardo.dao.UsuarioDAO;
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
        Usuario user=new Usuario();
        user.setUsuario("Sebastian");
        user.setClave("12345678");
        user.setEstado("ACTIVO");
        Rol rol=new Rol();
        rol.setTipo("EJECUTIVO");
        rol.setEstado("ACTIVO");
        List<Rol> roles=new ArrayList<Rol>();
        roles.add(rol);
        user.setRoles(roles);
        UsuarioDAO uDAO=new UsuarioDAO();
        uDAO.save(user);
        
    }
}
