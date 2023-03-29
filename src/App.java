import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        // fazer uma conexão HTTP e buscar os top 250 filmes

        var http = new ClienteHttp();
        String json = http.buscaDados(ConfigAPI.CONFIG_API_NASA.getUrl());

        // exibir e manipular os dados
        List<Conteudo> conteudos = ConfigAPI.CONFIG_API_NASA.getExtrator().extraiConteudos(json);

        var geradora = new GeradorDeFigurinhas();
        for (int i=0; i< 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = conteudo.titulo().replace(":","-") + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.titulo());
            System.out.println();
        }
    }
}
