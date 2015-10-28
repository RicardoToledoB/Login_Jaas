package com.ricardo.dao;

import com.ricardo.model.Rol;
import java.util.List;
public interface RolDAO {
   public boolean save(Rol c);
   public boolean delete(int id);
   public List showAll();
   public Rol buscarRoles(int id);
   public boolean edit(Rol c);
   
}
