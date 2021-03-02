package errorhandling.rest;

public class Error {
    private String errorName;
    private String errorDescription;

    public Error() {
    }

    public String getErrorName() {
        return errorName;
    }

    public Error setErrorName(String errorName) {
        this.errorName = errorName;
        return this;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public Error setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        return this;
    }
}
