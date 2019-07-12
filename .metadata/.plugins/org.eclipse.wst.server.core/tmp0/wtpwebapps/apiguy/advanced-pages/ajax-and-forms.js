'use strict';

// AJAX is Asynchronous JavaScript and XML
//  It's asynchronous because we have to wait while
//  we send HTTP and get a response. 

let pokemonForm = document.getElementById("pokemonForm");
pokemonForm.addEventListener("submit", (event) => {
    // prevents default form behvaiour:
    event.preventDefault();

    // we can easily access user input in JS:
    let num = pokemonForm.number.value;

    getPokemon(num, (pokemonObj) => {
        //console.log(pokemonObj);
        document.getElementById("pokemonImage").src = pokemonObj.sprites.front_default;
        
    });
});

function getPokemon(number, onSuccess) {

    // This object is provided by the browser to let us do AJAX
    let xhr = new XMLHttpRequest();

    //we next define what to do as the request-response lifecycle proceeds
    xhr.addEventListener("readystatechange", () => {
        console.log(`ready state : ${xhr.readyState}`);

        //when ready state reaches 4, we have the response:
        if (xhr.readyState === 4) {
            let responseJson = xhr.response;
            //console.log(responseJson);

            // Working with JSON strings :
            // JSON.parse to "deserialize" (read) JSON
            // JSON.stringify to "serialize" (write) JSON

            // We know that we've received a response, but
            // we don't know if our request was successful

            // HTTP response status codes 200-299 mean success
            if (xhr.status >= 200 && xhr.status < 300) {
                console.log("HTTP Status Code says success!");

                let responseObj = JSON.parse(responseJson);
                console.log(responseObj);

                //This line does a lot of work :
                onSuccess(responseObj);
            } else {
                // some kind of error occured
                console.log("failure");
                console.log(responseJson);
            }

        }
    });

    // set up the request we want to send
    xhr.open("get", `https://pokeapi.co/api/v2/pokemon/${number}`);

    // actually send the request
    xhr.send();

}