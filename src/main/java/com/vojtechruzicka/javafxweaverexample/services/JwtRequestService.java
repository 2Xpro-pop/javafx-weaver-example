package com.vojtechruzicka.javafxweaverexample.services;

import org.springframework.stereotype.Service;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.*;
import java.net.http.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class HttpRequestService implements RequestService {
    private static final String host = "https://localhost:7077/";

    public  HttpRequestService()
    {
        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLS");
            ctx.init(new KeyManager[0], new TrustManager[] {new DefaultTrustManager()}, new SecureRandom());
            SSLContext.setDefault(ctx);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public CompletableFuture<HttpResponse<String>> sendRequest(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(host+url))
                    .version(HttpClient.Version.HTTP_2)
                    .GET()
                    .build();
            return client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    @Override
    public CompletableFuture<HttpResponse<String>> login(String login, String password)
    {
        var response = sendRequest(
                String.format(host+"login/%s/%s", login, password)
        );
        return null;
    }


    private static class DefaultTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}
