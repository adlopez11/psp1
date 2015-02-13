package edu.uniandes.ecos.ui;

import edu.uniandes.ecos.biz.RegressionBiz;
import edu.uniandes.ecos.util.FileUtil;
import edu.uniandes.ecos.vo.ParVO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class MainWeb extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
      process("test1.txt",386d,resp);
      process("test2.txt",386d,resp);
      process("test3.txt",386d,resp);
      process("test4.txt",386d,resp);
  }
  
  private void process(String file, Double xk, HttpServletResponse resp) throws IOException{
       try {
           
            resp.getWriter().print("Prueba "+file+ " \n");

            LinkedList<ParVO> listPar = FileUtil.getListNumbers(file);
           
            
            Double b1 = RegressionBiz.getB1(listPar);
            
            Double b0 = RegressionBiz.getB0(listPar, b1);
            
            Double r = RegressionBiz.getR(listPar);
            
            Double yk = RegressionBiz.getYk(b0, b1, xk);

            resp.getWriter().print("xk: " + xk+ " \n");
            resp.getWriter().print("b0: " + b0+ " \n");
            resp.getWriter().print("b1: " + b1+ " \n");
            resp.getWriter().print("rXY: " + r+ " \n");
            resp.getWriter().print("r2: " + (r*r)+ " \n");
            resp.getWriter().print("yk: " + yk+ " \n");
            
            resp.getWriter().print("\n");


        } catch (FileNotFoundException ex) {
            resp.getWriter().print("No se encuentra el archivo especificado, se debe ubicar en la carpeta /src/test/resources/"+ " \n");
        } catch (IOException ex) {
            resp.getWriter().print("Error al leer el archivo especificado"+ " \n");
        } catch (NumberFormatException ex) {
            resp.getWriter().print("Error en el formato de los archivos deben haber dos numeros en cada linea separados por tabulacion, asi como el valor de xk deben ser Double"+ " \n");
        }
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
