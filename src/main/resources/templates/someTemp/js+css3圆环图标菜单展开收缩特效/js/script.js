/*
Designed by: Nicholas.design
Original image: https://dribbble.com/shots/7160097-Add-Interaction
*/

const btn = document.querySelector("#btn");
const item = document.querySelectorAll(".menu__item");

let showCard = (event) => {
    btn.classList.toggle("is-rotate");
    for (var i = 0; i < item.length; i++) {
        item[i].classList.toggle(`item-${i}`);
    }
}

btn.addEventListener("click", showCard);