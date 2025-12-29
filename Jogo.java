// INTEGRANTES: FELIPE DE ASSIS GOMES, FELIPE PEREIRA DA SILVA, MATHEUS ALVES PEDROSO.

import java.util.*;

public class Jogo {

    private Pergunta[] perguntas; // Array de perguntas
    private int vidas = 3;
    private int perguntaAtual = 0;
    private int acertosSeguidos = 0;
    private int totalAcertos = 0;
    private boolean chanceExtraUsada = false;

    private Scanner sc = new Scanner(System.in);

    // Construtor do jogo
    public Jogo() {
        carregarPerguntas();
    }

    // Carrega todas as perguntas do jogo
    private void carregarPerguntas() {

        String[] perguntasTxt = {
                "Qual é a capital do Brasil?",
                "Quanto é 9 * 9?",
                "Quem escreveu Dom Quixote?",
                "Qual é o maior planeta do sistema solar?",
                "Quem pintou a Mona Lisa?",
                "Qual é o elemento químico representado por O?",
                "Quantos lados tem um hexágono?",
                "Em que continente fica o Egito?",
                "Quem descobriu o Brasil?",
                "Qual é o rio mais extenso do mundo?",
                "Que país venceu a Copa de 2002?",
                "Quem inventou a lâmpada?",
                "Qual é a fórmula da água?",
                "Em qual país fica Tóquio?",
                "Qual é o segundo planeta do sistema solar?",
                "Qual é o oceano mais profundo do mundo?",
                "Quem desenvolveu a teoria da relatividade?",
                "Qual é o maior animal terrestre?",
                "Qual país é conhecido como Terra do Sol Nascente?",
                "Quem foi o primeiro homem a pisar na Lua?",
                "Qual é a montanha mais alta do mundo?",
                "Qual é o país mais populoso do mundo?",
                "Quem pintou Starry Night (A Noite Estrelada)?",
                "Em que ano começou a Segunda Guerra Mundial?",
                "Qual é a capital da França?",
                "Qual idioma é falado no Egito?",
                "Qual é o menor país do mundo?",
                "Quantos dias há em um ano bissexto?",
                "Que animal é conhecido como 'rei da selva'?",
                "Qual é o tecido responsável pelo transporte de seiva nas plantas?",
                "Qual é o metal líquido à temperatura ambiente?",
                "Qual é o país com maior área territorial?",
                "O que significa CPU?",
                "Qual é o maior órgão do corpo humano?",
                "Quem escreveu 'O Pequeno Príncipe'?",
                "Qual é a capital da Argentina?",
                "Em que continente está a Austrália?",
                "Qual é o deserto mais seco do mundo?",
                "Quem descobriu a teoria da gravidade?"
        };


        String[][] alternativasTxt = {
                {"Brasília", "Rio de Janeiro", "São Paulo", "Salvador"},
                {"72", "81", "99", "89"},
                {"Machado de Assis", "Shakespeare", "Miguel de Cervantes", "Fernando Pessoa"},
                {"Marte", "Júpiter", "Saturno", "Netuno"},
                {"Leonardo da Vinci", "Picasso", "Van Gogh", "Michelangelo"},
                {"Ouro", "Osso", "Oxigênio", "Osmio"},
                {"4", "5", "6", "8"},
                {"Ásia", "Europa", "África", "América"},
                {"Pedro Álvares Cabral", "Cristóvão Colombo", "Vasco da Gama", "Américo Vespúcio"},
                {"Nilo", "Amazonas", "Yangtzé", "Congo"},
                {"Brasil", "Alemanha", "França", "Itália"},
                {"Einstein", "Edison", "Tesla", "Galileu"},
                {"H2O", "CO2", "NaCl", "O2"},
                {"China", "Coreia do Sul", "Japão", "Tailândia"},
                {"Vênus", "Mercúrio", "Terra", "Marte"},
                {"Atlântico", "Índico", "Pacífico", "Ártico"},
                {"Newton", "Einstein", "Galileu", "Planck"},
                {"Elefante", "Rinoceronte", "Hipopótamo", "Girafa"},
                {"China", "Coreia do Sul", "Japão", "Tailândia"},
                {"Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin", "Michael Collins"},
                {"K2", "Everest", "Kilimanjaro", "Mont Blanc"},
                {"Índia", "Estados Unidos", "China", "Indonésia"},
                {"Picasso", "Van Gogh", "Michelangelo", "Da Vinci"},
                {"1939", "1914", "1945", "1929"},
                {"Paris", "Roma", "Londres", "Berlim"},
                {"Árabe", "Inglês", "Espanhol", "Francês"},
                {"Mônaco", "Vaticano", "San Marino", "Luxemburgo"},
                {"365", "366", "364", "360"},
                {"Leão", "Tigre", "Gorila", "Hiena"},
                {"Floema", "Xilema", "Clorofila", "Meristema"},
                {"Ouro", "Ferro", "Mercúrio", "Prata"},
                {"Rússia", "Canadá", "China", "Estados Unidos"},
                {"Central Processing Unit", "Computer Power Unit", "Control Process Utility", "Central Port Unit"},
                {"Coração", "Fígado", "Pele", "Pulmão"},
                {"Machado de Assis", "Saint-Exupéry", "Tolstói", "George Orwell"},
                {"Buenos Aires", "Córdoba", "Mendoza", "Rosário"},
                {"África", "Oceania", "Ásia", "Europa"},
                {"Kalahari", "Atacama", "Saara", "Gobi"},
                {"Einstein", "Newton", "Kepler", "Faraday"}

        };


        int[] respostas = {
                1, 2, 3, 2, 1, 3, 3, 3, 1, 1, 1, 2, 1, 3, 1, 3, 2, 1, 3, 1, 2, 3, 2, 1, 1, 1, 2, 2, 1, 1, 3, 1, 1, 3, 2, 1, 2, 2, 2
        };


        // Array das perguntas.
        perguntas = new Pergunta[perguntasTxt.length];

        // Loop que cria uma pergunta pra cada indice. (enunciado, alterativa e resposta)

        for (int i = 0; i < perguntasTxt.length; i++) {
            perguntas[i] = new Pergunta(perguntasTxt[i], alternativasTxt[i], respostas[i]);
        }

        // Randomiza as perguntas.
        List<Pergunta> perguntaList = Arrays.asList(perguntas);
        Collections.shuffle(perguntaList);
        perguntas = perguntaList.subList(0,15).toArray(new Pergunta[0]);

    }

