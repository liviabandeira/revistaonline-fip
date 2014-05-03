<div>
		<form action="${linkTo[AvaliacaoController].salvar[avaliacao]}" method="POST"> 
		<fieldset>
			
			<input type="hidden" name="avaliacao.id" value="${avaliacao.id}" />
			<legend>Avaliação</legend>
			Critério 1) Relevância para a Chamada de Trabalhos da revista(O tema do artigo é
			relevante para a área, em especial levando-se em conta a trilha/revista do
			artigo? O problema e os resultados obtidos são relevantes para a área?):
			<br>
			 <INPUT TYPE="radio" NAME="criterio1" VALUE="irrelevante">
			 Irrelevante
			 <br>
			 <INPUT TYPE="radio" NAME="criterio1" VALUE="moderadamente">
			 Moderadamente relevante
			 <br>
			 <INPUT TYPE="radio" NAME="criterio1" VALUE="relevante">
			 Relevante
			 <br>
			 <INPUT TYPE="radio" NAME="criterio1" VALUE="muito relevante">
			 Muito Relevante
			 <br>              
            Critério 2) Fundamentação teórica/metodológica (O artigo apresenta
			fundamentação teórica adequada ao tema que aborda? Os resultados
			apresentados são comparados com resultados de trabalhos anteriores na
			área?:
			<br>
			 <INPUT TYPE="radio" NAME="criterio2" VALUE="inadequada ou ausente">
			 Inadequada ou ausente
			 <br>
			 <INPUT TYPE="radio" NAME="criterio2" VALUE="fraca">
			 Fraca
			 <br>
			 <INPUT TYPE="radio" NAME="criterio2" VALUE="boa">
			 Boa
			 <br>
			 <INPUT TYPE="radio" NAME="criterio2" VALUE="muito boa">
			 Muito Boa
			 <br>
			 
			Critério 3) Qualidade técnica (O artigo tem mérito técnico? O problema abordado
			no artigo está caracterizado? O objetivo do artigo está caracterizado? A
			metodologia empregada é coerente com o problema e objetivo da pesquisa?
			Os dados são analisados e os resultados discutidos?): 
			<br>
			 <INPUT TYPE="radio" NAME="criterio3" VALUE="insuficiente">
			 Insuficiente
			 <br>
			 <INPUT TYPE="radio" NAME="criterio3" VALUE="baixa">
			 Baixa
			 <br>
			 <INPUT TYPE="radio" NAME="criterio3" VALUE="moderada">
			 Moderada
			 <br>
			 <INPUT TYPE="radio" NAME="criterio3" VALUE="alta">
			 Alta
			 <br>
			 
			 Critério 4)  Qualidade da apresentação (O artigo está bem escrito e organizado? É
			 fácil de ler? As contribuições estão claras? O template fornecido pela
			 organização foi rigorosamente seguido (incluindo tamanho de fontes,
			 espaçamentos e formato de citações bibliográficas)? 
			 <br>
			 <INPUT TYPE="radio" NAME="criterio4" VALUE="insuficiente">
			 Insuficiente
			 <br>
			 <INPUT TYPE="radio" NAME="criterio4" VALUE="baixa">
			 Baixa
			 <br>
			 <INPUT TYPE="radio" NAME="criterio4" VALUE="moderada">
			 Moderada
			 <br>
			 <INPUT TYPE="radio" NAME="criterio4" VALUE="alta">
			 Alta
			 <br>
			 
			 Critério 5) Familiaridade do Revisor (Qual a sua familiaridade com o assunto do
			 artigo?): 
			<br>
			 <INPUT TYPE="radio" NAME="criterio5" VALUE="pouco familiar">
			 Pouco Familiar
			 <br>
			 <INPUT TYPE="radio" NAME="criterio5" VALUE="moderadamente familiar">
			 Moderadamente Familiar
			 <br>
			 <INPUT TYPE="radio" NAME="criterio5" VALUE="bom conhecimento">
			 Bom Conhecimento
			 <br>
			 <INPUT TYPE="radio" NAME="criterio5" VALUE="muito familiar">
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