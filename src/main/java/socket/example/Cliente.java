package socket.example;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        try {
            System.out.println("Sistema Cliente");
            String endServidor = JOptionPane.showInputDialog("Digite a URL do servidor � se conectar : ");
            Socket cliente = new Socket(endServidor, 64789);
            System.out.println("Conectado no servidor");
            InputStream in = cliente.getInputStream();
            InputStreamReader inr = new InputStreamReader(in);
            Thread.sleep(2000);
            while (inr.ready()) {
                System.out.print((char) inr.read());
            }
            OutputStream out = cliente.getOutputStream();
            OutputStreamWriter outw = new OutputStreamWriter(out);
            String texto = "";
            while (!("SAIR".equalsIgnoreCase(texto))) {
                texto = JOptionPane.showInputDialog("Digite algo para ser encaminhado ao servidor : ");
                outw.write(texto);
                outw.flush();
            }
            out.write(27);
            out.close();
            cliente.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }

}
