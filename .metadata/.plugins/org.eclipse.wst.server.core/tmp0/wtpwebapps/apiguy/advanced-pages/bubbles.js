'use strict';

// In JS an event is handled by each element that has
// a listener for it.  The order that elements handle
// an event is determined by bubbling v. capturing.

// using bubbling, event listeners fire inside -> outside
// using capturing outermost -> innermost

// we can stop propagation of an event, but we shouldn't

let propagate = true;

// the callback function we give to event listeners can have
// a single argument -- the event itself.
function eventLogCallback(event) {
    console.log(event);
    alert(`Callback called for element with id : ${this.id}`);
    if (!propagate) event.stopPropagation();
}

// we determine whether or not we're using capturing
// by passing a boolean as a third argument to
// addEventListener();
let useCapture = false;

document.getElementById("outer")
        .addEventListener("click", eventLogCallback, useCapture);
document.getElementById("inner")
        .addEventListener("click", eventLogCallback, useCapture);
document.getElementById("innermost")
        .addEventListener("click", eventLogCallback, useCapture);

let propButton =  document.getElementById("propToggle");

propButton.addEventListener("click", () => {
    propagate = !propagate;
    if (propagate) {
        propButton.innerText = "Turn Propagation Off";
    } else {
        propButton.innerText = "Turn Propagation On";
    }
});