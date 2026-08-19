public class AgenteIA {

    public void processarPrompt(String prompt)
            throws FalhaProcessamentoAgenteException,
                   PromptInadequadoException,
                   ErroComunicacaoIAException {

        // Trata null antes de qualquer chamada de método sobre prompt
        if (prompt == null || prompt.isEmpty()) {
            throw new FalhaProcessamentoAgenteException(
                "O prompt não pode estar vazio."
            );
        }

        // O filtro de segurança deve ocorrer antes do processamento
        verificarSeguranca(prompt);

        if (prompt.length() > 100) {
            throw new FalhaProcessamentoAgenteException(
                "Prompt muito longo para o modelo atual."
            );
        }

        try {
            chamarModeloExterno();

            System.out.println("Agente processando: " + prompt);

        } finally {
            System.out.println("[LOG-AGENTE] Finalizando processamento.");
        }
    }

    public void verificarSeguranca(String prompt)
            throws PromptInadequadoException {

        if (prompt == null) {
            return;
        }

        String promptNormalizado = prompt.toLowerCase();

        if (promptNormalizado.contains("hackear")
                || promptNormalizado.contains("roubar")) {

            throw new PromptInadequadoException(
                "Prompt bloqueado pelo filtro de segurança."
            );
        }
    }

    public void chamarModeloExterno()
            throws ErroComunicacaoIAException {

        double numeroAleatorio = Math.random();

        if (numeroAleatorio > 0.7) {
            throw new ErroComunicacaoIAException(
                "Falha de comunicação com o serviço externo de IA."
            );
        }

        System.out.println("Comunicação com o modelo externo realizada.");
    }
}