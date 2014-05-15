<div>
		<form action="${linkTo[AvaliacaoController].salvar[avaliacao]}" method="POST"> 
		<fieldset>
			
			<input type="hidden" name="avaliacao.id" value="${avaliacao.id}" />
			<legend>Avaliação</legend>
			Critério 1) Relevância para a Chamada de Trabalhos da revista(O tema do artigo é
			relevante para a área, em especial levando-se em conta a trilha/revista do
			artigo? O problema e os resultados obtidos são relevantes para a área?):
			<br>
			 <INPUT TYPE="radio" NAME="criterio1" VALUE="1">
			 Irrelevante
			 <br>
			 <INPUT TYPE="radio" NAME="criterio1" VALUE="2">
			 Moderadamente relevante
			 <br>
			 <INPUT TYPE="radio" NAME="criterio1" VALUE="3">
			 Relevante
			 <br>
			 <INPUT TYPE="radio" NAME="criterio1" VALUE="4">
			 Muito Relevante
			 <br>              
            Critério 2) Fundamentação teórica/metodológica (O artigo apresenta
			fundamentação teórica adequada ao tema que aborda? Os resultados
			apresentados são comparados com resultados de trabalhos anteriores na
			área?:
			<br>
			 <INPUT TYPE="radio" NAME="criterio2" VALUE="1">
			 Inadequada ou ausente
			 <br>
			 <INPUT TYPE="radio" NAME="criterio2" VALUE="2">
			 Fraca
			 <br>
			 <INPUT TYPE="radio" NAME="criterio2" VALUE="3">
			 Boa
			 <br>
			 <INPUT TYPE="radio" NAME="criterio2" VALUE="4">
			 Muito Boa
			 <br>
			 
			Critério 3) Qualidade técnica (O artigo tem mérito técnico? O problema abordado
			no artigo está caracterizado? O objetivo do artigo está caracterizado? A
			metodologia empregada é coerente com o problema e objetivo da pesquisa?
			Os dados são analisados e os resultados discutidos?): 
			<br>
			 <INPUT TYPE="radio" NAME="criterio3" VALUE="1">
			 Insuficiente
			 <br>
			 <INPUT TYPE="radio" NAME="criterio3" VALUE="2">
			 Baixa
			 <br>
			 <INPUT TYPE="radio" NAME="criterio3" VALUE="3">
			 Moderada
			 <br>
			 <INPUT TYPE="radio" NAME="criterio3" VALUE="4">
			 Alta
			 <br>
			 
			 Critério 4)  Qualidade da apresentação (O artigo está bem escrito e organizado? É
			 fácil de ler? As contribuições estão claras? O template fornecido pela
			 organização foi rigorosamente seguido (incluindo tamanho de fontes,
			 espaçamentos e formato de citações bibliográficas)? 
			 <br>
			 <INPUT TYPE="radio" NAME="criterio4" VALUE="1">
			 Insuficiente
			 <br>
			 <INPUT TYPE="radio" NAME="criterio4" VALUE="2">
			 Baixa
			 <br>
			 <INPUT TYPE="radio" NAME="criterio4" VALUE="3">
			 Moderada
			 <br>
			 <INPUT TYPE="radio" NAME="criterio4" VALUE="4">
			 Alta
			 <br>
			 
			 Critério 5) Familiaridade do Revisor (Qual a sua familiaridade com o assunto do
			 artigo?): 
			<br>
			 <INPUT TYPE="radio" NAME="criterio5" VALUE="1">
			 Pouco Familiar
			 <br>
			 <INPUT TYPE="radio" NAME="criterio5" VALUE="2">
			 Moderadamente Familiar
			 <br>
			 <INPUT TYPE="radio" NAME="criterio5" VALUE="3">
			 Bom Conhecimento
			 <br>
			 <INPUT TYPE="radio" NAME="criterio5" VALUE="4">
			 Muito Familiar
			 <br>
			 Comentários: 
			 <br>
			 <textarea name="comentarios" rows="3" cols="40"></textarea>
			 <br>
              <INPUT TYPE="submit" VALUE="Enviar">
		</fieldset>
	 </form>

</div>