    // Inicia o jogo
    public void iniciar() {

        System.out.println("===== SHOW DO MILHÃO =====");
        System.out.println("Você começa com 3 vidas!");
        System.out.println("Acumule 15 acertos para vencer o jogo!\n");


        // Loop roda o jogo enquanto tiver perguntas para responder.

        while (perguntaAtual < perguntas.length) {

            if (vidas == 0) {
                tratarChanceExtra();
            }

            jogarRodada();
        }

        finalizarJogo();
    }

    // Realiza uma rodada (pergunta e resposta)
    private void jogarRodada() {

        // Mostrar pergunta atual
        perguntas[perguntaAtual].mostrarPergunta(perguntaAtual + 1);

        System.out.print("Sua resposta (1-4): ");
        int respostaUsuario = sc.nextInt();

        if (respostaUsuario < 1 || respostaUsuario > 4) {

            System.out.println("\nPor favor selecionar apenas alternativas entre 1 e 4!!!\n");

        } else {

            if (perguntas[perguntaAtual].verificarResposta(respostaUsuario)) {

                System.out.println("\n ✔ Resposta correta!");
                acertosSeguidos++;
                totalAcertos++;
                System.out.println("Acertos até o momento: " + totalAcertos);
                System.out.println();

                // Ganha vida extra
                if (acertosSeguidos == 3) {
                    vidas++;
                    acertosSeguidos = 0;
                    System.out.println("🎉 Você ganhou uma vida extra! Agora possui " + vidas + " vidas!\n");
                }

                perguntaAtual++;

            } else {

                System.out.println("✘ Resposta errada!");
                vidas--;
                acertosSeguidos = 0;
                System.out.println("Vidas restantes: " + vidas);

                // Regressa uma pergunta e randomiza para não ser a mesma anterior.
                perguntaAtual = Math.max(0, perguntaAtual - 1);
                System.out.println("Você retrocedeu para a pergunta: " + (perguntaAtual + 1) + "!\n");
            }
        }
    }

    // Trata quando o jogador perde todas as vidas, ou finaliza o jogo, ou se ele teve 3 acertos seguidos, uma chance
    // extra.
    private void tratarChanceExtra() {

        if (!chanceExtraUsada && totalAcertos >= 3) {
            System.out.println("\nVOCÊ PERDEU TODAS AS VIDAS!");
            System.out.println("Mas como você tem pelo menos 3 acertos...");
            System.out.println("GANHOU UMA CHANCE EXTRA!\n");
            vidas = 1;
            chanceExtraUsada = true;

        } else {
            System.out.println("\nFIM DE JOGO! Você perdeu todas as vidas.");
            System.out.println("Total de acertos: " + totalAcertos);
            System.exit(0);
        }
    }

    private void finalizarJogo() {
        System.out.println("\n🎉 PARABÉNS!!! VOCÊ VENCEU O SHOW DO MILHÃO!");
        System.out.println("Acertos totais: " + totalAcertos);
        System.out.println("===========================\n");
    }


}
