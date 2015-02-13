package edu.uniandes.ecos.ui;

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
//      final List<Aplicacion> aplicaciones = FileBiz.buscarProyectos();
//      imprimirWeb(aplicaciones,resp);
  }
  
//  private void imprimirWeb(final List<Aplicacion> aplicaciones, HttpServletResponse resp) throws IOException{
////        resp.getWriter().print("LOC de Aplicaciones\n\n");
////        for(int i = 0;i< aplicaciones.size();i++){
////            Aplicacion aplicacion = aplicaciones.get(i);
////            resp.getWriter().print("Aplicacion #"+(i+1)+"\n\n");
////            resp.getWriter().print("Nombre: "+aplicacion.getNombre()+"\n");
////            resp.getWriter().print("Numero de Clases: "+aplicacion.getClases().size()+"\n");
////            resp.getWriter().print("Total LOC: "+getLineasTotales(aplicacion)+"\n");
////            resp.getWriter().print("Clases:\n\n");
////            for(Clase clase: aplicacion.getClases()){
////                resp.getWriter().print("Nombre Clase: "+clase.getNombre()+"\n");
////                resp.getWriter().print("LOC Clase: "+clase.getLineas()+"\n");
////                resp.getWriter().print("Numero de Metodos: "+clase.getMetodos().size()+"\n");
////                resp.getWriter().print("Metodos:"+"\n");
////                for(Metodo metodo : clase.getMetodos()){
////                    resp.getWriter().print("Nombre Metodo: "+metodo.getNombre()+"\n");
////                    resp.getWriter().print("LOC Metodo: "+metodo.getLineas()+"\n");
////                }
////            }
////            resp.getWriter().print("\n\n");
//        }
//    }
//    
//    private int getLineasTotales(final Aplicacion aplicacion){
//        int cont =0;
//        for(Clase clase: aplicacion.getClases()){
//            cont = cont + clase.getLineas();
//        }
//        return cont;
//    }

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
