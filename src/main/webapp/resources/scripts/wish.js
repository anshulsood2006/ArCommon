var module = angular.module('wishApp',[]); 

module.controller('watsappController', function($scope) {
	var messageText ;
	$scope.promptForName = function () {
		messageText = prompt("Please enter your name:", "");
		if (typeof messageText == "undefined" || messageText == ""){
			alert("Name is mandatory");
			return false;
		}

	};
	
	$scope.message = messageText;
});

var timerId = null;
var msg = "$$ Happy Day";
var counter = 0;

if (timerId != null)
   clearTimeout(timerId);

function pad() {
  var padding  = "";
  // Prepend 50 spaces to the message:
  for (var n=0; n <= (80 + msg.length); n++)
      padding += " ";
  return(padding);
}

function scroll() {
	newMsg = pad() + msg + " ";
 	document.getElementById("message").value = newMsg.substring(counter, newMsg.length);
 	if (counter == newMsg.length) {
    	counter = 0;
 	}
 	counter ++;
 	timerId = setTimeout("scroll()", 80);  
 	return true;
}

function validateName(){
	var name = document.getElementById("to").value;
	if (typeof name == "undefined" || name == ""){
		alert("Enter your name");
		return false;
	}
	return true;
}

function sendViaWatsapp(){
	var url = document.URL;
	var urlParams = new URLSearchParams(window.location.search);
	var str = encodeURIComponent(urlParams.get("from")+ " has sent you wishes. Click here: "+url);
	window.location = "whatsapp://send?text="+str;
}