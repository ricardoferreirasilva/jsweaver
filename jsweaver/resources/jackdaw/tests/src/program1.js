var test = 1
if(test == 1){
	console.log("Inside if.");
	try {
	  console.log("On try");
	  throw "Big Fatal Error"
	}
	catch(err) {
	  console.log("On catch");
	} 
	finally {
	   console.log("On finally");
	}
	test = 3;
	switch(test){
		case 3:
			console.log("test = 3");
			while(test < 10){
				test++;
			}
			if(test >= 10){
				console.log("test = 10");
			}
			break;
		default:
			console.log("test is unknown");
			break;
	}
	console.log("Reached end of program.");
}