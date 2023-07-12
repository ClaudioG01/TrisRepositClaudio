package tris.service;

public class MossaErrataException extends Exception {

	private String code;

    public MossaErrataException(String code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
