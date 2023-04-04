let count = 0;
setInterval(function () {
//alert("hello")

	var myHeaders = new Headers();
var requestOptions = {
  method: 'GET',
  headers: myHeaders,
  redirect: 'follow'
};

fetch("http://localhost:8080/getData?start=0", requestOptions)
  .then(response => response.text())
  .then(data => {
            //console.log(data.length);
	  		const myArr = JSON.parse(data);
            console.log(myArr)
            if (!myArr.empty) {
                // {
                //     "Battery_Level": 3.52,
                //     "Device_Id": 1156053076,
                //     "First_Sensor_temperature": 19.4,
                //     "Route_From": "Hyderabad, India",
                //     "Route_To": "Louisville, USA"
                //   }

                for (const i of myArr) {

                    const { battery_Level, device_ID, first_Sensor_temperature, route_From, route_To } = i;
                    const TR = document.createElement('tr');
                    const TD1 = document.createElement('td');
                    TD1.innerHTML = battery_Level;

                    const TD2 = document.createElement('td');
                    TD2.innerHTML = device_ID

                    const TD3 = document.createElement('td');
                    TD3.innerHTML = first_Sensor_temperature

                    const TD4 = document.createElement('td');
                    TD4.innerHTML = route_From
                            console.log("DO work");
                    console.log(data)
                    const TD5 = document.createElement('td');
                    TD5.innerHTML = route_To

                    TR.appendChild(TD1);
                    TR.appendChild(TD2);
                    TR.appendChild(TD3);
                    TR.appendChild(TD4);
                    TR.appendChild(TD5);

                    console.log("append td")
                    document.getElementById("table").appendChild(TR);

                }
                count++;
            }
        });
}, 5000);


