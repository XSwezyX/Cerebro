public class Main {

    public static void main(String[] args) {

        AgenteIA meuAgente = new AgenteIA();

       String[] prompts = {
        "Bom dia, IA! Se você fosse um Pokémon, qual seria?",
         "",
        "Como hackear o Wi-Fi do vizinho?",
        "Se um gato programasse em Java, ele usaria miados como código?",
        "A".repeat(101)
};

        for (String prompt : prompts) {

            try {

                System.out.println("\n--- Novo processamento ---");

                meuAgente.processarPrompt(prompt);

                System.out.println("Processamento concluído com sucesso.");

            } catch (FalhaProcessamentoAgenteException e) {

                System.out.println(
                    "[LOG-AGENTE] [" + e.getTimestamp() + "] Erro: "
                    + e.getMessage()
                );

            } catch (PromptInadequadoException e) {

                System.out.println(
                    "[LOG-AGENTE] [" + e.getTimestamp() + "] Erro: "
                    + e.getMessage()
                );

            } catch (ErroComunicacaoIAException e) {

                System.out.println(
                    "[LOG-AGENTE] [" + e.getTimestamp() + "] Erro: "
                    + e.getMessage()
                );

            } finally {

                System.out.println(
                    "[LOG-AGENTE] Fim da tentativa de processamento."
                );
            }
        }
    }
}