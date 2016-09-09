function clientTest()
{
    console.log("clientTest");
    var data1 = document.getElementById("asMaxApproachDistance").value;
    var data2 = document.getElementById("asAbsenceMsg").value;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {             //SERVER RESPONSE READY??
        if (this.readyState == 4 && this.status == 200) {
            //callback(this.responseText);   
            console.log("response: ");
            console.log(this.responseText);
        }
    }

    var url="http://127.0.0.1:8080/saved_alarms?type=smuggling&operation=create&data1=";
    url+=data1;
    url+="&data2=";
    url+=data2;

    if (data1 != '' && data2 != ''){
    	if ("withCredentials" in xhttp) {
    		xhttp.open("GET", url, true);
		}
		else if (typeof XDomainRequest != "undefined") {
    		xhttp = new XDomainRequest();
    		xhttp.open("GET", url);
		}
		else {
	    	xhttp = null;
		}
    	//xhttp.open("GET", url, true); // true for asynchronous 
    	xhttp.send(null);
    	console.log('url is sent');

    	xhttp.onerror = function() {
  			console.log('There was an error!');
		};
    }

    console.log("end");
}


/*

Output:
clientTest.js:48 url is sent
clientTest.js:55 end
clientTest.js:25 response: 
clientTest.js:26 {"id":"0","type":"smuggling","operation":"create","maxApproachDistance":"123","absenceofAISMessage":"23"}

*/
