package com.example.filmes;

import com.example.filmes.entity.Filme;
import com.example.filmes.repository.FilmeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmesApplication.class, args);
	}

	@Bean
	public CommandLineRunner carregarDadosIniciais(FilmeRepository filmeRepository) {
		return (args) -> {

			// Romance
			Filme umaMulher = new Filme();
			umaMulher.setNome("Uma Linda Mulher");
			umaMulher.setGenero("Romance");
			umaMulher.setTempoMinutos(119L);
			umaMulher.setDescricao("Uma jovem prostituta é contratada por um empresário para acompanhá-lo em eventos e, inesperadamente, os dois se apaixonam enquanto descobrem o verdadeiro valor do amor e da confiança.");
			umaMulher.setAvaliacao("7.0");
			umaMulher.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/8/8c/Pretty_Woman.jpg/250px-Pretty_Woman.jpg");
			filmeRepository.save(umaMulher);

			Filme titanic = new Filme();
			titanic.setNome("Titanic");
			titanic.setGenero("Romance");
			titanic.setTempoMinutos(195L);
			titanic.setDescricao("Em meio à viagem inaugural do Titanic, o amor entre Jack e Rose floresce, mesmo diante das diferenças sociais e do trágico destino do navio que marcou a história do cinema.");
			titanic.setAvaliacao("8.0");
			titanic.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/2/22/Titanic_poster.jpg/250px-Titanic_poster.jpg");
			filmeRepository.save(titanic);

			Filme perderHomem = new Filme();
			perderHomem.setNome("Como Perder um Homem em 10 Dias");
			perderHomem.setGenero("Romance");
			perderHomem.setTempoMinutos(116L);
			perderHomem.setDescricao("Uma jornalista decide escrever uma matéria sobre como perder um homem em dez dias, mas seu plano se complica quando se apaixona por sua vítima, que também esconde um segredo.");
			perderHomem.setAvaliacao("6.4");
			perderHomem.setCartazUrl("https://upload.wikimedia.org/wikipedia/en/0/07/HowToLoseAGuyimp.jpg");
			filmeRepository.save(perderHomem);

			Filme diarioPaixao = new Filme();
			diarioPaixao.setNome("Diário de uma Paixão");
			diarioPaixao.setGenero("Romance");
			diarioPaixao.setTempoMinutos(123L);
			diarioPaixao.setDescricao("Noah e Allie se apaixonam durante um verão inesquecível, mas são separados pelas diferenças sociais e pelo tempo. Anos depois, o destino os reúne, provando que o amor verdadeiro nunca morre.");
			diarioPaixao.setAvaliacao("7.9");
			diarioPaixao.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/3/32/The_Notebook_p%C3%B4ster.jpg/250px-The_Notebook_p%C3%B4ster.jpg");
			filmeRepository.save(diarioPaixao);

			Filme ritmoQuente = new Filme();
			ritmoQuente.setNome("Ritmo Quente");
			ritmoQuente.setGenero("Romance");
			ritmoQuente.setTempoMinutos(100L);
			ritmoQuente.setDescricao("Durante um verão dos anos 60, uma jovem tímida descobre a paixão e a autoconfiança ao aprender a dançar com um instrutor carismático, mudando sua vida para sempre.");
			ritmoQuente.setAvaliacao("7.0");
			ritmoQuente.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/0/00/Dirty_Dancing.jpg/250px-Dirty_Dancing.jpg");
			filmeRepository.save(ritmoQuente);

			// Comédia
			Filme genteGrande = new Filme();
			genteGrande.setNome("Gente Grande");
			genteGrande.setGenero("Comédia");
			genteGrande.setTempoMinutos(102L);
			genteGrande.setDescricao("Cinco amigos de infância se reencontram após 30 anos para homenagear o antigo treinador e reviver momentos divertidos, aprendendo lições sobre amizade, família e maturidade.");
			genteGrande.setAvaliacao("5.9");
			genteGrande.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/f/fe/Grownupsmovie.jpg/250px-Grownupsmovie.jpg");
			filmeRepository.save(genteGrande);

			Filme elaECara = new Filme();
			elaECara.setNome("Ela é o Cara");
			elaECara.setGenero("Comédia");
			elaECara.setTempoMinutos(105L);
			elaECara.setDescricao("Quando o time de futebol feminino é cancelado, Viola decide se disfarçar de seu irmão para jogar em uma escola rival, iniciando uma série de confusões e situações hilárias sobre identidade e amor.");
			elaECara.setAvaliacao("6.3");
			elaECara.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/5/59/She%27s_the_Man.jpg/250px-She%27s_the_Man.jpg");
			filmeRepository.save(elaECara);

			Filme esposaMentirinha = new Filme();
			esposaMentirinha.setNome("Esposa de Mentirinha");
			esposaMentirinha.setGenero("Comédia");
			esposaMentirinha.setTempoMinutos(117L);
			esposaMentirinha.setDescricao("Um cirurgião plástico convence sua assistente a fingir ser sua esposa divorciada para impressionar a mulher dos seus sonhos, mas o plano sai do controle quando sentimentos reais aparecem.");
			esposaMentirinha.setAvaliacao("6.4");
			esposaMentirinha.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/9/9e/Just_Go_with_it_P%C3%B4ster.jpg");
			filmeRepository.save(esposaMentirinha);

			Filme asBranquelas = new Filme();
			asBranquelas.setNome("As Branquelas");
			asBranquelas.setGenero("Comédia");
			asBranquelas.setTempoMinutos(115L);
			asBranquelas.setDescricao("Dois agentes do FBI se disfarçam de socialites brancas para proteger duas herdeiras ameaçadas, resultando em uma das comédias mais icônicas com cenas absurdas e situações impagáveis.");
			asBranquelas.setAvaliacao("5.7");
			asBranquelas.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/d/de/White_chicks.jpeg/250px-White_chicks.jpeg");
			filmeRepository.save(asBranquelas);

			Filme beberNaoCase = new Filme();
			beberNaoCase.setNome("Se Beber, Não Case!");
			beberNaoCase.setGenero("Comédia");
			beberNaoCase.setTempoMinutos(100L);
			beberNaoCase.setDescricao("Após uma noite selvagem em Las Vegas, três amigos acordam sem lembranças e precisam refazer seus passos para encontrar o noivo desaparecido antes do casamento, enfrentando loucuras inesquecíveis.");
			beberNaoCase.setAvaliacao("7.7");
			beberNaoCase.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/b/b9/Hangoverposter09.jpg/255px-Hangoverposter09.jpg");
			filmeRepository.save(beberNaoCase);

			// Terror
			Filme carrie = new Filme();
			carrie.setNome("Carrie");
			carrie.setGenero("Terror");
			carrie.setTempoMinutos(98L);
			carrie.setDescricao("Carrie é uma jovem tímida e oprimida pela mãe religiosa. Após ser humilhada no baile da escola, seus poderes telecinéticos se manifestam de forma devastadora, mudando tudo ao seu redor.");
			carrie.setAvaliacao("7.4");
			carrie.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/2/2a/Carrie_%281976%29.jpg/250px-Carrie_%281976%29.jpg");
			filmeRepository.save(carrie);

			Filme it = new Filme();
			it.setNome("It: A Coisa");
			it.setGenero("Terror");
			it.setTempoMinutos(135L);
			it.setDescricao("Um grupo de amigos enfrenta um palhaço demoníaco que emerge dos esgotos a cada 27 anos para se alimentar do medo das crianças, em uma luta aterrorizante pela sobrevivência.");
			it.setAvaliacao("7.3");
			it.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/8/82/It_2017.jpg/250px-It_2017.jpg");
			filmeRepository.save(it);

			Filme chucky = new Filme();
			chucky.setNome("Chucky");
			chucky.setGenero("Terror");
			chucky.setTempoMinutos(87L);
			chucky.setDescricao("Um assassino transfere sua alma para um boneco infantil, que ganha vida e inicia uma série de crimes sangrentos, aterrorizando todos que cruzam seu caminho em busca de um novo corpo.");
			chucky.setAvaliacao("6.6");
			chucky.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/c/cc/Child%27s_play_poster_promocional.png");
			filmeRepository.save(chucky);

			Filme frankenstein = new Filme();
			frankenstein.setNome("Frankenstein");
			frankenstein.setGenero("Terror");
			frankenstein.setTempoMinutos(71L);
			frankenstein.setDescricao("Um cientista obcecado pela vida cria uma criatura feita de partes humanas e enfrenta as consequências de brincar de Deus quando sua criação se volta contra o mundo e o rejeita.");
			frankenstein.setAvaliacao("7.8");
			frankenstein.setCartazUrl("https://upload.wikimedia.org/wikipedia/en/a/a0/Frankenstein_%282015_film%29.jpg");
			filmeRepository.save(frankenstein);

			Filme horaPesadelo = new Filme();
			horaPesadelo.setNome("A Hora do Pesadelo");
			horaPesadelo.setGenero("Terror");
			horaPesadelo.setTempoMinutos(91L);
			horaPesadelo.setDescricao("Freddy Krueger, um assassino que ataca adolescentes em seus sonhos, transforma o sono em uma luta mortal onde ninguém está seguro, misturando realidade e pesadelo de forma assustadora.");
			horaPesadelo.setAvaliacao("7.5");
			horaPesadelo.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/3/3c/Nightmare_Elm_Street_1984.jpg/250px-Nightmare_Elm_Street_1984.jpg");
			filmeRepository.save(horaPesadelo);

			// Família
			Filme toyStory = new Filme();
			toyStory.setNome("Toy Story");
			toyStory.setGenero("Família");
			toyStory.setTempoMinutos(81L);
			toyStory.setDescricao("Quando um novo brinquedo ameaça o posto de favorito de Woody, os brinquedos embarcam em uma aventura emocionante sobre amizade, lealdade e o significado de crescer.");
			toyStory.setAvaliacao("8.3");
			toyStory.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/a/a7/Toy_Story_1995.jpg");
			filmeRepository.save(toyStory);

			Filme liloStitch = new Filme();
			liloStitch.setNome("Lilo & Stitch");
			liloStitch.setGenero("Família");
			liloStitch.setTempoMinutos(85L);
			liloStitch.setDescricao("Uma garota havaiana adota uma criatura alienígena fujona. Juntas, elas aprendem sobre amor, aceitação e o verdadeiro significado da palavra 'ohana', que quer dizer família.");
			liloStitch.setAvaliacao("7.3");
			liloStitch.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/8/89/Lilo_%26_Stitch.webp/330px-Lilo_%26_Stitch.webp.png");
			filmeRepository.save(liloStitch);

			Filme stuart = new Filme();
			stuart.setNome("Stuart Little");
			stuart.setGenero("Família");
			stuart.setTempoMinutos(84L);
			stuart.setDescricao("Um pequeno rato falante é adotado por uma família humana e embarca em aventuras cheias de coragem e humor, mostrando que o tamanho não define o coração.");
			stuart.setAvaliacao("6.0");
			stuart.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/9/96/Stuart_Little.jpg/250px-Stuart_Little.jpg");
			filmeRepository.save(stuart);

			Filme paddington = new Filme();
			paddington.setNome("Paddington");
			paddington.setGenero("Família");
			paddington.setTempoMinutos(95L);
			paddington.setDescricao("Um adorável urso do Peru viaja para Londres em busca de um lar. Lá, ele é acolhido por uma família e vive aventuras encantadoras que ensinam sobre empatia e gentileza.");
			paddington.setAvaliacao("7.2");
			paddington.setCartazUrl("https://br.web.img2.acsta.net/pictures/14/10/21/00/55/153495.jpg");
			filmeRepository.save(paddington);

			// Ação
			Filme missao = new Filme();
			missao.setNome("Missão Impossível");
			missao.setGenero("Ação");
			missao.setTempoMinutos(110L);
			missao.setDescricao("Ethan Hunt é acusado injustamente de traição e precisa usar suas habilidades de agente secreto para limpar seu nome, enfrentando conspirações e cenas de ação eletrizantes ao redor do mundo.");
			missao.setAvaliacao("7.1");
			missao.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/3/3f/Mission_Impossible_P%C3%B4ster.jpg/250px-Mission_Impossible_P%C3%B4ster.jpg");
			filmeRepository.save(missao);

			Filme horaRush = new Filme();
			horaRush.setNome("Hora do Rush");
			horaRush.setGenero("Ação");
			horaRush.setTempoMinutos(98L);
			horaRush.setDescricao("Um detetive americano e um inspetor chinês precisam superar suas diferenças culturais para salvar a filha de um diplomata sequestrada em Los Angeles, misturando ação e humor perfeitamente.");
			horaRush.setAvaliacao("7.0");
			horaRush.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/5/51/Rush_Hour.jpg/200px-Rush_Hour.jpg");
			filmeRepository.save(horaRush);

			Filme bond = new Filme();
			bond.setNome("007: Sem Tempo para Morrer");
			bond.setGenero("Ação");
			bond.setTempoMinutos(163L);
			bond.setDescricao("James Bond é chamado de volta à ação quando um novo vilão ameaça o mundo com uma tecnologia letal. Em sua missão final, ele enfrenta dilemas pessoais e o peso de seu legado como agente secreto.");
			bond.setAvaliacao("7.3");
			bond.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/5/52/No_Time_to_Die.jpg/250px-No_Time_to_Die.jpg");
			filmeRepository.save(bond);

			Filme homemAranha = new Filme();
			homemAranha.setNome("Homem-Aranha");
			homemAranha.setGenero("Ação");
			homemAranha.setTempoMinutos(121L);
			homemAranha.setDescricao("Após ser picado por uma aranha radioativa, Peter Parker ganha superpoderes e decide usá-los para proteger Nova York, aprendendo que grandes poderes trazem grandes responsabilidades.");
			homemAranha.setAvaliacao("7.4");
			homemAranha.setCartazUrl("https://upload.wikimedia.org/wikipedia/pt/thumb/1/14/Spide-Man_Poster.jpg/250px-Spide-Man_Poster.jpg");
			filmeRepository.save(homemAranha);

			// 3. Salva todos os filmes no banco de dados de uma vez
			filmeRepository.saveAll(List.of(missao, genteGrande, toyStory, carrie, titanic));
		};
	}
}
