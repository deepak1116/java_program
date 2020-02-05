function flames() {
	var data1 = document.getElementById("data1").value
	var data2 = document.getElementById("data2").value
	eel.flames(data1,data2)(setImage)
}

function setImage(base64) {
	document.getElementById("qr").src = base64
}