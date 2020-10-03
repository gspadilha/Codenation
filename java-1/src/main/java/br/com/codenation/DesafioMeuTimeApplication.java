package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private ArrayList<Times> times;
	private ArrayList<Jogadores> jogadores;

	public DesafioMeuTimeApplication() {
		this.times = new ArrayList<Times>();
		this.jogadores = new ArrayList<Jogadores>();
	}

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (this.existeTime(id)) {
			throw new IdentificadorUtilizadoException();
		}

		try {
			Times time = new Times(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
			this.times.add(time);
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}
	protected Boolean existeTime(Long idTime) {
		Boolean temTime = false;
		for (Times time: this.times) {
			if (time.getId().equals(idTime)) {
				temTime = true;
			}
		}
		return temTime;
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if (this.existeJogador(id)) {
			throw new IdentificadorUtilizadoException();
		}

		if (!this.existeTime(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		try {
			Jogadores jogador = new Jogadores(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
			this.jogadores.add(jogador);
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	protected Boolean existeJogador(Long id) {
		for (Jogadores jogador: this.jogadores) {
			if (jogador.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public void definirCapitao(Long idJogador) {
		if (!this.existeJogador(idJogador)) {
			throw new JogadorNaoEncontradoException();
		}

		try {
			Long idTime = null;
			for (Jogadores jogador: this.jogadores) {
				if (jogador.getId().equals(idJogador) && !jogador.isCaptain()) {
					this.removeCapitao(idTime);
					// novo capitão
					jogador.setIsCaptain(true);
				}
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	protected void removeCapitao(Long idTime) {
		for (Jogadores jogador: this.jogadores) {
			if (jogador.getIdTime().equals(idTime) && jogador.isCaptain()) {
				jogador.setIsCaptain(false);
			}
		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		if (!this.existeTime(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		Long idJogador = null;

		try {
			for (Jogadores jogador: this.jogadores) {
				if (jogador.getIdTime().equals(idTime) && jogador.isCaptain()) {
					idJogador = jogador.getId();
				}
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}

		if (idJogador == null ) {
			throw new CapitaoNaoInformadoException();
		}

		return idJogador;
	}

	public String buscarNomeJogador(Long idJogador) {
		if (!this.existeJogador(idJogador)) {
			throw new JogadorNaoEncontradoException();
		}

		try {
			String nomeJogador = "";
			for (Jogadores jogador: this.jogadores) {
				if (jogador.getId().equals(idJogador)) {
					nomeJogador = jogador.getNome();
				}
			}
			return nomeJogador;
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	public String buscarNomeTime(Long idTime) {
		if (!this.existeTime(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		try {
			String nomeTime = "";
			for (Times time: this.times) {
				if (time.getId().equals(idTime)) {
					nomeTime = time.getNome();
				}
			}
			return nomeTime;
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if (!this.existeTime(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		try {
			List<Long> jogadoresDoTime = new ArrayList<Long>();
			for (Jogadores jogador: this.jogadores) {
				if (jogador.getIdTime()==idTime) {
					jogadoresDoTime.add(jogador.getId());
				}
			}

			return jogadoresDoTime;
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if (!this.existeTime(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		try {
			Long idJogador = null;
			Integer maiorNivelHabilidade = 0;
			for (Jogadores jogador: this.jogadores) {
				if (jogador.getIdTime().equals(idTime) && jogador.getNivelHabilidade() > maiorNivelHabilidade) {
					maiorNivelHabilidade = jogador.getNivelHabilidade();
					idJogador = jogador.getId();
				}
			}
			return idJogador;
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if (!this.existeTime(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		try {
			Long idJogador = null;
			LocalDate maiorDataNascimento = LocalDate.MAX;
			for (Jogadores jogador: this.jogadores) {
				if (jogador.getIdTime().equals(idTime) && jogador.getDataNascimento().isBefore(maiorDataNascimento)) {
					System.out.println(jogador.getId() +  " " + jogador.getDataNascimento());
					maiorDataNascimento = jogador.getDataNascimento();
					idJogador = jogador.getId();
				}
			}
			return idJogador;
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	public List<Long> buscarTimes() {
		try {
			List<Long> _times = new ArrayList<Long>();
			for (Times time: this.times) {
				_times.add(time.getId());
			}
			return _times;
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if (!this.existeTime(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		try {
			Long idJogador = null;
			BigDecimal maiorSalario = new BigDecimal(0);
			for (Jogadores jogador: this.jogadores) {
				if (jogador.getIdTime().equals(idTime) && jogador.getSalario().doubleValue() > maiorSalario.doubleValue()) {
					maiorSalario = jogador.getSalario();
					idJogador = jogador.getId();
				}
			}
			return idJogador;
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if (!this.existeJogador(idJogador)) {
			throw new JogadorNaoEncontradoException();
		}

		try {
			BigDecimal salario = new BigDecimal(0);
			for (Jogadores jogador: this.jogadores) {
				if (jogador.getId().equals(idJogador)) {
					salario = jogador.getSalario();
				}
			}
			return salario;
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	public List<Long> buscarTopJogadores(Integer top) {
		try {
			List<Long> melhoresJogadores = new ArrayList<Long>();
			Collections.sort(this.jogadores, new CustomComparator());

			Integer x = 1;
			for (Jogadores jogador: this.jogadores) {
				System.out.println(jogador.getId());
				melhoresJogadores.add(jogador.getId());
				if (x == top) {
					break;
				}
				x++;
			}

			return melhoresJogadores;
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}
}
