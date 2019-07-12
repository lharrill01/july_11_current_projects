'use strict';

// closures are how we do encapsulation is JS
// it allows us to make "private" variables.

// our original clicker counter looked like this:
// let counter = 0;
// main_p.addEventListener("click", () => {
//     counter = counter + 1;
//     main_p.innerText = `This has been clicked : ${counter} times`;
// });

// Anywhere in our code, we could directly modify
// the counter variable, which would make it
// not accurately track clicks.

// Let's solve that problem with a closure!

// A closure has 4 essential pieces:
// 1: the outer function
function getClickerCounter() {
    // 2: the "closed over" variable that we make "private"
    let counter = 0;

    // 3: the inner function that modifies/returns the private variable
    function count() {
        counter = counter + 1;
        return counter;
        //return ++counter; // this does the same thing
    }

    // 4: the outer function's return statement
    //      where is returns the inner function
    return count;
}

let clickerCounter = getClickerCounter();

// console.log(clickerCounter());
// console.log(clickerCounter());
// console.log(clickerCounter());

let clickerCounter2 = getClickerCounter();

console.log(clickerCounter2());
console.log(clickerCounter2());
console.log(clickerCounter2());

let btn = document.getElementById("clicker");

btn.addEventListener("click", () => {
    btn.innerText = `This has been clicked ${clickerCounter()} times`;
});

// a little more fun example:
function makeCounter(noun) {
    let count = 0;

    function countNoun() {
        return `${noun} count is: ${++count}`;
    }

    return countNoun;
}

let catCounter = makeCounter("Cat");
let birdCounter = makeCounter("Bird");

console.log(catCounter());
console.log(birdCounter());
console.log(catCounter());
console.log(birdCounter());
console.log(catCounter());
console.log(birdCounter());