<!-- JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/modern-business.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.metisMenu.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.mask.min.js"></script>

<script>
$(document).ready(function(){
	  $('.date').mask('11/11/1111');
	  $('.time').mask('00:00:00');
	  $('.date_time').mask('00/00/0000 00:00:00');
	  $('.cep').mask('00000-000');
	  $('.phone').mask('0000-0000');
	  $('.phone_with_ddd').mask('(000) 0000-0000');
	  $('.phone_us').mask('(000) 000-0000');
	  $('.mixed').mask('AAA 000-S0S');
	  $('.cpf').mask('000.000.000-00', {reverse: true});
	  $('.money').mask('000.000.000.000.000,00', {reverse: true});
	  $('.money2').mask("#.##0,00", {reverse: true, maxlength: false});
	  $('.ip_address').mask('0ZZ.0ZZ.0ZZ.0ZZ', {translation: {'Z': {pattern: /[0-9]/, optional: true}}});
	  $('.ip_address').mask('099.099.099.099');
	  $('.percent').mask('##0,00%', {reverse: true});
});
</script>