package com.ricardo.dao;
import com.ricardo.model.Usuario;
import java.util.List;
public interface UsuarioDAO {
   public boolean save(Usuario c);
   public boolean delete(int id);
   public List showAll();
   public Usuario buscarContactos(int id);
   public boolean edit(Usuario c);
   public Usuario findByUsuario(Usuario user);
   public Usuario login(Usuario usuario);
}
