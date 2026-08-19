public class PromptInadequadoException extends Exception {

    private final String timestamp;

    public PromptInadequadoException(String mensagem) {
        super(mensagem);
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    public String getTimestamp() {
        return timestamp;
    }
}