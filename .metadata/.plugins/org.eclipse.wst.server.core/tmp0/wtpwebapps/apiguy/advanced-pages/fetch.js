'use strict';

// The Fetch API is a modern replacement for XMLHttpRequests (AJAX)
// It uses ES6 Promies, which not quite all browsers support

let swForm = document.getElementById("swForm");
let swInfo = document.getElementById("swInfo");

swForm.addEventListener("submit", (event) => {
    event.preventDefault();

    // a Promise object represents a result that isn't yet present
    // They can be resolved successfully or failure-ly, based on
    // the result actually showing up

    // We decide what a Promise does by giving it callback functions

    // provide the callback to run on a success with:
    //      .then(callback)
    // and the callback on a failure with:
    //      .catch(callback)

    // If your success function itself returns a promise, you can
    // chain .then(callback) calls.

    let type = swForm.typeSelect.value;
    let q = swForm.query.value;
    fetch(`https://swapi.co/api/${type}/${q}`)
    // the fetch returns a promise for a response object
    // .json() called on a response returns a promise for
    // the response converted to an object
            .then((response) => {return response.json()})
            .then((obj) => {
                //console.log(obj);
                swInfo.innerHTML = "";
                for(let x in obj) {
                    // for in loops through properties of an object
                    let swli = document.createElement("li");
                    swli.innerText = `${x} : ${obj[x]}`;
                    swInfo.appendChild(swli);
                };
            })
            .catch((err) => {
                console.log(err);
            });
});