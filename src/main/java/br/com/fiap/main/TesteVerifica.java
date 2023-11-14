package br.com.fiap.main;

import br.com.fiap.model.Verifica;
import br.com.fiap.services.VerificaBike;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.apache.http.client.ClientProtocolException;

public class TesteVerifica {

    public static void main(String[] args) throws ClientProtocolException, IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Escolha uma imagem");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String imagePath = selectedFile.getAbsolutePath();

            Verifica verifica = new Verifica(imagePath);
            VerificaBike verificaBike = new VerificaBike();

            String result = verificaBike.verificarBike(verifica.getImagePath());
            System.out.println(result);
        } else {
            System.out.println("Nenhuma imagem selecionada. Encerrando o programa.");
        }
    }
}
 