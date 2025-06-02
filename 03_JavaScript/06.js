const click = document.querySelector("section button:first-child");
const restart = document.querySelector("section button:last-child");
const image = document.querySelectorAll("img");
const span = document.querySelector("button span");
const h2 = document.querySelector("h2");

let count = 0;

const changeImg = () => {
  const random = [
    Math.floor(Math.random() * image.length) + 1,
    Math.floor(Math.random() * image.length) + 1,
    Math.floor(Math.random() * image.length) + 1,
  ];
  for (let i = 0; i < image.length; i++) {
    image[i].setAttribute("src", `assets/spy${random[i]}.jpg`);
  }

  span.textContent = ++count;

  if (random[0] == random[1] && random[1] == random[2]) {
    click.disabled = true;
    h2.style.visibility = "visible";
  }
};

const restartGame = () => {
  for (let i = 0; i < image.length; i++) {
    image[i].setAttribute("src", `assets/spy${i + 1}.jpg`);
  }
  count = 0;
  span.textContent = "";
  click.disabled = false;
  h2.style.visibility = "hidden";
};

click.addEventListener("click", changeImg);
restart.addEventListener("click", restartGame);
