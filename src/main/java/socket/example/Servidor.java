package socket.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        try {
            System.out.println("Servidor Java sendo iniciado...");
            ServerSocket srv = new ServerSocket(64789);
            System.out.println("Aguardando conexao na porta 110...");
            Socket cliente = srv.accept();
            System.out.println("Cliente conectado");

            OutputStream out = cliente.getOutputStream();
            OutputStreamWriter outw = new OutputStreamWriter(out);
            outw.write("Ola ... voce se conectou no servidor Java \r\n\r\n");
            outw.write("Tudo que voc� digitar sera mostrado na tela do servidor \r\n\r\n");
            outw.flush();

            InputStream in = cliente.getInputStream();
            int i = 0;
            while ((i = in.read()) != 27) {
                System.out.print((char) i);
            }

            outw.write("Ate logo \r\n\r\n");
            outw.flush();
            outw.close();
            cliente.close();
            srv.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
