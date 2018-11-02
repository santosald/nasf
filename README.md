###### NASF
### Links

[Página oficial do NASF](http://dab.saude.gov.br/portaldab/ape_nasf.php)

[Transferência de arquivo pela rede](https://www.devmedia.com.br/java-socket-transferencia-de-arquivos-pela-rede/32107)


### Vai ser necessário para a aplicação

>O servidor que vai armazenar td a lista de profissionais e pacientes, prontuário, cronogramas e a programção mensal e
vai retornar pelo buffer essas informações quando requisitadas e se quem requisitou pode ter acesso

>Um JFrame para caso um médico entre pelo login, lá vai ter acesso ao prontuário dos seus pacientes, o cronograma e programação
geral e lista de outros médicos.

>Um JFrame pra listar todos os médicos e enviar um pedido de consulta (passa o prontuário e o paciente como parâmetro no pedido)

>Um JFrame para caso um paciente entre pelo login, lá vai ter acesso ao seu prontuário (n pode editar), o cronograma e programação
geral e pedir um agendamento com o assistente social ou enfermeira somente.

Assim, o servidor vai se comunicar com cada thread criada para cada login feito, recebendo requisições de informação e enviando
para a thread que resitou (se essa tiver permissão). Utilizando assim o conceito de socket (100%) e thread (uns 70%), não sei se
aplicando só isso já utiliza de tds os conceitos que o prof pede. Pensar e, se necessário, complementar.

*Precisa ler o site do nasf para ver se existe mais alguma função que possa ser implementada*

### O que é feito lá

Nas reuniões, escolhem os horários de acordo com a demanda então é gerado um cronograma

O prontuário é enviado pelo servidor pra o respectivo prossional 

Todos os profissionais vão ter acesso a programação mensal


