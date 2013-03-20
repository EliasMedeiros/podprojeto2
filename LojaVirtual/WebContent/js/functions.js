function submit(operacao) {
	document.getElementById("operacao").value = operacao;
	alert(document.location.search);
	document.forms["carrinhoForm"].submit();
}

function outraCategoria() {
	x = document.getElementById("selectCategoria");
	if(x.value == -1) {
		document.getElementById("campoOutraCategoria").style.visibility = "visible";
	} else {
		document.getElementById("campoOutraCategoria").style.visibility = "hidden";
	}
}

function limitText(limitField, limitNum) {
	if(limitField.value.length > limitNum) {
		limitField.value = limitField.value.substring(0, limitNum);
	} 
}