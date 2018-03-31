var elementIdGlobal = "chart_div";
var graphDataGlobal=[];

function forecast() {
    
    var date = document.getElementById("date").value; 
    var table= document.getElementById("weatherTable");
    var TPtable= document.getElementById("weatherTableThirdParty"); 
    var ourResultHead= document.getElementById("ourResultHeading");
    var darkSkyHeading= document.getElementById("darkSkyHeading");
    ourResultHead.innerHTML="Please Wait.....";
    darkSkyHeading.innerHTML="Please Wait.....";
    clearTable(table);
    clearTable(TPtable);
    
    date=date.replace(new RegExp('-', 'g'),"");
    var localhost="localhost:1201";
    var server="18.221.165.2";

    var ip=server;

//    var address="http://"+ip+"/weather/forecast/"+date;
    var address="/weather/forecast/"+date;
    callRestService(address, table, ourResultHead, "Our Results", "our");    

//   var TPAddress="http://"+ip+"/weather/forecast/thirdParty/"+date;
   var TPAddress="/weather/forecast/thirdParty/"+date;
    callRestService(TPAddress, TPtable, darkSkyHeading, "Results from DarkSky API","thirdParty");   
   
    
    
}

function clearTable(table) {
    var rows = table.getElementsByTagName('tr');
    for(var i=rows.length-1; i>0; i--) {
        table.deleteRow(1);
    }
}

function callRestService(address, table, element, message, elementId) {
    var datesForThirdParty=[];
     var xhttp = new XMLHttpRequest();
    var graphData=[];
    
      xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        var responseJason = JSON.parse(xhttp.responseText);
                
        populateTable(table, responseJason);
        element.innerHTML=message;
        elementIdGlobal=elementId;  
        plotWeatherGraph();
        console.log(graphDataGlobal);
    }     
    };
    xhttp.open("GET", address, true);
   
    xhttp.send();
 
  /*  console.log("logginf the dates of third party .............."+ datesForThirdParty[0]);
    return datesForThirdParty;*/
    return graphData;
}

function populateTable( table, responseJason){
    var datesForThirdParty=[];
    var graphData=[];
    for(var i=responseJason.length-1, j=0; i>=0; i--, j++) {
            
            var weatherResponse=responseJason[i];
            
            var row = table.insertRow(1);
            var cell0=row.insertCell(0);
            var cell1=row.insertCell(1);
            var cell2=row.insertCell(2);
            var cell3=row.insertCell(3);
            
        
        
            var avgTemp=(weatherResponse["TMAX"]+weatherResponse["TMIN"])/2;
            var img = document.createElement("img");
            img.width=40;
            img.height=40;
            if(avgTemp>=70){
               img.src="images/sun.png";                        
            } else if(avgTemp<70 && avgTemp>50) {
                img.src="images/cloudy.png";
            } else if(avgTemp<=50 && avgTemp>=35) {
                          img.src="images/rainy.png";
            } else {
                img.src="images/snow.png";
            }
            cell0.appendChild(img);
        var dateFromResponse=getFormatedDate(weatherResponse["DATE"])
            cell1.innerHTML=dateFromResponse;
            cell2.innerHTML=weatherResponse["TMAX"];
            cell3.innerHTML=weatherResponse["TMIN"];
           
        var graphRow=[];
                     
            graphRow[0]=dateFromResponse;
            graphRow[1]=weatherResponse["TMAX"];
            graphRow[2]=weatherResponse["TMIN"];
            graphData[j]=graphRow;
        
        
        /*datesForThirdParty[j]=changeToTimeStamp(weatherResponse["DATE"]);*/
            
           /* console.log(weatherResponse["DATE"]);
            console.log(weatherResponse["TMAX"]);
            console.log(weatherResponse["TMIN"]);*/
            
        }
   graphDataGlobal=graphData.reverse();
    return graphData;
    
}

function getFormatedDate(date) {
    
    return date.slice(0,4)+"-"+date.slice(4,6)+"-"+date.slice(6);
    
}



function changeToTimeStamp(date) {
    var datechng=date.slice(0,4)+"-"+date.slice(4,6)+"-"+date.slice(6);
    //console.log("-------------------"+datechng);
    var time=Math.round(new Date(datechng).getTime()/ 1000);
    //console.log(time);
    return time;
}







function plotWeatherGraph() {
        google.charts.load('current', {packages: ['corechart', 'line']});
        google.charts.setOnLoadCallback(drawAxisTickColors);
 
}



function drawAxisTickColors() {
     var data = new google.visualization.DataTable();
      data.addColumn('string', 'Date');
      data.addColumn('number', 'Max Temp');
      data.addColumn('number', 'Min Temp');
      data.addRows(graphDataGlobal);
    
       var options = {
        hAxis: {
          title: 'Date (YYYY-MM-DD)',
          textStyle: {
            color: '#1a237e',
            fontSize: 24,
            fontName: 'Arial',
            bold: true,
            italic: true
          },
          titleTextStyle: {
            color: '#01579b',
            fontSize: 24,
            fontName: 'Arial',
            bold: true,
            italic: true
          }
        },
        vAxis: {
          title: 'Temp (°F)',
          textStyle: {
            color: '#1a237e',
            fontSize: 24,
            bold: true
          },
          titleTextStyle: {
            color: '#1a237e',
            fontSize: 24,
            bold: true
          }
        },
        colors: ['#f42011', '#94b2f7']
      };
    var chart = new google.visualization.LineChart(document.getElementById(elementIdGlobal));
      chart.draw(data, options); 
    }
