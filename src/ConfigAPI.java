public enum ConfigAPI {
    CONFIG_API_IMDB("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ExtratorDeConteudoDoIMDB()), 
    CONFIG_API_NASA("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json", new ExtratorDeConteudoDaNasa());
    
    private String url;
    private ExtratorDeConteudo extrator;

    ConfigAPI(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return this.url;
    }

    public ExtratorDeConteudo getExtrator(){
        return this.extrator;
    }
}
