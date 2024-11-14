package enums;

public enum Tamanho {
    P(1.0),
    M(1.2),
    G(1.5);

    private double fator;

    Tamanho(double fator) {
        this.fator = fator;
    }

    public double getFator() {
        return fator;
    }
}
