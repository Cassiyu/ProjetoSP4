package br.com.fiap.services;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class VerificaBike {

    public String verificarBike(String imagePath) throws ClientProtocolException, IOException{
        try {
            File imagem1 = new File(imagePath);
        
            CloseableHttpClient httpClient = HttpClients.createDefault();
          
            HttpPost httpPost = new HttpPost("http://127.0.0.1:5000/predict");
          
            HttpEntity multipartEntity = MultipartEntityBuilder.create()
                    .addBinaryBody("file", imagem1, ContentType.DEFAULT_BINARY, imagem1.getName())
                    .build();
       
            httpPost.setEntity(multipartEntity);
           
            CloseableHttpResponse response = httpClient.execute(httpPost);

            try {
                HttpEntity responseEntity = response.getEntity();
                return EntityUtils.toString(responseEntity);

            } finally {
                response.close();
            }

        } catch (ClientProtocolException e) {
            return "Erro de protocolo HTTP: " + e.getMessage();
        } catch (IOException e) {
            return "Erro de I/O: " + e.getMessage();
        }
    }
}
