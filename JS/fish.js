"use strict";

document.querySelector("body > form").addEventListener("submit", function (event) {
    event.preventDefault(); // turns off the page refresh/redirect
  

    console.log("THIS:", this);

    const data = {
        name: this.name.value,
        species: this.species.value,
        age: this.age.value
    }

    console.log("DATA:", data);

    axios.post("http://localhost:8080/createFish", data)
            .then(res => {
                console.log("RES:", res);
                this.reset();
                this.name.focus();
                renderFishs();
            })
            .catch(err => console.error(err));
});

const output = document.querySelector("#output");

function renderFishs() {
    axios.get("http://localhost:8080/getFishs")
        .then(res => {
            console.log("fishs: ", res.data);
            output.innerHTML = "";
            for (let fish of res.data) {
                const fishCol = document.createElement("div");
                fishCol.className = "col";

                const fishCard = document.createElement("div");
                fishCard.className = "card";
                fishCol.appendChild(fishCard);

                const fishDiv = document.createElement("div");
                fishDiv.className = "card-body";
                fishCard.appendChild(fishDiv);

                const fishName = document.createElement("h2");
                fishName.innerText = fish.name;
                fishDiv.appendChild(fishName);

                const fishAge = document.createElement("p");
                fishAge.innerText = fish.age + " years old.";
                fishDiv.appendChild(fishAge);

                const fishSpecies = document.createElement("p");
                fishSpecies.innerText = fish.species;
                fishDiv.appendChild(fishSpecies);

                const fishDelete = document.createElement('button');
                fishDelete.innerText = "DELETE";
                fishDelete.addEventListener("click", () => {
                    console.log("FISH: ", fish);
                    deleteFish(fish.id);
                });
                fishDiv.appendChild(fishDelete);

                output.appendChild(fishCol);
            }
        })
        .catch(err => console.error(err));
}

const deleteFish = (id) => {
    axios.delete("http://localhost:8080/removeFish/" + id)
            .then(res => {
                console.log("Delete successful");
                renderFishs();
            }).catch(err => console.error(err));
}

renderFishs();