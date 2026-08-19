public class ErroComunicacaoIAException extends Exception {

    private final String timestamp;

    public ErroComunicacaoIAException(String mensagem) {
        super(mensagem);
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    public String getTimestamp() {
        return timestamp;
    }
}