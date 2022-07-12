"use strict";

const output = document.querySelector("div#output");

axios.get("https://raw.githubusercontent.com/ewomackQA/JSONDataRepo/master/kings.json")
.then (response => {
    
    console.log("RES:", response)
    for (let i = 0; i < (response.data).length; i++) {
    const nm = document.createElement("p");
    nm.innerText = "Name: " + response.data[i].nm;
    output.appendChild(nm);

    const cty = document.createElement("p");
    cty.innerText = "City: " + response.data[i].cty;
    output.appendChild(cty);

    const hse = document.createElement("p");
    hse.innerText = "House: " + response.data[i].hse;
    output.appendChild(hse);
    

    const yrs = document.createElement("p");
    yrs.innerText = "Years: " + response.data[i].yrs;
    output.appendChild(yrs);
    }

})
.catch(error => console.error(error));