package challenge;

import java.util.ArrayList;

public class Estacionamento {

    final private int VAGAS = 10;
    final private int MAX_PONTOS = 20;
    private ArrayList<Carro> carrosNoEstacionamento;

    public Estacionamento() {
        this.carrosNoEstacionamento = new ArrayList<>();
    }

    public void estacionar(Carro carro) {
        if (carro.getMotorista() == null) {
            throw new EstacionamentoException("naoDeveTerCarroAutonomo");
        }

        if (carro.getMotorista().getPontos() > this.MAX_PONTOS) {
            throw new EstacionamentoException("naoDeveEstacionarMotoristaCOMPontos");
        }

        if (carro.getMotorista().getIdade() < 18) {
            throw new EstacionamentoException("naoDeveTerMotoristaDeMenor");
        }

        boolean podeEstacionar = true;
        if (this.VAGAS == this.carrosEstacionados()) {
            podeEstacionar = this.verificaSeAlguemDeveSair(carro);
        }

        if (!podeEstacionar) {
            throw new EstacionamentoException("casoTodosSejamSeniorONovoMotoristaNaoTeraVaga");
        }

        if (podeEstacionar) {
            this.carrosNoEstacionamento.add(carro);
        }
    }

    public int carrosEstacionados() { return this.carrosNoEstacionamento.size(); }

    protected boolean verificaSeAlguemDeveSair(Carro carroTentandoEstacionar) {
        int index = 0;

        for (Carro carroNoEstacionamento : this.carrosNoEstacionamento) {
            if (carroNoEstacionamento.getMotorista().getIdade() < 55) {
                this.carrosNoEstacionamento.remove(index);
                return true;
            }
            index++;
        }

        return false;
    }

    public boolean carroEstacionado(Carro carro) {
        for (Carro carroNoEstacionamento : this.carrosNoEstacionamento) {
            if (carroNoEstacionamento.equals(carro)) {
                return true;
            }
        }

        return false;
    }
}
