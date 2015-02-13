package edu.uniandes.ecos.ui;

import edu.uniandes.ecos.biz.FileBiz;
import edu.uniandes.ecos.vo.Aplicacion;
import edu.uniandes.ecos.vo.Clase;
import edu.uniandes.ecos.vo.Metodo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class MainWeb extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
      final List<Aplicacion> aplicaciones = FileBiz.buscarProyectos();
      imprimirWeb(aplicaciones,resp);
  }
  
  private void imprimirWeb(final List<Aplicacion> aplicaciones, HttpServletResponse resp) throws IOException{
        resp.getWriter().print("LOC de Aplicaciones\n");
        for(int i = 0;i< aplicaciones.size();i++){
            Aplicacion aplicacion = aplicaciones.get(i);
            resp.getWriter().print("Aplicacion #"+(i+1)+"\n");
            resp.getWriter().print("Nombre: "+aplicacion.getNombre());
            resp.getWriter().print("Numero de Clases: "+aplicacion.getClases().size());
            resp.getWriter().print("Total LOC: "+getLineasTotales(aplicacion));
            resp.getWriter().print("Clases:\n");
            for(Clase clase: aplicacion.getClases()){
                resp.getWriter().print("Nombre Clase: "+clase.getNombre());
                resp.getWriter().print("LOC Clase: "+clase.getLineas());
                resp.getWriter().print("Numero de Metodos: "+clase.getMetodos().size());
                resp.getWriter().print("Metodos:");
                for(Metodo metodo : clase.getMetodos()){
                    resp.getWriter().print("Nombre Metodo: "+metodo.getNombre());
                    resp.getWriter().print("LOC Metodo: "+metodo.getLineas());
                }
            }
            resp.getWriter().print("\n");
        }
    }
    
    private int getLineasTotales(final Aplicacion aplicacion){
        int cont =0;
        for(Clase clase: aplicacion.getClases()){
            cont = cont + clase.getLineas();
        }
        return cont;
    }

  public static void main(String[] args) throws Exception {
    Server server = new Server(Integer.valueOf(System.getenv("PORT")));
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    server.setHandler(context);
    context.addServlet(new ServletHolder(new MainWeb()),"/*");
    server.start();
    server.join();
  }
}
