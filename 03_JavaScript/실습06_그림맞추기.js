const click = document.querySelector(".click");
const restart = document.querySelector("#restart");
const imgContainer = document.querySelector("#imgContainer");
const imgs = document.querySelectorAll("#imgContainer img");
const celebration = document.querySelector("#celebration");

console.log(imgs.length);

let clickCount = 0;
const changeImg = (e) => {
  for (let i = 0; i < imgs.length; i++) {
    let random = Math.floor(Math.random() * 3);
    imgs[i].setAttribute("src", `assets/spy${random + 1}.jpg`);
  }
  clickCount += 1;

  click.textContent = `Click ${clickCount}`;
};

const checking = (e) => {
  const img1 = imgs[0].getAttribute("src");
  const img2 = imgs[1].getAttribute("src");
  const img3 = imgs[2].getAttribute("src");
  console.log(img1);
  console.log(img2);
  console.log(img3);
  if (img1 == img2 && img1 == img3) {
    console.log("help!");
    celebration.textContent =
      "축하합니다! 다시 시작하려면 재시작 버튼을 눌러주세요";
    click.removeAttribute("class");
  }
};

const restartGame = (e) => {};

click.addEventListener("click", () => {
  changeImg(), checking();
});

restart.addEventListener("click", restartGame);
