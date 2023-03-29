import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo{
    
    public List<Conteudo> extraiConteudos(String json) {

        // extrair só os dados que interessam (titulo, poster, classificação)

        JsonParser parser = new JsonParser();
        List<Map<String,String>> listaDeAtributos = parser.parse(json);

        return listaDeAtributos.stream().map((atributo) -> {
            String titulo = atributo.get("title");
            String urlImagem = atributo.get("url");
            Conteudo conteudo = new Conteudo(titulo,urlImagem);
            return conteudo;
        }).toList();
    }
}
