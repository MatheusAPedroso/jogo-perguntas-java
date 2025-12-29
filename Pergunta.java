// INTEGRANTES: FELIPE DE ASSIS GOMES, FELIPE PEREIRA DA SILVA, MATHEUS ALVES PEDROSO.

public class Pergunta {

    private String enunciado;
    private String[] alternativas;
    private int respostaCorreta;

    // Construtor
    public Pergunta(String enunciado, String[] alternativas, int respostaCorreta) {
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
    }

    // Exibir a pergunta e as alternativas
    public void mostrarPergunta(int numeroPergunta) {
        System.out.println("Pergunta " + numeroPergunta + ":");
        System.out.println(enunciado);

        for (int i = 0; i < alternativas.length; i++) {
            System.out.println((i + 1) + ") " + alternativas[i]);
        }
    }

    // Verificar se a resposta está correta
    public boolean verificarResposta(int respostaUsuario) {
        return respostaUsuario == respostaCorreta;
    }
}
