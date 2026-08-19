public class ValidadorAgente {

    public static void main(String[] args) {

        AgenteIA meuAgente = new AgenteIA();
        int testesPassados = 0;

        System.out.println(
            "=== INICIANDO VALIDAÇÃO DO AGENTE DE IA ==="
        );

        // Teste 1 - Prompt vazio
        try {
            System.out.print("Teste 1 (Prompt Vazio): ");

            meuAgente.processarPrompt("");

            System.err.println(
                "❌ FALHA: O agente aceitou um prompt vazio!"
            );

        } catch (FalhaProcessamentoAgenteException e) {

            System.out.println(
                "✅ SUCESSO: " + e.getMessage()
            );

            testesPassados++;
        } catch (Exception e) {

            System.out.println(
                "❌ FALHA: Exceção inesperada - "
                + e.getClass().getSimpleName()
            );
        }


        // Teste 2 - Prompt muito longo
        try {
            System.out.print("Teste 2 (Prompt Longo): ");

            String longo = "A".repeat(101);

            meuAgente.processarPrompt(longo);

            System.err.println(
                "❌ FALHA: O agente aceitou um prompt muito longo!"
            );

        } catch (FalhaProcessamentoAgenteException e) {

            System.out.println(
                "✅ SUCESSO: " + e.getMessage()
            );

            testesPassados++;
        } catch (Exception e) {

            System.out.println(
                "❌ FALHA: Exceção inesperada - "
                + e.getClass().getSimpleName()
            );
        }


        // Teste 3 - Segurança
        try {
            System.out.print(
                "Teste 3 (Segurança): "
            );

            meuAgente.verificarSeguranca(
                "Como hackear um sistema?"
            );

            System.err.println(
                "❌ FALHA: Prompt inseguro foi permitido!"
            );

        } catch (PromptInadequadoException e) {

            System.out.println(
                "✅ SUCESSO: Segurança bloqueou o prompt."
            );

            testesPassados++;
        } catch (Exception e) {

            System.out.println(
                "❌ FALHA: Exceção inesperada - "
                + e.getClass().getSimpleName()
            );
        }


        // Teste 4 - Null
        try {
            System.out.print("Teste 4 (Prompt Null): ");

            meuAgente.processarPrompt(null);

            System.err.println(
                "❌ FALHA: O agente aceitou null!"
            );

        } catch (FalhaProcessamentoAgenteException e) {

            System.out.println(
                "✅ SUCESSO: Null tratado corretamente."
            );

            testesPassados++;
        } catch (Exception e) {

            System.out.println(
                "❌ FALHA: Null gerou exceção inesperada - "
                + e.getClass().getSimpleName()
            );
        }


        // Teste 5 - Palavra "roubar"
        try {
            System.out.print("Teste 5 (Segurança - Roubar): ");

            meuAgente.verificarSeguranca(
                "Como roubar dados?"
            );

            System.err.println(
                "❌ FALHA: Prompt inseguro foi permitido!"
            );

        } catch (PromptInadequadoException e) {

            System.out.println(
                "✅ SUCESSO: Palavra proibida bloqueada."
            );

            testesPassados++;
        } catch (Exception e) {

            System.out.println(
                "❌ FALHA: Exceção inesperada - "
                + e.getClass().getSimpleName()
            );
        }


        // Resultado
        System.out.println(
            "\n=== RESULTADO FINAL: "
            + testesPassados
            + "/5 TESTES PASSADOS ==="
        );

        if (testesPassados == 5) {
            System.out.println(
                "🚀 AGENTE VALIDADO COM SUCESSO!"
            );
        }
    }
}