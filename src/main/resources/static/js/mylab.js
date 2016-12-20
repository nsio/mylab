/*
 * TODA VEZ QUE O MODAL APARECER UM EVENTO JAVASCRIPT É LANÇADO, ASSIM PODEMOS ADICIONAR UM FUNÇÃO NESTE EVENTO,
 * FAREMOS ISSO USANDO JQUERY
 * [NA DOCUMENTAÇÃO DO BOOTSTRAP HÁ OS NOMES DOS EVENTOS]
 */
// ID DO MODAL, TODA VEZ O EVENTO DO MODAL ACONTECER, VAMOS RECEBER O EVENTO NA FUNÇÃO
$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event){
	/*
	 * CADA PÁGINA, CONTÉM A URL DESTINO, ESSA FUNÇÃO INFORMA AO FORM DO MODAL, QUAL SERÁ O DESTINO DO POST PARA EFETUAR O DELETE
	 * */
	// VAMOS CAPTURAR O BUTTON QUE DISPAROU O EVENTO
	var button = $(event.relatedTarget);
	var codigo = button.data('codigo');
	var destinoPost = button.data('destiny');
	var descricaoObjeto = button.data('descricao');
	
	// VAMOS ACESSAR O MODAL E APARTIR DO MODAL, ENCONTRAR O FORMULÁRIO
	var modal = $(this); // ESSA LINHA TRANSFORMA O MODAL EM UM OBJETO DO JQUERY, ASSIM TEMOS FUNÇÕES MAIS AVANÇADAS PARA FACILITAR O TRABALHO.
	var form = modal.find('form');
	//var action = form.attr('action'); // AQUIE RECUPERAMOS O VALOR DO ACTION QUE ESTÁ NO FORM, DENTRO DO MODAL
	//if(!action.endsWith('/')){
	//	action += '/';
	//}
	
	form.attr('action', destinoPost + '/' + codigo); // ALTERANDO O VALOR DO CAMPO ACTION DO FORMULARIO, ESSE CAMPO INFORMA AO BROWSER QUALQUE É A URL QUE O FORMULARIO DEVERÁ SER SUBMETIDO.
	
	// AGORA VAMOS ALTERAR O CAMPO DE DESCRIÇÃO DO MODAL
	modal.find('.modal-body span').html('Tem certeza que deseja excluir <strong>' + descricaoObjeto + ' </strong>?'); // ENCONTRAR O SPAN DENTRO DO BODY, USANDO O NOME DA CLASSE DO ELEMENTO.
	
});
